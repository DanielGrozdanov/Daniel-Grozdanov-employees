package com.example.employeestracker.service;

import com.example.employeestracker.dto.Pair;
import com.example.employeestracker.entity.Employee;
import com.example.employeestracker.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void save(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public List<Pair> getPairsOfEmployees() {
        List<Employee> employees = this.employeeRepository.findAll();
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < employees.size() - 1; i++) {
            for (int j = i + 1; j < employees.size(); j++) {

                Employee firstEmployee = employees.get(i);
                Employee secondEmployee = employees.get(j);

                /* Retrieving the employees form the db and comparing if they have the same projectId and if the Start/End date period overlap */
                if (firstEmployee.getProjectId() == secondEmployee.getProjectId() && checkStartAndEndDateOverlap(firstEmployee, secondEmployee)) {
                    /* As the "between" method is excluding the end date on the last day of work the result would return 433
                     * for Employee 1 with Id 5 - 2012-02-07 and Employee 2 with id 100 - 2013-04-15 */
                    int daysWorkingTogether = calculateDays(firstEmployee, secondEmployee); //+ 1;
                    Pair pair = new Pair(firstEmployee.getId(), secondEmployee.getId(), firstEmployee.getProjectId(), daysWorkingTogether);
                    pairs.add(pair);
                }
            }
        }
        return pairs;
    }

    /*Calculating the days the employees have worked together */
    private int calculateDays(Employee firstEmployee, Employee secondEmployee) {
        LocalDate startDate = firstEmployee.getDateFrom().isBefore(secondEmployee.getDateFrom())
                ? secondEmployee.getDateFrom()
                : firstEmployee.getDateFrom();

        LocalDate endDate = firstEmployee.getDateTo().isAfter(secondEmployee.getDateTo())
                ? secondEmployee.getDateTo()
                : firstEmployee.getDateTo();

        return (int) Math.abs(ChronoUnit.DAYS.between(startDate, endDate));
    }


    private boolean checkStartAndEndDateOverlap(Employee first, Employee second) {
        return first.getDateFrom().isEqual(second.getDateTo()) || first.getDateFrom().isBefore(second.getDateTo())
                && first.getDateTo().isAfter(second.getDateFrom()) || first.getDateTo().equals(second.getDateFrom());
    }
}
