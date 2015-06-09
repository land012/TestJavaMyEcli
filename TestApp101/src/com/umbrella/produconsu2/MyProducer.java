package com.umbrella.produconsu2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class MyProducer extends Producer<String> {
	
	private static Logger log = Logger.getLogger(MyProducer.class);

	@Override
	public List<String> produce() {
		log.info("生产者 " + Thread.currentThread().getName() + " begin");
		List<String> list = null;
		File file = null;
		BufferedReader br = null;
		try {
			file = new File("files/file3.db");
			br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			if(line != null) {
				list = new ArrayList<String>();
				list.add(line);
				while((line=br.readLine()) != null) {
					Thread.sleep((long)(Math.random()*100));
					list.add(line);
				}
			}
		} catch (FileNotFoundException e) {
			log.info("生产者 " + Thread.currentThread().getName() + " 找不到文件，没有需要生产的资源了");
		} catch (IOException e) {
			log.info("", e);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
					br = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(file != null) {
				file.delete();
			}
		}
		log.info("生产者 " + Thread.currentThread().getName() + " end");
		return list;
	}

}
