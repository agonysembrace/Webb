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
    public String blog(Model model)//对应函数
    {
        UserDTO user = UserHolder.getUser();
//        Blog blog = blogService.getBlogByIdAndUser(1, user.getUserId());
        List<Blog> list = blogService.getBlogByUserId(user.getUserId());
//        model.addAttribute("blogList",list);
//        if(list.size() > 0)
//          model.addAttribute("blog1",list.get(0));
//        if(list.size() > 1)
//          model.addAttribute("blog2",list.get(1));
//        if(list.size() > 2)
//          model.addAttribute("blog3",list.get(2));
        model.addAttribute("author",user);
        model.addAttribute("blogList",list);
        return "blog";//与templates中index.html对应
    }

    @GetMapping("single")//页面的url地址
    public String singleBlog(@RequestParam("blogId")int blogId, Model model)//对应函数
    {

        Blog blog = blogService.getBlogByBlogId(blogId);
        User user = userService.getUserById(blog.getUserId());
        List<Reply> replyList = blogService.getReplyByBlogId(blogId);
        model.addAttribute("replyList",replyList);
        model.addAttribute("replyListSize",replyList.size());
        model.addAttribute("blog",blog);
        model.addAttribute("author",user);
        return "singleBlog";//与templates中index.html对应
    }

    @RequestMapping(value = "/getImgById", method = RequestMethod.GET)
    public void getImgById(@RequestParam(value = "id")int id,
                           HttpServletResponse response){
        try {
            byte[] img = userService.getImgByUserId(id);
//            byte[] data = imgTest.getImg();
            response.setContentType("image/jpeg");
            response.setCharacterEncoding("UTF-8");
            OutputStream outputSream = response.getOutputStream();
            outputSream.write(img);
            outputSream.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
