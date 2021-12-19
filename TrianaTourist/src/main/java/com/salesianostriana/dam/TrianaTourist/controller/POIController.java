package com.salesianostriana.dam.TrianaTourist.controller;

import com.salesianostriana.dam.TrianaTourist.dto.POIDto.CreatePOIDto;
import com.salesianostriana.dam.TrianaTourist.dto.POIDto.GetPOIDto;
import com.salesianostriana.dam.TrianaTourist.dto.POIDto.POIDtoConverter;
import com.salesianostriana.dam.TrianaTourist.model.POI;
import com.salesianostriana.dam.TrianaTourist.service.POIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/poi")
public class POIController {

    private final POIService poiService;
    private final POIDtoConverter poiDtoConverter;

    @GetMapping("/")
    public ResponseEntity<List<POI>> findAll(){

        return ResponseEntity.ok().body(poiService.findAll());

    }
    @GetMapping("/{id}")
    public ResponseEntity<GetPOIDto> findOne(@PathVariable Long id){

        Optional<POI> poi= poiService.findOne(id);

        return ResponseEntity.ok().body(poiDtoConverter.POIToGetPOIDto(poi.get()));

    }
    @PostMapping("/")
    public ResponseEntity<GetPOIDto> create(@Valid @RequestBody CreatePOIDto dto){

        POI poi = poiDtoConverter.createPOIDtoToPOI(dto);

        poiService.save(poi);

        GetPOIDto poiDto = poiDtoConverter.POIToGetPOIDto(poi);

        return ResponseEntity.status(HttpStatus.CREATED).body(poiDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){

        poiService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<POI> edit(@PathVariable("id") Long id, @Valid @RequestBody CreatePOIDto createPOIDto){

        return poiService.edit(id, createPOIDto);


    }



}

