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
 * ����Զ��ͼƬ
 * @author asdf
 *
 */
public class GetRemotePic {
	
	public static void main(String[] args) {
//		getFileRemotePic("files/adult.txt");
		getUrlRemotePic("http://www.com");
	}
	
	/**
	 * ��ȡ�ļ��е�Զ��ͼƬ
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
	 * ��ȡ�����е�ͼƬ
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
				System.out.println("��ȡͼƬ�����ˣ�url=" + s);
				continue;
			}
		}
	}
	
	/**
	 * ���ı��л�ȡͼƬ������
	 * �������Ǿ��Ե�ַ���� http ��ͷ
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
				System.out.println("ͼƬ���ӣ�" + remotepicpath);
				resList.add(remotepicpath);
			}
		}
		return resList;
	}
	
	
	/**
	 * ����Զ���ļ�
	 * ��ָ��·����ͬ���ļ�ʱ���Ḳ��
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
