package com.example.web.controller;

import com.example.web.DTO.UserDTO;
import com.example.web.pojo.Blog;
import com.example.web.pojo.Reply;
import com.example.web.pojo.User;
import com.example.web.service.BlogService;
import com.example.web.service.Impl.BlogServiceImpl;
import com.example.web.service.UserService;
import com.example.web.utils.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author lingfei Wang
 * @version 1.0
 * @date 2022/11/15 21:02
 * @Decription:
 */

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    UserService userService;
    @GetMapping("blog")//页面的url地址
    public String blog(@RequestParam("authorId") int authorId, Model model)//对应函数
    {
        User author = userService.getUserById(authorId);
        UserDTO visitor = UserHolder.getUser();
        List<Blog> list = blogService.getBlogByUserId(author.getUserId());

        model.addAttribute("visitor",visitor);
        model.addAttribute("author",author);
        model.addAttribute("blogList",list);
        boolean followingStat = userService.FollowingOrNot(visitor.getUserId(), authorId);
        model.addAttribute("followingStat",followingStat);
        return "blog";
    }

    @GetMapping("single")//页面的url地址
    public String singleBlog(@RequestParam("blogId")int blogId, Model model)//对应函数
    {
        UserDTO visitor = UserHolder.getUser();
        Blog blog = blogService.getBlogByBlogId(blogId);
        //因为是从博客标题点进来的，所以直接通过携带的博客Id获取作者id
        User user = userService.getUserById(blog.getUserId());
        List<Reply> replyList = blogService.getReplyByBlogId(blogId);
        model.addAttribute("visitor",visitor);
        model.addAttribute("replyList",replyList);
        model.addAttribute("replyListSize",replyList.size());
        model.addAttribute("blog",blog);
        model.addAttribute("author",user);
        boolean followingStat = userService.FollowingOrNot(visitor.getUserId(), user.getUserId());
        model.addAttribute("followingStat",followingStat);
        return "singleBlog";//与templates中index.html对应
    }

    @RequestMapping(value = "/getImgById", method = RequestMethod.GET)
    public void getImgById(@RequestParam(value = "id")int id,
                           HttpServletResponse response) throws IOException {
        OutputStream outputStream = null;
        try {
            byte[] img = userService.getImgByUserId(id);
//            byte[] data = imgTest.getImg();```
            response.setContentType("image/jpeg");
            response.setCharacterEncoding("UTF-8");
            outputStream = response.getOutputStream();
            outputStream.write(img);
            outputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            outputStream.close();
        }
    }
}
