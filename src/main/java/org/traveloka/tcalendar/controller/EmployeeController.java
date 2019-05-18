package org.traveloka.tcalendar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.traveloka.tcalendar.dao.CalendarDao;
import org.traveloka.tcalendar.entity.Employee;
import org.traveloka.tcalendar.entity.MeetingRoom;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private CalendarDao calendarDao;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) throws Exception {
		return new ResponseEntity<Employee>(calendarDao.createEmployee(employee), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable Integer employeeId) throws Exception {
		return calendarDao.getEmployee(employeeId);
	}

	@RequestMapping(value = "/{employeeId}/meetings", method = RequestMethod.GET)
	public List<MeetingRoom> getMeetingByEmployee(@PathVariable Integer employeeId) throws Exception {
		return calendarDao.getEmployeeMeetings(employeeId);
	}

}
