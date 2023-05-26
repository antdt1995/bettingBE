package com.axonactive.personalproject.rest.admin;

import com.axonactive.personalproject.service.customDto.AccountRoleAssignCustomDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/bet/assign")
@PreAuthorize("hasRole('ADMIN')")
public interface AccountRoleAssignmentApi {
    @GetMapping
    ResponseEntity<List<AccountRoleAssignCustomDto>> getAllAssign();
    @GetMapping("/{id}")
    ResponseEntity<AccountRoleAssignCustomDto> getAssignById(@PathVariable("id") Long id);
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteAssignById(@PathVariable("id") Long id);
    @PostMapping("/{accountId}")
    ResponseEntity<AccountRoleAssignCustomDto> createRole(@RequestBody AccountRoleAssignCustomDto accountRoleAssignCustomDto,@PathVariable("accountId") Long accountId);
    @PutMapping("/{id}")
    ResponseEntity<AccountRoleAssignCustomDto> updateRole(@RequestBody AccountRoleAssignCustomDto accountRoleAssignCustomDto,@PathVariable("id") Long id);

}
