package catering.info;

import Model.EventInformation;
import junit.framework.TestCase;

public class EventTest extends TestCase {

	String eventID = "12345";
	String position = "Waiter";
	String customerName = "Department of State";
	String eventLocation = "Washington DC";
	String callIn = "5:30";
	String callOut = "11:00";
	String date = "Nov 13, 2015";
	double hoursWorked = 5.5;
	double extraPay = 20;
	EventInformation event;

	public void setUp() {
		event = new EventInformation(eventID, position, customerName,
				eventLocation, callIn, callOut, hoursWorked, date);
	}
	
	public void testNotNull() {
		assertNotNull(event);
	}
	
	public void testEventID() {
		assertEquals(event.getEventID(), eventID);
		event.setEventID("54321");
		assertEquals(event.getEventID(), "54321");
	}
	
	public void testCustomerLocation() {
		assertEquals(event.getCustomerName(), "Department of State");
		event.setCustomerName("Mall");
		assertEquals(event.getCustomerName(), "Mall");
		
		assertEquals(event.getEventLocation(), "Washington DC");
		event.setEventLocation("Mall");
		assertEquals(event.getEventLocation(), "Mall");
	}
	
	public void testCallInOut() {
		assertEquals(event.getCallIn(), "5:30");
		
		assertEquals(event.getCallOut(), "11:00");
	}
}
