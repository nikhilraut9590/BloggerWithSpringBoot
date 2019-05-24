package com.nikhilraut.blogger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nikhilraut.blogger.entity.Blog;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer>{

}
