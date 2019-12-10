package model;

import java.util.ArrayList;
import java.util.Iterator;

public class ContactGroup implements ContactComponent, Subject{
    
    private ArrayList contactComponents;
    private String groupName;
    
    private ArrayList<Observer> observers;    
    
    //Tornar construtor privado e criar factory
    public ContactGroup(String newGroupName){
        
        this.contactComponents = new ArrayList();
        
        this.groupName = newGroupName;
        
    }
    
    public void setContactGroupName(String newGroupName){
        
        this.groupName = newGroupName;
        this.notifyObserver();
        
    }
    
    @Override
    public String getName(){
        
        return this.groupName;
        
    }
     
    public void add(ContactComponent newContactComponent){
        
        contactComponents.add(newContactComponent);
        this.notifyObserver();
        
    }
    
    public void delete(ContactComponent newContactComponent){
        
        contactComponents.remove(newContactComponent);
        this.notifyObserver();
        
    }
    
    
    @Override
    public String displayContactInfo(){
        String s = " ";
        s+= this.toString();
        
        Iterator contactIterator = contactComponents.iterator();
        
        while(contactIterator.hasNext()){
            
            ContactComponent contactInfo = (ContactComponent) contactIterator.next();
            s+= contactInfo.displayContactInfo();
            
        }
        
        return s;

    }
    
    @Override
    public String toString(){
        String s = " ";
        
        s += this.getName() + "\n";
        
        return s;
    }

    @Override
    public void register(Observer newObserver){
        
        this.observers.add(newObserver);
        
    }

    @Override
    public void unregister(Observer deleteObserver){
        
        int obsIndex = this.observers.indexOf(deleteObserver);
        System.out.println("Observer " + (obsIndex + 1) + " deleted");
        this.observers.remove(obsIndex);
        
    }

    @Override
    public void notifyObserver(){
        
        Iterator observerIterator = observers.iterator();
        
        while(observerIterator.hasNext()){
            Observer ob = (Observer) observerIterator.next();
            ob.update(this);
        }
        
    }
}
