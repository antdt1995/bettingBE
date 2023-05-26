package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.entity.FootballMatch;
import com.axonactive.personalproject.entity.House;
import com.axonactive.personalproject.entity.Odd;
import com.axonactive.personalproject.entity.OddType;
import com.axonactive.personalproject.exception.ProjectException;
import com.axonactive.personalproject.repository.FootballMatchRepository;
import com.axonactive.personalproject.repository.HouseRepository;
import com.axonactive.personalproject.repository.OddRepository;
import com.axonactive.personalproject.service.OddService;
import com.axonactive.personalproject.service.OddTypeService;
import com.axonactive.personalproject.service.customDto.OddCustomDto;
import com.axonactive.personalproject.service.dto.OddDto;
import com.axonactive.personalproject.service.dto.OddTypeDto;
import com.axonactive.personalproject.service.mapper.OddMapper;
import com.axonactive.personalproject.service.mapper.OddTypeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class OddImpl implements OddService {
    private final OddRepository oddRepository;
    private final FootballMatchRepository footballMatchRepository;
    private final HouseRepository houseRepository;
    private final OddTypeService oddTypeService;



    @Override
    public List<OddCustomDto> getAllOdd() {
        List<Odd> odds = oddRepository.findAll();
        if (odds.isEmpty()) {
            throw ProjectException.OddNotFound();
        }
        return OddMapper.INSTANCE.toDtos(odds);
    }

    @Override
    public OddCustomDto findOddById(Long id) {
        Odd odd = oddRepository.findById(id).orElseThrow(ProjectException::OddNotFound);
        return OddMapper.INSTANCE.toDto(odd);
    }

    @Override
    public void deleteOddById(Long id) {
        if (id == null) {
            throw ProjectException.badRequest("IdInvalid", "Id cannot be null");
        }
        Odd odd = oddRepository.findById(id).orElseThrow(ProjectException::OddNotFound);
        oddRepository.delete(odd);

    }

    @Override
    public OddCustomDto createOdd(OddDto oddDto,Long houseId, Long matchId, Long typeId) {
        //get football match
        FootballMatch footballMatch=footballMatchRepository.findById(matchId).orElseThrow(ProjectException::footballMatchNotFound);
        //get house
        House house=houseRepository.findById(houseId).orElseThrow(ProjectException::houseNotFound);
        //get odd type
        OddTypeDto oddTypeDto = oddTypeService.findOddTypeById(typeId);
        OddType oddType = OddTypeMapper.INSTANCE.toEntity(oddTypeDto);
        //exception
        exception(oddDto, footballMatch.getStartDate());
        //create odd
        Odd odd = new Odd();
        odd.setOddRate(oddDto.getOddRate());
        odd.setSetScore(oddDto.getSetScore());
        odd.setFootballMatch(footballMatch);
        odd.setEndDate(oddDto.getEndDate());
        odd.setOddType(oddType);
        odd.setHouse(house);
        odd = oddRepository.save(odd);
        return OddMapper.INSTANCE.toDto(odd);
    }

    @Override
    public OddCustomDto updateOdd(OddDto oddDto, Long id) {
        Odd odd = new Odd();
        LocalDate startDate = odd.getFootballMatch().getStartDate();
        exception(oddDto, startDate);
        odd.setOddRate(oddDto.getOddRate());
        odd.setSetScore(oddDto.getSetScore());
        odd.setEndDate(oddDto.getEndDate());
        odd = oddRepository.save(odd);
        return OddMapper.INSTANCE.toDto(odd);
    }

    @Override
    public Long findWinOddIds(Long matchId) {
        return oddRepository.findWinLoseOddIds(matchId);
    }

    @Override
    public Long findOverOddId(Long matchId) {
        return oddRepository.findOverOddId(matchId);
    }

    @Override
    public Long findUnderOddId(Long matchId) {
        return oddRepository.findUnderOddId(matchId);
    }

    @Override
    public List<Object[]> findOddByMatchId(Long matchId) {
        FootballMatch footballMatch=footballMatchRepository.findById(matchId).orElseThrow(ProjectException::footballMatchNotFound);
        if (matchId == null) {
            throw ProjectException.badRequest("IdInvalid", "Id cannot be null");
        }
        return oddRepository.findOddByMatchId(footballMatch.getId());
    }

    private static void exception(OddDto oddDto, LocalDate footballMatch) {
        if (oddDto.getOddRate() < 0) {
            throw ProjectException.badRequest("WrongValue", "Odd rate cannot negative");
        }
        if (oddDto.getSetScore() < 0) {
            throw ProjectException.badRequest("WrongValue", "Set score cannot negative");
        }
        if (oddDto.getEndDate().isAfter(footballMatch)) {
            throw ProjectException.badRequest("WrongDate", "End date must be set before or equal football match start date");
        }
    }
}
