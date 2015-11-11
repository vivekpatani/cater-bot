package catering.info;

import Model.EmployeeInformation;
import junit.framework.TestCase;

public class EmployeeTest extends TestCase {
	String name = "Andres Rivero";
	String address = "5475 Sheffield Ct";
	String city = "Alexandria";
	String state = "VA";
	String zip = "22311";
	String email = "drusc0@hotmail.com";
	String billingStart = "11/16/2015";
	String billingEnd = "12/15/2015";
	EmployeeInformation emp1;
	EmployeeInformation emp2;

	public void setUp() {
		emp1 = new EmployeeInformation(name, address, email, billingStart,
				billingEnd);
		emp2 = new EmployeeInformation(name, address, city, state, zip, email,
				billingStart, billingEnd);
	}

	public void testEmployeeNotNull() {
		assertNotNull(emp1);
		assertNotNull(emp2);
	}

	public void testNameValid() {
		assertTrue(emp1.getName().equals(emp2.getName()));
		emp1.setName("Richard Perez");
		assertTrue(!emp1.getName().equals(emp2.getName()));
	}

	public void testAddressValid() {
		assertTrue(emp1.getAddress().equals(emp2.getAddress()));
		emp1.setAddress("506 S Muller Pkwy");
		assertTrue(!emp1.getAddress().equals(emp2.getAddress()));
	}

	public void testCityStateZipValid() {
		assertNotNull( emp1.getCity().isEmpty() );
		assertTrue( !emp2.getCity().isEmpty() );

		assertTrue( emp1.getState().isEmpty() );
		assertTrue(!emp2.getState().isEmpty());

		assertTrue(emp1.getZip().isEmpty());
		assertTrue(!emp2.getZip().isEmpty());
	}

	public void testEmailValid() {
		assertTrue(emp1.getEmail().equals(emp2.getEmail()));
		emp1.setEmail("arivero@hotmail.com");
		assertTrue(!emp1.getEmail().equals(emp2.getEmail()));
	}
	
}
