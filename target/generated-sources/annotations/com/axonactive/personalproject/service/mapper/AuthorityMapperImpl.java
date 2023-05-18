package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.Authority;
import com.axonactive.personalproject.service.dto.AuthorityDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-17T10:42:22+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.17 (Oracle Corporation)"
)
public class AuthorityMapperImpl implements AuthorityMapper {

    @Override
    public AuthorityDto toDto(Authority authority) {
        if ( authority == null ) {
            return null;
        }

        AuthorityDto authorityDto = new AuthorityDto();

        authorityDto.setId( authority.getId() );
        authorityDto.setName( authority.getName() );

        return authorityDto;
    }

    @Override
    public List<AuthorityDto> toDtos(List<Authority> authorities) {
        if ( authorities == null ) {
            return null;
        }

        List<AuthorityDto> list = new ArrayList<AuthorityDto>( authorities.size() );
        for ( Authority authority : authorities ) {
            list.add( toDto( authority ) );
        }

        return list;
    }
}
