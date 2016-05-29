package com.peerless2012.multithreadinandroid.asynctask;


public interface LoadDataCallBack<T> {
	public void onPreExecute();
	public abstract void onPostExecute(T t);
	public void onCancled();
	
}
