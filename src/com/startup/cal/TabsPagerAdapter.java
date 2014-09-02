package com.startup.cal;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter{
	public TabsPagerAdapter(FragmentManager fm){
		super(fm);
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		 Fragment fragment = new EventFragment();
		switch(arg0){
		case 0:
			return new EventFragment();
		case 1:
			return new ToDoFragment();
		case 2:
			return new DeadlineFragment();
		case 3:
			return new SubsFragment();
		}
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 4;
	}
	  @Override
	    public CharSequence getPageTitle(int position){
	        String title = "";
	        switch(position){
	        case 0:
	            title = "Events";
	            break;
	        case 1:
	            title = "ToDo";
	            break;
	        case 2:
	            title = "Deadlines";
	            break;
	        case 3:
	            title = "Subscription";
	            break;
	        }
	        return title;
	    }
}
