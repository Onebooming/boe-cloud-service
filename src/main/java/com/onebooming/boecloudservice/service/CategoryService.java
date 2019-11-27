package com.onebooming.boecloudservice.service;

import com.onebooming.boecloudservice.bean.Category;
import com.onebooming.boecloudservice.dao.CategoryMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Onebooming
 * @apiNote
 */
@Service
@Transactional
public class CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    /*
       @Autowired注解后，如果categoryMapper接口没有被@Compenent注解，就会显示no beans of “CategoryMapper” found
     */


    public List<Category> getAllCategories() {
        return categoryMapper.getAllCategories();
    }

    public boolean deleteCategoryByIds(String ids) {
        String[] split = ids.split(",");
        int result = categoryMapper.deleteCategoryByIds(split);
        return result == split.length;
    }

    public int updateCategoryById(Category category) {
        return categoryMapper.updateCategoryById(category);
    }

    public int addCategory(Category category) {
        category.setDate(new Timestamp(System.currentTimeMillis()));
        return categoryMapper.addCategory(category);
    }
}
