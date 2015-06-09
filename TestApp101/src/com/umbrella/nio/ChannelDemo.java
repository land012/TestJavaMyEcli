package com.umbrella.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.apache.log4j.Logger;

public class ChannelDemo {
	
	private static Logger log = Logger.getLogger(ChannelDemo.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			RandomAccessFile file = new RandomAccessFile("files/file1.txt", "r");
			FileChannel channel = file.getChannel();
			ByteBuffer buf = ByteBuffer.allocate(48);
			
			int i = channel.read(buf);
//			List<byte> list = new ArrayList<byte>();
			while(i!=-1) {
				log.info("read " + i);
				buf.flip();
				
				log.info(buf.toString());
				
				log.info("--------------------------");
				
				byte[] arr = buf.array();
				log.info("arr.length=" + arr.length);
				String s = new String(arr, 0, i, "utf-8");
				log.info(s);
				
				log.info("--------------------------");
				
				while(buf.hasRemaining()) {
					//log.info((char)buf.get());
					System.out.print((char)buf.get());
				}
				buf.clear();
				i = channel.read(buf);
			}
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
