package com.axonactive.personalproject.repository;


import com.axonactive.personalproject.entity.Assign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignRepository extends JpaRepository<Assign,Long> {
}
