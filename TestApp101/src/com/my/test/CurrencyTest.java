package com.my.test;

import java.util.Currency;
import java.util.Locale;

import com.my.base.BaseTest;

public class CurrencyTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Currency c = Currency.getInstance(Locale.CHINA);
		info.info("ISO 4217 货币代码：" + c);
		info.info("货币符号：" + c.getSymbol());
		c = Currency.getInstance(Locale.SIMPLIFIED_CHINESE);
		info.info("ISO 4217 货币代码：" + c);
		info.info("货币符号：" + c.getSymbol());
		c = Currency.getInstance(Locale.PRC);
		info.info("ISO 4217 货币代码：" + c);
		info.info("货币符号：" + c.getSymbol());
		info.info("--------------------------------------");
		c = Currency.getInstance(Locale.TAIWAN);
		info.info("ISO 4217 货币代码：" + c);
		info.info("货币符号：" + c.getSymbol());
		info.info("货币符号：" + c.getSymbol(Locale.TAIWAN));
		c = Currency.getInstance(Locale.TRADITIONAL_CHINESE);
		info.info("ISO 4217 货币代码：" + c);
		info.info("货币符号：" + c.getSymbol(Locale.TRADITIONAL_CHINESE));
		c = Currency.getInstance(Locale.UK);
		info.info("ISO 4217 货币代码：" + c);
		info.info("货币符号：" + c.getSymbol(Locale.UK));
		c = Currency.getInstance(Locale.US);
		info.info("ISO 4217 货币代码：" + c);
		info.info("货币符号：" + c.getSymbol(Locale.US));
		c = Currency.getInstance(Locale.FRANCE);
		info.info("ISO 4217 货币代码：" + c);
		info.info("货币符号：" + c.getSymbol(Locale.FRANCE));
		c = Currency.getInstance(Locale.GERMANY);
		info.info("ISO 4217 货币代码：" + c);
		info.info("货币符号：" + c.getSymbol(Locale.GERMANY));
		c = Currency.getInstance(Locale.JAPAN);
		info.info("ISO 4217 货币代码：" + c);
		info.info("货币符号：" + c.getSymbol(Locale.JAPAN));
		c = Currency.getInstance(Locale.KOREA);
		info.info("ISO 4217 货币代码：" + c);
		info.info("货币符号：" + c.getSymbol(Locale.KOREA));
	}

}
