package com.believe.we.runtime;

import com.believe.we.SystemUtils;

public class RunTimeCalls {

	public static void main(String[] args) {
		
		System.out.println("Process ID in main: " + SystemUtils.getProcessId());
		
		Runtime.getRuntime().addShutdownHook( new Thread( new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Process Id in shutdown hook: " + SystemUtils.getProcessId());
				System.out.println("Thread Id in shutdown hook: " + SystemUtils.getThreadId());
				System.out.println("Thread id from Java : "+ Thread.currentThread().getId());
			}
		}));
		
		while (true) {
			
		}
		

	}

}
