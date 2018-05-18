import com.zryq.cms.admin.dao.ColumnMapper;
import com.zryq.cms.admin.dao.RoleMapper;
import com.zryq.cms.admin.dao.UserMapper;
import com.zryq.cms.admin.dao.WebInfoMapper;
import com.zryq.cms.admin.entity.Article;
import com.zryq.cms.admin.entity.Column;
import com.zryq.cms.admin.entity.Role;
import com.zryq.cms.admin.service.ArticleService;
import com.zryq.cms.admin.service.UserService;
import com.zryq.cms.common.enums.WebTemplate;
import com.zryq.cms.common.utils.FreeMarkerUtil;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 锐 on 2017/10/20.
 */
public class TestService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private WebInfoMapper webInfoMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private ColumnMapper columnMapper;


    @Autowired
    private ArticleService articleService;

    /*public  void test(){

        Map  map = new HashMap<>();
        map.put("username","张锐1");
        FreeMarkerUtil.createHtml("贵州省检察院/list.ftl",map,"list.html");
    }

    public void test19(){
        Role role = roleMapper.selectPermissionByRoleId(1);
        System.out.println(" = ");
    }



    public void test2(){
        int a = WebTemplate.GYS.getValue();

        String b = WebTemplate.GYS.getName();

        System.out.println("aaa");

    }


    public void test3(){

       List<Article> articleList =  articleService.includePic(null,null);
        System.out.println("aaa");
    }*/
}
