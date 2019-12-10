package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Contact implements ContactComponent, Subject{
    
    private String contactName;
    private String contactEmail;
    private String contactNumber;
    
    private ArrayList<Observer> observers;
    
    
    //Tornar construtor privado e criar factory
    public Contact(String newContactName, String newContactEmail, String newContactNumber){
        
        this.contactName = newContactName;
        this.contactEmail = newContactEmail;
        this.contactNumber = newContactNumber;
        
    }
    
    @Override
    public String getName(){
        
        return this.contactName;
    
    }
    
    public String getEmail(){
        
        return this.contactEmail;
    }
    
    public String getNumber(){
        
        return this.contactNumber;
    }
    
    public void setName(String newContactName){
        
        this.contactName = newContactName;
        this.notifyObserver();
        
    }
    
    public void setEmail(String newContactEmail){
        
        this.contactEmail = newContactEmail;
        this.notifyObserver();
        
    }
    
    public void setNumber(String newContactNumber){
        
        this.contactNumber = newContactNumber;
        this.notifyObserver();
        
    }
    
    @Override
    public String displayContactInfo(){
        
        return this.toString();
      
    }
    
    @Override
    public String toString(){
        
        String s = " ";
        
        s+= this.contactName + " " + this.contactEmail + " " + this.contactNumber + "\n";
        
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