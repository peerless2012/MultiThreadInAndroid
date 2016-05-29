package com.peerless2012.multithreadinandroid.handlethread;

import com.peerless2012.multithreadinandroid.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;

public class HandleThreadActivity extends Activity {

	private HandlerThread mHandleThread;
	
	private Looper mHandlerLooper;
	
	private Handler mWorkHandler;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_handle_thread);
		initHandlerThread();
	}

	public void doWorkInWorkThread(View v) {
		mWorkHandler.sendEmptyMessage(0);
	}
	
	private void initHandlerThread() {
		mHandleThread = new HandlerThread("WorkThread");
		mHandleThread.start();
		mHandlerLooper = mHandleThread.getLooper();
		mWorkHandler = new Handler(mHandlerLooper){
			@Override
			public void handleMessage(Message msg) {
				super.handleMessage(msg);
				Log.i("HandleThreadActivity", "doSomeThing + thread id = "+ Thread.currentThread().getId()+"   ,name = "+Thread.currentThread().getName());
			}
		};
	}
	
	@Override
	protected void onDestroy() {
		releaseHandlerThread();
		super.onDestroy();
	}
	
	@SuppressLint("NewApi")
	private void releaseHandlerThread() {
		mWorkHandler.removeCallbacksAndMessages(null);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			mHandlerLooper.quitSafely();
			mHandleThread.quitSafely();
		}else {
			mHandlerLooper.quit();
			mHandleThread.quit();
		}
	}
	
	public static void launch(Context context) {
		Intent intent = new Intent(context, HandleThreadActivity.class);
		context.startActivity(intent);
		
	}
}
