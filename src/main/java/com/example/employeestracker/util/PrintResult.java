package com.example.employeestracker.util;

import com.example.employeestracker.dto.Pair;

import java.util.List;

public class PrintResult {
    public static void print(List<Pair> pairList) {
        for (Pair pair : pairList) {
            System.out.println(pair.getFirstEmployeeId() + ", " + pair.getSecondEmployeeId());
        }
    }
}
