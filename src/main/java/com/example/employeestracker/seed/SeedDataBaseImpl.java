package com.example.employeestracker.seed;

import com.example.employeestracker.entity.Employee;
import com.example.employeestracker.service.EmployeeService;
import com.example.employeestracker.util.DateFormatterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

@Component
public class SeedDataBaseImpl implements SeedDataBase {
    private final EmployeeService employeeService;
    private final static String COMMA_AND_SPACE_DELIMITER = ", ";
    private final static int INDEX_ZERO = 0;
    private final static int INDEX_ONE = 1;
    private final static int INDEX_TWO = 2;
    private final static int INDEX_THREE = 3;


    @Autowired
    public SeedDataBaseImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /* Reading a file via the console by name "fileName.txt" parsing the data for each row and saving the employee to DB*/
    @Override
    public void readFile(String name) throws IOException {
        Path filePath = Paths.get(name);
        Files.readAllLines(filePath).forEach(row -> {

            String[] data = row.split(COMMA_AND_SPACE_DELIMITER);

            int id = Integer.parseInt(data[INDEX_ZERO]);
            int project = Integer.parseInt(data[INDEX_ONE]);

            LocalDate dateFrom = DateFormatterUtil.parse(data[INDEX_TWO]);

            LocalDate dateTo = data[INDEX_THREE].equals("NULL")
                    ? LocalDate.now()
                    : DateFormatterUtil.parse(data[INDEX_THREE]);

            Employee employee = new Employee(id, project, dateFrom, dateTo);
            employeeService.save(employee);
        });
    }
}
