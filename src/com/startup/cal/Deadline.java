package com.startup.cal;

public class Deadline {
	int _id;
	String _Name;
	String _Description;
	String _Time;
   public Deadline(){}
   
   public Deadline(int id, String Name, String Description,String Time){
	   this._id = id;
	   this._Name = Name;
	   this._Description = Description;
	   this._Time = Time;
   }
   
   public Deadline(String Name,String Description,String Time){
	   this._Name = Name;
	   this._Description = Description;
	   this._Time = Time;
   }
   public Deadline(String Name,String Time){
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
   
   
   public void setDescription(String Description){
	   this._Description = Description;
   }
   
   public String getDescription(){
	   return this._Description;}
   
   public void setTime(String Time){
	   this._Time = Time;
   }
   public String getTime(){
	  return this._Time;
   }
   }

