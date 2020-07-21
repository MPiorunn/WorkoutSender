package com.piorun.app.workout;


import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Workout {

    @Id
    private String id;
    private List<String> workouts = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String workout : workouts) {
            stringBuilder.append(" - ").append(workout).append("\n\n");
        }

        return stringBuilder.toString();
    }

    public String add(String workout) {
        this.workouts.add(workout);
        return workout;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
