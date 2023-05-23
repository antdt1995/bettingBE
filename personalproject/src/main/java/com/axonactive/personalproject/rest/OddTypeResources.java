package com.axonactive.personalproject.rest;

import com.axonactive.personalproject.rest.admin.OddTypeApi;
import com.axonactive.personalproject.service.OddTypeService;
import com.axonactive.personalproject.service.dto.OddTypeDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OddTypeResources implements OddTypeApi {
    private final OddTypeService oddTypeService;

    @Override
    public ResponseEntity<List<OddTypeDto>> getAllOddType() {
       return ResponseEntity.ok(oddTypeService.getAllOddType());
    }

    @Override
    public ResponseEntity<OddTypeDto> findOddTypeById(Long id) {
        return ResponseEntity.ok(oddTypeService.findOddTypeById(id));
    }

    @Override
    public ResponseEntity<Void> deleteOddTypeById(Long id) {
        log.info("Delete odd type {}",id);
        oddTypeService.deleteOddTypeById(id);
        return ResponseEntity.noContent().header("Odd Type has been delete").build();
    }

    @Override
    public ResponseEntity<OddTypeDto> createOddType(OddTypeDto oddTypeDto) {
        OddTypeDto oddTypeDto1=oddTypeService.createOddType(oddTypeDto);
        return ResponseEntity.created(URI.create("/bet/oddtypes/"+oddTypeDto.getId())).body(oddTypeDto1);
    }

    @Override
    public ResponseEntity<OddTypeDto> updateOddType(OddTypeDto oddTypeDto, Long id) {
        return ResponseEntity.ok().body(oddTypeService.updateOddType(oddTypeDto,id));
    }
}
