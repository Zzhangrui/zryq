package com.zryq.cms.admin.controller;

import com.zryq.cms.admin.entity.Article;
import com.zryq.cms.admin.entity.Column;
import com.zryq.cms.admin.entity.Group;
import com.zryq.cms.admin.entity.WebInfo;
import com.zryq.cms.admin.service.ArticleService;
import com.zryq.cms.admin.service.ColumnService;
import com.zryq.cms.admin.service.GroupService;
import com.zryq.cms.admin.service.WebInfService;
import com.zryq.cms.common.data.LayUiData;
import com.zryq.cms.common.data.WebTempKeyValue;
import com.zryq.cms.common.enums.ArticleStatus;
import com.zryq.cms.common.enums.WebTemplate;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.zryq.cms.admin.entity.Article;
import com.zryq.cms.admin.entity.Column;
import com.zryq.cms.admin.entity.Group;
import com.zryq.cms.admin.entity.WebInfo;
import com.zryq.cms.admin.service.ArticleService;
import com.zryq.cms.admin.service.ColumnService;
import com.zryq.cms.admin.service.GroupService;
import com.zryq.cms.admin.service.WebInfService;
import com.zryq.cms.common.data.WebTempKeyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 前台页面控制器
 * Created by 锐 on 2017/11/14.
 */
@Controller
public class FrontController {

    @Autowired
    private WebInfService webInfService;

    @Autowired
    private ColumnService columnService;

    @Autowired
    private ArticleService articleService;


    @Autowired
    private GroupService groupService;

    /**
     * 打开首页
     *
     * @param id 站点id
     * @return
     */
    @RequestMapping("{id}/index")
    public ModelAndView index(@PathVariable("id") Integer webId, Integer pageNum, Integer pageSize) {
        if (null == pageNum) {
            pageNum = 1;
        }
        if (null == pageSize) {
            pageSize = 5;
        }

        WebInfo webInfo = webInfService.selectById(webId);

        Integer temId = webInfo.getTempId();

        String tempName = WebTempKeyValue.WebTempMap.get(temId);  //所使用的模板属于哪个洲市


        ModelAndView modelAndView = new ModelAndView("/front/" + tempName + "/index");
        List<Column> topColumnList =
                columnService.selectDefaultSonColumn(webId, "1", null);//"1" 代表顶部导航
        List<Column> picColumnList =
                columnService.selectDefaultSonColumn(webId, "2", null);//"2" 代表专题专栏
        List<Column> lhColumnList = columnService.selectColumnByWebId(webId, "3", null);//后来灵活新增的栏目

        Column tzgg = columnService.selectArticleByColumnPosition(1, 6, webId, "tzgg");
        modelAndView.addObject("tzgg", tzgg);

        Column zhyw = columnService.selectArticleByColumnPosition(1, 6, webId, "zhyw");
        modelAndView.addObject("zhyw", zhyw);

        Column gddt = columnService.selectArticleByColumnPosition(1, 6, webId, "gddt");
        modelAndView.addObject("gddt", gddt);

        Column jcfc1 = columnService.selectArticleByColumnPosition(1, 9, webId, "jcfc1");
        modelAndView.addObject("jcfc1", jcfc1);

        Column jcfc2 = columnService.selectArticleByColumnPosition(1, 12, webId, "jcfc2");
        modelAndView.addObject("jcfc2", jcfc2);

        Column jcfc3 = columnService.selectArticleByColumnPosition(1, 6, webId, "jcfc3");
        modelAndView.addObject("jcfc3", jcfc3);

        Column jcfc4 = columnService.selectArticleByColumnPosition(1, 6, webId, "jcfc4");
        modelAndView.addObject("jcfc4", jcfc4);

        Column jcfc5 = columnService.selectArticleByColumnPosition(1, 6, webId, "jcfc5");
        modelAndView.addObject("jcfc5", jcfc5);

        Column jcfc6 = columnService.selectArticleByColumnPosition(1, 6, webId, "jcfc6");
        modelAndView.addObject("jcfc6", jcfc6);



        List<Article> recentArticleList = articleService.selectRecent(1, 5, webId);  //最近更新
        modelAndView.addObject("recentArticleList", recentArticleList);

        if (recentArticleList != null && !recentArticleList.isEmpty()) {
            recentArticleList.forEach(article -> {

            });
        }



        lhColumnList = columnService.selectFlexColumn(1, 6, webId, "3");
        modelAndView.addObject("lhColumnList", lhColumnList);
        modelAndView.addObject("topColumnList", topColumnList);
        modelAndView.addObject("picColumnList", picColumnList);


        modelAndView.addObject("webInfo", webInfo);


        List<Group> groupList = groupService.selectWebGroup(webId, null);

        modelAndView.addObject("groupList", groupList);

        List<Article> picArticleList = articleService.includePic(webId, null);

        modelAndView.addObject("picArticleList", picArticleList);

        return modelAndView;
    }


