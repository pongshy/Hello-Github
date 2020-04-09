package com.shu.labrary.controller;

import com.shu.labrary.exception.AllException;
import com.shu.labrary.service.surface.ManagerService;
import com.shu.labrary.service.surface.Teacherservice;
import com.shu.labrary.service.surface.UserService;
import com.shu.labrary.tools.TableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

/**
 * @Description: 公共页面接口
 * @Author: pongshy
 * @Date: 2020-2-23
 */
@RestController
@CrossOrigin
@RequestMapping("/public")
public class PublicController {
    @Autowired
    private Teacherservice teacherservice;

    @Autowired
    private UserService userService;

    @Autowired
    private ManagerService managerService;


    /**
     * @Description: 首页显示明星教师
     * @Param: []
     * @Return: com.shu.labrary.model.tools.TableModel\
     * @Author: pongshy
     * @Date: 2020-2-3
     */
    @GetMapping("showTeachers")
    @ResponseBody
    public TableModel showAllTeachers() throws AllException {

        return teacherservice.showInformation();
    }

    /**
     * @Description: 首页加载有图片新闻，5条——轮播图
     * @Param: []
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-13
     */
    @GetMapping("showPictureNews")
    @ResponseBody
    public TableModel showPictureNews() throws AllException {

        return userService.pictureNews();
    }


    /**
     * @Description: 首页加载有图片新闻，3条
     * @Param: []
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-13
     */
    @GetMapping("showNewsWithoutPicture")
    @ResponseBody
    public TableModel showNewsWithoutPicture() throws AllException {

        return userService.showNews();
    }

    /**
     * @Description: 前端发送一个当前页码序号，后端发送总共的新闻总数以及10条新闻
     * @Param: [cur]
     * @Return: com.shu.labrary.tools.TableModel
     * @Author: pongshy
     * @Date: 2020-2-13
     */
    @GetMapping("newsPage")
    @ResponseBody
    public TableModel showNewsPage(@RequestParam(value = "cur", defaultValue = "1") Integer cur) throws AllException {
        return userService.showNewsPage(cur);
    }


    @RequestMapping(value = "/searchNews")
    @ResponseBody
    public TableModel searchNews(@RequestParam("newsId") Integer newsId) throws ParseException, AllException {

        return managerService.searchNews(newsId);
    }


    @RequestMapping(value = "/searchNewsForLatest")
    @ResponseBody
    public TableModel searchNewsForLatest() throws ParseException, AllException {

        return managerService.searchNewsForLatest();

    }


}
