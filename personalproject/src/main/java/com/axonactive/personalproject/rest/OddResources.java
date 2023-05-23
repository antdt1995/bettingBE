package com.axonactive.personalproject.rest;

import com.axonactive.personalproject.rest.admin.OddApi;
import com.axonactive.personalproject.service.OddService;
import com.axonactive.personalproject.service.customDto.OddCustomDto;
import com.axonactive.personalproject.service.dto.OddDto;
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
public class OddResources implements OddApi {
    private final OddService oddService;

    @Override
    public ResponseEntity<List<OddCustomDto>> getAllOdd() {
        return ResponseEntity.ok(oddService.getAllOdd());
    }

    @Override
    public ResponseEntity<OddCustomDto> findOddById(Long id) {
        return ResponseEntity.ok(oddService.findOddById(id));
    }

    @Override
    public ResponseEntity<Void> deleteOddById(Long id) {
        oddService.deleteOddById(id);
        return ResponseEntity.noContent().header("Odd has been deleted").build();
    }

    @Override
    public ResponseEntity<OddCustomDto> createOdd(OddDto oddDto, Long matchId, Long typeId) {
        OddCustomDto oddCustomDto=oddService.createOdd(oddDto,matchId,typeId);
        return ResponseEntity.created(URI.create("/bet/odds/"+oddDto.getId())).body(oddCustomDto);
    }

    @Override
    public ResponseEntity<OddCustomDto> updateOdd(OddDto oddDto, Long id) {
        OddCustomDto oddCustomDto=oddService.updateOdd(oddDto,id);
        return ResponseEntity.ok().body(oddCustomDto);
    }
}
