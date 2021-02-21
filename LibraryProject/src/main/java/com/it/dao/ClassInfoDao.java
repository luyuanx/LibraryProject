package com.it.dao;

import com.it.po.ClassInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassInfoDao {
    List<ClassInfo> queryClassInfoAll(@Param(value = "name") String name);
    //@Param是MyBatis所提供的(org.apache.ibatis.annotations.Param)，作为Dao层的注解，作用是用于传递参数，从而可以与SQL中的的字段名相对应


    //添加图书类型
    void addClassInfo(ClassInfo classInfo);


    //修改图书类型
    void updateClassInfo(ClassInfo info);

    //根据id查询图书类型,更改类型时数据回显需要用到
    ClassInfo queryClassInfoById(Integer id);

    //删除图书类型
    void deleteClassInfoByIds(List<Integer> ids);




}
