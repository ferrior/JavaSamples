package com.bliu.mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersonDaoImplTest {

	private PersonDao dao= null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dao = new PersonDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
//	public void testAnyStr() {
//		Person person = mock(Person.class);
//		dao.update(person);
//		when(person.getPersonName(anyString())).thenReturn("aaa");
//		Person p = dao.fetchPerson(10);
//		String a= p.getPersonName("b");
//		assertEquals(a,"aaa");
//	}
	
	@Test
	public void testAnyObj() {
		Person person = mock(Person.class);
		dao.update(person);
		when(person.getPersonName((Person)anyObject(), anyInt(), (PersonType)anyObject())).thenReturn("aaa");
		Person p = dao.fetchPerson(10);
		String a= p.getPersonName(new Person(30,"bbb"), 10, PersonType.Big);
		assertEquals(a,"aaa");
	}

	@Test
	public void testAnyInt() {
		Person person = mock(Person.class);
		dao.update(person);
		when(person.getPersonID(anyInt())).thenReturn(10);
		Person p = dao.fetchPerson(10);
		int a= p.getPersonID(5);
		assertEquals(a,10);
	}

}
