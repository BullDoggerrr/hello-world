package org.bulld.workers_shifts_schedule.repository;

import org.bulld.workers_shifts_schedule.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
