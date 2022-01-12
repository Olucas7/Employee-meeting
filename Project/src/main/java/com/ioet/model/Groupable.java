package com.ioet.model;

import java.util.List;

public interface Groupable {

    boolean comeUpon(Employee employeeA, Employee employeeB, DayOfWeek day);

    void getTogether(Employee employee, List<Employee> employees);
}
