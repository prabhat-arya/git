package com.arya.service;

import org.springframework.stereotype.Service;

import com.arya.exception.UserDefineExceptionNOBookFoundException;

@Service
public class BookServiceImpl implements BookService {
	@Override
	public Double bookPrice(String bookId) {
		if (bookId.equals("b123")) {
			return 800.3;
		}else {
			throw new UserDefineExceptionNOBookFoundException("this is user define Exception");
		}
	}

}
