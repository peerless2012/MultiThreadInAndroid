package com.peerless2012.multithreadinandroid.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
* @Author peerless2012
* @Email peerless2012@126.com
* @DateTime 2016年6月30日 上午10:50:57
* @Version V1.0
* @Description 线程池任务类
*/
public class ExecutorsTask {
	
	private static volatile ExecutorsTask INSTANCE;
	
	private ExecutorService mExecutorService;
	
	private ExecutorsTask() {
		super();
		mExecutorService = Executors.newCachedThreadPool();
	}



	public static ExecutorsTask getInstance() {
		ExecutorsTask ins = INSTANCE;
		if (ins == null) {
			synchronized (ExecutorsTask.class) {
				ins = INSTANCE;
				if (ins == null) {
					INSTANCE = new ExecutorsTask();
					ins = INSTANCE;
				}
			}
		}
		return ins;
	}
	
	public void execute(Runnable runnable) {
		mExecutorService.submit(runnable);

	}
	public <V> void execute(Callable<V> callable) {
		mExecutorService.submit(callable);
	}
}
