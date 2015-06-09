package com.umbrella.commons.pool2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReadUtil ru = ReadUtil.getInstance();
		try {
			System.out.println(ru.readToString(new FileReader(new File("files/file1.txt"))));
			System.out.println("-------------------------");
			System.out.println(ru.readToString(new FileInputStream(new File("files/file1.txt"))));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
