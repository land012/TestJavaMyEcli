package com.land.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.Cookie;

import net.sf.json.JSONArray;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.land.base.BaseAction;
import com.land.model.User;
import com.land.util.CommonUtils;
import com.land.util.VeriCode;

public class Test1Action extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8059026052933780977L;
	
	private String username;
	private String password;
	
	// Struts2 文件上传
	private File filefirst;
	private String filefirstFileName;
	private String filefirstContentType;
	
	// struts2 下载
	private InputStream downfile;
	private String downfileName;
	
	private String filesecond;
	private String filesecondName;
	
	private List<String> cb1;
	private String cb2;
	private String[] cb3;
	
	public String index() {
//		info.info("当前 class 名：" + this.getClass().getName());
//		info.info("当前classpath绝对路径：" + this.getClass().getClassLoader().getResource("/"));
		info.info(request.getRemoteHost());
		info.info(request.getRequestURI());
		info.info(request.getRequestURL());
		info.info(request.getRemoteUser());
		info.info(request.getPathInfo());
		
		return "index";
	}
	
	public String fn1() {
		info.info("☆☆☆☆☆ 这是 fn1 哟！ ☆☆☆☆☆");
		
		// -------- disabled 表单提交 Start --------
//		info.info(this.username);
//		info.info(this.password);
////		System.out.println(this.password); // null
//		
//		if(null == username) {
//			info.info("username 是  null");
//		} else if (StringUtils.equals("", this.username)) {
//			info.info("username 是 “”");
//		} else {
//			info.info(username);
//		}
//		
//		if(null == password) {
//			info.info("password 是  null");
//		} else if("".equals(this.password)) {
//			info.info("password 是 “”");
//		}
		// -------- disabled 表单提交 End --------
		
		// -------- Struts文件上传 Start --------
		String tmpPath = "D:\\_c_myEc9\\tmp"; // 上传路径
		if(filefirst != null) {
			File temp = this.filefirst;
			info.info("临时文件路径名：" + temp.getPath());
			info.info(this.filefirstFileName);
			info.info(this.filefirstContentType);
			
			String suffix = StringUtils.substring(this.filefirstFileName, 
					StringUtils.lastIndexOf(this.filefirstFileName, "."));
			File srcFile = this.filefirst;
			File destFile = new File(tmpPath + "\\" + System.currentTimeMillis() + suffix);
			
			try {
//				// --------- 方案1 Start ---------
//				FileUtils.copyFile(srcFile, destFile);
//				// --------- 方案1 End ---------
				
				// --------- 方案2 Start ---------
				FileInputStream fis = new FileInputStream(srcFile);
				FileOutputStream fos = new FileOutputStream(destFile);
				// 两种写法都可以
//				byte[] b = new byte[512];
//				while(fis.read(b)>0) {
//					fos.write(b);
//				}
				int b = 0;
				while((b=fis.read())!=-1) {
					fos.write(b);
				}
				fis.close();
				fos.close();
				// --------- 方案2 End ---------
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return ERROR;
			} catch (IOException e) {
				e.printStackTrace();
				return ERROR;
			}
			
		}
		// -------- Struts文件上传 Start --------
		
		return "fn1";
	}
	
	/**
	 * Struts 文件上传到 web 目录下
	 * @return
	 */
	public String fn11() {
		if(filefirst!=null) {
			String ext = StringUtils.substring(this.filefirstFileName,
					StringUtils.lastIndexOf(this.filefirstFileName, "."));
			System.out.println("文件后缀名：" + ext);
			
			String contextAbsolutePath1 = ServletActionContext.getServletContext().getRealPath("/");
			String contextAbsolutePath2 = ServletActionContext.getServletContext().getRealPath("");
			String virtualPath1 = "upload/" + this.filefirstFileName;
			String virtualPath2 = "/upload/" + this.filefirstFileName;
			
			System.out.println(ServletActionContext.getServletContext().getContextPath());
			
			System.out.println(contextAbsolutePath1); // 工程路径
			System.out.println(contextAbsolutePath2); // 工程路径
			
			File destFile = new File(contextAbsolutePath1 + virtualPath1);
			try {
				FileUtils.copyFile(this.filefirst, destFile);
				
				// ie下，下面两种指明编码的方式都可以
//				response.setCharacterEncoding("gbk");
				response.setContentType("text/html; charset=gbk"); // 在 firefox下，使用这种方式，否则汉字乱码
				
				PrintWriter pw = response.getWriter();
				pw.write("<a href=\"" + virtualPath1 + "\" target=\"_blank\" >图片</a>");
				pw.flush();
				pw.close();
			} catch (IOException e) {
				System.out.println("保存文件出错！");
				e.printStackTrace();
			}
			return null;
		}
		return "fn11";
	}
	
	// 下载文件
	public String fn2down() {
		info.info("开始下载文件！");
		
//		File f = new File("D:\\_c_myEc9\\tmp\\1364893849915.txt");
//		info.info("创建文件成功！");
//		try {
//			this.downfile = new FileInputStream(f);
//		} catch (FileNotFoundException e1) {
//			info.info("找不到文件！");
//			return ERROR;
//		}
		
		/*
		 * 使用这种方式得到InputStream时，必须使用相对路径，不能使用绝对路径(D:/xxx/xx.xx)
		 * 这种方式可以取到web根目录下的文件 ，而不是绝对路径的文件
		 */
		this.downfile = ServletActionContext.getServletContext().getResourceAsStream("tmp/text1.txt");
		this.downfileName = "文件名.txt";
		try {
			this.downfileName = new String(this.downfileName.getBytes("gbk"), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			info.info("转码出错！异常名：UnsupportedEncodingException");
		}
		
		if(null == this.downfile) {
			info.info("创建输入流失败！！");
			return ERROR;
		}
		
		// 手动下载
//		try {
//			String fileName = new String("文件名.txt".getBytes("gbk"), "ISO-8859-1");
//			response.setContentType("application/force-download");
//			response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
//			PrintWriter pw = response.getWriter();
//			int b = 0;
//			while((b=downfile.read())!=-1) {
//				pw.write(b);
//			}
//			pw.close();
//			downfile.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		return "fn2down";
	}
	
	// 上传文件
	public String fn3() {
		return "fn3";
	}
	
	/**
	 * 乱码测试 ajax
	 * @return
	 */
	public String test1() {
		String method = request.getMethod();
		String str1 = request.getParameter("str1");
		System.out.println("method=" + method);
		System.out.println("str1=" + str1);
		
		try {
			response.setContentType("text/html; charset=gbk");
			response.getWriter().write("响应汉字");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ajax向后台提交
	 * @return
	 */
	public String test2() {
		String k1 = request.getParameter("k1");
		System.out.println("k1=" + k1);
		response.setContentType("text/plain; charset=gbk");
		try {
			response.getWriter().write("haha");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * checkbox 接收
	 * @return
	 */
	public String test3() {
		String operate = request.getParameter("operate");
		if(null == operate || "".equals(operate)) return "test3";
		
		System.out.println("cb1:" + cb1); // List
		System.out.println("cb2:" + cb2); // String
		System.out.println("cb3:" + Arrays.toString(cb3)); // 数组
		
//		String[] arr1 = StringUtils.split(cb2, ",");
//		for(String s : arr1) {
//			System.out.println(s.length());
//		}
		return "test3";
	}
	
	/**
	 * 获取验证码
	 * @return
	 */
	public String getVeriCode() {
		response.setContentType("image/jpeg");
		response.setHeader("Cache-Control", "no-store"); // HTTP 1.1
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0
		response.setDateHeader("Expires", 0); //prevents catching at proxy server
		VeriCode veriCode = new VeriCode();
		veriCode.setWidth(100);
		veriCode.setHeight(30);
		veriCode.getVeriCode(request, response);
		System.out.println("Session中的验证码：" + request.getSession().getAttribute(veriCode.getVericodeKey()));
		return null;
	}
	
	/**
	 * json测试
	 * @return
	 */
	public String getJson() {
		System.out.println("JSON test!");
		User u1 = new User();
		u1.setId("1");
		u1.setUsername("u1");
		User u2 = new User();
		u2.setId("2");
		u2.setUsername("u2");
		List<User> list = new ArrayList<User>();
		list.add(u1);
		list.add(u2);
		CommonUtils.response(response, "text/html", JSONArray.fromObject(list).toString());
		return null;
	}
	
	/**
	 * 响应 zip 流
	 * @return
	 */
	public String writeZip() {
		try {
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie : cookies) {
				System.out.format("%s=%s,", cookie.getName(), cookie.getValue());
			}
			
			response.setHeader("Content-Disposition", "attachment;filename=1111.zip");
			FileInputStream fis = new FileInputStream("E:\\TDDOWNLOAD\\1111.zip");
			OutputStream os = response.getOutputStream();
			int i = -1;
			byte[] buf = new byte[1024];
			while((i=fis.read(buf))!=-1) {
				os.write(buf, 0, i);
			}
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * ====================== setter and getter ==========================
	 */
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public File getFilefirst() {
		return filefirst;
	}

	public void setFilefirst(File filefirst) {
		this.filefirst = filefirst;
	}

	public String getFilefirstFileName() {
		return filefirstFileName;
	}

	public void setFilefirstFileName(String filefirstFileName) {
		this.filefirstFileName = filefirstFileName;
	}

	public String getFilefirstContentType() {
		return filefirstContentType;
	}

	public void setFilefirstContentType(String filefirstContentType) {
		this.filefirstContentType = filefirstContentType;
	}

	public InputStream getDownfile() {
		return downfile;
	}

	public void setDownfile(InputStream downfile) {
		this.downfile = downfile;
	}

	public String getDownfileName() {
		return downfileName;
	}

	public void setDownfileName(String downfileName) {
		this.downfileName = downfileName;
	}

	public String getFilesecond() {
		return filesecond;
	}

	public void setFilesecond(String filesecond) {
		this.filesecond = filesecond;
	}

	public String getFilesecondName() {
		return filesecondName;
	}

	public void setFilesecondName(String filesecondName) {
		this.filesecondName = filesecondName;
	}

	public List<String> getCb1() {
		return cb1;
	}

	public void setCb1(List<String> cb1) {
		this.cb1 = cb1;
	}

	public String getCb2() {
		return cb2;
	}

	public void setCb2(String cb2) {
		this.cb2 = cb2;
	}

	public String[] getCb3() {
		return cb3;
	}

	public void setCb3(String[] cb3) {
		this.cb3 = cb3;
	}

}
