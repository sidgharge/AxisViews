package com.demo.jdbcviews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.jdbcviews.models.UserView;

public interface UserViewRepository extends JpaRepository<UserView, Long> {

}
