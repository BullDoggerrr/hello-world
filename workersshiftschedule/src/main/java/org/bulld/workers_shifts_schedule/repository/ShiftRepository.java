package org.bulld.workers_shifts_schedule.repository;

import org.bulld.workers_shifts_schedule.model.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Long> {
    List<Shift> findAllByDate (LocalDate date);
}
