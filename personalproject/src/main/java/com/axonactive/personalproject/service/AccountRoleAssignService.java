package com.axonactive.personalproject.service;

import com.axonactive.personalproject.entity.AccountRoleAssignment;
import com.axonactive.personalproject.service.dto.AccountRoleAssignDto;

import java.util.List;

public interface AccountRoleAssignService {
    List<AccountRoleAssignDto> getAllAssign();
    AccountRoleAssignDto findAssignById(Long id);
    void deleteAssignById(Long id);
    AccountRoleAssignment updateAssign(AccountRoleAssignDto accountRoleAssignDto, Long id);
    AccountRoleAssignment createAssign(AccountRoleAssignDto accountRoleAssignDto, Long customerId, Long roleId);
}
