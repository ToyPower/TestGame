package com.mikemik44.managers;

import java.util.ArrayList;
import com.mikemik44.components.ThreadComponent;

public class ThreadManager {
	
	//holds all threads
	private static ArrayList<ThreadManager> threads = new ArrayList<ThreadManager>();
	
	//this will close every thread that is up
	public static void closeAll() {
		//closes every thread
		for (ThreadManager tm : threads) {
			
			tm.stop();
			
		}
		
	}
	
	//holds our thread and ThreadComponent
	private Thread t;
	
	//this is the constructor asking for a threadcomponent
	public ThreadManager(ThreadComponent tc) {
		
		this(tc, "EMPTY THREAD");
		
	}
	
	//this is the constructor asking for threadcomponent and a name
	public ThreadManager(ThreadComponent tc, String threadName) {
		
		this(tc, threadName, false);
		
	}

	//this is the constructor asking for a threadcomponent a game and if you want to start it
	public ThreadManager(ThreadComponent tc, String threadName, boolean start) {
		ThreadManager tm = this;
		threads.add(tm);
		this.t = new Thread() {
			
			public void run() {
				
				tc.run();
				tm.stop();
				
			}
			
		};
		this.t.setName(threadName);
		if (start) {
			
			start();
			
		}
		
	}
	
	//this starts the thread
	public void start() {
		
		t.start();
		
	}
	
	//this stops the thread
	@SuppressWarnings("deprecation")
	public void stop() {
		
		t.stop();
		
	}
	
	//this waits for the thread to close
	public void await() {
		
		try {
			t.join();
		} catch (InterruptedException e) {
		}
		
	}
	
}
