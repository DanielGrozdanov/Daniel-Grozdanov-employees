package com.example.employeestracker.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    private int id;

    @Column(nullable = false)
    private int projectId;

    @Column(name = "date_from", nullable = false)
    private LocalDate dateFrom;

    @Column(name = "date_to")
    private LocalDate dateTo;


    public Employee(int id, int projectId, LocalDate dateFrom, LocalDate dateTo) {
        this.setId(id);
        this.setProjectId(projectId);
        this.setDateFrom(dateFrom);
        this.setDateTo(dateTo);
    }

    public Employee() {

    }

    public int getProjectId() {
        return projectId;
    }

    private void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }


    public LocalDate getDateFrom() {
        return dateFrom;
    }

    private void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    private void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }
}
