package com.startup.cal;

public class ToDo {
	int _id;
	String _Name;
	String _Description;
   public ToDo(){}
   
   public ToDo(int id, String Name, String Description){
	   this._id = id;
	   this._Name = Name;
	   this._Description = Description;
   }
   
   public ToDo(String Name,String Description){
	   this._Name = Name;
	   this._Description = Description;
   }
   public ToDo(String Name){
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


