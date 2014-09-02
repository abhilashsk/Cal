package com.startup.cal;

public class Event {
	//private variable
	int _id;
	String _Name;
	String _Location;
	String _Description;
   public Event(){}
   
   public Event(int id, String Name, String Location, String Description){
	   this._id = id;
	   this._Name = Name;
	   this._Location = Location;
	   this._Description = Description;
   }
   
   public Event(String Name, String Location,String Description){
	   this._Name = Name;
	   this._Location = Location;
	   this._Description = Description;
   }
   public Event(String Name, String Location){
	   this._Name = Name;
	   this._Location = Location;
   }
   
   public Event(String Name){
	   this._Name = Name;
   }
   
   public void setName(String Name){
	   this._Name = Name;
   }
   public String getName(){
	   return this._Name;
   }
   
   public void setLocation(String Location){
	   this._Location = Location;
   }
   
   public String getLocation(){
	   return this._Location;
   }
   
   public void setDescription(String Description){
	   this._Description = Description;
   }
   
   public String getDescription(){
	   return this._Description;}
   }
