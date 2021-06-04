package model.common;

import java.time.LocalTime;
import java.io.*;

/**
 * Class planning which manage the planning of employee
 *  <p>
 * 	A planning is characterized by :
 * <ul>
 * <li> A day
 * <li> A start hour
 * <li> An end hour
 * <li> A type of task 
 * </ul>
 * </p>
 */

public class Planning implements Serializable{

	/**
	 * Day in the planning
	 * <p>
	 * @see Planning(String day_planning, LocalTime start_Hour, LocalTime end_Hour, String task_Type)
	 * @see getDayPlanning()
	 * @see setDayPlanning(String day_planning)
	 */
	private String dayPlanning;

	/**
	 * Hour when an employee start to work
	 * <p>
	 * @see Planning(String day_planning, LocalTime start_Hour, LocalTime end_Hour, String task_Type)
	 * @see getStartHour()
	 * @see setStartHour(LocalTime start_Hour)
	 */
	private LocalTime startHour;
	
	/**
	 * Hour when an employee stop working
	 * <p>
	 * @see Planning(String day_planning, LocalTime start_Hour, LocalTime end_Hour, String task_Type)
	 * @see getEndhour()
	 * @see setEndHour(LocalTime end_Hour)
	 */
	private LocalTime endHour;

	/**
	 * Task that the employee did everyday
	 * <p>
	 * @see Planning(String day_planning, LocalTime start_Hour, LocalTime end_Hour, String task_Type)
	 * @see getTaskType()
	 * @see setTaskType(String task_Type)
	 */
	private String taskType;

	/**
	 * Constructor of the class planning
	 * <p>
	 * @param day_planning
	 * @param start_Hour
	 * @param end_Hour
	 * @param task_Type
	 */
	public Planning(String day_planning, LocalTime start_Hour, LocalTime end_Hour, String task_Type) {
		super();
		dayPlanning = day_planning;
		startHour = start_Hour;
		endHour = end_Hour;
		taskType = task_Type;
	}

	/**
	 * Getter of dayPlanning
	 * <p>
	 * @return dayPlanning
	 */
	public String getDayPlanning() {
		return dayPlanning;
	}

	/**
	 * Setter of dayPlanning
	 * <p>
	 * @param day_planning
	 */
	public void setDayPlanning(String day_planning) {
		dayPlanning = day_planning;
	}

	/**
	 * Getter of startHour
	 * <p>
	 * @return startHour
	 */
	public LocalTime getStartHour() {
		return startHour;
	}

	/**
	 * Setter of startHour
	 * <p>
	 * @param start_Hour
	 */
	public void setStartHour(LocalTime start_Hour) {
		startHour = start_Hour;
	}

	/**
	 * Getter of endHour
	 * <p>
	 * @return endHour
	 */
	public LocalTime getEndhour() {
		return endHour;
	}

	/**
	 * Setter of endHour
	 * <p>
	 * @param end_Hour
	 */
	public void setEndHour(LocalTime end_Hour) {
		endHour = end_Hour;
	}
	
	/**
	 * Getter of taskType
	 * <p>
	 * @return taskType
	 */
	public String getTaskType() {
		return taskType;
	}

	/**
	 * Setter of taskType
	 * <p>
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
