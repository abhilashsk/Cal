package com.startup.cal;

public class Deadline {
	int _id;
	String _Name;
	String _Description;
   public Deadline(){}
   
   public Deadline(int id, String Name, String Description){
	   this._id = id;
	   this._Name = Name;
	   this._Description = Description;
   }
   
   public Deadline(String Name,String Description){
	   this._Name = Name;
	   this._Description = Description;
   }
   public Deadline(String Name){
	   this._Name = Name;
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
   }

