package com.startup.cal;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.viewpagerindicator.TitlePageIndicator;

@SuppressLint("NewApi")
public class CalMain extends FragmentActivity {
	private ViewPager tabPager1;
    private TabsPagerAdapter tpAdapter;
    private ActionBar actionBar;
    private TitlePageIndicator Tindicator;
    //Tab titles
    private String[] tabs = { "Events", "ToDo", "Deadlines","Subscription" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cal_main);
		// Initialization
		tabPager1 = (ViewPager)findViewById(R.id.pager);
		tpAdapter = new TabsPagerAdapter(getSupportFragmentManager());
		tabPager1.setAdapter(tpAdapter);
		
		//actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		//Adding Tabs
		//for(String tab_name : tabs){
		//	actionBar.addTab(actionBar.newTab().setText(tab_name).setTabListener(this));
		//}
          Tindicator = (TitlePageIndicator)findViewById(R.id.Tindicator);
        
        Tindicator.setViewPager(tabPager1);
		
		 // ViewPager Indicator
        
		/*TabHost cal = (TabHost)findViewById(R.id.calhost);
		cal.setup();
		TabSpec spec_events = cal.newTabSpec("Events");
		spec_events.setIndicator("Events");
		spec_events.setContent(R.id.tab_events);
		
		TabSpec spec_todo = cal.newTabSpec("ToDo");
		spec_todo.setIndicator("ToDo");
		spec_todo.setContent(R.id.tab_todo);
		
		TabSpec spec_deadlines = cal.newTabSpec("Deadlines");
		spec_deadlines.setIndicator("Deadlines");
		spec_deadlines.setContent(R.id.tab_deadlines);
		
		TabSpec spec_subs = cal.newTabSpec("Subscriptions");
		spec_subs.setIndicator("Subscription");
		spec_subs.setContent(R.id.tab_subscription);
		
		cal.addTab(spec_events); cal.addTab(spec_todo); cal.addTab(spec_deadlines); cal.addTab(spec_subs);*/
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cal_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
}
