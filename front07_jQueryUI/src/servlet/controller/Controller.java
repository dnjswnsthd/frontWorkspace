package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Template 기능...
public interface Controller {
	ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response);
}
