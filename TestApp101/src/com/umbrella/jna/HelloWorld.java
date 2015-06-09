package com.umbrella.jna;
/**
 * JNA Demo
 * @author asdf
 *
 */
public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CLibrary.INSTANCE.printf("Hello World");
	}

}
