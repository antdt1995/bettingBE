package com.axonactive.personalproject.service;

import com.axonactive.personalproject.service.customDto.AccountRoleAssignCustomDto;


import java.util.List;

public interface AccountRoleAssignService {
    List<AccountRoleAssignCustomDto> getAllAssign();
    AccountRoleAssignCustomDto findAssignById(Long id);
    void deleteAssignById(Long id);
    AccountRoleAssignCustomDto createRole(AccountRoleAssignCustomDto accountRoleAssignDto, Long accountId);
    AccountRoleAssignCustomDto updateRole(AccountRoleAssignCustomDto accountRoleAssignDto, Long roleId);
}
