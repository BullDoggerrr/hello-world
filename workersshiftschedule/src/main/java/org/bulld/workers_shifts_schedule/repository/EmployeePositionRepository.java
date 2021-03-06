package org.bulld.workers_shifts_schedule.repository;

import org.bulld.workers_shifts_schedule.model.EmployeePosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePositionRepository extends JpaRepository<EmployeePosition, Long> {
}
