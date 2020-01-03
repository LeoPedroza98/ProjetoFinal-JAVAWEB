package com.tbp.repository;

import com.tbp.model.Scheduling;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulingRepository extends CrudRepository<Scheduling,Long> {
}
