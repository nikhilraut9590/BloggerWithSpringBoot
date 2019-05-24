package com.nikhilraut.blogger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nikhilraut.blogger.entity.Feedback;

@Repository
public interface IFeedbackRepository extends JpaRepository<Feedback, Integer> {

}
