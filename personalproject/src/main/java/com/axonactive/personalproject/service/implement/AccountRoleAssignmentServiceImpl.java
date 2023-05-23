package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.entity.Account;
import com.axonactive.personalproject.entity.AccountRoleAssignment;
import com.axonactive.personalproject.entity.Role;
import com.axonactive.personalproject.exception.ProjectException;
import com.axonactive.personalproject.repository.AccountRoleAssignmentRepository;
import com.axonactive.personalproject.service.AccountRoleAssignService;
import com.axonactive.personalproject.service.customDto.AccountRoleAssignCustomDto;
import com.axonactive.personalproject.service.dto.AccountDto;
import com.axonactive.personalproject.service.mapper.AccountMapper;
import com.axonactive.personalproject.service.mapper.AssignMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountRoleAssignmentServiceImpl implements AccountRoleAssignService {
    private final AccountRoleAssignmentRepository accountRoleAssignmentRepository;
    private final AccountServiceImpl accountService;
    @Override
    public List<AccountRoleAssignCustomDto> getAllAssign() {
        List<AccountRoleAssignment> accountRoleAssignments=accountRoleAssignmentRepository.findAll();
        if(accountRoleAssignments.isEmpty()){
            throw ProjectException.AssignNotFound();
        }
        return AssignMapper.INSTANCE.toDtos(accountRoleAssignments);
    }

    @Override
    public AccountRoleAssignCustomDto findAssignById(Long id) {
        if(id==null){
            throw ProjectException.badRequest("IdInvalid","Id cannot be null");
        }
        AccountRoleAssignment assignment=accountRoleAssignmentRepository.findById(id).orElseThrow(ProjectException::AssignNotFound);
        return AssignMapper.INSTANCE.toDto(assignment);
    }

    @Override
    public void deleteAssignById(Long id) {
        if(id==null){
            throw ProjectException.badRequest("IdInvalid","Id cannot be null");
        }
        AccountRoleAssignment assignment=accountRoleAssignmentRepository.findById(id).orElseThrow(ProjectException::AssignNotFound);
        accountRoleAssignmentRepository.delete(assignment);
    }

    @Override
    public AccountRoleAssignCustomDto createRole(AccountRoleAssignCustomDto accountRoleAssignDto, Long accountId) {
        AccountDto accountDto=accountService.getAccountById(accountId);
        Account account= AccountMapper.INSTANCE.toEntity(accountDto);
        AccountRoleAssignment assignment = AccountRoleAssignment.builder()
                .role(Role.valueOf(accountRoleAssignDto.getRole()))
                .account(account)
                .build();
        accountRoleAssignmentRepository.save(assignment);
        return AssignMapper.INSTANCE.toDto(assignment);
    }

    @Override
    public AccountRoleAssignCustomDto updateRole(AccountRoleAssignCustomDto accountRoleAssignDto, Long roleId) {
        AccountRoleAssignment assignment=accountRoleAssignmentRepository.findById(roleId).orElseThrow(ProjectException::AssignNotFound);
        assignment.setRole(Role.valueOf(accountRoleAssignDto.getRole()));
        accountRoleAssignmentRepository.save(assignment);
        return AssignMapper.INSTANCE.toDto(assignment);
    }
}
