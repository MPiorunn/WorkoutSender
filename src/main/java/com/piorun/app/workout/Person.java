package com.piorun.app.workout;

import java.time.DayOfWeek;
import java.util.Map;

public class Person {

    private String email;
    private String name;
    private Map<DayOfWeek, Workout> weekDays;

    public Person(String email, String name, Map<DayOfWeek, Workout> weekDays) {
        this.email = email;
        this.name = name;
        this.weekDays = weekDays;
    }

    public Map<DayOfWeek, Workout> getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(Map<DayOfWeek, Workout> weekDays) {
        this.weekDays = weekDays;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
