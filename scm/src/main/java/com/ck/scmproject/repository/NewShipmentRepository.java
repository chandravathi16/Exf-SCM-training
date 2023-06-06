package com.ck.scmproject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ck.scmproject.model.NewShipment;

@Repository
public interface NewShipmentRepository extends MongoRepository<NewShipment, String> {
	
	//NewShipment findShipmentByShipmentNo(int shipmentNumber);
	
    boolean existsByShipmentNumber(int shipmentNumber);
    
    //List<NewShipment> findByUserEmail(String email);
}

