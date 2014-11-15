package com.believe.we.cpu.affinity;

public class Job {
	private int id;
	private int submitTime;
	private int CPUTime;
	private int CPUTimeLeft;
	
	private int startTime = 0;
	private int endTime = 0;
	/*	
	public int processCompletionTime;
	public int processArrivalTime;
	public int waitingTime;
	public int turnAroundTime; */
	
	private JobFinishEvent event;
	
/*	private int arrivalTime;
	private int cpuTime;     */ 
	private int processId;  
	
	public Job(int id, int processId, int submitTime, int cpuTime, JobFinishEvent event){
		
		this(processId, submitTime, cpuTime);
		
		this.id = id;
		this.event = event;
	}

	public Job(int processId, int submitTime, int cpuTime) {
		this.processId = processId;
		this.submitTime = submitTime;
		this.CPUTime = cpuTime;
		this.CPUTimeLeft = this.CPUTime;
	}
	
	public void start(int sysTime) {
		startTime = sysTime;
		System.out.println("Process " + processId + " started at " + startTime + "...");
	}
	
	public void tick(int systTime) {
		CPUTimeLeft--;
		
		if (CPUTimeLeft <= 0) {
			endTime = systTime;
			event.onFinish(this);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(int submitTime) {
		this.submitTime = submitTime;
	}

	public int getCPUTime() {
		return CPUTime;
	}

	public void setCPUTime(int cPUTime) {
		CPUTime = cPUTime;
	}

	public int getCPUTimeLeft() {
		return CPUTimeLeft;
	}

	public void setCPUTimeLeft(int cPUTimeLeft) {
		CPUTimeLeft = cPUTimeLeft;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	
	public int getEndTime() {
		return endTime;
	}
	
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	/*
	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getCpuTime() {
		return cpuTime;
	}

	public void setCpuTime(int cpuTime) {
		this.cpuTime = cpuTime;
	}
*/
	public int getProcessId() {
		return processId;
	}

	public void setProcessId(int processId) {
		this.processId = processId;
	}
	
	
}
