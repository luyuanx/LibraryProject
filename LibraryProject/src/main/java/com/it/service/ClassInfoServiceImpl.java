package com.it.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.dao.ClassInfoDao;
import com.it.po.ClassInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service(value = "ClassInfoService")
public class ClassInfoServiceImpl implements ClassInfoService {

    @Autowired
    ClassInfoDao classInfoDao;

    @Override
    public PageInfo<ClassInfo> queryClassInfoAll(String name, int page, int limit) {

        //将分页参数传入，让mybatis处理分页信息
        PageHelper.startPage(page, limit);

        //调用DAO层方法
        List<ClassInfo> list = classInfoDao.queryClassInfoAll(name);

        //通过pageinfo返回封装结果
        PageInfo<ClassInfo> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

    @Override
    public void addClassInfo(ClassInfo classInfo) {
        classInfoDao.addClassInfo(classInfo);
    }

    @Override
    public void updateClassInfo(ClassInfo info) {
        classInfoDao.updateClassInfo(info);
    }

    @Override
    public ClassInfo queryClassInfoById(Integer id) {
        return classInfoDao.queryClassInfoById(id);
    }

    @Override
    public void deleteClassInfoByIds(List<Integer> ids) {
        classInfoDao.deleteClassInfoByIds(ids);
    }


}
