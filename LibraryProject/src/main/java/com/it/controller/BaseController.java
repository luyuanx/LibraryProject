package com.it.controller;

import com.github.pagehelper.PageInfo;
import com.it.po.BookInfo;
import com.it.po.ClassInfo;
import com.it.po.Notice;
import com.it.service.BookInfoService;
import com.it.service.ClassInfoService;
import com.it.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller()
public class BaseController  {

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private ClassInfoService classInfoService;

    @GetMapping("/index")
    public String index(){
        return "index";
    }






    @RequestMapping("/welcome")
    public String welcome(Model model){

        List<Notice> notices = noticeService.queryNotice();

        if(notices.size()>0){
            Notice info = notices.get(0);
            model.addAttribute("info",info);
        }

        //根据图书类型查询图书数量,做统计

        List<ClassInfo> clslist = classInfoService.queryCountsByType();
        model.addAttribute("clslist",clslist);


        return "welcome";
    }
}
