package com.believe.we.cpu.affinity;

import java.util.ArrayList;
import java.util.List;


/*
 * can implement this class for all CPU scheduling strategies
 */

public abstract class AllocationStrategy {
	protected List<Job> jobList;
	protected ArrayList<Job> jobQueue;
	
	public AllocationStrategy(List<Job> jobs) {
		super();
		jobList = jobs;
	}	
	
	/*
	 *  update current job by 1 tick
     *  check if the job queue might need to be changed
     *  check for jobs to add to the queue
	 */
	public abstract void run();	
	
}
