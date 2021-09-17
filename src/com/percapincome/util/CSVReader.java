package com.percapincome.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.percapincome.pojo.People;

public class CSVReader implements MyReader<People> {
	PropReader prop=new PropReader();
	@Override
	public List<People> read(String locationOfFile) {
		return this.readBooksFromCSV(locationOfFile);
	}
	
	
	
	private  List<People> readBooksFromCSV(String fileName) {
        List<People> ppls = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            // read the first line from the text file
            String line = br.readLine();
            //for 1st line headers
            int counter=0;
            // loop until all lines are read
            while (line != null) {
            	if(counter==0) {
            		 counter++;
            		 line = br.readLine();
            		 continue;
            	}
            		
 
            	
            	// use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");

                People ppl = null;
				try {
					ppl = getpeopleObj(attributes);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

//				System.out.println("ppl=="+ppl.toString());
				
                // adding book into ArrayList
                ppls.add(ppl);
                
                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
               
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return ppls;
    }
	
	//City	Country	Gender	Currency	Average Income

	 private  People getpeopleObj(String[] metadata) throws FileNotFoundException {
	        String City = metadata[0];
	        String Country = metadata[1];
	        String Gender = metadata[2];
	        String Currency = metadata[3];
	        int AvgIncome = Integer.parseInt(metadata[4]);
	        
	        if(Country!=null && Country.length()<=0)
	        Country=City;
	        
	        return new People(City,Country,Gender,Currency,convertToUsd(Currency, AvgIncome));
	    }
	
	 public  double convertToUsd(String Currency,double value) throws FileNotFoundException{
//		System.out.println("---Currency---"+Currency);
//		System.out.println("readed value=="+prop.readValue(Currency));
		 double roc = 1;
			try {
				roc = Double.parseDouble(prop.readValue(Currency));
			} catch (NumberFormatException | FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return value/roc;
		}
}
