package com.paipai.client;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TabHost;

public class MainActivity extends TabActivity implements
		OnCheckedChangeListener {

	private Intent findingIntent;
	private Intent waitingIntent;
	private Intent friendsIntent;
	private Intent settingsIntent;
	private TabHost tabHost;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// super.onCreate(savedInstanceState);
		// Intent intent = new Intent(this,LoginActivity.class);
		// startActivityForResult(intent, 0);
		setContentView(R.layout.activity_main);
		((RadioButton) findViewById(R.id.radio_button0))
				.setOnCheckedChangeListener(this);
		((RadioButton) findViewById(R.id.radio_button1))
				.setOnCheckedChangeListener(this);
		this.findingIntent = new Intent(this, FindingActivity.class);
		this.waitingIntent = new Intent(this, WaitingActivity.class);
		this.friendsIntent = new Intent(this, FindingActivity.class);
		this.settingsIntent = new Intent(this, WaitingActivity.class);
		setupIntent();
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if (isChecked) {
			switch (buttonView.getId()) {
			case R.id.radio_button0:
				this.tabHost.setCurrentTabByTag("Finding");
				break;
			case R.id.radio_button1:
				this.tabHost.setCurrentTabByTag("Waiting");
				break;
			case R.id.radio_button2:
				this.tabHost.setCurrentTabByTag("Friends");
				break;
			case R.id.radio_button3:
				this.tabHost.setCurrentTabByTag("Settings");
				break;
			}
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void setupIntent() {
		this.tabHost = getTabHost();//(TabHost) findViewById(R.id.TabHost1);
		tabHost.addTab(buildTabSpec("Finding", R.string.navigate_finding,R.drawable.finding, this.findingIntent));
		tabHost.addTab(buildTabSpec("Waiting", R.string.navigate_waiting,R.drawable.waiting, this.waitingIntent));
		tabHost.addTab(buildTabSpec("Friends", R.string.navigate_friends,R.drawable.finding, this.findingIntent));
		tabHost.addTab(buildTabSpec("Settings", R.string.navigate_settings,R.drawable.waiting, this.waitingIntent));
	}

	private TabHost.TabSpec buildTabSpec(String tag, int resLabel, int resIcon,
			final Intent content) {
		return this.tabHost
				.newTabSpec(tag)
				.setIndicator(getString(resLabel),getResources().getDrawable(resIcon))
				.setContent(content);
	}

}
