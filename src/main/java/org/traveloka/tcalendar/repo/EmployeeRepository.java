package org.traveloka.tcalendar.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.traveloka.tcalendar.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}