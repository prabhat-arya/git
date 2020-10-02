package com.arya.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@ControllerAdvice
public class GlobleExceptionHandler {

	@ExceptionHandler(value = NullPointerException.class)
	public String handleNullPointerExeption(Model model) {
		model.addAttribute("err", "This is Globle Exception Handler Please try leter..!!");
		return "error";
	}
	@ExceptionHandler(value = UserDefineExceptionNOBookFoundException.class)
	public String handlenoBookFoundException(Model model) {
		model.addAttribute("err", "This is Globle Exception Handler Please try leter..!!");
		return "error";
	}
}
