package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.Assign;
import com.axonactive.personalproject.entity.Authority;
import com.axonactive.personalproject.entity.Customer;
import com.axonactive.personalproject.service.customDto.AssignCustomDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-17T10:42:22+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.17 (Oracle Corporation)"
)
public class AssignMapperImpl implements AssignMapper {

    @Override
    public AssignCustomDto toDto(Assign assign) {
        if ( assign == null ) {
            return null;
        }

        AssignCustomDto assignCustomDto = new AssignCustomDto();

        assignCustomDto.setRoleType( assignAuthorityName( assign ) );
        assignCustomDto.setUserName( assignCustomerLastName( assign ) );

        return assignCustomDto;
    }

    @Override
    public List<AssignCustomDto> toDtos(List<Assign> assigns) {
        if ( assigns == null ) {
            return null;
        }

        List<AssignCustomDto> list = new ArrayList<AssignCustomDto>( assigns.size() );
        for ( Assign assign : assigns ) {
            list.add( toDto( assign ) );
        }

        return list;
    }

    private String assignAuthorityName(Assign assign) {
        if ( assign == null ) {
            return null;
        }
        Authority authority = assign.getAuthority();
        if ( authority == null ) {
            return null;
        }
        String name = authority.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String assignCustomerLastName(Assign assign) {
        if ( assign == null ) {
            return null;
        }
        Customer customer = assign.getCustomer();
        if ( customer == null ) {
            return null;
        }
        String lastName = customer.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }
}
