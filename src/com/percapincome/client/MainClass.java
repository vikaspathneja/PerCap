package com.percapincome.client;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.percapincome.pojo.People;
import com.percapincome.pojo.WriterObj;
import com.percapincome.util.CCSVWriter;
import com.percapincome.util.CSVReader;
import com.percapincome.util.MyReader;
import com.percapincome.util.MyWriter;

public class MainClass {
	
	
	
	public static void main(String[] args) {
		MyReader<People> reader=new CSVReader();
		MyWriter writer=new CCSVWriter();
		List<People> list=reader.read(args[0]);
	

		Map<String, Map<String, Double>> avgIncomeByCountryAndGender=
		list.stream().collect(
				Collectors.groupingBy(
						People::getCountry,
						Collectors.groupingBy(People::getGender,Collectors.averagingDouble(People::getAverageIncome))
						));
				
			
		 
		
		Set<Entry<String, Map<String, Double>>> s=avgIncomeByCountryAndGender.entrySet();
		List<WriterObj>listOfObjs=new ArrayList<>();
				for (Entry<String, Map<String, Double>> entry : s) {
			String Country_City=entry.getKey();
			Map<String, Double> map=entry.getValue();
			Set<Entry<String, Double>> ss=map.entrySet();
			for(Entry<String, Double> entrye:ss) {
				String Gender=entrye.getKey();
				double AvgValue=entrye.getValue();
				listOfObjs.add(new WriterObj(Country_City, Gender, AvgValue));
			}
		}
		
		
		writer.write(args[1],listOfObjs);
		
		
	}
}
