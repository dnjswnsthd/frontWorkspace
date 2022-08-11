package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BranchesController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String result = "<ul><li>기장 일광 지점</li><br>"
				+ "<li>사하구 지점</li><br>"
				+ "<li>동래 대신동 지점</li><br>"
				+ "<li>남구 남천동 지점</li><br>"
				+ "<li>장전 지구 지점</li></ul>";
		
		request.setAttribute("result", result);
		return new ModelAndView("Result.jsp");
	}

}
