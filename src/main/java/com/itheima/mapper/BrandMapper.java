package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {

    //查询所有列表数据
    @Select("select * from test.tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    //添加数据
    @Insert("insert into test.tb_brand  values (null, #{brandName}, #{companyName}, #{ordered}, #{description}, #{status});")
    void add(Brand brand);

    void deleteByIds(@Param("ids") int[] ids);

    @Select("select * from test.tb_brand limit #{begin}, #{size}")
    @ResultMap("brandResultMap")
    List<Brand> selectByPage(@Param("begin") int begin, @Param("size") int size);

    @Select("select count(*) from test.tb_brand")
    int selectTotalCount();

    List<Brand> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("brand") Brand brand);

    int selectTotalCountByCondition(Brand brand);


    void updateById(Brand brand);
}
