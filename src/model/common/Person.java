package model.common;

import java.io.Serializable;
/**
 * Class which create a person
 *  <p>
 * 	A person is characterized by :
 * <ul>
 * <li> A name
 * <li> A surname
 * </ul>
 * </p>
 */
public class Person implements Serializable{

	/**
	 * Name of the person 
	 * <p>
	 * @see Person(String firstName, String lastName)
	 * @see getName()
	 * @see setName(String name)
	 */
	protected String namePerson;

	/**
	 * Surname of the person 
	 * <p>
	 * @see Person(String firstName, String lastName)
	 * @see getSurname()
	 * @see setSurname(String surname)
	 */
	protected String surnamePerson;

	/**
	 * Constructor of the class person
	 */
	public Person() 
	{
		setName(null);
		setSurname(null);
	}

	/**
	 * Copy Constructor of the class person
	 * <p>
	 * @param person
	 */
	public Person(Person person) {
		setName(person.getName());
		setSurname(person.getSurname());
	}

	/**
	 * Constructor of the class person
	 * <p>
	 * @param firstName
	 * @param lastName
	 */
	public Person(String firstName, String lastName) 
	{
		setName(firstName);
		setSurname(lastName);
	}

	/**
	 * Getter of the person name
	 * <p>
	 * @return namePerson
	 */
	public String getName() {
		return namePerson;
	}

	/**
	 * Setter of the person name
	 * <p>
	 * @param name
	 */
	public void setName(String name) {
		namePerson = name;
	}

	/**
	 * Getter of the person surname
	 * <p>
	 * @return surnamePerson
	 */
	public String getSurname() {
		return surnamePerson;
	}

	/**
	 * Setter of the person surname
	 * <p>
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
