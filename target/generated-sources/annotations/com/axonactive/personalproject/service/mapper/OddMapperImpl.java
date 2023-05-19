package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.FootballMatch;
import com.axonactive.personalproject.entity.FootballTeam;
import com.axonactive.personalproject.entity.Odd;
import com.axonactive.personalproject.entity.OddType;
import com.axonactive.personalproject.service.customDto.OddCustomDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-19T17:22:45+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.17 (Oracle Corporation)"
)
public class OddMapperImpl implements OddMapper {

    @Override
    public OddCustomDto toDto(Odd odd) {
        if ( odd == null ) {
            return null;
        }

        OddCustomDto oddCustomDto = new OddCustomDto();

        oddCustomDto.setOddType( oddOddTypeName( odd ) );
        oddCustomDto.setHomeTeamName( oddFootballMatchHomeTeamName( odd ) );
        oddCustomDto.setOddRate( odd.getOddRate() );
        oddCustomDto.setSetScore( odd.getSetScore() );
        oddCustomDto.setEndDate( odd.getEndDate() );

        return oddCustomDto;
    }

    @Override
    public List<OddCustomDto> toDtos(List<Odd> odds) {
        if ( odds == null ) {
            return null;
        }

        List<OddCustomDto> list = new ArrayList<OddCustomDto>( odds.size() );
        for ( Odd odd : odds ) {
            list.add( toDto( odd ) );
        }

        return list;
    }

    private String oddOddTypeName(Odd odd) {
        if ( odd == null ) {
            return null;
        }
        OddType oddType = odd.getOddType();
        if ( oddType == null ) {
            return null;
        }
        String name = oddType.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String oddFootballMatchHomeTeamName(Odd odd) {
        if ( odd == null ) {
            return null;
        }
        FootballMatch footballMatch = odd.getFootballMatch();
        if ( footballMatch == null ) {
            return null;
        }
        FootballTeam homeTeam = footballMatch.getHomeTeam();
        if ( homeTeam == null ) {
            return null;
        }
        String name = homeTeam.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
