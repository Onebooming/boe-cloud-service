package com.onebooming.boecloudservice.dao;

import com.onebooming.boecloudservice.bean.Category;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Onebooming
 * @apiNote
 */
@Mapper
public interface CategoryMapper {
    List<Category> getAllCategories();

    int deleteCategoryByIds(@Param("ids") String[] ids);

    int updateCategoryById(Category category);

    int addCategory(Category category);
}
