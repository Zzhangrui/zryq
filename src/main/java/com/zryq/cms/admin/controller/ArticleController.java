package com.zryq.cms.admin.controller;

import com.google.common.collect.Sets;
import com.zryq.cms.admin.entity.Article;
import com.zryq.cms.admin.entity.User;
import com.zryq.cms.admin.service.ArticleService;
import com.zryq.cms.common.data.JsonResult;
import com.zryq.cms.common.data.LayUiData;
import com.zryq.cms.common.utils.SessionPerson;
import com.github.pagehelper.PageInfo;
import com.zryq.cms.admin.entity.Article;
import com.zryq.cms.admin.entity.User;
import com.zryq.cms.admin.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by 锐 on 2017/10/24.
 * 文章controller
 */
@Controller
@RequestMapping("article")
public class ArticleController extends BaseController {


    @Autowired
    private ArticleService articleService;


    /**
     * 打开首页
     *
     * @return
     */
    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("admin/article_index");
        return modelAndView;
    }


    /**
     * 获取数据
     *
     * @param pageNum
     * @param pageSize
     * @param title
     * @param coluId
     * @return
     */
    @RequestMapping("data")
    @ResponseBody
    public LayUiData data(Integer pageNum, Integer pageSize, String title, Integer coluId) {
        if (pageNum == null) {

            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        Integer webId = SessionPerson.getWebId(); //获取站点
        PageInfo pageInfo =
                articleService.selectArticleData(pageNum, pageSize, title, coluId, webId);
        LayUiData data = new LayUiData();
        data.setCode("0");
        data.setCount(Integer.valueOf(String.valueOf(pageInfo.getTotal())));
        data.setData(pageInfo.getList());
        return data;
    }


    /**
     * 新增显示
     *
     * @param coluId
     * @param coluName
     * @return
     */
    @RequestMapping("add_show")
    public ModelAndView showAdd(Integer coluId, String coluName) {
        ModelAndView modelAndView = new ModelAndView("admin/article_add");
        modelAndView.addObject("coluId", coluId);
        modelAndView.addObject("coluName", coluName);
        modelAndView.addObject("url", "add_submit");
        return modelAndView;

    }

    /**
     * 新增提交
     *
     * @param article
     * @return
     */
    @RequestMapping("add_submit")
    @ResponseBody
    public JsonResult submitAdd(Article article) {

        JsonResult jsonResult = new JsonResult();
        jsonResult.setMessage("编辑成功");
        User user = currentUser();
        articleService.add(article, user);
        jsonResult.setSuccess(true);
        return jsonResult;

    }

    /**
     * 修改显示
     *
     * @param id
     * @return
     */
    @RequestMapping("modify_show/{id}")
    public ModelAndView showModify(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("admin/article_modify");
        Article article = articleService.selectById(id);
        modelAndView.addObject("article", article);
        modelAndView.addObject("url", "modify_submit");
        return modelAndView;
    }


    /**
     * 修改提交
     *
     * @param article
     * @return
     */
    @RequestMapping("modify_submit")
    @ResponseBody
    public JsonResult submitModify(Article article) {
        JsonResult jsonResult = new JsonResult();
        articleService.modifyById(article);
        jsonResult.setSuccess(true);
        return jsonResult;
    }


    /**
     * 更新
     *
     * @param id
     * @param state
     * @return
     */
    @RequestMapping("update/{id}/{state}")
    @ResponseBody
    public JsonResult updateState(@PathVariable("id") Integer id, @PathVariable("state") Integer state) {
        JsonResult jsonResult = new JsonResult();
        articleService.updateState(id, state);
        jsonResult.setSuccess(true);
        return jsonResult;
    }

    /**
     * 撤稿
     *
     * @param ids
     * @param state
     * @return
     */
    @RequestMapping("undo")
    @ResponseBody
    public JsonResult undo(String ids, Integer state) {
        JsonResult jsonResult = new JsonResult();
        state = 4; //表示归档
        articleService.undo(ids, state);
        jsonResult.setSuccess(true);
        return jsonResult;
    }


    /**
     * 转移显示
     *
     * @param ids
     * @return
     */
    @RequestMapping("move_show")
    public ModelAndView showMove(String ids) {
        ModelAndView modelAndView = new ModelAndView("admin/article_move");
        modelAndView.addObject("ids", ids);
        modelAndView.addObject("url", "move_submit");
        return modelAndView;
    }

    /**
     * 转移提交
     *
     * @param ids
     * @param coluId
     * @return
     */
    @RequestMapping("move_submit")
    @ResponseBody
    public JsonResult submitMove(String ids, Integer coluId) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        articleService.move(ids, coluId);
        return jsonResult;
    }



    @RequestMapping("share_show")
    public ModelAndView showShare(String ids) {
        ModelAndView modelAndView = new ModelAndView("admin/article_share");
        modelAndView.addObject("url", "share_submit");
        modelAndView.addObject("ids", ids);

        return modelAndView;
    }

    @RequestMapping("share_submit")
    @ResponseBody
    public JsonResult submitShare(String ids, Integer webId) {
        JsonResult jsonResult = new JsonResult();
        return jsonResult;
    }


    public static void main(String[] args) {

        isPowerOfFour(16);
    }

    public static void  isPowerOfFour(int num) {
       String n =  Integer.toBinaryString( num);
        System.out.println("n = " + n);

    }


    public static void solution(){
        String s ="abcabcdfdefgghbeeerbddd";
        int max = 0;
        int temMax= 0;
        byte[] a = s.getBytes();
        List charSet = new ArrayList();
        for(byte b : a){
            if(charSet.contains(b)){
                int startIndex = charSet.indexOf(b);
                charSet = charSet.subList(startIndex+1,charSet.size());
                charSet.add(b);
                max = temMax>max?temMax:max;
                temMax = charSet.size();
            }else{
                charSet.add(b);
                temMax = temMax+1;
            }
        }
        System.out.println(max);
    }

}
