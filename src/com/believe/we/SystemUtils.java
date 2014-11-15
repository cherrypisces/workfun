package com.believe.we;

public final class SystemUtils {

	public static final String SYS_LIBRARY_NAME = "SystemUtils"; 
	
	static {
		System.loadLibrary(SYS_LIBRARY_NAME);
	}
		
	public static native int getThreadId();
	public static native int getProcessId();

}
