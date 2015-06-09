package com.umbrella.calculate;

public class CalcUtil {
	/**
	 * x^1 + x^2 + x^3 + ... + x^n
	 */
	public static long fn1(long x, int n) {
		long r = 0;
		for(int i=1; i<=n; i++) {
			r = r + (long)Math.pow(x, i);
		}
		return r;
	}
	
}
