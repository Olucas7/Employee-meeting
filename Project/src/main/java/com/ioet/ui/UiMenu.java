package com.ioet.ui;

import com.ioet.Utilities.FileManager;
import com.ioet.Utilities.Utilities;
import com.ioet.model.DayOfWeek;
import com.ioet.model.Employee;
import com.ioet.model.EmployeeOftenMeet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UiMenu {

    public static void showMenu(){
        EmployeeOftenMeet employeeOftenMeet = new EmployeeOftenMeet();
        System.out.println("Hola desde la UI");
        List<Employee> employees = FileManager.createListOfEmployees("./src/main/resources/employees.txt");
        System.out.println("===============================");
        System.out.println("Active Employees");
        int i = 1;
        for (Employee employee : employees){
            List<Employee> tempList = new ArrayList<>(employees) ;
            tempList.remove(employee);

            employeeOftenMeet.getTogether(employee,tempList);
            System.out.println("===============================");
            for (Employee partner : employee.getPartners().keySet()){
                System.out.println(employee.getName()+"-"+partner.getName()+": "+ employee.getPartners().get(partner));
            }
        }
    }
}
