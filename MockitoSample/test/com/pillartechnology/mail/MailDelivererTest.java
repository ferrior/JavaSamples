package com.pillartechnology.mail;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class MailDelivererTest {

	@InjectMocks
	private MailDeliverer subject = new MailDeliverer();
	@Mock
	private ExternalMailSystem externalMailSystem;
	@Captor
	private ArgumentCaptor<Email> emailCaptor;

	@Before
	public void injectDoubles() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void sendsEmailByConstructingEmailObject() {
		String expectedUser = "tim";
		String expectedDomain = "wingfield.com";
		String expectedBody = "Hi Tim!";
		subject.deliver(expectedUser + "@" + expectedDomain, expectedBody);
		verify(externalMailSystem).send(emailCaptor.capture());
		Email email = emailCaptor.getValue();

		assertEquals(email.getUser(), expectedUser);
//		assertThat(email.getUser(), is(expectedUser));
//		assertThat(email.getDomain(), is(expectedDomain));
//		assertThat(email.getBody(), is(expectedBody));
	}

	@Test
	// "WIP - We're converting to the service method that sends an Email object"
	public void sendsEmailBySplittingAddress() {
		String expectedBody = "Hi Tim!";
		subject.deliver("tim@wingfield.com", expectedBody);
		verify(externalMailSystem).send("wingfield.com", "tim", expectedBody);
	}
}