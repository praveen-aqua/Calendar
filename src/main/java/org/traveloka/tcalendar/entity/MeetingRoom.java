package org.traveloka.tcalendar.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "meeting")
public class MeetingRoom implements Serializable {

	private static final long serialVersionUID = -5528101764768305043L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer meetingId;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Employee> attendees;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date endTime;

	public MeetingRoom() {
		this.attendees = new LinkedList<Employee>();
	}

	public Integer getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(Integer meetingId) {
		this.meetingId = meetingId;
	}

	public List<Employee> getAttendees() {
		return attendees;
	}

	public void setAttendees(List<Employee> attendees) {
		this.attendees = attendees;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "MeetingRoom [meetingId=" + meetingId + ", attendees=" + attendees + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}

}
