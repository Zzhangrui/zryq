package com.zryq.cms.admin.service;

import com.zryq.cms.admin.dao.CommentMapper;
import com.zryq.cms.admin.entity.Article;
import com.zryq.cms.admin.entity.ArticleExample;
import com.zryq.cms.admin.entity.Comment;
import com.zryq.cms.admin.entity.CommentExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import com.zryq.cms.common.data.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2017-11-10.
 */
@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;

    public JsonResult add(Comment comment) {
        if (null == comment || null == comment.getArticleId()
                || Strings.isNullOrEmpty(comment.getCommContent())) {
            return JsonResult.ERROR_PARAM;
        }
        comment.setCommTime(new Date());
        comment.setCommState(0);//保存
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
            comment.setUserIp(addr.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        commentMapper.insert(comment);
        return JsonResult.SUCCESS;
    }

    public boolean updateState(Integer id, Integer state) {
        Comment comment = new Comment();
        comment.setId(id);
        comment.setCommState(state);
        return commentMapper.updateByPrimaryKeySelective(comment) > 0;
    }

    public boolean modifyById(Comment comment) {
        return commentMapper.updateByPrimaryKeySelective(comment) > 0;
    }

    public PageInfo selectCommentData(Integer pageNum, Integer pageSize, String title, String search) {
        PageHelper.startPage(pageNum, pageSize);
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.or();
        if (!Strings.isNullOrEmpty(title)) {
            criteria.andCommContentLike("%" + title + "%");
        }
        if (!Strings.isNullOrEmpty(search)) {
            criteria.andCommContentLike("%" + search + "%");
        }

        List<Comment> commentList = commentMapper.selectByExample(commentExample);
        PageInfo<Comment> pageInfo = new PageInfo<>(commentList);
        return pageInfo;
    }

    public Comment selectById(Integer id) {
        return commentMapper.selectByPrimaryKey(id);
    }


    /**
     * 归档
     *
     * @param ids
     * @param state
     * @return
     */
    public boolean undo(String ids, Integer state) {
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.or();

        List<Integer> idList = new ArrayList<Integer>();
        if (ids != null) {
            for (int i = 0; i < ids.split(",").length; i++) {

                if (ids.split(",")[i] != null && ids.split(",")[i] != "")
                    idList.add(Integer.valueOf(ids.split(",")[i]));
            }
        }
        criteria.andIdIn(idList);
        Comment comment = new Comment();
        comment.setCommState(state);
        return commentMapper.updateByExampleSelective(comment, commentExample) > 0;

    }


    public PageInfo getBlogComment(Integer pageSize, Integer pageNum, Integer articleId) {
        if (null == pageNum) {
            pageNum = 0;
        }
        if (null == pageSize) {
            pageSize = 5;
        }
        if(null == articleId){
            return new PageInfo();
        }
        CommentExample commentExample = new CommentExample();
        commentExample.setOrderByClause("id DESC");
        CommentExample.Criteria criteria = commentExample.or();
        criteria.andArticleIdEqualTo(articleId);
        PageHelper.startPage(pageNum, pageSize);
        List<Comment> commentList = commentMapper.selectByExample(commentExample);
        PageInfo pageInfo = new PageInfo(commentList);
        return pageInfo;
    }

}
