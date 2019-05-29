package com.nikhilraut.blogger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nikhilraut.blogger.entity.BlogCategory;
@Repository
public interface IBlogCategoryRepository extends JpaRepository<BlogCategory, Integer>{

}
