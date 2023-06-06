package com.ck.scmproject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.ck.scmproject.model.DeviceData;

@Repository
public interface DeviceDataRepository extends MongoRepository<DeviceData,String>{
	
}
