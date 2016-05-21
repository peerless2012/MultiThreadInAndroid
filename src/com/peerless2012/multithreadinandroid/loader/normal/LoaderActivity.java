package com.peerless2012.multithreadinandroid.loader.normal;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.peerless2012.multithreadinandroid.R;

public class LoaderActivity extends Activity implements LoaderCallbacks<List<Student>>{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loader);
		
		LoaderManager loaderManager = getLoaderManager();
		loaderManager.initLoader(0, savedInstanceState, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.loader, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public Loader<List<Student>> onCreateLoader(int id, Bundle args) {
		return new MyLoader(this);
	}

	@Override
	public void onLoadFinished(Loader<List<Student>> loader, List<Student> data) {
		Toast.makeText(getApplicationContext(), "数据加载完毕",
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onLoaderReset(Loader<List<Student>> loader) {
		Toast.makeText(getApplicationContext(), "数据重置",
				Toast.LENGTH_SHORT).show();
	}
	
	class MyLoader extends AsyncTaskLoader<List<Student>>{

		public MyLoader(Context context) {
			super(context);
		}

		@Override
		public List<Student> loadInBackground() {
			SystemClock.sleep(3000);
			List<Student> students = new ArrayList<>();
			Student student = new Student();
			student.setName("测试");
			student.setAge(34);
			students.add(student);
			return students;
		}
		
		@Override
		protected void onStartLoading() {
			super.onStartLoading();
		}
		
		@Override
		protected void onStopLoading() {
			super.onStopLoading();
		}
		
		@Override
		public void deliverResult(List<Student> data) {
			super.deliverResult(data);
		}
		@Override
		public boolean isReset() {
			return super.isReset();
		}
	}

	
	public static void launch(Context context) {
			Intent intent = new Intent(context, LoaderActivity.class);
			context.startActivity(intent);
	}
	
}
