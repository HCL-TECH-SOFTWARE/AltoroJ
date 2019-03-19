package com.ibm.security.appscan.altoromutual.model;

/*
 * Submitted feedback bean
 */
public class Feedback {
	
	public static final long FEEDBACK_ALL = -999;
	
	private long feedbackID = -1;
	private String name = null;
	private String email = null;
	private String subject = null;
	private String message = null;

	/*
	 * Initializes feedback bean with all of the feedback attributes
	 */
	public Feedback(long feedbackId, String name, String email, String subject, String message){
		this.feedbackID = feedbackId;
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
	}
	
	public long getFeedbackID() {
		return feedbackID;
	}

	public String getName() {
		return name;
	}

	public String getMessage() {
		return message;
	}

	public String getSubject() {
		return subject;
	}

	public String getEmail() {
		return email;
	}

}
