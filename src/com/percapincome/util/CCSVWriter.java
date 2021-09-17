package com.percapincome.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVWriter;
import com.percapincome.pojo.People;
import com.percapincome.pojo.WriterObj;

public class CCSVWriter implements MyWriter {
	@Override
	public void write(String localtionOfFile, List<WriterObj> list) {
		writeDataLineByLine(localtionOfFile,list);
		
	}
	
	
	public static void writeDataLineByLine(String filePath,List<WriterObj> list)
	{
	    // first create file object for file placed at location
	    // specified by filepath
	    File file = new File(filePath);
	    try {
	        // create FileWriter object with file as parameter
	        FileWriter outputfile = new FileWriter(file);
	  
	        // create CSVWriter object filewriter object as parameter
	        CSVWriter writer = new CSVWriter(outputfile);
	        // adding header to csv
	        String[] header = { "City/Country", "Gender", "Average Income(in USD)" };
	        writer.writeNext(header);
			String[] data1=new String[3];
	        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				WriterObj writerObj = (WriterObj) iterator.next();
				data1[0]=writerObj.getCountry_city();
				data1[1]=writerObj.getGender();
				data1[2]=String.valueOf(writerObj.getAvgIncome());
				writer.writeNext(data1);
			}
	        writer.close();
	    }
	    catch (IOException e) {
	        e.printStackTrace();
	    }
	}


	
}
