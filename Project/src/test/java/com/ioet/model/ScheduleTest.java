package com.ioet.model;

import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ScheduleTest {

    private Employee employee;
    private ArrayList<DayOfWeek> daysOfWeekWorked = new ArrayList<>();
    private List<Schedule.TimeRange> timeRanges = new ArrayList<>();
    private Schedule shift = new Schedule(timeRanges);
    @Before
    public void setup() {
        daysOfWeekWorked.add(DayOfWeek.MONDAY);
        daysOfWeekWorked.add(DayOfWeek.TUESDAY);
        daysOfWeekWorked.add(DayOfWeek.FRIDAY);
        daysOfWeekWorked.add(DayOfWeek.SUNDAY);
        timeRanges.add(new Schedule.TimeRange(DayOfWeek.MONDAY, "12:00", "13:00"));
        timeRanges.add(new Schedule.TimeRange(DayOfWeek.TUESDAY, "12:00", "13:00"));
        timeRanges.add(new Schedule.TimeRange(DayOfWeek.FRIDAY, "12:00", "13:00"));
        timeRanges.add(new Schedule.TimeRange(DayOfWeek.SUNDAY, "12:00", "13:00"));
    }

    @Test
    public void total_hour_worked_two() {
        Schedule schedule = new Schedule();
        Schedule.TimeRange timeRange = new Schedule.TimeRange(DayOfWeek.MONDAY,"10:00","12:00");

        assertEquals("02:00", schedule.hoursWorked(timeRange));

    }

    @Test
    public void total_min_woked_five() {
        Schedule schedule = new Schedule();
        Schedule.TimeRange timeRange = new Schedule.TimeRange(DayOfWeek.MONDAY,"12:15","12:20");

        assertEquals("00:05", schedule.hoursWorked(timeRange));
    }

    @Test
    public void total_hour_min_worked() {
        Schedule schedule = new Schedule();
        Schedule.TimeRange timeRange = new Schedule.TimeRange(DayOfWeek.MONDAY,"7:23","17:07");

        assertEquals("09:44", schedule.hoursWorked(timeRange));
    }

    @Test
    public void total_time_worked() {
        Schedule schedule = new Schedule();
        Schedule.TimeRange timeRange = new Schedule.TimeRange(DayOfWeek.MONDAY,"7:23","18:07");

        assertEquals("10:44", schedule.hoursWorked(timeRange));
    }

    @Test
    public void days_of_work() {
        Employee employee = new Employee("Oscar");
        employee.setShift(shift);
        assertEquals(employee.getShift().getWorkdays(), daysOfWeekWorked);
    }
}