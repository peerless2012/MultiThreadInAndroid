package com.peerless2012.multithreadinandroid.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Log;

/**
* @Author peerless2012
* @Email peerless2012@126.com
* @DateTime 2016年5月21日 上午11:48:10
* @Version V1.0
* @Description:上报数据后台服务
*/
public class DataUploadService extends IntentService {

	public final static String RESULT_RECEIVER = "ResultReceiver";
	
	public final static String RESULT_DATA = "ResultData";
	
	/**
	 * 开始
	 */
	public final static int RESULT_START = 0x00;
	
	/**
	 * 更新进度
	 */
	public final static int RESULT_UPDATE_PROGRESS = 0x01;
	/**
	 * 完成
	 */
	public final static int RESULT_COMPLETE = 0x02;
	/**
	 * 出错
	 */
	public final static int RESULT_ERROR = 0x03;
	
	
	
	public DataUploadService() {
		super("UploadData");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		//注 ： 通过打印HashCode可以发现，如果当前服务还在运行，则新启动Service将会排在队列中公用同一个Service，如果新的Intent到来的时候，服务已经停止，则启动新的。
		Log.i("DataUploadService", this.hashCode()+"");
		ResultReceiver resultReceiver = intent.getParcelableExtra(RESULT_RECEIVER);
		try {
			if (resultReceiver != null) resultReceiver.send(RESULT_START, Bundle.EMPTY);
			int count = 0;
			for (int i = 0; i < 10; i++) {
				SystemClock.sleep(500);
				count ++;
				if (resultReceiver != null){
					Bundle bundle = new Bundle();
					bundle.putInt(RESULT_DATA, count);
					resultReceiver.send(RESULT_UPDATE_PROGRESS, bundle);
				} 
			}
			if (resultReceiver != null){
				Bundle bundle = new Bundle();
				bundle.putInt(RESULT_DATA, count);
				resultReceiver.send(RESULT_COMPLETE, bundle);
			} 
		} catch (Exception e) {
			e.printStackTrace();
			if (resultReceiver != null) resultReceiver.send(RESULT_ERROR, Bundle.EMPTY);
		}
	}

	
}
