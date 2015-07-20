package com.example.tests;








//import org.testng.asserts.*;


import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.File;

import java.io.IOException;
import java.util.Iterator;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.fw.GroupHelper;
import com.example.utils.SortedListOf;

public class GroupCreationTests extends TestBase {
	

	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException {
	return wrapGroupDataForProvider(loadGroupsFromXmlFile(new File( "groups.xml"))).iterator();
		
	}
		
	


@Test(dataProvider ="groupsFromFile")
  public void testGroupCreationValidData(GroupData group) throws Exception {
	//app.navigateTo().mainPage();
	//app.navigateTo().groupsPage();
  
	GroupHelper groupHelper = app.getGroupHelper();
	SortedListOf<GroupData> oldList = groupHelper.getGroups();
	

   // GroupData group = new GroupData();
    group.name = "sdf";
    group.header = "header1 1";
    group.footer = "footer 1";
	app.getGroupHelper().createGroup(group);
	
	
	SortedListOf<GroupData> newList = groupHelper.getGroups();
    
  //  assertEquals(newList.size(), oldList.size()+1);
	assertThat(newList, equalTo(oldList.withAdded(group)));

  }

  @Test
  public void testEmptyGroupCreation() throws Exception {
	app.navigateTo().mainPage();
	app.navigateTo().groupsPage();
	SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
	GroupData group = new GroupData();
	group.name = "";
	group.header = "";
	group.footer = "";
   
	app.getGroupHelper().initGroupCreation(); 
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
    
    
    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
    
    //  assertEquals(newList.size(), oldList.size()+1);
    assertThat(newList, equalTo(oldList.withAdded(group)));  
    
  }


}
