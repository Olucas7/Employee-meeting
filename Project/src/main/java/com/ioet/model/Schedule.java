package com.ioet.model;

import com.ioet.Utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private List<TimeRange> timeRanges = new ArrayList<>();

    public Schedule() {
    }

    public Schedule(List<TimeRange> timeRanges) {
        this.timeRanges = timeRanges;
    }

    public List<TimeRange> getTimeRanges() {
        return timeRanges;
    }

    public void setTimeRanges(List<TimeRange> timeRanges) {
        this.timeRanges = timeRanges;
    }

    public TimeRange getTimeDay(DayOfWeek day){
        for (TimeRange timeRange:
             this.timeRanges) {
            if(timeRange.day == day)
                return timeRange;
        }
        return null;
    }
    public List<DayOfWeek> getWorkdays() {
        List<DayOfWeek> workDaysList = new ArrayList<>();
        for (TimeRange timeRange: this.timeRanges) {
            workDaysList.add(timeRange.getDay());
        }
        return workDaysList;
    }

    public String hoursWorked(TimeRange timeRange) {
        String finalHour;
        String finalMin;
        // Start Time
        int hourStart = Utilities.timeRangeToInteger(timeRange).get("hourStart");
        int minStart = Utilities.timeRangeToInteger(timeRange).get("minStart");
        // End Time
        int hourEnd = Utilities.timeRangeToInteger(timeRange).get("hourEnd");
        int minSEnd = Utilities.timeRangeToInteger(timeRange).get("minEnd");
        if (minSEnd < minStart) {
            minSEnd += 60;
            hourEnd -= 1;
        }
        finalHour = String.valueOf(hourEnd - hourStart);
        finalMin = String.valueOf(minSEnd - minStart);
        if (finalHour.length() == 1) {
            String tempA = finalHour;
            finalHour = "0" + tempA;
        }
        if (finalMin.length() == 1) {
            String tempA = finalMin;
            finalMin = "0" + tempA;
        }
        return (finalHour + ":" + finalMin).trim();
    }

    // NESTED CLASS - STATIC
    public static class TimeRange {
        private DayOfWeek day;
        private String start;
        private String end;

        public TimeRange() {
        }

        public TimeRange(DayOfWeek day, String start, String end) {
            this.day = day;
            this.start = start;
            this.end = end;
        }

        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public String getEnd() {
            return end;
        }

        public void setEnd(String end) {
            this.end = end;
        }

        public DayOfWeek getDay() {
            return day;
        }

        public void setDay(DayOfWeek day) {
            this.day = day;
        }


    }
}
