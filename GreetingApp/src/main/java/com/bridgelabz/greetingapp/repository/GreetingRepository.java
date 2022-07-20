package com.bridgelabz.greetingapp.repository;

import com.bridgelabz.greetingapp.model.GreetingData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<GreetingData,Integer> {

}