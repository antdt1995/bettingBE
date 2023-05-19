package com.axonactive.personalproject.repository;


import com.axonactive.personalproject.entity.AccountRoleAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignRepository extends JpaRepository<AccountRoleAssignment,Long> {
}
