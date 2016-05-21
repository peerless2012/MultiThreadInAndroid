package com.peerless2012.multithreadinandroid.intentservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;

public class DataUploadActivity extends Activity {

	private DataUploadReceiver mDataUploadReceiver;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mDataUploadReceiver = new DataUploadReceiver();
	}
	
	private void uploadData() {
		Intent intent = new Intent(this, DataUploadService.class);
		intent.putExtra("ResultReceiver", mDataUploadReceiver);
		startService(intent);
	}
	
	class DataUploadReceiver extends ResultReceiver{

		public DataUploadReceiver() {
			super(null);//如果不需要实现跨进程通信，传空即可
		}
		
		@Override
		protected void onReceiveResult(int resultCode, Bundle resultData) {
			super.onReceiveResult(resultCode, resultData);
		}
	}
}
