package com.example.fw;




import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContacnData;
import com.example.utils.SortedListOf;



public class ContactHelper extends HelperBase {

	public static boolean CREATION=true;
	public static boolean MODIFICATION=false;
	//public static boolean REMOVAL=true;
	
	
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private SortedListOf<ContacnData> cachedContacts;
	
	public SortedListOf<ContacnData> getContacts(){
		if (cachedContacts == null) {
			rebuildCache();
			
		}
		return cachedContacts;
	}

	

	
	private void rebuildCache() {
		
		SortedListOf<ContacnData> contacts = new SortedListOf<ContacnData>();  
		
		List<WebElement> contactRows = driver.findElements(By.xpath("//tr[@name='entry']"));  
		for (WebElement contactRow : contactRows) {  
			
 				String fname = contactRow.findElement(By.xpath("./td[3]")).getText();  
 			String lname = contactRow.findElement(By.xpath("./td[2]")).getText();  
 				String mail1 = contactRow.findElement(By.xpath("./td[4]")).getText();  
 			String hnumber = contactRow.findElement(By.xpath("./td[5]")).getText();  
 				
 				contacts.add(new ContacnData().withFname(fname)); 
 			}  
		
	}




	public ContactHelper createContacts(ContacnData contact) {
		
		gotoContactsPage();
		fillContactForm(contact, CREATION);
	    submitContactCreation();
	    returnContactPage();
	    rebuildCache();
	    return this;
	   	
	}

	
	public ContactHelper modifyContacts(int index, ContacnData contact) {
		initContactModification(index);
		//ContacnData contact = new ContacnData();
		//contact.fname = "new name";
	     fillContactForm(contact, ContactHelper.MODIFICATION);
	    submitContactModification();
	   returnContactPage();
	   rebuildCache();
	   return this;
		// TODO Auto-generated method stub
		
	}

	//public ContactHelper deleteContacts(int index) {
		// TODO Auto-generated method stub
		
		//app.getContactHelper()
		   
	//	deleteContact(index);
	//returnContactPage();
	  //save new state
		//return this;
		
		
	//}

	public ContactHelper deleteContact(int index) {
		selectContactByIndex(index);
		submitContactDeletion();
		rebuildCache();
		return this;
		
	}


	
//---------------------------------------------------------------------------------------------------------

	
	

	public ContactHelper gotoContactsPage() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		cachedContacts=null;
		return this;
	}

	public ContactHelper fillContactForm(ContacnData contact, boolean formType) {
		type(By.name("firstname"), contact.getFname());
		type(By.name("lastname"), contact.getLname());
		type(By.name("address"), contact.getAddress1());
		type(By.name("home"), contact.getHnumber());
		type(By.name("mobile"), contact.getMnumber());
		type(By.name("work"), contact.getWnumber());
		type(By.name("email"), contact.getMail1());
		type(By.name("email2"), contact.getMail2());
		type(By.name("byear"), contact.getYear());
		if (formType == CREATION){
			
		}
		else{
			if (driver.findElements(By.name("new_group")).size()!= 0) {
				throw new  Error ("group selection in contact modofication form");
				
			}
		}
		type(By.name("address2"), contact.getAddress2());
		type(By.name("phone2"), contact.getPhonenumber());
		return this;
	    
	}

	public ContactHelper returnContactPage() {
		click(By.linkText("home page"));
		return this;
	}

	

	private ContactHelper selectContactByIndex(int index) {
		click(By.xpath("(//img[@alt='Edit'])["+ index +"]"));
		return this;
	}

	public ContactHelper initContactModification(int index) {
		selectContactByIndex(index);
		return this;
	}
	

	public ContactHelper submitContactModification() {
		click(By.xpath("(//input[@name='update'])[1]"));
		cachedContacts=null;
		return this;
		
	}

	public void submitContactDeletion() {
		click(By.xpath("(//input[@name='update'])[2]"));
		cachedContacts=null;
	}
	
	
}
