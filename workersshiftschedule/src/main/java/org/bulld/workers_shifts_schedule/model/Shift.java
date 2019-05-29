package org.bulld.workers_shifts_schedule.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@Entity
@Table(name = "shifts")
public class Shift {
    private long id;
    private Employee employee;
//    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private LocalDate date;

    public Shift(){

    }

    public Shift (Employee employee, LocalDate date){
        this.employee = employee;
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", nullable = false)
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee (Employee employee) {
        this.employee = employee;
    }

    @Column(name = "date")
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Shift [id=" + id +", employee=" + employee + ", date=" + date
                + "]";
    }
}
