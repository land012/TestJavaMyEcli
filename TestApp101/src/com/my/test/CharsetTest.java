package com.my.test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

import com.my.base.BaseTest;

public class CharsetTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			byte[] bytes1 = "0123".getBytes("gbk");
			byte[] bytes2 = "0123".getBytes("utf-8");
			System.out.println(Arrays.toString(bytes1));
			System.out.println(Arrays.toString(bytes2));
			
			byte[] bytes3 = "Œ“".getBytes("gbk");
			byte[] bytes4 = "Œ“".getBytes("utf-8");
			System.out.println(Arrays.toString(bytes3));
			System.out.println(Arrays.toString(bytes4));
			
			byte[] bytes5 = "a".getBytes("gbk");
			byte[] bytes6 = "a".getBytes("utf-8");
			System.out.println(Arrays.toString(bytes5));
			System.out.println(Arrays.toString(bytes6));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
