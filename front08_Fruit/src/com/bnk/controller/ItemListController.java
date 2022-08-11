package com.bnk.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bnk.model.Item;
import com.bnk.model.ItemDao;

public class ItemListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<Item> list =  ItemDao.getInstance().getAllItem();
		request.setAttribute("list", list);
		return new ModelAndView("itemList.jsp");
	}

}
