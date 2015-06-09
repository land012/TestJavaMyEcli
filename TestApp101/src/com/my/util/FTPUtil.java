package com.my.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;

public class FTPUtil {
	private static final Logger msg = Logger.getLogger(FTPUtil.class);
	
	/**
	 * 
	 * @param hostname
	 * @param port
	 * @param username
	 * @param password
	 * @param connectMode 值：PASSIVE_LOCAL_DATA_CONNECTION_MODE, ACTIVE_LOCAL_DATA_CONNECTION_MODE
	 * @param remotefilepath
	 * @param remotefilename
	 * @param localfile
	 * @return
	 */
	public static boolean down(String hostname,
			int port,
			String username,
			String password,
			int connectMode,
			String remotefilepath,
			String remotefilename,
			String localfile) {
		boolean res = false;
		
		String remotefilepathname = remotefilepath + remotefilename;
		
		FTPClient ftp = new FTPClient();
		try {
			ftp.connect(hostname, port);
			ftp.login(username, password);
			
			if(connectMode == FTPClient.PASSIVE_LOCAL_DATA_CONNECTION_MODE) {
				ftp.enterLocalPassiveMode();
			}
//			ftp.setControlEncoding("utf-8");
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			
			msg.info("ftp.getReplyCode()=" + ftp.getReplyCode());
			msg.info("ftp.getReplyString()=" + StringUtils.trimToEmpty(ftp.getReplyString()));
			
			if(!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
				msg.info("ftp server refused connection.");
				ftp.disconnect();
				return false;
			}
			
			
			
			msg.info("===============" + remotefilepath + " 下的文件 begin ===============");
			FTPFile[] files = ftp.listFiles(remotefilepath);
			if(files==null || files.length<1) {
				msg.info("找不到文件");
				res = false;
			} else {
				for(FTPFile f : files) {
					msg.info(f.getName());
				}
			}
			msg.info("===============" + remotefilepath + " 下的文件 end ===============");
			
			FileOutputStream fos = new FileOutputStream(new File(localfile));
			res = ftp.retrieveFile(remotefilepathname, fos);
			if(res) {
				msg.info("ftp下载成功=" + remotefilepathname);
			} else {
				msg.info("ftp下载失败=" + remotefilepathname);
			}
			fos.close();
			ftp.logout();
		} catch (SocketException e) {
			msg.info("ftp 下载异常", e);
			res = false;
		} catch (IOException e) {
			msg.info("ftp 下载异常", e);
			res = false;
		}
		
		return res;
	}
	
	public void fn1() {
		
	}
	
	public String fn1(int i) {
		return "";
	}
}
