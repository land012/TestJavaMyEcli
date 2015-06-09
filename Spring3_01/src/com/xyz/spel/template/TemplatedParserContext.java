package com.xyz.spel.template;

import org.springframework.expression.ParserContext;

public class TemplatedParserContext implements ParserContext {

	@Override
	public String getExpressionPrefix() {
		return "${";
	}

	@Override
	public String getExpressionSuffix() {
		return "}";
	}

	@Override
	public boolean isTemplate() {
		return true;
	}

}
