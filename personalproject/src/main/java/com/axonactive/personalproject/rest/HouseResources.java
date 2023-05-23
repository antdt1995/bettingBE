package com.axonactive.personalproject.rest;

import com.axonactive.personalproject.rest.admin.HouseApi;
import com.axonactive.personalproject.service.HouseService;
import com.axonactive.personalproject.service.dto.HouseDto;
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
public class HouseResources implements HouseApi {
    private final HouseService houseService;

    @Override
    public ResponseEntity<List<HouseDto>> getAllHouse() {
       log.info("get all house");
        return ResponseEntity.ok(houseService.getAllHouse());
    }

    @Override
    public ResponseEntity<HouseDto> findHouseById(Long id) {
        log.info("get house by id");
        return ResponseEntity.ok(houseService.findHouseById(id));
    }

    @Override
    public ResponseEntity<Void> deleteHouseById(Long id) {
        log.info("delete house id {}", id);
        houseService.deleteHouseById(id);
        return ResponseEntity.noContent().header("DeleteSuccess","Delete house success").build();
    }

    @Override
    public ResponseEntity<HouseDto> createHouse(HouseDto houseDto) {
        HouseDto houseDto1=houseService.createHouse(houseDto);
        return ResponseEntity.created(URI.create("/bet/houses/"+houseDto.getId())).body(houseDto1);
    }

    @Override
    public ResponseEntity<HouseDto> updateHouse(HouseDto houseDto, Long id) {
        return ResponseEntity.ok().body(houseService.updateHouse(houseDto,id));
    }
}
