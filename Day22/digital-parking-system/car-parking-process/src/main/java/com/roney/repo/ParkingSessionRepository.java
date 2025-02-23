package com.roney.repo;



import com.roney.model.ParkingSession;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface ParkingSessionRepository extends CrudRepository<ParkingSession, String> {
    ParkingSession findByRegNo(String regNo);
}

