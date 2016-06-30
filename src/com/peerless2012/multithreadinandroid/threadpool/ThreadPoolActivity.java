package com.peerless2012.multithreadinandroid.threadpool;

import com.peerless2012.multithreadinandroid.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;

public class ThreadPoolActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_thread_pool);
		ExecutorsTask.getInstance().execute(new Runnable() {
			
			@Override
			public void run() {
				//do some thing
				SystemClock.sleep(3000);
				Log.i("ThreadPoolActivity", "结束");
			}
		});
	}

	
	
	public static void launch(Context context) {
		Intent intent = new Intent(context, ThreadPoolActivity.class);
		context.startActivity(intent);
	}
}
