package com.ck.scmproject.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ck.scmproject.model.Signup;

@Repository
public interface SignupRepository extends MongoRepository<Signup, String> {
	
    Optional<Signup> findUserByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByRole(String role);

}
