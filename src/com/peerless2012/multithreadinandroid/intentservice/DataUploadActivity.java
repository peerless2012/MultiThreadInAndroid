package com.peerless2012.multithreadinandroid.intentservice;

import com.peerless2012.multithreadinandroid.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

/**
* @Author peerless2012
* @Email peerless2012@126.com
* @DateTime 2016年5月21日 下午4:14:04
* @Version V1.0
* @Description: 上传数据
*/
public class DataUploadActivity extends Activity implements OnClickListener{

	private DataUploadReceiver mDataUploadReceiver;
	private TextView mTextView;
	private Handler mHandler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_data_upload);
		findViewById(R.id.start).setOnClickListener(this);
		mTextView = (TextView) findViewById(R.id.progress);
		mHandler = new Handler();
		mDataUploadReceiver = new DataUploadReceiver(mHandler);
	}
	
	/**
	* @Author peerless2012
	* @Email peerless2012@126.com
	* @DateTime 2016年5月21日 下午4:13:31
	* @Version V1.0
	* @Description: 接收IntentService返回的数据（可能会造成内存泄露）
	*/
	class DataUploadReceiver extends ResultReceiver{

		public DataUploadReceiver(Handler handler) {
			super(handler);//如果不需要实现跨进程通信，传空即可
		}
		
		@Override
		protected void onReceiveResult(int resultCode, Bundle resultData) {
			String msg = null;
			if (resultCode == DataUploadService.RESULT_START) {
				msg = "开始";
			}else if (resultCode == DataUploadService.RESULT_UPDATE_PROGRESS) {
				msg = "当前进度 ： " + resultData.getInt(DataUploadService.RESULT_DATA, 0);
			}else if (resultCode == DataUploadService.RESULT_COMPLETE) {
				msg = "完成";
			}else if (resultCode == DataUploadService.RESULT_ERROR) {
				msg = "出错";
			}else {
				msg = "其他";
			}
			mTextView.setText(msg);
		}
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(this, DataUploadService.class);
		intent.putExtra("ResultReceiver", mDataUploadReceiver);
		startService(intent);
	}

	public static void launch(Context context) {
		Intent intent = new Intent(context, DataUploadActivity.class);
		context.startActivity(intent);
	}
}
