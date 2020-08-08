package com.diangezan.api.communication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CommunicationApiV1ApplicationTests {

	@Autowired
	private CommunicationsController communicationsController;

	@Test
	void contextLoads() {
		assertNotNull(communicationsController);
	}

}
