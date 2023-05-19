package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.Account;
import com.axonactive.personalproject.entity.AccountRoleAssignment;
import com.axonactive.personalproject.service.customDto.AssignCustomDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-19T17:22:45+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.17 (Oracle Corporation)"
)
public class AssignMapperImpl implements AssignMapper {

    @Override
    public AssignCustomDto toDto(AccountRoleAssignment accountRoleAssignment) {
        if ( accountRoleAssignment == null ) {
            return null;
        }

        AssignCustomDto assignCustomDto = new AssignCustomDto();

        assignCustomDto.setUserName( accountRoleAssignmentAccountUserName( accountRoleAssignment ) );

        return assignCustomDto;
    }

    @Override
    public List<AssignCustomDto> toDtos(List<AccountRoleAssignment> accountRoleAssignments) {
        if ( accountRoleAssignments == null ) {
            return null;
        }

        List<AssignCustomDto> list = new ArrayList<AssignCustomDto>( accountRoleAssignments.size() );
        for ( AccountRoleAssignment accountRoleAssignment : accountRoleAssignments ) {
            list.add( toDto( accountRoleAssignment ) );
        }

        return list;
    }

    private String accountRoleAssignmentAccountUserName(AccountRoleAssignment accountRoleAssignment) {
        if ( accountRoleAssignment == null ) {
            return null;
        }
        Account account = accountRoleAssignment.getAccount();
        if ( account == null ) {
            return null;
        }
        String userName = account.getUserName();
        if ( userName == null ) {
            return null;
        }
        return userName;
    }
}
