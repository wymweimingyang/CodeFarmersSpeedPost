package com.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.config.Tool;
import com.example.entity.Worker;
import com.example.service.IWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wanghao
 * @since 2020-03-05
 */
@RestController
@RequestMapping("/worker")
public class WorkerController {
    @Autowired
    private IWorkerService IWorkerService;

    @RequestMapping("/test")
    public String  test(){
        System.out.println("test被调用");
        return "test";
    }
    //    @RequestMapping("/getInfoListSQL")
//    public IPage<UserInfoEntity> getInfoListSQL(){
//        //查询大于60分以上的学生,并且分页
//        IPage<UserInfoEntity> page = new Page<>();
//        page.setCurrent(2);
//        page.setSize(5);
//        page = userInfoService.selectUserInfoByGtFraction(page,20L);
//        return page;
//    }
    @RequestMapping("/getListrest")
    public ModelAndView getrest(ModelAndView modelAndView,@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "2") int pageSize,@RequestParam(value = "years", defaultValue = "100") int years,
                                @RequestParam(value = "data", defaultValue = "0") int data,@RequestParam(value = "yx", defaultValue = "0") int yx,
                                @RequestParam(value = "education", defaultValue = "无") String education,@RequestParam(value = "wtype", defaultValue = "无") String wtype,
                                HttpSession session){
        QueryWrapper<Worker> queryWrapper = new QueryWrapper<>();
        Tool tool;
        tool=(Tool) session.getAttribute("tool");
        if(tool!=null){
            if(years !=100){
                tool.setYears(years);
                switch (tool.getYears()){
                    case 0:
                        queryWrapper.lambda().eq(Worker::getYears,0);
                        break;
                    case 1:
                        queryWrapper.lambda().gt(Worker::getYears,1);
                        queryWrapper.lambda().le(Worker::getYears,3);
                        break;
                    case 2:
                        queryWrapper.lambda().gt(Worker::getYears,3);
                        queryWrapper.lambda().le(Worker::getYears,5);
                        break;
                    case 3:
                        queryWrapper.lambda().gt(Worker::getYears,5);
                        queryWrapper.lambda().le(Worker::getYears,10);
                        break;
                    case 4:
                        queryWrapper.lambda().gt(Worker::getYears,10);
                        break;
                    case 5:
                        break;
                }
            }
            if(!(wtype.equals("无"))){
                tool.setWtype(wtype);
                queryWrapper.lambda().like(Worker::getWtype,tool.getWtype());
            }
            if(!(education.equals("无"))){
                tool.setEducation(education);
                queryWrapper.lambda().like(Worker::getEducation,tool.getEducation());
            }
        }else{
            tool=new Tool(education,years,wtype,yx);
            session.setAttribute("tool",tool);
            if(tool.getYears() !=100){
                switch (tool.getYears()){
                    case 0:
                        queryWrapper.lambda().eq(Worker::getYears,0);
                        break;
                    case 1:
                        queryWrapper.lambda().gt(Worker::getYears,1);
                        queryWrapper.lambda().le(Worker::getYears,3);
                        break;
                    case 2:
                        queryWrapper.lambda().gt(Worker::getYears,3);
                        queryWrapper.lambda().le(Worker::getYears,5);
                        break;
                    case 3:
                        queryWrapper.lambda().gt(Worker::getYears,5);
                        queryWrapper.lambda().le(Worker::getYears,10);
                        break;
                    case 4:
                        queryWrapper.lambda().gt(Worker::getYears,10);
                        break;
                }
            }
            if(!(tool.getWtype().equals("无"))){
                queryWrapper.lambda().like(Worker::getWtype,tool.getWtype());
            }
            if(!(tool.getEducation().equals("无"))){
                queryWrapper.lambda().like(Worker::getEducation,tool.getEducation());
            }
        }
        IPage<Worker> page = new Page<>();
        page.setCurrent(pageNum); //当前页
        page.setSize(pageSize);    //每页条数
        int shu=IWorkerService.count(queryWrapper);//总数居
        int z=0;
        if(shu%2 ==0){
            z =shu/2;
        }else{
            z =shu/2+1;
        }

        System.out.println("总页数" + z);
        System.out.println("当前页是：" + pageNum);
        System.out.println("分页数据：");
        page=IWorkerService.page(page,queryWrapper);
        Iterator<Worker> u = page.getRecords().iterator();
        while (u.hasNext()){

            System.out.println(u.next().toString());
        }
        List<Worker> li=page.getRecords();
        modelAndView.addObject("work", li);
        modelAndView.addObject("z",z);
        modelAndView.addObject("Num",pageNum);
        System.out.println(pageNum);
        System.out.println(z);
        modelAndView.setViewName("workerList");
        return  modelAndView;
    }
    @RequestMapping("/getList")
    public ModelAndView getInfo(ModelAndView modelAndView, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "2") int pageSize){
        IPage<Worker> page = new Page<>();
        page.setCurrent(pageNum); //当前页
        page.setSize(pageSize);    //每页条数
        int shu=IWorkerService.count();//总数居
        int z=0;
        if(shu%2 ==0){
            z =shu/2;
        }else{
            z =shu/2+1;
        }

        System.out.println("总页数" + z);
        System.out.println("当前页是：" + pageNum);
        System.out.println("分页数据：");
        page=IWorkerService.page(page);
        Iterator<Worker> u = page.getRecords().iterator();
        while (u.hasNext()){

            System.out.println(u.next().toString());
        }
        List<Worker> li=page.getRecords();
        modelAndView.addObject("work", li);
        modelAndView.addObject("z",z);
        modelAndView.addObject("Num",pageNum);
        System.out.println(pageNum);
        System.out.println(z);
        modelAndView.setViewName("workerList");
        return modelAndView;
    }
    @RequestMapping("/getInfoListPage")
    public ModelAndView getInfoListPage(@RequestParam(value = "id", defaultValue = "1") int id,ModelAndView modelAndView){
        //需要在Config配置类中配置分页插件
        Worker page = IWorkerService.getById(id);
        modelAndView.addObject("word",page);
        modelAndView.setViewName("workerinfo");
        return modelAndView;
    }
}
