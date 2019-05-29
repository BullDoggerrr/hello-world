package org.bulld.workers_shifts_schedule.model;

import javax.persistence.*;

@Entity
@Table(name = "employee_positions")
public class EmployeePosition {
    private long id;
    private String name;

    public EmployeePosition(){

    }

    public EmployeePosition(String name){
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

//    @OneToMany(mappedBy = "id")
//    private List<Employee> employees;

    @Override
    public String toString() {
        return "Employee position [id=" + id +", name=" + name
                + "]";
    }
}
