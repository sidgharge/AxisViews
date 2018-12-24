package com.demo.jdbcviews.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.jdbcviews.models.ReviewerTxbPower;
import com.demo.jdbcviews.repositories.ReviewerJdbcRepository;
import com.demo.jdbcviews.repositories.ReviewerRepository;

@RestController
@RequestMapping("/rev")
public class ReviewerController {
	
	@Autowired
	private ReviewerJdbcRepository reviewerRepository;

	@GetMapping("/{id}")
	public ReviewerTxbPower getReviewerById(@PathVariable Integer id) {
		return reviewerRepository.getById(id);
	}
	
	
	@GetMapping("/from/{from}/size/{size}")
	public List<ReviewerTxbPower> getReviewers(@PathVariable Integer from, @PathVariable Integer size) {
		return reviewerRepository.getList(from, size);
	}
}
