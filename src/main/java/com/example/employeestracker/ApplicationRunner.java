package com.example.employeestracker;

import com.example.employeestracker.service.EmployeeService;
import com.example.employeestracker.seed.SeedDataBase;
import com.example.employeestracker.util.PrintResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ApplicationRunner implements CommandLineRunner {

    private SeedDataBase seedDataBase;
    private EmployeeService employeeService;

    @Autowired
    public ApplicationRunner(SeedDataBase seedDataBase, EmployeeService employeeService) {
        this.seedDataBase = seedDataBase;
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Input a text file's name in order to get results");

        Scanner scanner = new Scanner(System.in);
        seedDataBase.readFile(scanner.nextLine());

        PrintResult.print(employeeService.getPairsOfEmployees());

    }
}
