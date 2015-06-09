package com.land.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.land.util.CommonUtils;
/**
 * �� Struts2 ����У��ֶ�ʹ�� commons fileupload �ļ��ϴ�
 * ֻ��ʹ��Servlet������ struts.xml �й��˵���·��
 * @author asdf
 *
 */
public class UploadServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3958350822546156552L;
	private static Logger info = Logger.getLogger("stdout");

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		info.info("������ UploadServlet doPost ������");
		
		request.setCharacterEncoding("gbk");
		
		// -------- Apache Commons FileUpload �ļ��ϴ� Start --------
		String uploadPath = "D:\\_c_myEc9\\tmp";   // �ļ��ϴ����·��
		String tempPath = "D:\\_c_myEc9\\tmp1"; // �ļ���ʱ·��
		File tempPathFile = new File(tempPath);
		try {
			FileUtils.forceMkdir(tempPathFile);
		} catch (IOException e1) {
			info.info("������ʱ�ϴ�·����ʧ�ܣ�");
		}
		
//		RequestContext requestContext = new ServletRequestContext(request);
//		info.info("���룺" + requestContext.getCharacterEncoding());
		
		// true
//		if(ServletFileUpload.isMultipartContent(requestContext)) {
		if(ServletFileUpload.isMultipartContent(request)) {
			info.info("������ The Request contains multipart content ������");
			
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(tempPathFile);
//			factory.setSizeThreshold(5*1024);
			ServletFileUpload sfu = new ServletFileUpload(factory);
			info.info("upload ���󴴽���ɣ�");
			
			try {
				@SuppressWarnings("unchecked")
				List<FileItem> items = sfu.parseRequest(request); //
//				List<FileItem> items = sfu.parseRequest(requestContext);
				info.info("���������" + items.size());
				
				for(FileItem item : items) {
					if(!item.isFormField()) {
						info.info("�������� �ļ��ֶΣ���������");
						String fieldName = item.getFieldName();
						info.info("�ֶ�����" + fieldName);
						
						/*
						 * ˵�������������ȡ���ļ�������
						 * �ı��ļ����ļ�����
						 * ͼƬ������
						 * �գ�null
						 * 0�ֽڵ�txt�ļ��� null
						 */
						String fieldValue = item.getString();
						info.info("�ֶ�ֵ��" + CommonUtils.convertEncode(fieldValue));
						
						/*
						 * �գ�application/octet-stream
						 * 0�ֽڵ�txt�ļ���text/plain
						 * 0�ֽڵ�jpg�ļ���image/jpeg
						 * �޺�׺�����ļ���application/octet-stream
						 */
						info.info("contentType��" + item.getContentType());
						/*
						 * �գ�0
						 * 0�ֽڵ�txt�ļ���0
						 * 0�ֽڵ�jpg�ļ���0
						 */
						info.info("size��" + item.getSize());
						
						/*
						 * �ļ���
						 * ����Ϊ�գ���
						 */
						String fileName = item.getName();
						info.info("�ļ�����" + item.getName());
						if(null == fileName) {
							info.info("�ļ���Ϊnull��");
						} else if("".equals(fileName)) {
							info.info("�ļ����ǿգ�");
						} else {
							info.info("�ļ����Ȳ���nullҲ���ǿգ�");
						}
						String extName = CommonUtils.getExtName(fileName); // ��չ��
						
						String filepathName = uploadPath + File.separator + CommonUtils.getCurrentTime() + "." + extName;
						info.info("������ļ�·������" + filepathName);
						// �����ļ������ַ�ʽ����ʹ file ��Ϊ �գ�Ҳ�������ļ�
						item.write(new File(filepathName));
					} else {
						info.info("�������� ��ͨ�ֶΣ���������");
						info.info("�ֶ�����" + item.getFieldName());
						info.info("�ֶ�ֵ��" + CommonUtils.convertEncode(item.getString()));
						info.info("�ļ�����" + item.getName()); // null
					}
				}
				
//				response.setContentType("text/html; charset=gbk");
//				PrintWriter pw = response.getWriter();
//				pw.write("�ϴ��ļ��ɹ���");
				
				// Servlet to jsp
				getServletConfig().getServletContext().getRequestDispatcher("/public/success.jsp").forward(request, response);
			} catch (FileUploadException e) {
				info.info("����requestʧ�ܣ�");
			} catch (Exception e) {
				info.info("�����ļ�����");
			}
		} else {
			info.info("the request contains not multipart content");
		}
		
		// -------- Apache Commons FileUpload �ļ��ϴ� End --------
	}

}
