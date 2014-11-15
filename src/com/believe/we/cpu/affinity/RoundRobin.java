package com.believe.we.cpu.affinity;

import java.util.List;

public class RoundRobin {
	private int[] turnAroundTimeCurrPass;
	private int   overallTurnaroundTime;
	private int   timePassed;
	private int   timeSlice;
	private int[] cpuTimeLeft;
	private int   btCache = 0;
	
	
	public void start2(List<Job> jobList) {
		for (int i=0;i < cpuTimeLeft.length; i++) {
			int cpuTime = cpuTimeLeft[i];
			if (cpuTime > 0) {
				
				if (cpuTime <= timeSlice) {
					turnAroundTimeCurrPass[i] = btCache + cpuTime;
					btCache = turnAroundTimeCurrPass[i];
					timePassed += cpuTime;
					cpuTime -= cpuTime;
				} else {
					turnAroundTimeCurrPass[i] = btCache + timeSlice;
					btCache = turnAroundTimeCurrPass[i];
					timePassed += timeSlice;
					cpuTime -= timeSlice;
				}
				
				cpuTimeLeft[i] = cpuTime;
				
			} 
		}
		
		if (timePassed < overallTurnaroundTime)
			start2(jobList);
	}
	
	public void start(List<Job> jobList) {
		
		for (int i=0; i< cpuTimeLeft.length; i++) 
		{			
			int cpuTime = cpuTimeLeft[i];
			if (cpuTime > 0) 
			{
				Job job = jobList.get(i);
				job.start(timePassed);
				if (cpuTime <= timeSlice)
				{
					turnAroundTimeCurrPass[i] += cpuTime;
					timePassed += cpuTime;
					cpuTimeLeft[i] -= cpuTime;
				} 
				else 
				{
					turnAroundTimeCurrPass[i] += timeSlice;
					timePassed += timeSlice;
					cpuTimeLeft[i] -= timeSlice;
				}
				int ticks = timePassed - job.getStartTime();
				while (ticks-- > 0) {
					job.tick(timePassed);
				}
				
			}
		}
		
		if (timePassed < overallTurnaroundTime)
			start(jobList);
	}

	/*
	 * jobList already sorted according to arrival time
	 */
	public void run(List<Job> jobList, int quantum) {
		
		int p_count = jobList.size();
		cpuTimeLeft = new int[p_count];		
		turnAroundTimeCurrPass = new int[p_count];
		
		overallTurnaroundTime = jobList.get(0).getSubmitTime();
		timePassed = jobList.get(0).getSubmitTime();	
		
		int count = 0;
		for (Job job : jobList) {
			cpuTimeLeft[count] = job.getCPUTime();
			overallTurnaroundTime += job.getCPUTime();
			count++;
		}	
		
		timeSlice = quantum;
		
		start(jobList);
		//display(jobList);		
	}
	
	
	private void display(List<Job> jobList) {
		float avgTurnArroundTime = 0;
		float avgWaitingTime = 0;
	
		System.out.println("============================================ ");
		System.out.println("Process ID | Turnaround time | Waiting time ");
		System.out.println("============================================ ");
		
		Object[] jobs = jobList.toArray();	
		for (int i=0; i<turnAroundTimeCurrPass.length; i++) {
			Job job = jobList.get(i);
			System.out.println( "  " + job.getProcessId() + "     |       " + turnAroundTimeCurrPass[i] +
							"        |     " + (turnAroundTimeCurrPass[i]-job.getCPUTime()));
			System.out.println("----------------------------------------");
			
			avgTurnArroundTime += turnAroundTimeCurrPass[i];
			avgWaitingTime += (turnAroundTimeCurrPass[i] - job.getCPUTime());			
		}
		
		System.out.println("===============================================");
		System.out.println( "Avg waiting time = " + avgWaitingTime/turnAroundTimeCurrPass.length);
		System.out.println("===============================================");
		System.out.println( "Avg turn round time = " + avgTurnArroundTime/turnAroundTimeCurrPass.length);
		System.out.println("===============================================");
	}

}
