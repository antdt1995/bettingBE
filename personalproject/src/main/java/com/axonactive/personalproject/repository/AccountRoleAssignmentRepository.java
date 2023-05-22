package com.axonactive.personalproject.repository;


import com.axonactive.personalproject.entity.AccountRoleAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRoleAssignmentRepository extends JpaRepository<AccountRoleAssignment,Long> {
}
