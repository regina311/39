package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {

	protected ApplicationManager app;
	
	@DataProvider
	public Iterator<Object[]> randomValidGroupgenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		
		for (int i=0;i<5; i++){
		
			GroupData group = new GroupData()
			.withName(generateRandomString())
			.withHeader(generateRandomString())
			.withFooter(generateRandomString());
			
			
				
			list.add(new Object[] {group});
		}
		
		return list.iterator();
		
	}
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		
		for (int i=0;i<3; i++){
		
			ContacnData contact = new ContacnData()
			.withFname(generateRandomString())
			.withLname(generateRandomString());	
			
			
			//group.header = generateRandomString();
			//group.footer =generateRandomString();
			list.add(new Object[] {contact});
		}
		
		return list.iterator();
		
	}
	
	
	
	
	public String generateRandomString(){
		
		Random rnd = new Random();
		
		
			if (rnd.nextInt(3)==0){
				return "";
			} else {
				return "test"+rnd.nextInt();
			}
			
			
		}
		
		
		
		


	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();

	  }
	
	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	  
	  }
	
	
}