package com.my.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//PropertyConfigurator.configure("ini/log4j.properties");
		
		/*
		 * log4j ��־�ļ�ʾ����
		 * 2012-12-27 15:44:13,325 INFO [main] Log4jTest.main(16) | ��־1
		 * 2012-12-27 15:44:13,325 DEBUG [main] Log4jTest.main(17) | ��־debug
		 */
		Logger log = Logger.getLogger("logs");
		log.info("��־1");
		log.debug("��־debug");
		
		/*
		 * log4j ֻ��̨��ӡ�����������־�ļ�
		 */
		Logger stdout = Logger.getLogger("stdout");
		stdout.info("stdout0001");
		
		/*
		 * log ʹ������� Log ʱ����־�ļ��У���������־��ӡ�����ݣ���û��ʱ���������Ϣ
		 * ����
		 * ��־001
		 * ��־debug001
		 */
		Log log1 = LogFactory.getLog("logs2");
		log1.info("��־001");
		log1.debug("��־debug001"); // û�д�ӡ������̨
	}

}
