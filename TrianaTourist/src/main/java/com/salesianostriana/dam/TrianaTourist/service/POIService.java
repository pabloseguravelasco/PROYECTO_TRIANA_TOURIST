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
        }else{
            return poiRepository.findAll();
        }
    }
    public Optional<POI> findOne(Long id){
        if (poiRepository.findById(id).isEmpty()){
            throw new SingleEntityNotFoundException(POI.class,id.toString());
        }else {
            return poiRepository.findById(id);
        }
    }
    public void deleteById(Long id){
        if (poiRepository.findById(id).isEmpty()){
            throw new SingleEntityNotFoundException(POI.class, id.toString());
        }else{
            poiRepository.deleteById(id);
        }
    }

    public void save (POI poi){
        poiRepository.save(poi);
    }

    public ResponseEntity<POI> edit(Long id, CreatePOIDto poi) {

        Optional<POI> data = poiRepository.findById(id);

        if (data.isEmpty()) {
            throw new SingleEntityNotFoundException(Category.class,id.toString());
        } else {
            return ResponseEntity.of(poiRepository.findById(id).map(
                    m -> {
                        m.setName(poi.getName());
                        m.setLocation(poi.getLocation());
                        m.setDescription(poi.getDescription());
                        m.setDate(poi.getDate());
                        m.setCategory(categoryRepository.findById(poi.getCategory()).get());
                        m.setCoverPhoto(poi.getCoverPhoto());
                        m.setPhoto2(poi.getPhoto2());
                        m.setPhoto3(poi.getPhoto3());
                        poiRepository.save(m);
                        return m;
                    }
            ));
        }


    }



}