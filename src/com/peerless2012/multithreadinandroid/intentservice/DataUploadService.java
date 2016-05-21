package com.peerless2012.multithreadinandroid.intentservice;

import android.app.IntentService;
import android.content.Intent;

/**
* @Author peerless2012
* @Email peerless2012@126.com
* @DateTime 2016年5月21日 上午11:48:10
* @Version V1.0
* @Description:上报数据
*/
public class DataUploadService extends IntentService {

	public DataUploadService() {
		super("UploadData");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		
	}

}
