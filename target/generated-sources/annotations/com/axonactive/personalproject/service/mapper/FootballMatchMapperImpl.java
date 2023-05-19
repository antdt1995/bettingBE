package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.FootballMatch;
import com.axonactive.personalproject.entity.FootballTeam;
import com.axonactive.personalproject.service.customDto.FootballMatchCustomDto;
import com.axonactive.personalproject.service.dto.FootballMatchDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-19T17:22:45+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.17 (Oracle Corporation)"
)
public class FootballMatchMapperImpl implements FootballMatchMapper {

    @Override
    public FootballMatchCustomDto toDto(FootballMatch footballMatch) {
        if ( footballMatch == null ) {
            return null;
        }

        FootballMatchCustomDto footballMatchCustomDto = new FootballMatchCustomDto();

        footballMatchCustomDto.setHomeTeamName( footballMatchHomeTeamName( footballMatch ) );
        footballMatchCustomDto.setAwayTeamName( footballMatchAwayTeamName( footballMatch ) );
        footballMatchCustomDto.setHomeScore( footballMatch.getHomeScore() );
        footballMatchCustomDto.setAwayScore( footballMatch.getAwayScore() );
        footballMatchCustomDto.setTotalScore( footballMatch.getTotalScore() );
        footballMatchCustomDto.setStartDate( footballMatch.getStartDate() );

        return footballMatchCustomDto;
    }

    @Override
    public List<FootballMatchCustomDto> toDtos(List<FootballMatch> footballMatches) {
        if ( footballMatches == null ) {
            return null;
        }

        List<FootballMatchCustomDto> list = new ArrayList<FootballMatchCustomDto>( footballMatches.size() );
        for ( FootballMatch footballMatch : footballMatches ) {
            list.add( toDto( footballMatch ) );
        }

        return list;
    }

    @Override
    public FootballMatchDto toXDto(FootballMatch footballMatch) {
        if ( footballMatch == null ) {
            return null;
        }

        FootballMatchDto footballMatchDto = new FootballMatchDto();

        footballMatchDto.setId( footballMatch.getId() );
        footballMatchDto.setHomeScore( footballMatch.getHomeScore() );
        footballMatchDto.setAwayScore( footballMatch.getAwayScore() );
        footballMatchDto.setTotalScore( footballMatch.getTotalScore() );
        footballMatchDto.setStartDate( footballMatch.getStartDate() );

        return footballMatchDto;
    }

    @Override
    public List<FootballMatchDto> toXDtos(List<FootballMatch> footballMatches) {
        if ( footballMatches == null ) {
            return null;
        }

        List<FootballMatchDto> list = new ArrayList<FootballMatchDto>( footballMatches.size() );
        for ( FootballMatch footballMatch : footballMatches ) {
            list.add( toXDto( footballMatch ) );
        }

        return list;
    }

    private String footballMatchHomeTeamName(FootballMatch footballMatch) {
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

    private String footballMatchAwayTeamName(FootballMatch footballMatch) {
        if ( footballMatch == null ) {
            return null;
        }
        FootballTeam awayTeam = footballMatch.getAwayTeam();
        if ( awayTeam == null ) {
            return null;
        }
        String name = awayTeam.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
