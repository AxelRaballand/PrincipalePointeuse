package model.common;

import java.time.LocalDate;
import java.time.LocalTime;
import java.io.*;

public class Planning implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5034352691535752885L;

	private static int counter=0;
	
	private int idPlanning;

	private String dayPlanning;

	private LocalTime startHour;
	
	private LocalTime endHour;
	
	private LocalDate today;

	private String taskType;

	/**
	 * Constructor
	 * @param day_planning
	 * @param start_Hour
	 * @param end_Hour
	 * @param task_Type
	 */
	public Planning(String day_planning, LocalTime start_Hour, LocalTime end_Hour, String task_Type,LocalDate day) {
		super();
		idPlanning = counter++;
		dayPlanning = day_planning;
		startHour = start_Hour;
		endHour = end_Hour;
		taskType = task_Type;
		this.today = day;
	}

	/**
	 * 
	 * @return idPlanning
	 */
	public int getIdPlanning() {
		return idPlanning;
	}
	
	/**
	 * 
	 * @return dayPlanning
	 */
	public String getDay_planning() {
		return dayPlanning;
	}

	/**
	 * 
	 * @param day_planning
	 */
	public void setDay_planning(String day_planning) {
		dayPlanning = day_planning;
	}

	/**
	 * 
	 * @return startHour
	 */
	public LocalTime getStartTime() {
		return startHour;
	}

	/**
	 * 
	 * @param start_Hour
	 */
	public void setStartTime(LocalTime start_Hour) {
		startHour = start_Hour;
	}

	/**
	 * 
	 * @return endHour
	 */
	public LocalTime getEndTime() {
		return endHour;
	}

	/**
	 * 
	 * @param end_Hour
	 */
	public void setEndTime(LocalTime end_Hour) {
		endHour = end_Hour;
	}
	
	/**
	 * 
	 * @param today
	 */
	public LocalDate getToday() {
		return today;
	}
	
	/**
	 * 
	 * @param today
	 */
	public void setToday() {
		this.today = LocalDate.now();
	}

	/**
	 * 
	 * @return taskType
	 */

	public String getTaskType() {
		return taskType;
	}

	/**
	 * 
	 * @param task_Type
	 */
	public void setTaskType(String task_Type) {
		taskType = task_Type;
	}

	@Override
	public String toString() {
		return "Planning [day_Planning=" + dayPlanning + ", start_Hour=" + startHour + ", end_Hour=" + endHour
				+ ", task_Type=" + taskType + "]";
	}
}
