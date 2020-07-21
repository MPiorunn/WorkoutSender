package com.piorun.app.repository;

import com.piorun.app.workout.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
}
