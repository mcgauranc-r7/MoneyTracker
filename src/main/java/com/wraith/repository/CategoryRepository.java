package com.wraith.repository;

import com.wraith.repository.entity.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * User: rowan.massey
 * Date: 24/02/13
 * Time: 16:35
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

    public List<Category> findByName(String categoryName);

}
