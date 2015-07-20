package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	
	public static void main(String[] args) throws IOException {
	
		if (args.length <3){
			System.out.println("parametr 3 need");
			return;
		}
	int amount = Integer.parseInt(args[0]);
	File file= new File(args[1]);
	String format = args[2];
if (file.exists()) {
		
		System.out.println("file exist,please remove it manually"+ file );
		return;
	}
	List<ContacnData>contacts = generateRandomContact(amount);
	if ("csv".equals(format)){
		saveContactsToCsvFile(contacts, file);
	}else if ("xml".equals(format))

	{
		saveContactsToXmlFile(contacts, file);
	} else {
		System.out.println("unknown format"+ format);
		return;
	}
	
	}

	  public static List<ContacnData> loadContactsFromCsvFile(File file) throws IOException {
		  List<ContacnData> list = new ArrayList<ContacnData>();
		
			// TODO Auto-generated method stub
		 FileReader reader = new FileReader(file);
		 BufferedReader bufferedReader = new BufferedReader(reader);
		 String line= bufferedReader.readLine();
		 while(line !=null){
String[] part = line.split(",");
ContacnData contact= new ContacnData()
.withFname(part[0])
.withLname(part[1]);

list.add(contact);
line=bufferedReader.readLine();
		 }
		 bufferedReader.close();
		 
		  return list;
		  
		}
		
	  public static void saveContactsToXmlFile(List<ContacnData> contacts, File file) throws IOException {
			XStream xstream =new XStream();
			
			xstream.alias("contact",ContacnData.class);
			String xml = xstream.toXML(contacts);
			
		
			FileWriter writer = new FileWriter(file);
			writer.write(xml);
			writer.close();
			
		}
		
		public static List<ContacnData> loadContactsFromXmlFile( File file)  {
			
			
	XStream xstream =new XStream();
			
			xstream.alias("group",GroupData.class);
			return (List<ContacnData>) xstream.fromXML(file);
		}
	  



	private static void saveContactsToCsvFile(List<ContacnData> contacts,
			File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContacnData contact :contacts) {
		writer.write(contact.getFname()+"," + contact.getLname()+",!"+"\n");
		}	
			writer.close();
		
	}

	public static List<ContacnData> generateRandomContact(int amount) {
List<ContacnData> list = new ArrayList<ContacnData>();
		
		for (int i=0;i<amount; i++){
		
			ContacnData contact = new ContacnData()
			.withFname(generateRandomString())
			.withLname(generateRandomString());	
			
			
			//group.header = generateRandomString();
			//group.footer =generateRandomString();
			list.add(contact);
		}
		
		return list;
		
	}

	private static String generateRandomString() {
		Random rnd = new Random();
		
		
		if (rnd.nextInt(3)==0){
			return "";
		} else {
			return "test"+rnd.nextInt();
		}// TODO Auto-generated method stub
		
	}

	

	

	}


