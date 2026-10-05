package org.example;

import org.example.entity.Employee;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static LinkedList<Employee> employees = new LinkedList<>();

    public static List<Employee> findDuplicates(List<Employee> employees) {

        Map<Integer, Integer> counts = new HashMap<>();

        for (Employee employee : employees) {
            if (employee != null) {
                counts.put(
                        employee.getId(),
                        counts.getOrDefault(employee.getId(), 0) + 1
                );
            }
        }

        List<Employee> duplicates = new LinkedList<>();
        Set<Integer> addedIds = new HashSet<>();

        for (Employee employee : employees) {
            if (employee != null
                    && counts.get(employee.getId()) > 1
                    && !addedIds.contains(employee.getId())) {

                duplicates.add(employee);
                addedIds.add(employee.getId());
            }
        }

        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {

        Map<Integer, Employee> uniqueEmployees = new HashMap<>();

        for (Employee employee : employees) {
            if (employee != null) {
                uniqueEmployees.putIfAbsent(employee.getId(), employee);
            }
        }

        return uniqueEmployees;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {

        Map<Integer, Integer> counts = new HashMap<>();

        for (Employee employee : employees) {
            if (employee != null) {
                counts.put(
                        employee.getId(),
                        counts.getOrDefault(employee.getId(), 0) + 1
                );
            }
        }

        List<Employee> result = new LinkedList<>();

        for (Employee employee : employees) {
            if (employee != null && counts.get(employee.getId()) == 1) {
                result.add(employee);
            }
        }

        return result;
    }

    public static void main(String[] args) {
    }
}
