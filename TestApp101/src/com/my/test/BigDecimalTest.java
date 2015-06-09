package com.my.test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import com.my.base.BaseTest;

/**
 * Double.parseDouble()
 * BigDecimal
 * @author xudz
 *
 */
public class BigDecimalTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		try {
//			Double.parseDouble("abc");
//		} catch(NumberFormatException e) {
//			info.info("java.lang.NumberFormatException");
//		}
//		try {
//			Double.parseDouble(null);
//		} catch(NullPointerException e) {
//			info.info("java.lang.NullPointerException");
//		}
		
//		Double d = new Double("299.40");
//		int i = (int)d.doubleValue();
//		System.out.println(i);
//		
//		double d1 = 299.9;
//		int i1 = (int)d1;
//		System.out.println(i1);
		
//		BigDecimal bd = new BigDecimal(299.40);
//		double d1 = 299.40;
//		DecimalFormat df = new DecimalFormat("####");
//		System.out.println(bd.toString());
//		System.out.println(d1);
//		System.out.println(df.format(d1));
		
//		Double d1 = new Double("299.40");
//		float f1 = (float)d1.doubleValue();
//		System.out.println(f1);
		
//		BigDecimal bd1 = new BigDecimal(299);
//		info.info(bd1);
//		info.info(bd1.scale()); // 0
//		BigDecimal bd2 = new BigDecimal(0.5);
//		info.info(bd2);
//		info.info(bd2.scale()); // 1
		
//		BigDecimal bd3 = new BigDecimal(1.54);
//		info.info(bd3); // 1.54000000000000003552713678800500929355621337890625
//		info.info(bd3.scale()); // 50
//		info.info(bd3.doubleValue()); // 1.54
//		// 异常： java.lang.ArithmeticException: Rounding necessary
//		// info.info(bd3.byteValueExact());
//		info.info(bd3.toBigInteger()); // 1
		
//		BigDecimal bd4 = new BigDecimal(7);
//		BigDecimal bd5 = new BigDecimal(3);
//		/*
//		 * 异常：java.lang.ArithmeticException:
//		 * Non-terminating decimal expansion;
//		 * no exact representable decimal result.
//		 */
//		//BigDecimal bd6 = bd4.divide(bd5);
//		BigDecimal bd7 = bd4.divide(bd5, RoundingMode.HALF_UP);
//		info.info(7.0/3); // 2.3333333333333335
//		info.info(bd7); //2
		
//		BigDecimal bd8 = new BigDecimal(12.5);
//		BigDecimal bd9 = new BigDecimal(5);
////		info.info(12.5/5); // 2.5
////		// 异常
////		//info.info(bd8.divide(bd9, RoundingMode.UNNECESSARY)); // 返回精确结果
//		info.info(bd8.divide(bd9, 2, RoundingMode.CEILING));   // 3 不小于
//		info.info(bd8.divide(bd9, 0, RoundingMode.FLOOR));     // 2 不大于
//		info.info(bd8.divide(bd9, 0, RoundingMode.UP));        // 3 入
//		info.info(bd8.divide(bd9, 0, RoundingMode.DOWN));      // 2 舍
//		info.info(bd8.divide(bd9, 0, RoundingMode.HALF_UP));   // 3 五入
//		info.info(bd8.divide(bd9, 0, RoundingMode.HALF_DOWN)); // 2 五舍
//		info.info(bd8.divide(bd9, 0, RoundingMode.HALF_EVEN)); // 2 五向偶舍入
		
//		BigDecimal b1 = new BigDecimal(1.5348565);
//		info.info(b1); // 1.534856500000000067984728957526385784149169921875
//		// 这个值 b1 实际大于 1.5348565
//		info.info(b1.round(MathContext.DECIMAL32));                      // 1.534857，？？ 入
//		info.info(b1.round(new MathContext(7, RoundingMode.HALF_EVEN))); // 1.534857，？？入
//		info.info(b1.round(new MathContext(7, RoundingMode.HALF_DOWN))); // 1.534857
//		info.info(b1.round(new MathContext(7, RoundingMode.CEILING)));   // 1.534857
//		info.info(b1.round(new MathContext(7, RoundingMode.FLOOR)));     // 1.534856
//		info.info(b1.round(new MathContext(7, RoundingMode.DOWN)));      // 1.534856
//		BigDecimal b11 = new BigDecimal(1.5);
//		info.info(b11); // 1.5
//		info.info(b11.round(new MathContext(1, RoundingMode.HALF_EVEN))); // 2，向偶舍近
//		BigDecimal b12 = new BigDecimal(2.5);
//		info.info(b12); // 2.5
//		info.info(b12.round(new MathContext(1, RoundingMode.HALF_EVEN))); // 2，向偶舍近
		
//		BigDecimal b2 = new BigDecimal(64646545.5348565);
//		info.info(b2.round(MathContext.DECIMAL32));                      // 6.464655E+7
//		info.info(b2.round(new MathContext(7, RoundingMode.HALF_EVEN))); // 6.464655E+7
//		info.info(b2.round(new MathContext(7, RoundingMode.HALF_DOWN))); // 6.464655E+7
//		info.info(b2.round(new MathContext(7, RoundingMode.CEILING)));   // 6.464655E+7
//		info.info(b2.round(new MathContext(7, RoundingMode.FLOOR)));     // 6.464654E+7
//		info.info(b2.round(new MathContext(7, RoundingMode.DOWN)));      // 6.464654E+7
//		BigDecimal b3 = new BigDecimal(4577545.5348565);
//		info.info(b3.round(new MathContext(7, RoundingMode.DOWN))); // 4577545
//		BigDecimal b4 = new BigDecimal(545.5348565);
//		info.info(b4.round(new MathContext(7, RoundingMode.DOWN))); // 545.5348
		
//		BigDecimal b3 = new BigDecimal(0.000005348565);
//		info.info(b3); // 0.0000053485650000000000100813975223434937333877314813435077667236328125
//		// 这个值 b3 实际大于 0.000005348565，所以 ceiling 时，会得到 0.000005348566
//		info.info(b3.round(MathContext.DECIMAL32)); // 0.000005348565
//		info.info(b3.round(new MathContext(7, RoundingMode.HALF_EVEN))); // 0.000005348565
//		info.info(b3.round(new MathContext(7, RoundingMode.HALF_DOWN))); // 0.000005348565
//		info.info(b3.round(new MathContext(7, RoundingMode.CEILING))); // 0.000005348566，？？
//		info.info(b3.round(new MathContext(7, RoundingMode.FLOOR))); // 0.000005348565
//		info.info(b3.round(new MathContext(7, RoundingMode.DOWN))); // 0.000005348565
		
