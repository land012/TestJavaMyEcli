package com.my.util;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.enterprisedt.net.ftp.FTPConnectMode;
import com.enterprisedt.net.ftp.FTPException;
import com.enterprisedt.net.ftp.FTPTransferType;
import com.enterprisedt.net.ftp.FileTransferClient;

public class FTPClientEdtUtil {
	
	private static final Logger msg = Logger.getLogger(FTPClientEdtUtil.class);
	
	private String remoteHost;
	private int remotePort;
	private String userName;
	private String password;
	private FTPConnectMode connectMode;
	private FTPTransferType transferType;
	
	public FTPClientEdtUtil(String remoteHost,
			int remotePort,
			String userName,
			String password) {
		this.remoteHost = remoteHost;
		this.remotePort = remotePort;
		this.userName = userName;
		this.password = password;
		this.connectMode = FTPConnectMode.PASV;
		this.transferType = FTPTransferType.BINARY;
	}
	
	public FTPClientEdtUtil(String remoteHost,
			int remotePort,
			String userName,
			String password,
			FTPConnectMode connectMode,
			FTPTransferType transferType) {
		this.remoteHost = remoteHost;
		this.remotePort = remotePort;
		this.userName = userName;
		this.password = password;
		this.connectMode = connectMode;
		this.transferType = transferType;
	}
	
	/**
	 * 
	 * @param localfile
	 * @param remotefile
	 * @return
	 */
	public boolean down(String localfile, String remotefile) {
		
		msg.info("��ʼ�����ļ���" + remotefile);
		
		boolean res = false;
		FileTransferClient ftp = new FileTransferClient();
		try {
			ftp.setRemoteHost(remoteHost);
			ftp.setRemotePort(remotePort);
			ftp.setUserName(userName);
			ftp.setPassword(password);
			
			ftp.connect();
			
			ftp.getAdvancedFTPSettings().setConnectMode(connectMode);
			ftp.setContentType(transferType);
			
			ftp.downloadFile(localfile, remotefile);
			res = true;
		} catch (FTPException e) {
			msg.info("ftp �����ļ��쳣", e);
			res = false;
		} catch (IOException e) {
			msg.info("ftp �����ļ��쳣", e);
			res = false;
		} finally {
			if(ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (FTPException e) {
					msg.info("ftp �ر��쳣", e);
				} catch (IOException e) {
					msg.info("ftp �ر��쳣", e);
				}
			}
		}
		
		if(res) {
			msg.info("ftp �����ļ��ɹ���" + remotefile);
		} else {
			msg.info("ftp �����ļ�ʧ�ܣ�" + remotefile);
		}
		
		msg.info("���������ļ���" + remotefile);
		
		return res;
	}
}
