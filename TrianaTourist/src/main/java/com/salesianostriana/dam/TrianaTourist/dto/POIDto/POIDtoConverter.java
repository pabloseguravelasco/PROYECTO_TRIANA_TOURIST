package com.salesianostriana.dam.TrianaTourist.dto.POIDto;

import com.salesianostriana.dam.TrianaTourist.dto.POIDto.CreatePOIDto;
import com.salesianostriana.dam.TrianaTourist.dto.POIDto.GetPOIDto;
import com.salesianostriana.dam.TrianaTourist.model.Category;
import com.salesianostriana.dam.TrianaTourist.model.POI;
import com.salesianostriana.dam.TrianaTourist.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class POIDtoConverter {

    private final CategoryRepository categoryRepository;

    public POI createPOIDtoToPOI(CreatePOIDto dto){
        return POI.builder()
                .id(dto.getId())
                .name(dto.getName())
                .location(dto.getLocation())
                .description(dto.getDescription())
                .date(dto.getDate())
                .category(categoryRepository.findById(dto.getCategory()).get())
                .coverPhoto(dto.getCoverPhoto())
                .photo2(dto.getPhoto2())
                .photo3(dto.getPhoto3())
                .build();
    }

    public GetPOIDto POIToGetPOIDto(POI poi){
        return GetPOIDto.builder()
                .id(poi.getId())
                .name(poi.getName())
                .location(poi.getLocation())
                .date(poi.getDate())
                .category(poi.getCategory())
                .coverPhoto(poi.getCoverPhoto())
                .photo2(poi.getPhoto2())
                .photo3(poi.getPhoto3())
                .build();



    }
}
