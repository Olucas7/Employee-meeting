package com.ioet.model;

import com.ioet.Utilities.Utilities;
import java.util.List;

import java.util.TreeMap;

public class EmployeeOftenMeet implements Groupable{
    private List<Employee> employees;

    public EmployeeOftenMeet(List<Employee> employees) {
        this.employees = employees;
    }

    public EmployeeOftenMeet() {

    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean comeUpon(Employee employeeA, Employee employeeB, DayOfWeek day) {
        if(!employeeA.getShift().getWorkdays().contains(day) || !employeeB.getShift().getWorkdays().contains(day)){
            return false;
        }
        TreeMap<String,Integer> startHourEmployeeA = Utilities.hourMinToInterger(employeeA.getShift().getTimeDay(day).getStart());
        TreeMap<String,Integer> startHourEmployeeB = Utilities.hourMinToInterger(employeeB.getShift().getTimeDay(day).getStart());
        Employee employeeCameFirst = Utilities.whoCameFirts(employeeA,employeeB,day);
//        if(employeeCameFirst == null){
//            return true;
//        }
        assert employeeCameFirst != null;
        TreeMap<String,Integer> totalHourWorkedFirstEmployee = Utilities.hourMinToInterger(employeeCameFirst.getShift().hoursWorked(employeeCameFirst.getShift().getTimeDay(day)));
        TreeMap<String,Integer> subraction = Utilities.hourMinToInterger(Utilities.TimeSubtraction(startHourEmployeeA,startHourEmployeeB));
        return Utilities.isMenor(subraction, totalHourWorkedFirstEmployee);
        /*TEORIA:
        * Sea un dia cualquiera y dos empleados con horas de entrada y salida definidos,
        * Si la diferencia entre la hora de entrada del empleado segundo en llegar(valor mayor)
        * y la hora de entrada del empleado que llego primero(valor menor) es menor que el total
        * de horas trabajadas por el empleado primero en llegar, entonces ambos trabajadores se
        * encuentran.
        * */
    }

    @Override
    public void getTogether(Employee employee, List<Employee> employees) {
        for (DayOfWeek day : DayOfWeek.values()){
            for (Employee emp: employees){
                if(comeUpon(emp,employee,day)){
                    if(!employee.getPartners().containsKey(emp)){
                        employee.getPartners().put(emp,1);
                    }else{
                        int valTemp = employee.getPartners().get(emp);
                        employee.getPartners().replace(emp,valTemp+1);
                    }
                }

            }
        }



    }
}
