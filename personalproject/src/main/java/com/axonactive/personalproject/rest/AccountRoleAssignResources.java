package com.axonactive.personalproject.rest;

import com.axonactive.personalproject.rest.admin.AccountRoleAssignmentApi;
import com.axonactive.personalproject.service.customDto.AccountRoleAssignCustomDto;
import com.axonactive.personalproject.service.implement.AccountRoleAssignmentServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AccountRoleAssignResources implements AccountRoleAssignmentApi {
    private final AccountRoleAssignmentServiceImpl assignmentService;

    @Override
    public ResponseEntity<List<AccountRoleAssignCustomDto>> getAllAssign() {
        log.info("Get all account role");
        return ResponseEntity.ok(assignmentService.getAllAssign());
    }

    @Override
    public ResponseEntity<AccountRoleAssignCustomDto> getAssignById(Long id) {
        log.info("Get account role id");
        return ResponseEntity.ok(assignmentService.findAssignById(id));
    }

    @Override
    public ResponseEntity<Void> deleteAssignById(Long id) {
        log.info("delete account role by id");
        assignmentService.deleteAssignById(id);
        return ResponseEntity.noContent().header("DeleteSuccess","Delete id: "+id+" success").build();
    }

    @Override
    public ResponseEntity<AccountRoleAssignCustomDto> createRole(AccountRoleAssignCustomDto accountRoleAssignCustomDto, Long customerId) {
        log.info("Create role");
        AccountRoleAssignCustomDto accountRole=assignmentService.createRole(accountRoleAssignCustomDto,customerId);
        return ResponseEntity.created(URI.create("auth/assign/" + accountRole.getId())).body(accountRole);
    }

    @Override
    public ResponseEntity<AccountRoleAssignCustomDto> updateRole(AccountRoleAssignCustomDto accountRoleAssignCustomDto, Long id) {
        log.info("update account role");
        AccountRoleAssignCustomDto accountRole=assignmentService.updateRole(accountRoleAssignCustomDto,id);
        return ResponseEntity.ok().body(accountRole);
    }
}
