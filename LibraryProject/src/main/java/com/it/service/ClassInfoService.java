package com.it.service;

import com.github.pagehelper.PageInfo;
import com.it.po.ClassInfo;

import java.util.List;

public interface ClassInfoService {
    PageInfo<ClassInfo> queryClassInfoAll(String name,int page,int limit);

    //添加图书类型
    void addClassInfo(ClassInfo classInfo);


    //修改图书类型
    void updateClassInfo(ClassInfo info);

    //根据id查询图书类型,更改类型时数据回显需要用到
    ClassInfo queryClassInfoById(Integer id);

    //删除图书类型
    void deleteClassInfoByIds(List<Integer> ids);



}
