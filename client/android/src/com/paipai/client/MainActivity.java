package com.paipai.client;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Menu;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TabHost;

public class MainActivity extends FragmentActivity 
		 {

	private Intent findingIntent;
	private Intent waitingIntent;
	private Intent friendsIntent;
	private Intent settingsIntent;
	private FragmentTabHost tabHost;

	@Override
	public void onCreate(Bundle savedInstanceState)  {
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		// super.onCreate(savedInstanceState);
		// Intent intent = new Intent(this,LoginActivity.class);
		// startActivityForResult(intent, 0);
		setContentView(R.layout.activity_main);
		this.findingIntent = new Intent(this, FindingFragment.class);
		this.waitingIntent = new Intent(this, WaitingFragment.class);
		this.friendsIntent = new Intent(this, FriendsFragment.class);
		this.settingsIntent = new Intent(this, SettingsFragment.class);
		setupIntent();
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void setupIntent() {
		this.tabHost = (FragmentTabHost) findViewById(R.id.tab);
		this.tabHost.setup(this,getSupportFragmentManager(),R.id.tabcontent);
		
		tabHost.addTab(buildTabSpec("Finding", R.string.navigate_finding,R.drawable.finding, this.findingIntent),FindingFragment.class,null);
		tabHost.addTab(buildTabSpec("Waiting", R.string.navigate_waiting,R.drawable.waiting, this.waitingIntent),WaitingFragment.class,null);
		tabHost.addTab(buildTabSpec("Settings", R.string.navigate_settings,R.drawable.waiting, this.settingsIntent),SettingsFragment.class,null);
	}

	private TabHost.TabSpec buildTabSpec(String tag, int resLabel, int resIcon,
			final Intent content) {
		return this.tabHost
				.newTabSpec(tag)
				.setIndicator(getString(resLabel),getResources().getDrawable(resIcon))
				.setContent(content);
	}

}
