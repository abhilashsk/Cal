package com.startup.cal;

public class Event {
	//private variable
	int _id;
	String _Name;
	String _Location;
	String _Description;
	String _Time;
   public Event(){}
   
   public Event(int id, String Name, String Location, String Description,String Time){
	   this._id = id;
	   this._Name = Name;
	   this._Location = Location;
	   this._Description = Description;
	   this._Time = Time;
   }
   
   public Event(String Name, String Location,String Description,String Time){
	   this._Name = Name;
	   this._Location = Location;
	   this._Description = Description;
	   this._Time = Time;
   }
   public Event(String Name, String Location,String Time){
	   this._Name = Name;
	   this._Location = Location;
	   this._Time = Time;
   }
   
   public Event(String Name,String Time){
	   this._Name = Name;
	   this._Time = Time;
   }
   public void setID(int id){
	   this._id = id;
   }
   public int getID(){
	   return this._id;
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
	   return this._Description;
	   }
   public void setTime(String Time){
	   this._Time = Time;
   }
   public String getTime(){
	  return this._Time;
   }
   
   }
   
  
   
