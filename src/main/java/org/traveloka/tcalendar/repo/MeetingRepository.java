package org.traveloka.tcalendar.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.traveloka.tcalendar.entity.Employee;
import org.traveloka.tcalendar.entity.MeetingRoom;

@Repository
public interface MeetingRepository extends CrudRepository<MeetingRoom, Integer> {

	public List<MeetingRoom> findMeetingByAttendees(Employee employee);
	

	@Query(value = "from MeetingRoom t where t.startTime >= :startTime AND t.endTime <= :endTime")
	public List<MeetingRoom> findAllByStartTimeGreaterThanEqualAndEndTimeLessThanEqual(
			@Param("startTime") Date startTime, @Param("endTime") Date endTime);

}