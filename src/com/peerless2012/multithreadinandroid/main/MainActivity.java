package com.peerless2012.multithreadinandroid.main;

import com.peerless2012.multithreadinandroid.R;
import com.peerless2012.multithreadinandroid.R.id;
import com.peerless2012.multithreadinandroid.R.layout;
import com.peerless2012.multithreadinandroid.loader.normal.LoaderActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.loader).setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.loader:
			LoaderActivity.launch(this);
			break;

		default:
			break;
		}
	}
}
