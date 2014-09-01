package com.startup.cal;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
public class EventFragment extends Fragment{
	private ListView lvEvent;
 @Override
 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
	 View rootView = inflater.inflate(R.layout.fragment_event, container, false);
     lvEvent = (ListView)rootView.findViewById(R.id.lvEvent);
     return rootView;
 }
}
