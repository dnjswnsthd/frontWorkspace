package servlet.controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bnk.model.Item;
import com.bnk.model.ItemDao;


public class ItemViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int itemnum = Integer.parseInt(request.getParameter("itemnumber"));
		
		//count증가...로직을 함께 작성
		boolean result=ItemDao.getInstance().updateRecordCount(itemnum);
		System.out.println("count update? "+result);
		
		Item item=ItemDao.getInstance().getItem(itemnum);
		System.out.println("getItem()? "+item);
		
		// 상세보기로 들어갔다... 이때 오늘본 상품이 무엇인지를 쿠키에 담는다.
		// 1. 쿠키 생성
		Cookie cookie = new Cookie("fruitshop"+itemnum, item.getUrl());
		ArrayList<String> fruits = new ArrayList<>();
		cookie.setMaxAge(24*60*60); // 하루 동안 쿠키를 유지함
		
		// 브라우저로 보냄.
		response.addCookie(cookie);
		
		request.setAttribute("item", item);
		return new ModelAndView("itemView.jsp");
	}

}









