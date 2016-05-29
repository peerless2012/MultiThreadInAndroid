package com.peerless2012.multithreadinandroid.asynctask;

import java.util.ArrayList;
import java.util.List;
import android.os.SystemClock;

public class LoadDataTask extends BaseAsyncTask<String, List<Person>> {

	public LoadDataTask(LoadDataCallBack<List<Person>> callBack) {
		super(callBack);
	}
	
	@Override
	protected List<Person> doInBackground(String... params) {
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 10; i++) {
			if (isCancelled()) break;
			SystemClock.sleep(500);
			Person person = new Person();
			person.setName("Name   "+i);
			persons.add(person);
		}
		return persons;
	}
}
