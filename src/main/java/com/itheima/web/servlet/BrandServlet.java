package com.itheima.web.servlet;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandService;
import com.itheima.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * @author: Java_cmr
 * @Date: 2023/2/16 - 15:37
 */

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{
    private BrandService brandService = new BrandServiceImpl();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Brand> brands = brandService.selectAll();
        String jsonString = JSON.toJSONString(brands);

        response.setContentType("text/json; charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        BufferedReader bf = request.getReader();
        String params = bf.readLine();

        Brand brand = JSON.parseObject(params, Brand.class);

        brandService.add(brand);
        response.getWriter().write("success");
    }

    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        BufferedReader bf = request.getReader();
        String params = bf.readLine();

        int[] ids = JSON.parseObject(params, int[].class);

        brandService.deleteByIds(ids);
        response.getWriter().write("success");
    }

    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));

        PageBean<Brand> brandPageBean = brandService.selectByPage(currentPage, pageSize);

        String jsonString = JSON.toJSONString(brandPageBean);

        response.setContentType("text/json; charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));

        BufferedReader bf = request.getReader();
        String params = bf.readLine();
        Brand brand = JSON.parseObject(params, Brand.class);

        PageBean<Brand> brandPageBean = brandService.selectByPageAndCondition(currentPage, pageSize, brand);

        String jsonString = JSON.toJSONString(brandPageBean);

        response.setContentType("text/json; charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void updateById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        BufferedReader bf = request.getReader();
        String params = bf.readLine();

        Brand brand = JSON.parseObject(params, Brand.class);

        brandService.updateById(brand);
        response.getWriter().write("success");
    }
}
