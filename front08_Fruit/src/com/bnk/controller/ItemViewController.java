package com.bnk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bnk.model.Item;
import com.bnk.model.ItemDao;

public class ItemViewController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int itemnuber = Integer.parseInt(request.getParameter("itemnuber"));
		// 조회수 추가후
		ItemDao.getInstance().updateRecordCount(itemnuber);
		// item을 가져온다.
		Item item = ItemDao.getInstance().getItem(itemnuber);
		
		request.setAttribute("item", item);
		return new ModelAndView("itemView.jsp");
	}

}
