package test.com.my.util;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.enterprisedt.net.ftp.FTPConnectMode;
import com.enterprisedt.net.ftp.FTPException;
import com.enterprisedt.net.ftp.FTPTransferType;
import com.enterprisedt.net.ftp.FileTransferClient;
import com.my.util.FTPClientEdtUtil;
import com.my.util.FTPUtil;

public class FTPUtilTest {
	
	private static final Logger msg = Logger.getLogger(FTPUtilTest.class);
	
	/**
	 * 钱包 apache.commons.net.ftp
	 * @param args
	 * @throws FTPException 
	 * @throws IOException 
	 */
	@Test
	public void testPuEdtDown() throws FTPException, IOException {
		String hostname = "118.144.87.151";
		int port = 80;
		String username = "checkaccountftp";
		String password = "checkaccountftp";
		String remotepathname = "/transaccount/";
		String remontefilename = "TR_1_190028_2014-03-31.txt";
		String localfile = "E:\\TDDOWNLOAD\\aa.txt";
		
//		FileTransferClient ftp = new FileTransferClient();
//		ftp.setRemoteHost(hostname);
//		ftp.setRemotePort(port);
//		ftp.setUserName(username);
//		ftp.setPassword(password);
//		ftp.connect();
//		
//		ftp.getAdvancedFTPSettings().setConnectMode(FTPConnectMode.PASV);
//		ftp.setContentType(FTPTransferType.BINARY);
//		
//		msg.info("============= " + remotepathname + " 下所有文件 begin ==============");
//		String[] fileNames = ftp.directoryNameList(remotepathname, false);
//		for(String s : fileNames) {
//			msg.info(s);
//		}
//		msg.info("============= " + remotepathname + " 下所有文件 end ==============");
//		
//		ftp.downloadFile(localfile, remotepathname + remontefilename);
//		
//		ftp.disconnect();
		
		FTPClientEdtUtil ftpUtil = new FTPClientEdtUtil(hostname, port, username, password);
		ftpUtil.down(localfile, remotepathname + remontefilename);
	}
	
	/**
	 * dabin apache.commons.net.ftp
	 */
	@Test
	public void testPuFtpDown() {
		String hostname = "118.144.87.151";
		int port = 80;
		String username = "checkaccountftp";
		String password = "checkaccountftp";
		
		String remotefilepath = "/transaccount/";
		String remotefilename = "TR_1_190028_2014-03-31.txt";
		String localfile = "E:\\TDDOWNLOAD\\aa.txt";
		
		FTPUtil.down(hostname,
				port,
				username,
				password,
				FTPClient.PASSIVE_LOCAL_DATA_CONNECTION_MODE,
				remotefilepath,
				remotefilename,
				localfile);
	}
	
	/**
	 * dabing EdtFTP
	 * @throws FTPException
	 * @throws IOException
	 */
	@Test
	public void testDaBingEdtDown() throws FTPException, IOException {
		String remoteHost = "dabing.w16.mc-test.com";
		int remotePort = 21;
		String userName = "dabing";
		String password = "duan1514008160!";
		
		String localFileName = "E:\\TDDOWNLOAD\\aa.txt";
		String remoteFileName = "/logs/dabing-error_log.2014.03.31";
		
		FileTransferClient ftp = new FileTransferClient();
		ftp.setRemoteHost(remoteHost);
		ftp.setRemotePort(remotePort);
		ftp.setUserName(userName);
		ftp.setPassword(password);
		ftp.connect();
		
		ftp.getAdvancedFTPSettings().setConnectMode(FTPConnectMode.PASV);
		ftp.setContentType(FTPTransferType.BINARY);
		
		msg.info("============= /logs/ 下所有文件 begin ==============");
		String[] fileNames = ftp.directoryNameList("/logs", false);
		for(String s : fileNames) {
			msg.info(s);
		}
		msg.info("============= /logs/ 下所有文件 end ==============");
		
		ftp.downloadFile(localFileName, remoteFileName);
		
		ftp.disconnect();
	}
	
	/**
	 * dabing apache.commons.net.ftp
	 * @throws FTPException
	 * @throws IOException
	 */
	@Test
	public void testDaBingFtpDown() {
		String remoteHost = "dabing.w16.mc-test.com";
		int remotePort = 21;
		String userName = "dabing";
		String password = "duan1514008160!";
		
		String localFileName = "E:\\TDDOWNLOAD\\aa.txt";
		String remotepathname = "/logs/";
		String remotefilename = "dabing-error_log.2014.03.31";
		
		FTPUtil.down(remoteHost,
				remotePort,
				userName,
				password,
				FTPClient.PASSIVE_LOCAL_DATA_CONNECTION_MODE,
				remotepathname,
				remotefilename,
				localFileName);
	}
	
	/**
	 * 本机 EdtFTP
	 * @throws FTPException
	 * @throws IOException
	 */
	@Test
	public void testLocalEdtDown() throws FTPException, IOException {
		String remoteHost = "192.168.1.104";
		int remotePort = 21;
		String userName = "asdf";
		String password = "725606";
		
//		String localFileName = "E:\\TDDOWNLOAD\\aa.txt";
//		String remoteFileName = "/file1.txt";
		
		FileTransferClient ftp = new FileTransferClient();
		ftp.setRemoteHost(remoteHost);
		ftp.setRemotePort(remotePort);
		ftp.setUserName(userName);
		ftp.setPassword(password);
		ftp.connect();
		
		ftp.setContentType(FTPTransferType.BINARY);
		
		String[] fileNames = ftp.directoryNameList("/dir1", false);
		for(String s : fileNames) {
			System.out.println(s);
		}
		
		System.out.println("=============================");
		
		String[] fullFileNames = ftp.directoryNameList("/dir1", true);
		for(String s : fullFileNames) {
			System.out.println(s);
		}
		
		// 下载文件
//		ftp.downloadFile(localFileName, remoteFileName);
		
		ftp.disconnect();
	}
	
	/**
	 * 本机 apache.commons.net.ftp
	 * @throws FTPException
	 * @throws IOException
	 */
	@Test
	public void testLocalFtpDown() throws FTPException, IOException {
		String remoteHost = "192.168.1.104";
		int remotePort = 21;
		String userName = "asdf";
		String password = "725606";
		
		String localFileName = "E:\\TDDOWNLOAD\\aa.txt";
		String remotepathname = "/dir1/";
		String remotefilename = "file1_1.txt";
		
		FTPUtil.down(remoteHost, remotePort, userName, password,
				FTPClient.PASSIVE_LOCAL_DATA_CONNECTION_MODE,
				remotepathname, remotefilename, localFileName);
	}
}
