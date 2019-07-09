package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.Type;
import com.team.house.entity.TypeExample;
import com.team.house.mapper.TypeMapper;
import com.team.house.service.TypeService;
import com.team.house.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 王建兵
 * @Classname TypeServiceImpl
 * @Description TODO
 * @Date 2019/6/29 8:32
 * @Created by Administrator
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public PageInfo<Type> getTypeByPage(Page page) {
        PageHelper.startPage(page.getPage(),page.getRows());
        //查询所有
        TypeExample typeExample=new TypeExample();
        List<Type> list=typeMapper.selectByExample(typeExample);
        return new PageInfo<Type>(list);
    }

    @Override
    public int addType(Type type) {
        return typeMapper.insertSelective(type);
    }

    @Override
    public Type getType(Integer id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateType(Type type) {
        return typeMapper.updateByPrimaryKeySelective(type);
    }

    @Override
    public int deleteType(Integer id) {
        return typeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int delMoreType(List<Integer> ids) {
        return typeMapper.delMoreType(ids);
    }

    @Override
    public List<Type> getAllType() {
        return typeMapper.selectByExample(new TypeExample());
    }
}
