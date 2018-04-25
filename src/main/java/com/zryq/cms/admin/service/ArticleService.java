package com.zryq.cms.admin.service;

import com.zryq.cms.admin.dao.ArticleMapper;
import com.zryq.cms.admin.entity.Article;
import com.zryq.cms.admin.entity.ArticleExample;
import com.zryq.cms.admin.entity.Column;
import com.zryq.cms.admin.entity.User;
import com.zryq.cms.common.enums.ArticleStatus;
import com.zryq.cms.common.utils.OperateHtmlUtil;
import com.zryq.cms.common.utils.SessionPerson;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import com.zryq.cms.admin.dao.ArticleMapper;
import com.zryq.cms.admin.entity.Article;
import com.zryq.cms.admin.entity.Column;
import com.zryq.cms.admin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 锐 on 2017/10/24.
 */
@Service
public class ArticleService {


    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ColumnService columnService;

    /**
     * 新增
     *
     * @param article
     * @return
     */
    public boolean add(Article article, User user) {
        article.setCreateTime(new Date());
        article.setArtState(0);//保存
        article.setCreateUserId(user.getId());
        article.setCreateUsername(user.getUsername());
        article.setWebId(SessionPerson.getWebId());

        article.setCreateGroupId(user.getGroupId());
        article.setCreateGroupName(user.getGroupName());
        return articleMapper.insert(article) > 0;
    }


    public boolean updateState(Integer id, int state) {
        Article article = new Article();
        article.setId(id);
        article.setArtState(state);
        if (state == 4) { //发布
            article.setPublishTime(new Date());
            User user = SessionPerson.current();
            article.setPublishUserId(String.valueOf(user.getId()));
            article.setPublishUsername(user.getUsername());
        }

        return articleMapper.updateByPrimaryKeySelective(article) > 0;
    }

    public boolean modifyById(Article article) {
        return articleMapper.updateByPrimaryKeySelective(article) > 0;
    }


    public PageInfo selectArticleData(Integer pageNum, Integer pageSize, String title, Integer coluId, Integer webId) {
        PageHelper.startPage(pageNum, pageSize);
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.or();
        if (!Strings.isNullOrEmpty(title)) {
            criteria.andArtTitleLike("%" + title + "%");
        }

        if (coluId != null) {
            criteria.andColuIdEqualTo(coluId);
        }
        if (webId != null) {
            criteria.andWebIdEqualTo(webId);
        }
        List<Article> articleList = articleMapper.selectByExample(articleExample);
        PageInfo<Article> pageInfo = new PageInfo<>(articleList);
        return pageInfo;
    }

    public Article selectById(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }


    /**
     * 归档
     *
     * @param ids
     * @param state
     * @return
     */
    public boolean undo(String ids, Integer state) {
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.or();

        List<Integer> idList = new ArrayList<Integer>();
        if (ids != null) {
            for (int i = 0; i < ids.split(",").length; i++) {
                if (ids.split(",")[i] != null && ids.split(",")[i] != "")
                    idList.add(Integer.valueOf(ids.split(",")[i]));
            }
        }

        criteria.andIdIn(idList);
        Article article = new Article();
        article.setArtState(state);
        return articleMapper.updateByExampleSelective(article, articleExample) > 0;
    }


    /**
     * 信息转移
     *
     * @param ids
     * @param coluId
     * @return
     */
    public boolean move(String ids, Integer coluId) {
        List<Integer> idList = new ArrayList<Integer>();
        if (ids != null) {
            for (int i = 0; i < ids.split(",").length; i++) {
                if (ids.split(",")[i] != null && ids.split(",")[i] != "")
                    idList.add(Integer.valueOf(ids.split(",")[i]));
            }
        }
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.or();
        criteria.andIdIn(idList);
        Column column = columnService.selectById(coluId);  //更新栏目名称
        Article article = new Article();
        article.setColuId(coluId);
        article.setColuName(column.getColuName());
        return articleMapper.updateByExampleSelective(article, articleExample) > 0;
    }


