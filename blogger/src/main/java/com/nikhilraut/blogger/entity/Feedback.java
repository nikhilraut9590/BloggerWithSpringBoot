package com.nikhilraut.blogger.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="feedback")
public class Feedback {
	@Id
	@GeneratedValue
	@Column(name="feedId")
	private int feedback_Id;
	@Column(name="name")
	private String feedbacker_name;
	@Column(name="email")
	private String feedbacker_emailId;
	@Column(name="message")
	private String feedbacker_message;
	public int getFeedback_Id() {
		return feedback_Id;
	}
	public void setFeedback_Id(int feedback_Id) {
		this.feedback_Id = feedback_Id;
	}
	public String getFeedbacker_name() {
		return feedbacker_name;
	}
	public void setFeedbacker_name(String feedbacker_name) {
		this.feedbacker_name = feedbacker_name;
	}
	public String getFeedbacker_emailId() {
		return feedbacker_emailId;
	}
	public void setFeedbacker_emailId(String feedbacker_emailId) {
		this.feedbacker_emailId = feedbacker_emailId;
	}
	public String getFeedbacker_message() {
		return feedbacker_message;
	}
	public void setFeedbacker_message(String feedbacker_message) {
		this.feedbacker_message = feedbacker_message;
	}
	
}
