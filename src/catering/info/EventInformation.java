package catering.info;

public class EventInformation {

	private int eventID;
	private String position;
	private String customerName;
	private String eventLocation;
	private String callIn;
	private String callOut;
	private double hoursWorked;
	private double extraPay;

	public EventInformation(int eventID, String position, String customer,
			String location, String callin, String callout, double hoursWorked,
			double extra) {

		this.eventID = eventID;
		this.position = position;
		this.customerName = customer;
		this.eventLocation = location;
		this.callIn = callin;
		this.callOut = callout;
		this.hoursWorked = hoursWorked;
		this.extraPay = extra;
	}

	/*
	 * Getters and Setters for Fields
	 */
	public int getEventID() {
		return eventID;
	}

	public void setEventID(int eventID) {
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

	public void setHoursWorked(float hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public double getExtraPay() {
		return extraPay;
	}

	public void setExtraPay(float extraPay) {
		this.extraPay = extraPay;
	}
	/* ------------------------------------------------------------ */
}
