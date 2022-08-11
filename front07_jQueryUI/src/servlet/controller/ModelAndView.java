package servlet.controller;

// 결과 페이지와 페이지 이동 방법에 대한 정보를 담고 있는 클래스...
public class ModelAndView {
	private String path; // 결과 페이지 이름...
	private boolean isRedirect; // 페이지 이동 방법 false --> forward, ture --> redirect

	public ModelAndView() {
		super();
	}

	public ModelAndView(String path) {
		super();
		this.path = path;
	}

	public ModelAndView(String path, boolean isRedirect) {
		super();
		this.path = path;
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	@Override
	public String toString() {
		return "ModelAndView [path=" + path + ", isRedirect=" + isRedirect + "]";
	}

}
