package com.bridgelabz.greetingapp.repository;

import com.bridgelabz.greetingapp.model.GreetingData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<GreetingData,Integer>{
}
