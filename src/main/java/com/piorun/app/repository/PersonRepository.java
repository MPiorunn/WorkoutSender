package com.piorun.app.repository;


import com.piorun.app.workout.Person;
import com.piorun.app.workout.Workout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// HARDCODED REPOSITORY [*]
@Component
public class PersonRepository {


    private final Logger logger = LoggerFactory.getLogger(PersonRepository.class);

    private Person kasia;
    private Person maciek;

    public PersonRepository() {
        setupKasia();
        setupMaciek();
    }


    public void setupKasia() {

        logger.debug("Creating Kasia's workout");
        Workout monday = new Workout();
        Workout tuesday = new Workout();
        Workout wednesday = new Workout();
        Workout thursday = new Workout();
        Workout friday = new Workout();
        Workout saturday = new Workout();
        Workout sunday = new Workout();

        logger.debug("Adding monday");
        monday.add("Joga : https://www.youtube.com/watch?v=ABBuecfNqXc&list=PLRz2ixZUdsyRkGl1OVdZf3pz1FylysvCT");
        monday.add("Bieganko : setki");
        monday.add("Trening siatkowki");


        logger.debug("Adding tuesday");
        tuesday.add("Rozciaganie albo joga na rozciaganie");
        tuesday.add("Trening silowy : plecki i brzuch\n" +
                "Brzuchol - jakoś 15-20 min\n" +
                "- plank 30s  5\n" +
                "    - jedna na pewno bokiem\n" +
                "- russian twist 30s 5\n" +
                "- nogi zgięte w kolanach w zwisie na drążku 15s x 5\n" +
                "- mountain climbers 30s x 5\n" +
                "\n" +
                "Plecy:\n" +
                "- martwy ciąg kettlem\n" +
                "- martwy ciąg kettlem na 1 nodze\n" +
                "- superman z poduszką pod brzuchem");
        tuesday.add("Siatkówka - lajtowe odbijanko");


        logger.debug("Adding wednesday");
        wednesday.add("Bieganie : 300m interwałki ");
        wednesday.add("Trening siatkowka");
        wednesday.add("Joga : https://www.youtube.com/watch?v=ABBuecfNqXc&list=PLRz2ixZUdsyRkGl1OVdZf3pz1FylysvCT");

        logger.debug("Adding thursday");
        thursday.add("Trening siatkówki");
        thursday.add("Rozciąganie");

        logger.debug("Adding friday");
        friday.add("Trening siłowy:\n" +
                "tyłek : https://pl.pinterest.com/pin/788200372274680329/\n" +
                "nogi : https://www.youtube.com/watch?v=4_6kPsyo4Vo");


        logger.debug("Adding saturday");
        saturday.add("SPANKO NON STOP ^^");


        logger.debug("Adding sunday");
        sunday.add("SPANKO NON STOP ^^");

        Map<DayOfWeek, Workout> workoutMap = new HashMap<>();
        workoutMap.put(DayOfWeek.MONDAY, monday);
        workoutMap.put(DayOfWeek.TUESDAY, tuesday);
        workoutMap.put(DayOfWeek.WEDNESDAY, wednesday);
        workoutMap.put(DayOfWeek.THURSDAY, thursday);
        workoutMap.put(DayOfWeek.FRIDAY, friday);
        workoutMap.put(DayOfWeek.SATURDAY, saturday);
        workoutMap.put(DayOfWeek.SUNDAY, sunday);

        logger.debug("Finishing Kasia creation");
        kasia = new Person("kasiapiorun8@gmail.com", "Kasia", workoutMap);

    }

    public void setupMaciek() {

        logger.debug("Creating Maciek's workout");
        Workout monday = new Workout();
        Workout tuesday = new Workout();
        Workout wednesday = new Workout();
        Workout thursday = new Workout();
        Workout friday = new Workout();
        Workout saturday = new Workout();
        Workout sunday = new Workout();


        logger.debug("Adding monday");

        monday.add("Poranne interwały: 10-12 powtórzeń 40 sekund sprintu, 20 sec przerwy");
        monday.add("Rozciąganie : https://www.youtube.com/watch?v=lPKRiU9u_Hc");
        monday.add("Szybki trening na nogi : \n" +
                "- 5x15 wskoki obunóż" +
                "- 5x15 wskoki jedną nogą");

        logger.debug("Adding tuesday");
        tuesday.add("Trening siłowy : standardowy set na kółkach: \n" +
                "3 serie na maxa : \n" +
                "- podciągnięcia na kółkach\n" +
                "- pompki na kółkach\n" +
                "- pozycja do dipsów\n" +
                "- dipsy" +
                "- nogi");


        logger.debug("Adding wednesday");
        wednesday.add("Poranny BRUTAL HIIT WORKOUT");
        wednesday.add("Nóżka z Tieto");

        logger.debug("Adding thursday");
        thursday.add("Trening siłowy : standardowy set na kółkach: \n" +
                "3 serie na maxa : \n" +
                "- podciągnięcia na kółkach\n" +
                "- pompki na kółkach\n" +
                "- pozycja do dipsów\n" +
                "- dipsy" +
                "- nogi");

        logger.debug("Adding friday");
        friday.add("Poranne interwały: 10-12 powtórzeń 40 sekund sprintu, 20 sec przerwy");
        friday.add("Szybki trening na nogi : \n" +
                "- 5x15 wskoki obunóż" +
                "- 5x15 wskoki jedną nogą");

        logger.debug("Adding saturday");
        saturday.add("Rozciąganie : https://www.youtube.com/watch?v=L_xrDAtykMI");

        logger.debug("Adding sunday");
        sunday.add("SPANKO NON STOP ^^");

        Map<DayOfWeek, Workout> workoutMap = new HashMap<>();
        workoutMap.put(DayOfWeek.MONDAY, monday);
        workoutMap.put(DayOfWeek.TUESDAY, tuesday);
        workoutMap.put(DayOfWeek.WEDNESDAY, wednesday);
        workoutMap.put(DayOfWeek.THURSDAY, thursday);
        workoutMap.put(DayOfWeek.FRIDAY, friday);
        workoutMap.put(DayOfWeek.SATURDAY, saturday);
        workoutMap.put(DayOfWeek.SUNDAY, sunday);

        logger.debug("Done with that f bastard xD");
        maciek = new Person("pyorunochron@gmail.com", "Maciek", workoutMap);
    }

    public Person getKasia() {
        return kasia;
    }

    public Person getMaciek() {
        return maciek;
    }

    public List<Person> getAll() {
        List<Person> people = new ArrayList<>();
        people.add(kasia);
        people.add(maciek);
        return people;
    }
}
