package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.entity.OddType;
import com.axonactive.personalproject.exception.ProjectException;
import com.axonactive.personalproject.repository.OddTypeRepository;
import com.axonactive.personalproject.service.OddTypeService;
import com.axonactive.personalproject.service.dto.OddTypeDto;
import com.axonactive.personalproject.service.mapper.OddTypeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.axonactive.personalproject.exception.BooleanMethod.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class OddTypeImpl implements OddTypeService {
    private final OddTypeRepository oddTypeRepository;

    @Override
    public List<OddTypeDto> getAllOddType() {
        List<OddType> oddTypes=oddTypeRepository.findAll();
        if(oddTypes.isEmpty()){
            throw ProjectException.OddTypeNotFound();
        }
        return OddTypeMapper.INSTANCE.toDtos(oddTypes);
    }

    @Override
    public OddTypeDto findOddTypeById(Long id) {
        OddType oddType=oddTypeRepository.findById(id).orElseThrow(ProjectException::OddTypeNotFound);
        return OddTypeMapper.INSTANCE.toDto(oddType);
    }

    @Override
    public void deleteOddTypeById(Long id) {
        if(id==null){
            throw ProjectException.badRequest("IdInvalid","Id cannot be null");
        }
        OddType oddType=oddTypeRepository.findById(id).orElseThrow(ProjectException::OddTypeNotFound);
        oddTypeRepository.delete(oddType);
    }

    @Override
    public OddTypeDto createOddType(OddTypeDto oddTypeDto) {
        if(!isAlphaOrNumberOrSpecial(oddTypeDto.getName())){
            throw ProjectException.badRequest("WrongFormat","Odd type should contain special character, letters, or numbers");
        }
        OddType oddType=new OddType();
        oddType.setName(oddTypeDto.getName());
        oddType=oddTypeRepository.save(oddType);
        return OddTypeMapper.INSTANCE.toDto(oddType);
    }

    @Override
    public OddTypeDto updateOddType(OddTypeDto oddTypeDto, Long id) {
        OddType oddType=oddTypeRepository.findById(id).orElseThrow(ProjectException::OddTypeNotFound);
        if(!isAlphaOrNumberOrSpecial(oddTypeDto.getName())){
            throw ProjectException.badRequest("WrongFormat","Odd type should contain special character, letters, or numbers");
        }
        oddType.setName(oddTypeDto.getName());
        oddType=oddTypeRepository.save(oddType);
        return OddTypeMapper.INSTANCE.toDto(oddType);
    }
}
