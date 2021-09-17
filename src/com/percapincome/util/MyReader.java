package com.percapincome.util;

import java.util.List;


public interface MyReader<T> {
	public List<T> read(String localtionOfFile);
	
	
}
