package controller;

import java.util.ArrayList;
import model.Contact;
import model.Observer;
import model.Subject;
import view.ContactView;

public class ContactController implements Observer{
    
    private ArrayList<Contact> contacts;
    private ContactView contactView; 
    
    public ContactController(Contact s){
        contacts = new ArrayList();
        contacts.add(s);
    }
    
    @Override
    public void update(Subject s) {
        
        contactView.display();
    }
    
}
