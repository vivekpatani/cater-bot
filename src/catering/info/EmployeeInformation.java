package catering.info;

import java.util.ArrayList;
import java.util.List;

/*
 * EmployeeInformation
 * 
 * This is will contain the basic information that will be used in the report
 * In addition to the personal information, we will mix it with a list of
 * events with that this employee worked.
 */

public class EmployeeInformation {

	private String name;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String email;
	private String billingStart;
	private String billingEnd;
	private List<EventInformation> listOfEvents;

	public EmployeeInformation(String name, String address, String email,
			String billingStart, String billingEnd) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.billingStart = billingStart;
		this.billingEnd = billingEnd;
		this.city = "";
		this.state = "";
		this.zip = "";
		this.listOfEvents = new ArrayList<EventInformation>();
	}

	public EmployeeInformation(String name, String address, String city,
			String state, String zip, String email, String billingStart,
			String billingEnd) {
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.email = email;
		this.billingStart = billingStart;
		this.billingEnd = billingEnd;
		this.listOfEvents = new ArrayList<EventInformation>();
	}

	/*
	 * Getters and Setters for Fields
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBillingStart() {
		return billingStart;
	}

	public void setBillingStart(String billingStart) {
		this.billingStart = billingStart;
	}

	public String getBillingEnd() {
		return billingEnd;
	}

	public void setBillingEnd(String billingEnd) {
		this.billingEnd = billingEnd;
	}

	public List<EventInformation> getListOfEvents() {
		return listOfEvents;
	}

	public void setListOfEvents(List<EventInformation> listOfEvents) {
		this.listOfEvents = listOfEvents;
	}
	/* ------------------------------------------------------------ */
	
	public void add(EventInformation event) {
		this.listOfEvents.add(event);
	}

}
