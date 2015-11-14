package Model;

public class EventInformation {

	private String eventID;
	private String position;
	private String customerName;
	private String date;
	private String eventLocation;
	private String callIn;
	private String callOut;
	private double hoursWorked;
	private double extraPay;

	public EventInformation(String eventID, String position, String customer,
			String location, String callin, String callout, double hoursWorked,
			String date) {

		this.eventID = eventID;
		this.position = position;
		this.customerName = customer;
		this.eventLocation = location;
		this.callIn = callin;
		this.callOut = callout;
		this.hoursWorked = hoursWorked;
		this.date = date;
	}
	
	public EventInformation() {
		this.eventID = "";
		this.position = "";
		this.customerName = "";
		this.eventLocation = "";
		this.callIn = "";
		this.callOut = "";
		this.hoursWorked = 0;
		this.date = "";
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	/*
	 * Getters and Setters for Fields
	 */
	public String getEventID() {
		return eventID;
	}

	public void setEventID(String eventID) {
		this.eventID = eventID;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public String getCallIn() {
		return callIn;
	}

	public void setCallIn(String callIn) {
		this.callIn = callIn;
	}

	public String getCallOut() {
		return callOut;
	}

	public void setCallOut(String callOut) {
		this.callOut = callOut;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(double d) {
		this.hoursWorked = d;
	}

	public double getExtraPay() {
		return extraPay;
	}

	public void setExtraPay(float extraPay) {
		this.extraPay = extraPay;
	}
	
	public void print() {
		System.out.println(this.getEventID() + " | " + this.getPosition() + " | " + this.getCustomerName() + " | "
				+ this.getCallIn() + " | " + this.getCallOut() + " | " + this.getHoursWorked() + " | "
				+ this.getEventLocation() + " | " + this.getDate());
	}
	/* ------------------------------------------------------------ */
}
