package com.axonactive.personalproject.repository;

import com.axonactive.personalproject.entity.Odd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OddRepository extends JpaRepository<Odd,Long> {
}
