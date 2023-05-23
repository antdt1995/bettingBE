package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.entity.House;
import com.axonactive.personalproject.exception.ProjectException;
import com.axonactive.personalproject.repository.HouseRepository;
import com.axonactive.personalproject.service.HouseService;
import com.axonactive.personalproject.service.dto.HouseDto;
import com.axonactive.personalproject.service.mapper.HouseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import static com.axonactive.personalproject.exception.BooleanMethod.*;
import static org.hibernate.query.criteria.internal.ValueHandlerFactory.isNumeric;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HouseImpl implements HouseService {
    private final HouseRepository houseRepository;
    @Override
    public List<HouseDto> getAllHouse() {
        List<House> houses=houseRepository.findAll();
        if(houses.isEmpty()){
            throw ProjectException.houseNotFound();
        }
        return HouseMapper.INSTANCE.toDtos(houses);
    }

    @Override
    public HouseDto findHouseById(Long id) {
        House house=houseRepository.findById(id).orElseThrow(ProjectException::houseNotFound);

        return HouseMapper.INSTANCE.toDto(house);
    }

    @Override
    public void deleteHouseById(Long id) {
        if(id==null){
            throw ProjectException.badRequest("IdInvalid","Id cannot be null");
        }
        House house=houseRepository.findById(id).orElseThrow(ProjectException::houseNotFound);
        houseRepository.delete(house);
    }

    @Override
    public HouseDto createHouse(HouseDto houseDto) {
        if(!isAlphanumeric(houseDto.getName())){
            throw ProjectException.badRequest("WrongFormat","House name should contain only letters and numbers");
        }
        if(!isNumeric(houseDto.getBalance())){
            throw ProjectException.badRequest("WrongFormat","Balance should contain only numbers");
        }
        if(houseDto.getBalance()<=0){
            throw ProjectException.badRequest("WrongValue","Balance cannot equal or less than 0");
        }
        House house=new House();
        house.setName(houseDto.getName());
        house.setAddress(houseDto.getAddress());
        house.setBalance(houseDto.getBalance());
        houseRepository.save(house);
        return HouseMapper.INSTANCE.toDto(house);
    }

    @Override
    public HouseDto updateHouse(HouseDto houseDto, Long id) {
        if(!isAlphanumeric(houseDto.getName())){
            throw ProjectException.badRequest("WrongFormat","House name should contain only letters and numbers");
        }
        if(!isNumeric(houseDto.getBalance())){
            throw ProjectException.badRequest("WrongFormat","Balance should contain only numbers");
        }
        if(houseDto.getBalance()<=0){
            throw ProjectException.badRequest("WrongValue","Balance cannot equal or less than 0");
        }
        House house=houseRepository.findById(id).orElseThrow(ProjectException::houseNotFound);
        house.setName(houseDto.getName());
        house.setAddress(houseDto.getAddress());
        house.setBalance(houseDto.getBalance());
        houseRepository.save(house);
        return HouseMapper.INSTANCE.toDto(house);
    }
}
