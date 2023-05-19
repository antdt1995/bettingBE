package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.entity.AccountRoleAssignment;
import com.axonactive.personalproject.repository.AssignRepository;
import com.axonactive.personalproject.service.AssignService;
import com.axonactive.personalproject.service.dto.AssignDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AssignServiceImpl implements AssignService {
    private final AssignRepository assignRepository;

    @Override
    public List<AssignDto> getAllAssign() {
        return null;
    }

    @Override
    public AssignDto findAssignById(Long id) {
        return null;
    }

    @Override
    public void deleteAssignById(Long id) {

    }

    @Override
    public AccountRoleAssignment updateAssign(AssignDto assignDto, Long id) {
        return null;
    }

    @Override
    public AccountRoleAssignment createAssign(AssignDto assignDto, Long customerId, Long roleId) {
        return null;
    }
}
