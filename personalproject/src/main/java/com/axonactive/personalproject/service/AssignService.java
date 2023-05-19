package com.axonactive.personalproject.service;

import com.axonactive.personalproject.entity.AccountRoleAssignment;
import com.axonactive.personalproject.service.dto.AssignDto;

import java.util.List;

public interface AssignService {
    List<AssignDto> getAllAssign();
    AssignDto findAssignById(Long id);
    void deleteAssignById(Long id);
    AccountRoleAssignment updateAssign(AssignDto assignDto, Long id);
    AccountRoleAssignment createAssign(AssignDto assignDto, Long customerId, Long roleId);
}
