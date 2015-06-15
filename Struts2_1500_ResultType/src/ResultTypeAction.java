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
		//System.out.println("This is jump!"); // ��֤�÷����Ƿ�ִ�е�
		req.setAttribute("a1", "this is \"r.jsp\"!"); // ��֤�Ƿ���ͬһ�� request
		System.out.println(req.getParameter("username")); // ��֤�Ƿ��ܻ�ô�����ֵ
		return SUCCESS;
	}

}
