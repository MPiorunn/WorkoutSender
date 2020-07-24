package com.piorun.app.workout;


import java.util.ArrayList;
import java.util.List;

public class Workout {

    private List<String> workouts = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String workout : workouts) {
            stringBuilder.append(" - ").append(workout).append("\n\n");
        }

        return stringBuilder.toString();
    }

    public void add(String workout) {
        this.workouts.add(workout);
    }
}
