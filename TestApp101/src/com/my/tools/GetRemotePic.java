package com.my.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import com.my.util.HttpUtils;
/**
 * 下载远程图片
 * @author asdf
 *
 */
public class GetRemotePic {
	
	public static void main(String[] args) {
//		getFileRemotePic("files/adult.txt");
		getUrlRemotePic("http://www.com");
	}
	
	/**
	 * 获取文件中的远程图片
	 * @param txtfilepath
	 */
	private static void getFileRemotePic(String txtfilepath) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(txtfilepath));
			StringBuffer filecontent = new StringBuffer();
			String line = null;
			while((line=br.readLine())!=null) {
				filecontent.append(line);
			}
//			System.out.println(filecontent);
			
			List<String> picurlList = getPicUrl(filecontent.toString());
			for(String s : picurlList) {
				String picname = StringUtils.substring(s, StringUtils.lastIndexOf(s, "/")+1);
				String destpicpath = "D:/download/" + picname;
				try {
					downfile(s, destpicpath);
				} catch(Exception e) {
					e.printStackTrace();
					continue;
				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br!=null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				br = null;
			}
		}
	}
	
	/**
	 * 获取链接中的图片
	 * @param purl
	 */
	private static void getUrlRemotePic(String purl) {
		String html = HttpUtils.doGet(purl, "gbk");
		System.out.println(html);
		List<String> picurlList = getPicUrl(html);
		for(String s : picurlList) {
			String picname = StringUtils.substring(s, StringUtils.lastIndexOf(s, "/")+1);
			String destpicpath = "D:/download/" + picname;
			try {
				downfile(s, destpicpath);
			} catch(Exception e) {
				System.out.println("获取图片出错了，url=" + s);
				continue;
			}
		}
	}
	
	/**
	 * 从文本中获取图片的链接
	 * 链接须是绝对地址，以 http 打头
	 * @param content
	 * @return
	 */
	private static List<String> getPicUrl(String content) {
		List<String> resList = null;
		if(StringUtils.isNotEmpty(content)) {
			resList = new ArrayList<String>();
//			String pt1 = "src=\"([^\"]+)\"";
			String pt2 = "http://[^\"]+((\\.jpg)|(\\.gif)|(\\.png))";
			Pattern p = Pattern.compile(pt2, Pattern.MULTILINE);
			Matcher m = p.matcher(content);
			while(m.find()) {
				String remotepicpath = m.group();
				System.out.println("图片链接：" + remotepicpath);
				resList.add(remotepicpath);
			}
		}
		return resList;
	}
	
	
	/**
	 * 下载远程文件
	 * 当指定路径有同名文件时，会覆盖
	 * @param fileurl
	 * @param destpath
	 * @throws IOException 
	 */
	private static void downfile(String fileurl, String destpath) throws IOException {
		URL url = new URL(fileurl);
		URLConnection conn = url.openConnection();
		InputStream is = conn.getInputStream();
		OutputStream os = new FileOutputStream(destpath);
		
		byte[] buf = new byte[1024];
		int i = -1;
		while((i=is.read(buf))!=-1) {
			os.write(buf, 0, i);
		}
	}
}
