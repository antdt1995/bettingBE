package com.axonactive.personalproject.repository;


import com.axonactive.personalproject.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleTypeRepository extends JpaRepository<Authority,Long> {
}
