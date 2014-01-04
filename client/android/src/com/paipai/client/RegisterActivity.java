/**
 * 
 */
package com.paipai.client;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

/**
 * @author huangxuelun
 *
 */
public class RegisterActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
