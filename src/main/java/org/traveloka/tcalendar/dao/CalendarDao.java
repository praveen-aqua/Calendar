package org.traveloka.tcalendar.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.traveloka.tcalendar.entity.Employee;
import org.traveloka.tcalendar.entity.MeetingModel;
import org.traveloka.tcalendar.entity.MeetingRoom;
import org.traveloka.tcalendar.repo.EmployeeRepository;
import org.traveloka.tcalendar.repo.MeetingRepository;

@Component
public class CalendarDao {

	@Autowired
	private MeetingRepository meetingRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee getEmployee(Integer employeeId) {
		return employeeRepository.findById(employeeId).get();
	}

	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	@Transactional
	public MeetingRoom createMeeting(MeetingModel meetingModel) throws Exception {
		MeetingRoom m = new MeetingRoom();
		Date startTime = df.parse(meetingModel.getStartTime());
		Date endTime = df.parse(meetingModel.getEndTime());
		List<Employee> ll  = new ArrayList<Employee>();
		for (Integer empId : meetingModel.getAttendees()) {
			List<MeetingRoom> list = meetingRepository.findMeetingByAttendees(employeeRepository.findById(empId).get());
			for (MeetingRoom meetingRoom : list) {
				if ((startTime.getTime() >= meetingRoom.getStartTime().getTime()
						&& startTime.getTime() <= meetingRoom.getEndTime().getTime()) || (endTime.getTime() >= meetingRoom.getStartTime().getTime()
								&& endTime.getTime() <= meetingRoom.getEndTime().getTime())) {
					throw new Exception("Time Clash for " + meetingRoom);
				}
			}
			ll.add(employeeRepository.findById(empId).get());
		}
		m.setAttendees(ll);
		m.setStartTime(startTime);
		m.setEndTime(endTime);
		return meetingRepository.save(m);
	}

	public MeetingRoom getMeeting(Integer meetingId) {
		return meetingRepository.findById(meetingId).get();
	}

	public List<MeetingRoom> getEmployeeMeetings(Integer employeeId) {
		return meetingRepository.findMeetingByAttendees(employeeRepository.findById(employeeId).get());
	}

	public List<MeetingRoom> getMeetingByTime(String startDate1, String endDate1) throws Exception {
		Date startDate = df.parse(startDate1);
		Date endDate = df.parse(endDate1);
		return meetingRepository.findAllByStartTimeGreaterThanEqualAndEndTimeLessThanEqual(startDate, endDate);
	}
}