    /**
     * 获取id
     *
     * @param entityLiet
     * @return
     */
    private List<Integer> getIdList(List<Column> entityLiet) {
        List<Integer> idList = Lists.newArrayList();
        entityLiet.forEach(entity -> {
            idList.add(entity.getId());
        });
        return idList;
    }


    /**
     * 获取栏目list
     *
     * @param id
     * @param columnId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("{id}/list/{columnId}")
    public ModelAndView list(@PathVariable("id") Integer webId, @PathVariable("columnId") Integer columnId, Integer pageNum, Integer pageSize) {
        if (null == pageNum) {
            pageNum = 1;
        }
        if (null == pageSize) {
            pageSize = 5;
        }
        WebInfo webInfo = webInfService.selectById(webId);

        Integer temId = webInfo.getTempId();

        String tempName = WebTempKeyValue.WebTempMap.get(temId);  //所使用的模板属于哪个洲市


        ModelAndView modelAndView = new ModelAndView("/front/" + tempName + "/list");
        Column column = columnService.selectById(columnId);
        modelAndView.addObject("column", column);
        PageInfo pageInfo =
                articleService.selectColumnArticle(pageNum, pageSize, columnId, ArticleStatus.Publish.getValue());
        modelAndView.addObject("articleList", pageInfo.getList());

        List<Column> topColumnList =
                columnService.selectDefaultSonColumn(webId, "1", null);//"1" 代表顶部导航
        modelAndView.addObject("topColumnList", topColumnList);


        return modelAndView;
    }

    /**
     * 前台列表页获取数据
     *
     * @param pageNum
     * @param pageSize
     * @param webId
     * @param coluId
     * @return
     */
    @RequestMapping("{id}/data/{columnId}")
    @ResponseBody
    public LayUiData frontData(@RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize, @PathVariable("id") Integer webId, @PathVariable("columnId") Integer coluId) {
        LayUiData data = new LayUiData();

        PageInfo pageInfo = articleService.frontData(pageNum, pageSize, webId, coluId);
        data.setCode("0");
        data.setCount(Integer.valueOf(String.valueOf(pageInfo.getTotal())));
        data.setData(pageInfo.getList());

        return data;
    }


    /**
     * 获取栏目list
     *
     * @param id
     * @param columnId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("{id}/group/{groupId}")
    public ModelAndView groupList(@PathVariable("id") Integer webId, @PathVariable("groupId") Integer groupId, Integer pageNum, Integer pageSize) {
        if (null == pageNum) {
            pageNum = 1;
        }
        if (null == pageSize) {
            pageSize = 5;
        }
        WebInfo webInfo = webInfService.selectById(webId);

        Integer temId = webInfo.getTempId();

        String tempName = WebTempKeyValue.WebTempMap.get(temId);  //所使用的模板属于哪个洲市


        ModelAndView modelAndView = new ModelAndView("/front/" + tempName + "/group");
        Group group = groupService.selectById(groupId);
        modelAndView.addObject("group", group);
        PageInfo pageInfo =
                articleService.selectGroupArticle(pageNum, pageSize, groupId, ArticleStatus.Publish.getValue());
        modelAndView.addObject("articleList", pageInfo.getList());

        List<Column> topColumnList =
                columnService.selectDefaultSonColumn(webId, "1", null);//"1" 代表顶部导航
        modelAndView.addObject("topColumnList", topColumnList);
        return modelAndView;
    }

    /**
     * 前台列表页获取数据
     *
     * @param pageNum
     * @param pageSize
     * @param webId
     * @param coluId
     * @return
     */
    @RequestMapping("{id}/groupData/{groupId}")
    @ResponseBody
    public LayUiData frontGroupData(@RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize, @PathVariable("id") Integer webId, @PathVariable("groupId") Integer groupId) {
        LayUiData data = new LayUiData();

        PageInfo pageInfo = articleService.frontGroupData(pageNum, pageSize, webId, groupId);
        data.setCode("0");
        data.setCount(Integer.valueOf(String.valueOf(pageInfo.getTotal())));
        data.setData(pageInfo.getList());

        return data;
    }



    /**
     * 文章详情页
     *
     * @param webId
     * @param artId
     * @return
     */
    @RequestMapping("{id}/detail/{artId}")
    public ModelAndView detail(@PathVariable("id") Integer webId, @PathVariable("artId") Integer artId) {
        WebInfo webInfo = webInfService.selectById(webId);

        Integer temId = webInfo.getTempId();

        String tempName = WebTempKeyValue.WebTempMap.get(temId);  //所使用的模板属于哪个洲市


        ModelAndView modelAndView = new ModelAndView("/front/" + tempName + "/detail");
        Article article = articleService.selectById(artId);
        modelAndView.addObject("article", article);

        List<Column> topColumnList =
                columnService.selectDefaultSonColumn(webId, "1", null);//"1" 代表顶部导航
        modelAndView.addObject("topColumnList", topColumnList);

        return modelAndView;
    }



}
