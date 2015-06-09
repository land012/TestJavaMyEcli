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
	
	// Struts2 �ļ��ϴ�
	private File filefirst;
	private String filefirstFileName;
	private String filefirstContentType;
	
	// struts2 ����
	private InputStream downfile;
	private String downfileName;
	
	private String filesecond;
	private String filesecondName;
	
	private List<String> cb1;
	private String cb2;
	private String[] cb3;
	
	public String index() {
//		info.info("��ǰ class ����" + this.getClass().getName());
//		info.info("��ǰclasspath����·����" + this.getClass().getClassLoader().getResource("/"));
		info.info(request.getRemoteHost());
		info.info(request.getRequestURI());
		info.info(request.getRequestURL());
		info.info(request.getRemoteUser());
		info.info(request.getPathInfo());
		
		return "index";
	}
	
	public String fn1() {
		info.info("������ ���� fn1 Ӵ�� ������");
		
		// -------- disabled ���ύ Start --------
//		info.info(this.username);
//		info.info(this.password);
////		System.out.println(this.password); // null
//		
//		if(null == username) {
//			info.info("username ��  null");
//		} else if (StringUtils.equals("", this.username)) {
//			info.info("username �� ����");
//		} else {
//			info.info(username);
//		}
//		
//		if(null == password) {
//			info.info("password ��  null");
//		} else if("".equals(this.password)) {
//			info.info("password �� ����");
//		}
		// -------- disabled ���ύ End --------
		
		// -------- Struts�ļ��ϴ� Start --------
		String tmpPath = "D:\\_c_myEc9\\tmp"; // �ϴ�·��
		if(filefirst != null) {
			File temp = this.filefirst;
			info.info("��ʱ�ļ�·������" + temp.getPath());
			info.info(this.filefirstFileName);
			info.info(this.filefirstContentType);
			
			String suffix = StringUtils.substring(this.filefirstFileName, 
					StringUtils.lastIndexOf(this.filefirstFileName, "."));
			File srcFile = this.filefirst;
			File destFile = new File(tmpPath + "\\" + System.currentTimeMillis() + suffix);
			
			try {
//				// --------- ����1 Start ---------
//				FileUtils.copyFile(srcFile, destFile);
//				// --------- ����1 End ---------
				
				// --------- ����2 Start ---------
				FileInputStream fis = new FileInputStream(srcFile);
				FileOutputStream fos = new FileOutputStream(destFile);
				// ����д��������
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
				// --------- ����2 End ---------
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return ERROR;
			} catch (IOException e) {
				e.printStackTrace();
				return ERROR;
			}
			
		}
		// -------- Struts�ļ��ϴ� Start --------
		
		return "fn1";
	}
	
	/**
	 * Struts �ļ��ϴ��� web Ŀ¼��
	 * @return
	 */
	public String fn11() {
		if(filefirst!=null) {
			String ext = StringUtils.substring(this.filefirstFileName,
					StringUtils.lastIndexOf(this.filefirstFileName, "."));
			System.out.println("�ļ���׺����" + ext);
			
			String contextAbsolutePath1 = ServletActionContext.getServletContext().getRealPath("/");
			String contextAbsolutePath2 = ServletActionContext.getServletContext().getRealPath("");
			String virtualPath1 = "upload/" + this.filefirstFileName;
			String virtualPath2 = "/upload/" + this.filefirstFileName;
			
			System.out.println(ServletActionContext.getServletContext().getContextPath());
			
			System.out.println(contextAbsolutePath1); // ����·��
			System.out.println(contextAbsolutePath2); // ����·��
			
			File destFile = new File(contextAbsolutePath1 + virtualPath1);
			try {
				FileUtils.copyFile(this.filefirst, destFile);
				
				// ie�£���������ָ������ķ�ʽ������
//				response.setCharacterEncoding("gbk");
				response.setContentType("text/html; charset=gbk"); // �� firefox�£�ʹ�����ַ�ʽ������������
				
				PrintWriter pw = response.getWriter();
				pw.write("<a href=\"" + virtualPath1 + "\" target=\"_blank\" >ͼƬ</a>");
				pw.flush();
				pw.close();
			} catch (IOException e) {
				System.out.println("�����ļ�����");
				e.printStackTrace();
			}
			return null;
		}
		return "fn11";
	}
	
	// �����ļ�
	public String fn2down() {
		info.info("��ʼ�����ļ���");
		
//		File f = new File("D:\\_c_myEc9\\tmp\\1364893849915.txt");
//		info.info("�����ļ��ɹ���");
//		try {
//			this.downfile = new FileInputStream(f);
//		} catch (FileNotFoundException e1) {
//			info.info("�Ҳ����ļ���");
//			return ERROR;
//		}
		
		/*
		 * ʹ�����ַ�ʽ�õ�InputStreamʱ������ʹ�����·��������ʹ�þ���·��(D:/xxx/xx.xx)
		 * ���ַ�ʽ����ȡ��web��Ŀ¼�µ��ļ� �������Ǿ���·�����ļ�
		 */
		this.downfile = ServletActionContext.getServletContext().getResourceAsStream("tmp/text1.txt");
		this.downfileName = "�ļ���.txt";
		try {
			this.downfileName = new String(this.downfileName.getBytes("gbk"), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			info.info("ת������쳣����UnsupportedEncodingException");
		}
		
		if(null == this.downfile) {
			info.info("����������ʧ�ܣ���");
			return ERROR;
		}
		
		// �ֶ�����
//		try {
//			String fileName = new String("�ļ���.txt".getBytes("gbk"), "ISO-8859-1");
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
	
	// �ϴ��ļ�
	public String fn3() {
		return "fn3";
	}
	
	/**
	 * ������� ajax
	 * @return
	 */
	public String test1() {
		String method = request.getMethod();
		String str1 = request.getParameter("str1");
		System.out.println("method=" + method);
		System.out.println("str1=" + str1);
		
		try {
			response.setContentType("text/html; charset=gbk");
			response.getWriter().write("��Ӧ����");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ajax���̨�ύ
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
	 * checkbox ����
	 * @return
	 */
	public String test3() {
		String operate = request.getParameter("operate");
		if(null == operate || "".equals(operate)) return "test3";
		
		System.out.println("cb1:" + cb1); // List
		System.out.println("cb2:" + cb2); // String
		System.out.println("cb3:" + Arrays.toString(cb3)); // ����
		
//		String[] arr1 = StringUtils.split(cb2, ",");
//		for(String s : arr1) {
//			System.out.println(s.length());
//		}
		return "test3";
	}
	
	/**
	 * ��ȡ��֤��
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
		System.out.println("Session�е���֤�룺" + request.getSession().getAttribute(veriCode.getVericodeKey()));
		return null;
	}
	
	/**
	 * json����
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
	 * ��Ӧ zip ��
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
