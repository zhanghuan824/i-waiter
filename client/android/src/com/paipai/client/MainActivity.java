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
		tabHost.addTab(buildTabSpec("Finding", R.string.navigate_finding,R.drawable.icon_1_n, this.findingIntent));
		tabHost.addTab(buildTabSpec("Waiting", R.string.navigate_waiting,R.drawable.icon_2_n, this.waitingIntent));
	}

	private TabHost.TabSpec buildTabSpec(String tag, int resLabel, int resIcon,
			final Intent content) {
		return this.tabHost
				.newTabSpec(tag)
				.setIndicator(getString(resLabel),getResources().getDrawable(resIcon))
				.setContent(content);
	}

}
