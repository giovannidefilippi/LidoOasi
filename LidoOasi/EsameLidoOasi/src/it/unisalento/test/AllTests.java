package it.unisalento.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AffittoDaoTest.class, ClienteTest.class,
		SistemaBusinessTest.class, TestDBConnection.class })
public class AllTests {

}
