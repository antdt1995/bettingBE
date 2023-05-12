package com.axonactive.personalproject.service;

import com.axonactive.personalproject.entity.Assign;
import com.axonactive.personalproject.service.dto.AssignDto;

import java.util.List;

public interface AssignService {
    List<AssignDto> getAllAssign();
    AssignDto findAssignById(Long id);
    void deleteAssignById(Long id);
    Assign updateAssign(AssignDto assignDto, Long id);
    Assign createAssign(AssignDto assignDto,Long customerId, Long roleId);
}
