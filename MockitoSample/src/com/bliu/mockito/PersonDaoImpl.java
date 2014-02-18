/**
 * 
 */
package com.bliu.mockito;

/**
 * @author bliu
 * 
 */
public class PersonDaoImpl implements PersonDao {

	Person person;

	/**
	 * 
	 */
	public PersonDaoImpl() {
		person = new Person(95, "Tester");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bliu.mockito.PersonDao#fetchPerson(java.lang.Integer)
	 */
	@Override
	public Person fetchPerson(Integer personID) {
		return person;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bliu.mockito.PersonDao#update(com.bliu.mockito.Person)
	 */
	@Override
	public void update(Person person) {
		this.person = person;

	}

}
