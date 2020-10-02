package com.arya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arya.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService service;

	@RequestMapping(value = "/book")
	public String bookPrice(@RequestParam("bid") String id, Model model) {
		Double bookPrice = service.bookPrice(id);
		model.addAttribute("price", "This book price is :: " + bookPrice);
		return "book";
	}
}
