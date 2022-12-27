package com.ulcotheque.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Antoine
 *
 */

@RestController
@RequestMapping
@Transactional
public class TestBD {
	
	@GetMapping
	public String getMethodtest() {
		return "Back Ulcotheque lancé";	
	}
}
