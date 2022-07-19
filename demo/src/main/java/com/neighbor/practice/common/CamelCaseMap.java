package com.neighbor.practice.common;

import java.util.HashMap;

import org.springframework.jdbc.support.JdbcUtils;

public class CamelCaseMap extends HashMap<String, Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Object put(String key, Object value) {
		return super.put(JdbcUtils.convertUnderscoreNameToPropertyName(key), value);
	}
	
}
