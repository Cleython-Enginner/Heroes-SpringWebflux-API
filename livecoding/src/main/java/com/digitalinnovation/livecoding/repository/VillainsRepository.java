package com.digitalinnovation.livecoding.repository;

import com.digitalinnovation.livecoding.document.Villains;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

public interface VillainsRepository extends CrudRepository <Villains, String>{
}
