package com.ioet.model;

import java.util.LinkedHashMap;
import java.util.Map;


public class Employee extends User{
    private LinkedHashMap<Employee,Integer> partners;
    private Schedule shift;


    public Employee(String name) {
        super(name);
        partners = new LinkedHashMap<>();
    }

    public Employee(String name, Schedule shift) {
        super(name);
        this.shift = shift;
        partners = new LinkedHashMap<>();
    }

    public Employee(String name, LinkedHashMap<Employee, Integer> partners, Schedule shift) {
        super(name);
        this.partners = partners;
        this.shift = shift;
    }

    public Schedule getShift() {
        return shift;
    }

    public void setShift(Schedule shift) {
        this.shift = shift;
    }

    public Map<Employee, Integer> getPartners() {
        return partners;
    }

    public void setPartners(LinkedHashMap<Employee, Integer> partners) {
        this.partners = partners;
    }




}