		/**
		 * 标度 和 精度 begin
		 */
//		BigDecimal dividend = new BigDecimal(10000.0);
//		BigDecimal divisor = new BigDecimal(3);
//		/*
//		 * 指定明标度的商
//		 * 小数点后保留位数
//		 */
//		BigDecimal rs1 = dividend.divide(divisor, 3, RoundingMode.HALF_UP);
//		info.info(rs1); // 33.333
//		info.info(rs1.scale()); // 3
		
//		/*
//		 * 指明精度的商
//		 * 左起保留非零数位数
//		 */
//		MathContext mc = new MathContext(2, RoundingMode.HALF_UP);
//		BigDecimal rs = dividend.divide(divisor, mc);
//		info.info(rs.toPlainString()); // 33.333
//		info.info(mc.getPrecision()); // 5
		
//		BigDecimal dividend = new BigDecimal(3.001);
//		BigDecimal divisor = new BigDecimal(3);
//		// 指定明标度的商
//		BigDecimal quotient = dividend.divide(divisor, 5, RoundingMode.HALF_UP);
//		info.info(quotient); // 0.00033
//		info.info(quotient.scale()); // 5
		
		/*
		 * 指明精度的商
		 * 左边保留的位数
		 */
//		MathContext mc = new MathContext(5, RoundingMode.HALF_UP);
//		BigDecimal rs = dividend.divide(divisor, mc);
//		info.info(rs); // 0.00033333
//		info.info(mc.getPrecision()); // 5
//		info.info(rs.scale()); // 标度 8
		/**
		 * 标度 和 精度 end
		 */
		

//		// 异常 java.lang.NullPointerException
//		BigDecimal bd1 = new BigDecimal("123.456");
//		info.info(bd1.add(null));
		
		/**
		 * 显示全数字（非科学计法）
		 * MathContext 的第一个参数为精度，左起保留的位数
		 */
//		System.out.println(new BigDecimal(1111.111).add(new BigDecimal("1111.111"), 
//				new MathContext(2, RoundingMode.HALF_UP)).toPlainString());
		// 科学计算法
//		System.out.println(new BigDecimal(1111.111).add(new BigDecimal("11111.111"), 
//				new MathContext(1, RoundingMode.HALF_UP)).toEngineeringString());
		
		// 12222.222000000000103682396002113819122314453125
//		System.out.println(new BigDecimal(1111.111).add(new BigDecimal("11111.111")).setScale(4, RoundingMode.HALF_UP).toString());
		
		
		/**
		 * setScale(int) 抛异常的情况  begin
		 * 解决，需同时指定 RoundingMode
		 */
		/*
		 * 保留两位小数
		 * 12222.22
		 */
//		System.out.println(new BigDecimal(1111.111).add(new BigDecimal("11111.111")).setScale(2, RoundingMode.HALF_UP));
		
//		// 异常 java.lang.ArithmeticException: Rounding necessary
//		System.out.println(new BigDecimal(1.1111).setScale(2));
		
		/*
		 * 当无限循环时，会抛这种异常
		 * 异常 java.lang.ArithmeticException:
		 * Non-terminating decimal expansion; no exact representable decimal result.
		 */
//		info.info(new BigDecimal(1000).divide(new BigDecimal(3)));
		/*
		 * 实际小数位数多于指定标度时
		 * 异常
		 *     java.lang.ArithmeticException: Rounding necessary		
		 */
//		info.info(new BigDecimal(0.2).divide(new BigDecimal(5)).setScale(2));
//		info.info(new BigDecimal(1).divide(new BigDecimal(8)).setScale(2));
		
		/*
		 * 不会抛异常
		 * setScale()
		 *     当结果小数位数小于等于指定标度时，不会抛异常
		 */
//		info.info(new BigDecimal(1).divide(new BigDecimal(50)).setScale(2));
		/**
		 * setScale(int) 抛异常的情况  end
		 */
		
		
		/**
		 * 浮点数小数位问题
		 */
		float[] arr1 = { 2.1f, 37.9f, 36.3f, 23.7f };
		for(int i=0; i<arr1.length; i++) {
			BigDecimal temp = new BigDecimal(arr1[i]).multiply(new BigDecimal(100)).setScale(4, RoundingMode.HALF_UP);
			System.out.print(temp + ",");
		}
		
		System.out.println();
		
		String[] arr2 = { "2.1", "37.9", "36.3", "23.7" };
		for(int i=0; i<arr1.length; i++) {
			BigDecimal temp = new BigDecimal(arr2[i]).multiply(new BigDecimal(100)).setScale(4, RoundingMode.HALF_UP);
			System.out.print(temp + ",");
		}
	}

}
