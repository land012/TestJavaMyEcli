import com.opensymphony.xwork2.ActionSupport;


public class DynamicRs extends ActionSupport {
	private int type;
	private String r;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getR() {
		return r;
	}
	public void setR(String r) {
		this.r = r;
	}
	@Override
	public String execute() throws Exception {
		if(type==1) {
			this.r = "/admin.jsp";
		} else if(type==2) {
			this.r = "/user.jsp";
		}
		return SUCCESS;
	}
	
}
