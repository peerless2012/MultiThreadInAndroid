package com.peerless2012.multithreadinandroid.asynctask;

import java.util.List;

import com.peerless2012.multithreadinandroid.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class AsyncTaskActivity extends Activity implements LoadDataCallBack<List<Person>>{

	private TextView mTextView;
	
	private LoadDataTask mLoadDataTask;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_async_task);
		mTextView = (TextView) findViewById(R.id.result);
		mLoadDataTask = new LoadDataTask(this);
		mLoadDataTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "url");
	}

	@Override
	public void onPreExecute() {
		mTextView.setText("开始加载！");
	}

	@Override
	public void onPostExecute(List<Person> t) {
		mTextView.setText("获取结果 ： " + t == null? "空" : t.toString());
	}

	@Override
	public void onCancled() {
		Log.i("AsyncTaskActivity", "取消");
		
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (mLoadDataTask != null) {
			mLoadDataTask.cancelTask();
		}
	}

	public static void launch(Context context) {
		Intent intent = new Intent(context, AsyncTaskActivity.class);
		context.startActivity(intent);
	}
}
