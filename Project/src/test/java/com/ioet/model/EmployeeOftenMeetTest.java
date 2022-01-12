package com.ioet.model;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class EmployeeOftenMeetTest {
    EmployeeOftenMeet employeeOftenMeet = new EmployeeOftenMeet();
    Employee employeeA = new Employee("Oscar");
    Employee employeeB = new Employee("Salma");
    Employee employeeC = new Employee("Joby");
    Employee employeeD = new Employee("Josue");
    Employee employeeE = new Employee("Hatus");
    private List<Schedule.TimeRange> timeRangesA = new ArrayList<>();
    private Schedule shiftA = new Schedule(timeRangesA);
    private List<Schedule.TimeRange> timeRangesB = new ArrayList<>();
    private Schedule shiftB = new Schedule(timeRangesB);
    private List<Schedule.TimeRange> timeRangesC = new ArrayList<>();
    private Schedule shiftC = new Schedule(timeRangesC);
    private List<Schedule.TimeRange> timeRangesD = new ArrayList<>();
    private Schedule shiftD = new Schedule(timeRangesD);
    private List<Schedule.TimeRange> timeRangesE = new ArrayList<>();
    private Schedule shiftE = new Schedule(timeRangesE);

    @Before
    public void setup() {
        //EmployeeA
        timeRangesA.add(new Schedule.TimeRange(DayOfWeek.MONDAY, "10:15", "12:00"));
        timeRangesA.add(new Schedule.TimeRange(DayOfWeek.TUESDAY, "10:00", "12:00"));
        timeRangesA.add(new Schedule.TimeRange(DayOfWeek.THRURSDAY, "13:00", "13:15"));
        timeRangesA.add(new Schedule.TimeRange(DayOfWeek.SATURDAY, "14:00", "18:00"));
        timeRangesA.add(new Schedule.TimeRange(DayOfWeek.SUNDAY, "20:00", "21:00"));
        employeeA.setShift(shiftA);
        //EmployeeB
        timeRangesB.add(new Schedule.TimeRange(DayOfWeek.MONDAY, "10:00", "12:00"));
//        timeRangesB.add(new Schedule.TimeRange(DayOfWeek.TUESDAY, "12:00", "13:00"));
        timeRangesB.add(new Schedule.TimeRange(DayOfWeek.THRURSDAY, "12:00", "14:00"));
//        timeRangesB.add(new Schedule.TimeRange(DayOfWeek.FRIDAY, "10:00", "13:14"));
//        timeRangesB.add(new Schedule.TimeRange(DayOfWeek.SATURDAY, "12:00", "13:00"));
        timeRangesB.add(new Schedule.TimeRange(DayOfWeek.SUNDAY, "20:00", "21:00"));
        employeeB.setShift(shiftB);
        //EmployeeC
        timeRangesC.add(new Schedule.TimeRange(DayOfWeek.MONDAY, "06:00", "10:14"));
        timeRangesC.add(new Schedule.TimeRange(DayOfWeek.TUESDAY, "10:00", "12:00"));
        employeeC.setShift(shiftC);
        //EmployeeD
        timeRangesD.add(new Schedule.TimeRange(DayOfWeek.THRURSDAY, "15:30", "20:15"));
        timeRangesD.add(new Schedule.TimeRange(DayOfWeek.SATURDAY, "10:30", "14:18"));
        timeRangesD.add(new Schedule.TimeRange(DayOfWeek.SUNDAY, "09:34", "16:00"));
        employeeD.setShift(shiftD);
        //EmployeeE
        timeRangesE.add(new Schedule.TimeRange(DayOfWeek.MONDAY, "08:15", "11:23"));
        timeRangesE.add(new Schedule.TimeRange(DayOfWeek.TUESDAY, "12:00", "12:45"));
        timeRangesE.add(new Schedule.TimeRange(DayOfWeek.THRURSDAY, "14:22", "14:55"));
        timeRangesE.add(new Schedule.TimeRange(DayOfWeek.SATURDAY, "17:00", "18:59"));
        timeRangesE.add(new Schedule.TimeRange(DayOfWeek.SUNDAY, "18:00", "21:00"));
        employeeE.setShift(shiftE);

        //employee get together method
        ArrayList<Employee> allEmployees = new ArrayList<>();
//        allEmployees.add(employeeA);
        allEmployees.add(employeeB);
        allEmployees.add(employeeC);
        allEmployees.add(employeeD);
        allEmployees.add(employeeE);
        employeeOftenMeet.getTogether(employeeA, allEmployees);
    }
    @Test
    public void two_wokers_meet_at_monday() {
        assertFalse(employeeOftenMeet.comeUpon(employeeA,employeeC,DayOfWeek.MONDAY));
    }

    @Test
    public void two_wokers_meet_at_tuesday() {
        assertFalse(employeeOftenMeet.comeUpon(employeeA,employeeB,DayOfWeek.TUESDAY));
    }

    @Test
    public void two_wokers_meet_at_wednesday() {
        assertFalse(employeeOftenMeet.comeUpon(employeeA,employeeB,DayOfWeek.WEDNESDAY));
    }

    @Test
    public void two_wokers_meet_at_thursday() {
        assertTrue(employeeOftenMeet.comeUpon(employeeA,employeeB,DayOfWeek.THRURSDAY));
    }

    @Test
    public void two_wokers_meet_at_friday() {
        assertFalse(employeeOftenMeet.comeUpon(employeeA,employeeB,DayOfWeek.FRIDAY));
    }

    @Test
    public void two_wokers_meet_at_saturday() {
        assertFalse(employeeOftenMeet.comeUpon(employeeA,employeeB,DayOfWeek.SATURDAY));
    }

    @Test
    public void two_wokers_meet_at_sunday() {
        assertTrue(employeeOftenMeet.comeUpon(employeeA,employeeB,DayOfWeek.SUNDAY));
    }

    @Test
    public void true_if_list_partners_employeeA_was_fill_correct() {
        Map<Employee, Integer> partnersA = new LinkedHashMap<Employee,Integer>();

        partnersA.put(employeeB,3);
        partnersA.put(employeeE,3);
        partnersA.put(employeeC,1);
        partnersA.put(employeeD,1);
        assertEquals(partnersA.get(employeeB),employeeA.getPartners().get(employeeB));
        assertEquals(partnersA.get(employeeE),employeeA.getPartners().get(employeeE));
        assertEquals(partnersA.get(employeeC),employeeA.getPartners().get(employeeC));
        assertEquals(partnersA.get(employeeD),employeeA.getPartners().get(employeeD));
    }
}