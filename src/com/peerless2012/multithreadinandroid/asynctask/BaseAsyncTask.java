package com.peerless2012.multithreadinandroid.asynctask;

import android.os.AsyncTask;

public abstract class BaseAsyncTask<Params, Result> extends
		AsyncTask<Params, Void, Result> {

	private LoadDataCallBack<Result> mLoadDataCallBack;

	public BaseAsyncTask(LoadDataCallBack<Result> callBack) {
		mLoadDataCallBack = callBack;
	}

	public void cancelTask() {
		if (getStatus() != Status.FINISHED) {
			cancel(true);
		}
		mLoadDataCallBack = null;
	}
	
	@Override
	final protected void onPostExecute(Result result) {
		super.onPostExecute(result);
		if (mLoadDataCallBack != null) {
			mLoadDataCallBack.onPostExecute(result);
		}
	}
	
	@Override
	protected void onCancelled() {
		super.onCancelled();
		if (mLoadDataCallBack != null) {
			mLoadDataCallBack.onCancled();
		}
	}
	
	@Override
	final protected void onPreExecute() {
		super.onPreExecute();
		if (mLoadDataCallBack != null) {
			mLoadDataCallBack.onPreExecute();
		}
	}
}
