package com.salesianostriana.dam.TrianaTourist.service;

import com.salesianostriana.dam.TrianaTourist.dto.POIDto.CreatePOIDto;
import com.salesianostriana.dam.TrianaTourist.errores.excepciones.ListEntityNotFoundException;
import com.salesianostriana.dam.TrianaTourist.errores.excepciones.SingleEntityNotFoundException;
import com.salesianostriana.dam.TrianaTourist.model.Category;
import com.salesianostriana.dam.TrianaTourist.model.POI;
import com.salesianostriana.dam.TrianaTourist.repository.CategoryRepository;
import com.salesianostriana.dam.TrianaTourist.repository.POIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class POIService {

    private final POIRepository poiRepository;
    private final CategoryRepository categoryRepository;


    public List<POI> findAll(){

        if (poiRepository.findAll().isEmpty()){
            throw new ListEntityNotFoundException(POI.class);
        }
            return poiRepository.findAll();
    }
    public Optional<POI> findOne(Long id){

        if (poiRepository.findById(id).isEmpty()){
            throw new SingleEntityNotFoundException(POI.class,id.toString());
        }
            return poiRepository.findById(id);
    }
    public void deleteById(Long id){
        if (poiRepository.findById(id).isEmpty()){
            throw new SingleEntityNotFoundException(POI.class, id.toString());
        }
            poiRepository.deleteById(id);

    }

    public void savePOI (POI poi){

        poiRepository.save(poi);
    }

    public ResponseEntity<POI> editPOI(Long id, CreatePOIDto dto) {

        Optional<POI> POI = poiRepository.findById(id);

        if (POI.isEmpty()) {
            throw new SingleEntityNotFoundException(Category.class,id.toString());
        }
            return ResponseEntity.of(poiRepository.findById(id).map(
                   x -> {
                       x.setName(dto.getName());
                       x.setLocation(dto.getLocation());
                       x.setDescription(dto.getDescription());
                       x.setDate(dto.getDate());
                       x.setCategory(categoryRepository.findById(dto.getCategory()).get());
                       x.setCoverPhoto(dto.getCoverPhoto());
                       x.setPhoto2(dto.getPhoto2());
                       x.setPhoto3(dto.getPhoto3());
                        poiRepository.save(x);
                        return x;
                    }
            ));
        }

    }

