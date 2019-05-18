package org.traveloka.tcalendar.entity;

import java.io.Serializable;
import java.util.List;

public class MeetingModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer meetingId;

	private List<Integer> attendees;

	private String startTime;
	private String endTime;

	public Integer getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(Integer meetingId) {
		this.meetingId = meetingId;
	}

	public List<Integer> getAttendees() {
		return attendees;
	}

	public void setAttendees(List<Integer> attendees) {
		this.attendees = attendees;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
