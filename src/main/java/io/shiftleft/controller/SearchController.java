package io.shiftleft.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Search login
 */
@Controller
public class SearchController {

  @RequestMapping(value = "/search/user", method = RequestMethod.GET)
	@RequestMapping(value = "/search/user", method = RequestMethod.GET)
	public String doGetSearch(@RequestParam String foo, HttpServletResponse response, HttpServletRequest request) {
		String whitelist = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder sb = new StringBuilder();
		for (char c : foo.toCharArray()) {
			if (whitelist.indexOf(c) != -1) {
				sb.append(c);
			}
		}
		String cleanedFoo = sb.toString();
		// ... rest of the code
	}


