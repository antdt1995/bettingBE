package com.axonactive.personalproject.repository;


import com.axonactive.personalproject.entity.OddType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OddTypeRepository extends JpaRepository<OddType,Long> {
}
