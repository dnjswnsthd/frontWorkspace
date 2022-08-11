package com.bnk.controller;


/*
 * Component를 생성하는 공장
 * 싱글톤으로 작성
 * 서버클라이언트가 보내는 Command값에 따라서 생성되는 Component가 달라진다.
 */
public class ControllerFactory {
	private static ControllerFactory factory = new ControllerFactory();

	private ControllerFactory() {
		System.out.println("ControllerFactory 싱글톤");
	}

	public static ControllerFactory getInstance() {
		return factory;
	}

	// Component 생성하는 기능
	public Controller createController(String command) {
		Controller controller = null;
	
		if (command.equals("itemList.do")) {
			controller = new  ItemListController();
		} else if(command.equals("itemView.do")) {
			controller = new  ItemViewController();
		}

		return controller;
	}
}
