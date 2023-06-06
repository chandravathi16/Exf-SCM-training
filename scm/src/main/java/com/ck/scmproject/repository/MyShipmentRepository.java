package com.ck.scmproject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ck.scmproject.model.NewShipment;

@Repository
public interface MyShipmentRepository extends MongoRepository<NewShipment, String> {
	
}
