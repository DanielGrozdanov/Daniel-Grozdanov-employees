package com.example.employeestracker.service;

import com.example.employeestracker.dto.Pair;
import com.example.employeestracker.entity.Employee;

import java.util.List;

public interface EmployeeService {

    void save(Employee employee);

    List<Pair> getPairsOfEmployees();
}
