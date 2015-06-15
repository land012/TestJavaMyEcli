import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;


public class ResultTypeAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {
	private HttpServletRequest req;
	private HttpServletResponse resp;

	public void setServletRequest(HttpServletRequest req) {
		this.req = req;
	}

	public void setServletResponse(HttpServletResponse resp) {
		this.resp = resp;
	}
	
	public String jump() {
		//System.out.println("This is jump!"); // 验证该方法是否被执行到
		req.setAttribute("a1", "this is \"r.jsp\"!"); // 验证是否是同一个 request
		System.out.println(req.getParameter("username")); // 验证是否能获得传来的值
		return SUCCESS;
	}

}
