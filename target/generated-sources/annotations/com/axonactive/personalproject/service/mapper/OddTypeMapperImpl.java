package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.OddType;
import com.axonactive.personalproject.service.dto.OddTypeDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-17T10:42:22+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.17 (Oracle Corporation)"
)
public class OddTypeMapperImpl implements OddTypeMapper {

    @Override
    public OddTypeDto toDto(OddType oddType) {
        if ( oddType == null ) {
            return null;
        }

        OddTypeDto oddTypeDto = new OddTypeDto();

        oddTypeDto.setId( oddType.getId() );
        oddTypeDto.setName( oddType.getName() );

        return oddTypeDto;
    }

    @Override
    public List<OddTypeDto> toDtos(List<OddType> oddTypes) {
        if ( oddTypes == null ) {
            return null;
        }

        List<OddTypeDto> list = new ArrayList<OddTypeDto>( oddTypes.size() );
        for ( OddType oddType : oddTypes ) {
            list.add( toDto( oddType ) );
        }

        return list;
    }
}
