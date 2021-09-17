package com.percapincome.util;

import java.util.List;

import com.percapincome.pojo.WriterObj;

public interface MyWriter {
	public void write(String localtionOfFile,List<WriterObj>list);
}
