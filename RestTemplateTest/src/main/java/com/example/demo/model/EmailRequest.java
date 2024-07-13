package com.example.demo.model;



public class EmailRequest {
	
	
    private int id;
	private String toAddress;
	private String eventId;
    private String emailSubject;
    private String emailBody;
    private String statusMessage;
    private String attachment;
    
    
    

	public EmailRequest(String toAddress, String emailSubject, String emailBody) {
		super();
		this.toAddress = toAddress;
		this.emailSubject = emailSubject;
		this.emailBody = emailBody;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}


	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}
	
	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Email [toAddress=" + toAddress + ", eventId=" + eventId + ", id=" + id + ", emailSubject="
				+ emailSubject + ", emailBody=" + emailBody + ", statusMessage=" + statusMessage + ", attachment="
				+ attachment + "]";
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public int getId() {
		return id;
	}

	public String getEmailBody() {
		return emailBody;
	}

	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}


	
    
   
    

	
	
}
