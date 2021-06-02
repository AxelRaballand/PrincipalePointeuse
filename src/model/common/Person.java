package model.common;

import java.io.Serializable;

public class Person implements Serializable{

	protected String namePerson;

	protected String surnamePerson;

	/**
	 * Constructor
	 */
	public Person() 
	{
		setName(null);
		setSurname(null);
	}

	/**
	 * Constructor
	 * @param person
	 */
	public Person(Person person) {
		setName(person.getName());
		setSurname(person.getSurname());
	}

	/**
	 * Constructor
	 * @param firstName
	 * @param lastName
	 */
	public Person(String firstName, String lastName) 
	{
		setName(firstName);
		setSurname(lastName);
	}

	/**
	 * 
	 * @return namePerson
	 */
	public String getName() {
		return namePerson;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		namePerson = name;
	}

	/**
	 * 
	 * @return surnamePerson
	 */
	public String getSurname() {
		return surnamePerson;
	}

	/**
	 * 
	 * @param surname
	 */
	public void setSurname(String surname) {
		surnamePerson = surname;
	}
	
	/**
	 * @return msg
	 */
	public String toString()
	{
		String msg = getName() + " " + getSurname() + " ";
		return msg;
	}

}
