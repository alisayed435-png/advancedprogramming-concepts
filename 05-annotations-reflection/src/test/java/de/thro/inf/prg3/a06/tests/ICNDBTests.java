package de.thro.inf.prg3.a06.tests;

import de.thro.inf.prg3.a06.model.Joke;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Peter Kurfer
 * Created on 11/10/17.
 */
class ICNDBTests {

	private static final Logger logger = LogManager.getLogger(ICNDBTests.class);
	private static final int REQUEST_COUNT = 10;

	@Test
	void testGetRandomJoke() throws IOException {
	}

	@Test
	void testGetJokeByQuery() throws IOException {
	}

}
