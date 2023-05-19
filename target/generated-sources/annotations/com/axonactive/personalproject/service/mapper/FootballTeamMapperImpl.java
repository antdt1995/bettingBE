package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.FootballTeam;
import com.axonactive.personalproject.service.dto.FootballTeamDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-19T17:22:45+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.17 (Oracle Corporation)"
)
public class FootballTeamMapperImpl implements FootballTeamMapper {

    @Override
    public FootballTeamDto toDto(FootballTeam footballTeam) {
        if ( footballTeam == null ) {
            return null;
        }

        FootballTeamDto footballTeamDto = new FootballTeamDto();

        footballTeamDto.setId( footballTeam.getId() );
        footballTeamDto.setName( footballTeam.getName() );
        footballTeamDto.setLeague( footballTeam.getLeague() );
        footballTeamDto.setManager( footballTeam.getManager() );

        return footballTeamDto;
    }

    @Override
    public List<FootballTeamDto> toDtos(List<FootballTeam> footballTeams) {
        if ( footballTeams == null ) {
            return null;
        }

        List<FootballTeamDto> list = new ArrayList<FootballTeamDto>( footballTeams.size() );
        for ( FootballTeam footballTeam : footballTeams ) {
            list.add( toDto( footballTeam ) );
        }

        return list;
    }

    @Override
    public FootballTeam toEntity(FootballTeamDto footballTeamDto) {
        if ( footballTeamDto == null ) {
            return null;
        }

        FootballTeam.FootballTeamBuilder footballTeam = FootballTeam.builder();

        footballTeam.id( footballTeamDto.getId() );
        footballTeam.name( footballTeamDto.getName() );
        footballTeam.league( footballTeamDto.getLeague() );
        footballTeam.manager( footballTeamDto.getManager() );

        return footballTeam.build();
    }

    @Override
    public List<FootballTeam> toEntities(List<FootballTeamDto> footballTeamDtos) {
        if ( footballTeamDtos == null ) {
            return null;
        }

        List<FootballTeam> list = new ArrayList<FootballTeam>( footballTeamDtos.size() );
        for ( FootballTeamDto footballTeamDto : footballTeamDtos ) {
            list.add( toEntity( footballTeamDto ) );
        }

        return list;
    }
}
