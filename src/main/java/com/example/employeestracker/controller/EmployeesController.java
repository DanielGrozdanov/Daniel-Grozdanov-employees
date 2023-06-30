package com.example.employeestracker.controller;

import com.example.employeestracker.dto.Pair;
import com.example.employeestracker.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmployeesController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String getPairsOfEmployees(Model model) {
        List<Pair> pairsOfEmployees = employeeService.getPairsOfEmployees();
        model.addAttribute("pairs", pairsOfEmployees);
        return "employees";
    }
}
