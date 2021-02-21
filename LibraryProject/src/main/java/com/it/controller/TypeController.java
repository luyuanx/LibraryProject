package com.it.controller;


import com.github.pagehelper.PageInfo;
import com.it.po.ClassInfo;
import com.it.service.ClassInfoService;
import com.it.util.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class TypeController {

    @Autowired
    private ClassInfoService classInfoService;

    @GetMapping("/typeIndex")
    public String typeIndex() {
        return "type/typeIndex";
    }

    @GetMapping("/typeAll")
    @ResponseBody
    public Object typeAll(String name, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15")Integer limit){


        PageInfo<ClassInfo> pageInfo = classInfoService.queryClassInfoAll(name,page,limit);

        //返回数据响应类
        return R.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }


    // 类型添加的跳转
    @RequestMapping("/typeAdd")
    public String addType(){
        return "type/addType";
    }
    /**
     * 类型添加后提交
     */
    @ResponseBody
    @RequestMapping("/addTypeSubmit")
    public R addTypeSubmit(ClassInfo info){
      classInfoService.addClassInfo(info);
        return R.ok();
    }

    /**
     * 删除类型
     */
    @ResponseBody
    @RequestMapping("/deleteType")
    public R deleteType(String ids){
        //将前端传来的字符串转换为list
        List<String> strings = Arrays.asList(ids.split(","));
        //将String转为int,因为业务层传的是Integer类型参数
        List<Integer> list = new ArrayList<Integer>();
        for (String string:strings){
            Integer id = Integer.valueOf(string);
            list.add(id);
        }
        classInfoService.deleteClassInfoByIds(list);

        return R.ok();
    }
}
