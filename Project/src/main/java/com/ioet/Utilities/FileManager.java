package com.ioet.Utilities;

import com.ioet.model.DayOfWeek;
import com.ioet.model.Employee;
import com.ioet.model.Schedule;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public static List<Employee> createListOfEmployees (String fileDirec){
        List<Employee> employees = new ArrayList<>();
        try{
            BufferedReader bf = new BufferedReader(new FileReader(fileDirec));
            String temp="";
            String bfRead;
            System.out.println("Reading...");
            while((bfRead = bf.readLine()) != null){
                employees.add(createEmployee(bfRead));
            }
            bf.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found -> "+e.getMessage());
        }catch (IOException e){
            System.err.println("Input problems -> "+e.getMessage());
        }catch(Exception e){
            System.err.println("Error unknow -> "+e.getMessage());
        }
        return employees;
    }


    private static Employee createEmployee(String line){
        String name ="";
        Schedule shift = new Schedule();
        List<Schedule.TimeRange> timeRanges = new ArrayList<>();
        shift.setTimeRanges(timeRanges);
        String[] nameShift = line.split("=");
        name = nameShift[0].trim();
        String[] timeRangeString = nameShift[1].trim().split(",");
        for (String timeR : timeRangeString){ // MO 10:00-12:00
            String start;
            String end;
            DayOfWeek day;
            String dayString =  timeR.trim().split(" ")[0].trim();
            if (dayString.equals("MO")){
                day = DayOfWeek.MONDAY;
            }else if(dayString.equals("TU")){
                day = DayOfWeek.TUESDAY;
            }else if(dayString.equals("WE")){
                day = DayOfWeek.WEDNESDAY;
            }else if(dayString.equals("TH")){
                day = DayOfWeek.THRURSDAY;
            }else if(dayString.equals("FR")){
                day = DayOfWeek.FRIDAY;
            }else if(dayString.equals("SA")){
                day = DayOfWeek.SATURDAY;
            }else {
                day = DayOfWeek.SUNDAY;
            }
            String hours = timeR.trim().split(" ")[1].trim();
            start = hours.split("-")[0];
            end = hours.split("-")[1];
            Schedule.TimeRange timeRange = new Schedule.TimeRange(day,start,end);
            timeRanges.add(timeRange);
        }
        return new Employee(name,shift);
    }
}
