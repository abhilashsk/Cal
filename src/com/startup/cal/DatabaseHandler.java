package com.startup.cal;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper{
      public static int DATABASE_VERSION = 1;
      private static final String DATABASE_NAME = "CalData";
      private static final String TABLE_EVENTS = "events";
      private static final String TABLE_TODO = "todo";
      private static final String TABLE_DEADLINES = "deadlines";
      private static final String TABLE_SUBS = "subs";
      
      public static final String KEY_ID = "_id";
      public static final String KEY_NAME = "name";
  	  public static final String KEY_LOCATION = "location";
  	  public static final String KEY_TIME = "time";
  	  public static final String KEY_DESCRIPTION = "description";
  	  
  	private static final String CREATE_TABLE_EVENTS = "CREATE TABLE "
            + TABLE_EVENTS + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_LOCATION + " TEXT," + KEY_TIME
            + " DATETIME," + KEY_DESCRIPTION + " TEXT" + ")";
  	private static final String CREATE_TABLE_TODO = "CREATE TABLE "
            + TABLE_TODO + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_DESCRIPTION + " TEXT," + KEY_TIME
            + " DATETIME" + ")";
  	private static final String CREATE_TABLE_DEADLINES = "CREATE TABLE "
            + TABLE_DEADLINES + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_DESCRIPTION + " TEXT," + KEY_TIME
            + " DATETIME" + ")";
  	
  	  
  	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		Log.d("databasehandler:22","constructed");
	}
  	
  	 @Override
     public void onCreate(SQLiteDatabase db) {
  
         // creating required tables
         db.execSQL(CREATE_TABLE_TODO);
         db.execSQL(CREATE_TABLE_EVENTS);
         db.execSQL(CREATE_TABLE_DEADLINES);
     }
  	 
  	 @Override
     public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         // on upgrade drop older tables
         db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODO);
         db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENTS);
         db.execSQL("DROP TABLE IF EXISTS " + TABLE_DEADLINES);
  
         // create new tables
         onCreate(db);
     }
  	 
  	 public long createEvent(Event event){
  		 SQLiteDatabase db = this.getWritableDatabase();
  		 
  		 ContentValues values = new ContentValues();
  		 values.put(KEY_NAME, event.getName());
  		 values.put(KEY_LOCATION, event.getLocation());
  		 values.put(KEY_TIME, event.getTime());
  		 long event_id = db.insert(TABLE_EVENTS, null, values);
  		 return event_id;
  	 }
  	 
  	public long createToDo(ToDo todo){
 		 SQLiteDatabase db = this.getWritableDatabase();
 		 
 		 ContentValues values = new ContentValues();
 		 values.put(KEY_NAME, todo.getName());
 		 values.put(KEY_TIME, todo.getTime());
 		 long todo_id = db.insert(TABLE_TODO, null, values);
 		 return todo_id;
 	 }
  	
  	public long createDeadline(Deadline deadline){
 		 SQLiteDatabase db = this.getWritableDatabase();
 		 
 		 ContentValues values = new ContentValues();
 		 values.put(KEY_NAME, deadline.getName());
 		 values.put(KEY_TIME, deadline.getTime());
 		 long event_id = db.insert(TABLE_DEADLINES, null, values);
 		 return event_id;
 	 }
   
  	 public Event getEvent(long event_id){
  		 SQLiteDatabase db = getReadableDatabase();
  		 String selectQuery = "SELECT * FROM" + TABLE_EVENTS + " WHERE " + KEY_ID + " = " + event_id;
  		 
  		 Log.e("dbh:77",selectQuery);
  		 
  		 Cursor c = db.rawQuery(selectQuery,null);
  		 
  		if (c != null)
  			c.moveToFirst();
  			Event ev = new Event();
  	        ev.setID(c.getInt(c.getColumnIndex(KEY_ID)));
  			ev.setName((c.getString(c.getColumnIndex(KEY_NAME))));
  			ev.setTime(c.getString(c.getColumnIndex(KEY_TIME)));
  			ev.setDescription(c.getString(c.getColumnIndex(KEY_DESCRIPTION)));
  			ev.setLocation(c.getString(c.getColumnIndex(KEY_LOCATION)));
  	        return ev;
  		 
  	 }
  	 
  	public ToDo getToDo(long todo_id){
 		 SQLiteDatabase db = getReadableDatabase();
 		 String selectQuery = "SELECT * FROM" + TABLE_TODO + " WHERE " + KEY_ID + " = " + todo_id;
 		 
 		 Log.e("dbh:77",selectQuery);
 		 
 		 Cursor c = db.rawQuery(selectQuery,null);
 		 
 		if (c != null)
 			c.moveToFirst();
 			ToDo td = new ToDo();
 	        td.setID(c.getInt(c.getColumnIndex(KEY_ID)));
 			td.setName((c.getString(c.getColumnIndex(KEY_NAME))));
 			td.setTime(c.getString(c.getColumnIndex(KEY_TIME)));
 			td.setDescription(c.getString(c.getColumnIndex(KEY_DESCRIPTION)));
 	        return td;
 	 }
 	 
  	public Deadline getDeadline(long deadline_id){
		 SQLiteDatabase db = getReadableDatabase();
		 String selectQuery = "SELECT * FROM" + TABLE_DEADLINES + " WHERE " + KEY_ID + " = " + deadline_id;
		 
		 Log.e("dbh:77",selectQuery);
		 
		 Cursor c = db.rawQuery(selectQuery,null);
		 
		if (c != null)
			c.moveToFirst();
			Deadline de = new Deadline();
	        de.setID(c.getInt(c.getColumnIndex(KEY_ID)));
			de.setName((c.getString(c.getColumnIndex(KEY_NAME))));
			de.setTime(c.getString(c.getColumnIndex(KEY_TIME)));
			de.setDescription(c.getString(c.getColumnIndex(KEY_DESCRIPTION)));
	        return de;
	 }
  	 
  	public void deleteEvent(long event_id) {
  	    SQLiteDatabase db = this.getWritableDatabase();
  	    db.delete(TABLE_EVENTS, KEY_ID + " = ?",
  	            new String[] { String.valueOf(event_id) });
  	}
  	
  	public void deleteToDo(long todo_id) {
  	    SQLiteDatabase db = this.getWritableDatabase();
  	    db.delete(TABLE_TODO, KEY_ID + " = ?",
  	            new String[] { String.valueOf(todo_id) });
  	}
  	
  	public void deleteDeadline(long de_id) {
  	    SQLiteDatabase db = this.getWritableDatabase();
  	    db.delete(TABLE_DEADLINES, KEY_ID + " = ?",
  	            new String[] { String.valueOf(de_id) });
  	}
  	
  	public List<Event> getAllEvents() {
		List<Event> EventList = new ArrayList<Event>();
		// Select All Query
		//String selectQuery = "SELECT  * FROM " + TABLE_SONGS;
          String selectQuery = "SELECT  * FROM " + TABLE_EVENTS +" ORDER BY "+ KEY_ID +" DESCENTDING" ;
          
          Log.e("db:177",selectQuery);
          
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
        int i = 0;
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Event ev = getEvent(i);
				// Adding contact to list
				EventList.add(ev);
				i++;
			} while (cursor.moveToNext());}
		return EventList;
		}
  	
  	public List<ToDo> getAllToDos() {
		List<ToDo> ToDoList = new ArrayList<ToDo>();
		// Select All Query
		//String selectQuery = "SELECT  * FROM " + TABLE_SONGS;
          String selectQuery = "SELECT  * FROM " + TABLE_TODO +" ORDER BY "+ KEY_ID +" DESCENTDING" ;
          
          Log.e("db:177",selectQuery);
          
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
        int i = 0;
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				ToDo td = getToDo(i);
				// Adding contact to list
				ToDoList.add(td);
				i++;
			} while (cursor.moveToNext());}
		return ToDoList;
		}
  	
  	public List<Deadline> getAllDeadlines() {
		List<Deadline> DeadlineList = new ArrayList<Deadline>();
		// Select All Query
		//String selectQuery = "SELECT  * FROM " + TABLE_SONGS;
          String selectQuery = "SELECT  * FROM " + TABLE_DEADLINES +" ORDER BY "+ KEY_ID +" DESCENTDING" ;
          
          Log.e("db:177",selectQuery);
          
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
        int i = 0;
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Deadline de = getDeadline(i);
				// Adding contact to list
				DeadlineList.add(de);
				i++;
			} while (cursor.moveToNext());}
		return DeadlineList;
		}
 // closing database
  	public void closeDB(){
  		SQLiteDatabase db = getReadableDatabase();
  		if((db != null) && db.isOpen())
  			db.close();			
  	}
}