    /**
     * 获取栏目文章信息
     *
     * @param pageNum
     * @param pageSize
     * @param columnId
     * @return
     */
    public PageInfo selectColumnArticle(Integer pageNum, Integer pageSize, Integer columnId, Integer artState) {
        PageHelper.startPage(pageNum, pageSize);
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.or();
        if (columnId != null) {
            criteria.andColuIdEqualTo(columnId);
        }

        if (artState != null) {
            criteria.andArtStateEqualTo(artState);
        }
        articleExample.setOrderByClause(" publish_time DESC ");
        List<Article> articleList = articleMapper.selectByExample(articleExample);
        PageInfo pageInfo = new PageInfo(articleList);
        return pageInfo;
    }


    /**
     * 获取机构文章信息
     *
     * @param pageNum
     * @param pageSize
     * @param groupId
     * @param artState
     * @return
     */
    public PageInfo selectGroupArticle(Integer pageNum, Integer pageSize, Integer groupId, Integer artState) {
        PageHelper.startPage(pageNum, pageSize);
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.or();
        if (groupId != null) {
            criteria.andCreateGroupIdEqualTo(groupId);
        }
        if (artState != null) {
            criteria.andArtStateEqualTo(artState);
        }
        articleExample.setOrderByClause(" publish_time DESC ");
        List<Article> articleList = articleMapper.selectByExample(articleExample);
        PageInfo pageInfo = new PageInfo(articleList);
        return pageInfo;
    }


    /**
     * 查询站点最近更新
     *
     * @param pageNum
     * @param pageSize
     * @param webId
     * @return
     */
    public List<Article> selectRecent(Integer pageNum, Integer pageSize, Integer webId) {
        PageHelper.startPage(pageNum, pageSize);
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.or();
        if (webId != null) {
            criteria.andWebIdEqualTo(webId);
        }
        criteria.andArtStateEqualTo(ArticleStatus.Publish.getValue()); //已经发布的
        articleExample.setOrderByClause("publish_time DESC");
        List<Article> articleList = articleMapper.selectByExample(articleExample);
        return articleList;
    }


    /**
     * 获取前台数据
     *
     * @param pageNum
     * @param pageSize
     * @param webId
     * @param coluId
     * @return
     */
    public PageInfo frontData(Integer pageNum, Integer pageSize, Integer webId, Integer coluId) {
        PageHelper.startPage(pageNum, pageSize);
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.or();

        if (webId != null) {
            criteria.andWebIdEqualTo(webId);
        }
        if (coluId != null) {
            criteria.andColuIdEqualTo(coluId);
        }
        criteria.andArtStateEqualTo(ArticleStatus.Publish.getValue());//發佈的
        List<Article> articleList = articleMapper.selectByExample(articleExample);
        PageInfo pageInfo = new PageInfo(articleList);
        return pageInfo;

    }

    /**
     * 根据机构获取前台数据
     *
     * @param pageNum
     * @param pageSize
     * @param webId
     * @param groupId
     * @return
     */
    public PageInfo frontGroupData(Integer pageNum, Integer pageSize, Integer webId, Integer groupId) {
        PageHelper.startPage(pageNum, pageSize);
        ArticleExample articleExample = new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.or();

        if (webId != null) {
            criteria.andWebIdEqualTo(webId);
        }
        if (groupId != null) {
            criteria.andCreateGroupIdEqualTo(groupId);
        }
        criteria.andArtStateEqualTo(ArticleStatus.Publish.getValue());//發佈的
        List<Article> articleList = articleMapper.selectByExample(articleExample);
        PageInfo pageInfo = new PageInfo(articleList);
        return pageInfo;

    }


    /**
     * 获取带有图片的信息
     *
     * @param webId
     * @param columnId
     * @return
     */
    public List<Article> includePic(Integer webId, Integer columnId) {
        ArticleExample articleExample = new ArticleExample();

        ArticleExample.Criteria criteria = articleExample.or();

        if (webId != null) {
            criteria.andWebIdEqualTo(webId);
        }

        if (columnId != null) {
            criteria.andColuIdEqualTo(columnId);
        }
        criteria.andArtStateEqualTo(ArticleStatus.Publish.getValue());
        criteria.andCreateArtContentLike("%<img%");
        articleExample.setOrderByClause("publish_time DESC");
        //criteria.and

        PageHelper.startPage(1, 5);

        List<Article> articleList = articleMapper.selectByExampleWithBLOBs(articleExample);
        articleList.forEach(article -> {
            List<String> imgPath = OperateHtmlUtil.getImgSrc(article.getArtContent());
            article.setImgPath(imgPath);
            article.setFirstPicPath(imgPath.get(0));
        });

        return articleList;
    }

}
