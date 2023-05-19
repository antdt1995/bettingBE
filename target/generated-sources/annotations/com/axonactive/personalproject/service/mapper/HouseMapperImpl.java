package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.House;
import com.axonactive.personalproject.service.dto.HouseDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-19T17:22:45+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.17 (Oracle Corporation)"
)
public class HouseMapperImpl implements HouseMapper {

    @Override
    public HouseDto toDto(House house) {
        if ( house == null ) {
            return null;
        }

        HouseDto houseDto = new HouseDto();

        houseDto.setId( house.getId() );
        houseDto.setName( house.getName() );
        houseDto.setAddress( house.getAddress() );
        houseDto.setBalance( house.getBalance() );

        return houseDto;
    }

    @Override
    public List<HouseDto> toDtos(List<House> houses) {
        if ( houses == null ) {
            return null;
        }

        List<HouseDto> list = new ArrayList<HouseDto>( houses.size() );
        for ( House house : houses ) {
            list.add( toDto( house ) );
        }

        return list;
    }
}
