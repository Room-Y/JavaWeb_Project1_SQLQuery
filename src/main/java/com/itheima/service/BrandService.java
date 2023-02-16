package com.itheima.service;

import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: Java_cmr
 * @Date: 2023/2/15 - 21:17
 */
public interface BrandService {

    List<Brand> selectAll();

    void add(Brand brand);

    void deleteByIds(int[] ids);

    PageBean<Brand> selectByPage(int currentPage, int pagesize);

    PageBean<Brand> selectByPageAndCondition(int currentPage, int pagesize, Brand brand);

    void updateById(Brand brand);
}
