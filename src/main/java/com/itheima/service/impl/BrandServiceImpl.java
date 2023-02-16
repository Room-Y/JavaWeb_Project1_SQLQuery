package com.itheima.service.impl;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandService;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author: Java_cmr
 * @Date: 2023/2/15 - 21:18
 */
public class BrandServiceImpl implements BrandService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Brand> selectAll() {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = mapper.selectAll();
        //释放资源
        sqlSession.close();

        return brands;
    }

    @Override
    public void add(Brand brand) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.add(brand);

        sqlSession.commit();
        sqlSession.close();
        return;
    }

    public void deleteByIds(int[] ids) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.deleteByIds(ids);

        sqlSession.commit();
        sqlSession.close();
        return;
    }

    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pagesize) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        int begin = (currentPage - 1) * pagesize;

        List<Brand> brands = mapper.selectByPage(begin, pagesize);
        int count = mapper.selectTotalCount();

        PageBean<Brand> objectPageBean = new PageBean<>();
        objectPageBean.setRows(brands);
        objectPageBean.setTotalCount(count);

        sqlSession.close();
        return objectPageBean;
    }

    @Override
    public PageBean<Brand> selectByPageAndCondition(int currentPage, int pagesize, Brand brand) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        int begin = (currentPage - 1) * pagesize;

        String brandName = brand.getBrandName();
        if(brandName != null && brandName.length() > 0){
            brand.setBrandName("%" + brandName + "%");
        }

        String companyName = brand.getCompanyName();
        if(companyName != null && companyName.length() > 0){
            brand.setCompanyName("%" + companyName + "%");
        }
        
        List<Brand> brands = mapper.selectByPageAndCondition(begin, pagesize, brand);

        int count = mapper.selectTotalCountByCondition(brand);

        PageBean<Brand> objectPageBean = new PageBean<>();
        objectPageBean.setRows(brands);
        objectPageBean.setTotalCount(count);

        sqlSession.close();
        return objectPageBean;
    }

    @Override
    public void updateById(Brand brand) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.updateById(brand);

        sqlSession.commit();
        sqlSession.close();
        return;
    }

}
