package org.traveloka.tcalendar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.traveloka.tcalendar.dao.CalendarDao;
import org.traveloka.tcalendar.entity.MeetingModel;
import org.traveloka.tcalendar.entity.MeetingRoom;

@RestController
@RequestMapping(value = "/meeting")
public class MeetingController {

	@Autowired
	private CalendarDao calendarDao;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<MeetingRoom> createMeeting(@RequestBody MeetingModel meetingModel) throws Exception {
		return new ResponseEntity<MeetingRoom>(calendarDao.createMeeting(meetingModel), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{meetingId}", method = RequestMethod.GET)
	public MeetingRoom getMeeting(@PathVariable Integer meetingId) throws Exception {
		return calendarDao.getMeeting(meetingId);
	}
	

	@RequestMapping(value = "/bytime", method = RequestMethod.GET)
	public List<MeetingRoom> getMeetingByTime(
			@RequestParam(value = "startDate", required = true) String startDate,
			@RequestParam(value = "endDate", required = true) String endDate) throws Exception {
		return calendarDao.getMeetingByTime(startDate, endDate);
	}
	

}
