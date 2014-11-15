package com.believe.we.cpu.affinity;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class TestDriver {

    public static JobFinishEvent callback = new JobFinishEvent() {			
		@Override
		public void onFinish(Job job) {
			// TODO Auto-generated method stub
			System.out.println("Job " + job.getProcessId() + " is finished at " + job.getEndTime() + " !");
			System.out.println("~~~~ Context Switching ~~~~ ");
		}
	};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int processors = Runtime.getRuntime().availableProcessors();
		System.out.println("Available Processors: " + processors);
		long maxCoreBits = 1L << (processors - 1);
		System.out.println("Max Core Bits: " + maxCoreBits);
		System.out.println("=====================================");
		
		Scanner sc  = new Scanner(System.in);
		
		String filename = "/home/yinr/workspace/Test/src/com/believe/we/cpu/affinity/testing.txt";
		String allocationStrategy = "RR";
		int quantum = 10;

		
        BufferedReader br = null;
        
        try {
        	String sCurrentLine;
        	br = new BufferedReader(new FileReader(filename));
        	
        	List<Job> jobList = new ArrayList<Job>();
        	int id = 0;
        	while ((sCurrentLine = br.readLine())!=null) {
        		String a[] = sCurrentLine.split(",");
        		int processId = new Integer(a[0]);
        		int arrivalTime = new Integer(a[1]);
        		int cpuTime = new Integer(a[2]);
        		
        		Job job = new Job(id++,processId, arrivalTime, cpuTime,callback);
        		jobList.add(job);
        	}
        	
        	
        	if ("RR".equalsIgnoreCase(allocationStrategy)) {
        		
        		// sort according to process arrival time ...
        		Collections.sort(jobList, new Comparator<Job>(){
        			public int compare(Job o1, Job o2) {
        				return ( o1.getSubmitTime() - o2.getSubmitTime() );
        			}
        		});
        		
        		RoundRobin roundRobin = new RoundRobin();
        		roundRobin.run(jobList, quantum);
        	}
        	
        } catch (IOException e) {
        	e.printStackTrace();
        } finally {
        	try {
        		if (br != null)
        			br.close();
        	} catch (IOException ex) {
        		ex.printStackTrace();
        	}
        }
        

	}

}
