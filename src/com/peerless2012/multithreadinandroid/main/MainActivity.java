package com.peerless2012.multithreadinandroid.main;

import com.peerless2012.multithreadinandroid.R;
import com.peerless2012.multithreadinandroid.R.id;
import com.peerless2012.multithreadinandroid.R.layout;
import com.peerless2012.multithreadinandroid.asynctask.AsyncTaskActivity;
import com.peerless2012.multithreadinandroid.handlethread.HandleThreadActivity;
import com.peerless2012.multithreadinandroid.intentservice.DataUploadActivity;
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
		findViewById(R.id.async_task).setOnClickListener(this);
		findViewById(R.id.handle_thread).setOnClickListener(this);
		findViewById(R.id.intent_service).setOnClickListener(this);
		findViewById(R.id.thread_pool).setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.loader:
			LoaderActivity.launch(this);
			break;
			
		case R.id.async_task:
			AsyncTaskActivity.launch(this);
			break;
			
		case R.id.intent_service:
			DataUploadActivity.launch(this);
			break;
			
		case R.id.handle_thread:
			HandleThreadActivity.launch(this);
			break;

		default:
			break;
		}
	}
}
