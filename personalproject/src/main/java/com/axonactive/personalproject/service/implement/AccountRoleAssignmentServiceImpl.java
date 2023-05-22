package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.entity.AccountRoleAssignment;
import com.axonactive.personalproject.repository.AccountRoleAssignmentRepository;
import com.axonactive.personalproject.service.AccountRoleAssignService;
import com.axonactive.personalproject.service.dto.AccountRoleAssignDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountRoleAssignmentServiceImpl implements AccountRoleAssignService {
    private final AccountRoleAssignmentRepository accountRoleAssignmentRepository;

    @Override
    public List<AccountRoleAssignDto> getAllAssign() {
        return null;
    }

    @Override
    public AccountRoleAssignDto findAssignById(Long id) {
        return null;
    }

    @Override
    public void deleteAssignById(Long id) {

    }

    @Override
    public AccountRoleAssignment updateAssign(AccountRoleAssignDto accountRoleAssignDto, Long id) {
        return null;
    }

    @Override
    public AccountRoleAssignment createAssign(AccountRoleAssignDto accountRoleAssignDto, Long customerId, Long roleId) {
        return null;
    }
}
