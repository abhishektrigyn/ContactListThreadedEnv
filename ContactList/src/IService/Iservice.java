package IService;

import java.util.List;
import java.util.Vector;

import pojo.Contact;

public interface Iservice {
	
	boolean addContact(Contact contact);
	boolean modifyContact(Contact contact);
	boolean removeContact(Contact contact);
	List<Contact> searchAnything(String searchString);// this will accept search on anything
	// either on name, phone or address ,, it will accept substring as well as anycase string 
	

}
