package com.ioet.Utilities;

import com.ioet.model.DayOfWeek;
import com.ioet.model.Employee;
import com.ioet.model.Schedule;

import java.util.TreeMap;

public class Utilities {

    public static TreeMap<String,Integer> timeRangeToInteger(Schedule.TimeRange timeRange){
        String[] partsStart = timeRange.getStart().split(":");
        TreeMap<String,Integer> timeValues = new TreeMap<>();
        timeValues.put("hourStart", Integer.parseInt(partsStart[0]));
        timeValues.put("minStart", Integer.parseInt(partsStart[1]));
        String[] partsEnd = timeRange.getEnd().split(":");
        timeValues.put("hourEnd",Integer.parseInt(partsEnd[0]));
        timeValues.put("minEnd", Integer.parseInt(partsEnd[1]));
        return timeValues;
    }

    public static TreeMap<String,Integer> hourMinToInterger(String time){
        String[] hourAndMin = time.split(":");
        TreeMap<String,Integer> hourMin = new TreeMap<>();
        hourMin.put("hour", Integer.parseInt(hourAndMin[0]));
        hourMin.put("minute", Integer.parseInt(hourAndMin[1]));
        return hourMin;
    }

    public static Employee whoCameFirts(Employee employeeA, Employee employeeB, DayOfWeek day) {
        TreeMap<String, Integer> timeEmployeeA = timeRangeToInteger(employeeA.getShift().getTimeDay(day));
        TreeMap<String, Integer> timeEmployeeB = timeRangeToInteger(employeeB.getShift().getTimeDay(day));
        if (timeEmployeeA.get("hourStart") > timeEmployeeB.get("hourStart")) {
            return employeeB;
        }
        if (timeEmployeeA.get("hourStart") < timeEmployeeB.get("hourStart")) {
            return employeeA;
        }

        if (timeEmployeeA.get("hourStart") == timeEmployeeB.get("hourStart")) {
            if (timeEmployeeA.get("minStart") > timeEmployeeB.get("minStart")) {
                return employeeB;
            } else {
                return employeeA;
            }
        }


        return null;
        }

    public static String TimeSubtraction(TreeMap<String, Integer> startHourEmployeeA, TreeMap<String, Integer> startHourEmployeeB) {
        int totalHour;
        int totalMin;
        int hourA = startHourEmployeeA.get("hour");
        int minA = startHourEmployeeA.get("minute");
        int hourB = startHourEmployeeB.get("hour");
        int minB = startHourEmployeeB.get("minute");
        if(hourA > hourB){ //B llego primero //A es mayor
            if(minA < minB){
                minA += 60;
                hourA -= 1;
            }
            totalHour = hourA - hourB;
            totalMin = minA - minB;
            return totalHour+":"+totalMin;
        }else { //B es mayor
            if(minB < minA){
                minB += 60;
                hourB -= 1;
            }
            totalHour = hourB - hourA;
            totalMin = minB - minA;
            return totalHour+":"+totalMin;
        }
    }

    public static boolean isMenor(TreeMap<String, Integer> subraction, TreeMap<String, Integer> totalHourWorkedFirstEmployee) {
        if(subraction.get("hour") < totalHourWorkedFirstEmployee.get("hour"))
            return true;
        else return subraction.get("minute") < totalHourWorkedFirstEmployee.get("minute");
    }
}
