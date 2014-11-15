package com.believe.we.ipc;

import java.lang.management.ManagementFactory;
import com.believe.we.SystemUtils;

public class JNI {
	
	public static void main(String[] args) {
		// Platform independent
	
		String name = ManagementFactory.getRuntimeMXBean().getName();
		System.out.println("Current process name: " + name);
		System.out.println("Process Id is: " + name.split("@")[0]);
		
		// return from C++ code
		try {
			//System.load("/home/yinr/workspace/Test/libs/libSystemUtils.so");	
			//System.loadLibrary("SystemUtils");
		
			int pid = SystemUtils.getProcessId();
			System.out.println("Call C++ code to get current process id: " + pid);
			
		} catch (UnsatisfiedLinkError e) {
			e.printStackTrace();
		}

	}

}
