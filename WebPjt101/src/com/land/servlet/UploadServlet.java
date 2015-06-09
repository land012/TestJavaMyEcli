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
 * 在 Struts2 框架中，手动使用 commons fileupload 文件上传
 * 只能使用Servlet，并在 struts.xml 中过滤掉该路径
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
		
		info.info("☆☆☆☆☆ UploadServlet doPost ☆☆☆☆☆");
		
		request.setCharacterEncoding("gbk");
		
		// -------- Apache Commons FileUpload 文件上传 Start --------
		String uploadPath = "D:\\_c_myEc9\\tmp";   // 文件上传存放路径
		String tempPath = "D:\\_c_myEc9\\tmp1"; // 文件临时路径
		File tempPathFile = new File(tempPath);
		try {
			FileUtils.forceMkdir(tempPathFile);
		} catch (IOException e1) {
			info.info("创建临时上传路径名失败！");
		}
		
//		RequestContext requestContext = new ServletRequestContext(request);
//		info.info("编码：" + requestContext.getCharacterEncoding());
		
		// true
//		if(ServletFileUpload.isMultipartContent(requestContext)) {
		if(ServletFileUpload.isMultipartContent(request)) {
			info.info("○○○○○ The Request contains multipart content ○○○○○");
			
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(tempPathFile);
//			factory.setSizeThreshold(5*1024);
			ServletFileUpload sfu = new ServletFileUpload(factory);
			info.info("upload 对象创建完成！");
			
			try {
				@SuppressWarnings("unchecked")
				List<FileItem> items = sfu.parseRequest(request); //
//				List<FileItem> items = sfu.parseRequest(requestContext);
				info.info("表单项个数：" + items.size());
				
				for(FileItem item : items) {
					if(!item.isFormField()) {
						info.info("┼┼┼┼┼┼┼ 文件字段！┼┼┼┼┼┼┼");
						String fieldName = item.getFieldName();
						info.info("字段名：" + fieldName);
						
						/*
						 * 说明：这个方法会取出文件的内容
						 * 文本文件：文件内容
						 * 图片：乱码
						 * 空：null
						 * 0字节的txt文件： null
						 */
						String fieldValue = item.getString();
						info.info("字段值：" + CommonUtils.convertEncode(fieldValue));
						
						/*
						 * 空：application/octet-stream
						 * 0字节的txt文件：text/plain
						 * 0字节的jpg文件：image/jpeg
						 * 无后缀名的文件：application/octet-stream
						 */
						info.info("contentType：" + item.getContentType());
						/*
						 * 空：0
						 * 0字节的txt文件：0
						 * 0字节的jpg文件：0
						 */
						info.info("size：" + item.getSize());
						
						/*
						 * 文件名
						 * 表单项为空：空
						 */
						String fileName = item.getName();
						info.info("文件名：" + item.getName());
						if(null == fileName) {
							info.info("文件名为null！");
						} else if("".equals(fileName)) {
							info.info("文件名是空！");
						} else {
							info.info("文件名既不是null也不是空！");
						}
						String extName = CommonUtils.getExtName(fileName); // 扩展名
						
						String filepathName = uploadPath + File.separator + CommonUtils.getCurrentTime() + "." + extName;
						info.info("保存的文件路径名：" + filepathName);
						// 保存文件，这种方式，即使 file 表单为 空，也会生成文件
						item.write(new File(filepathName));
					} else {
						info.info("┼┼┼┼┼┼┼ 普通字段！┼┼┼┼┼┼┼");
						info.info("字段名：" + item.getFieldName());
						info.info("字段值：" + CommonUtils.convertEncode(item.getString()));
						info.info("文件名：" + item.getName()); // null
					}
				}
				
//				response.setContentType("text/html; charset=gbk");
//				PrintWriter pw = response.getWriter();
//				pw.write("上传文件成功！");
				
				// Servlet to jsp
				getServletConfig().getServletContext().getRequestDispatcher("/public/success.jsp").forward(request, response);
			} catch (FileUploadException e) {
				info.info("解析request失败！");
			} catch (Exception e) {
				info.info("保存文件出错！");
			}
		} else {
			info.info("the request contains not multipart content");
		}
		
		// -------- Apache Commons FileUpload 文件上传 End --------
	}

}
