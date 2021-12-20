package com.salesianostriana.dam.TrianaTourist.service;

import com.salesianostriana.dam.TrianaTourist.dto.CategoryDto.CategoryDtoConverter;
import com.salesianostriana.dam.TrianaTourist.dto.CategoryDto.CreateCategoryDto;
import com.salesianostriana.dam.TrianaTourist.dto.CategoryDto.GetCategoryDto;
import com.salesianostriana.dam.TrianaTourist.errores.excepciones.ListEntityNotFoundException;
import com.salesianostriana.dam.TrianaTourist.errores.excepciones.SingleEntityNotFoundException;
import com.salesianostriana.dam.TrianaTourist.model.Category;
import com.salesianostriana.dam.TrianaTourist.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {


    private final CategoryRepository categoryRepository;
    private final CategoryDtoConverter categoryDtoConverter;


    public ResponseEntity<List<GetCategoryDto>> findAll() {

        List<Category> listaCategory = categoryRepository.findAll();

        if (listaCategory.isEmpty()) {
            throw new ListEntityNotFoundException(Category.class);
        }
            List<GetCategoryDto> result = listaCategory
                    .stream()
                    .map(categoryDtoConverter::categoryToGetCategoryDto)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(result);
        }


    public ResponseEntity<List<GetCategoryDto>> findById(Long id) {

        Optional<Category> category = categoryRepository.findById(id);

        if (category.isEmpty()) {
            throw new SingleEntityNotFoundException(Category.class, id.toString());
        }
            List<GetCategoryDto> result = category
                    .stream()
                    .map(categoryDtoConverter::categoryToGetCategoryDto)
                    .collect(Collectors.toList());

            return ResponseEntity.ok().body(result);
        }

    public ResponseEntity<Category> saveCategory(CreateCategoryDto dto) {

        Category nuevaCategory = categoryDtoConverter.createCategoryDtoToCategory(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(categoryRepository.save(nuevaCategory));
    }

    public ResponseEntity<Category> editCategory(Long id, CreateCategoryDto dto) {

        Optional<Category> category = categoryRepository.findById(id);

        if (category.isEmpty()) {
            throw new SingleEntityNotFoundException(Category.class, id.toString());
        }
            return ResponseEntity.of(categoryRepository.findById(id).map(
                    x -> {
                        x.setName(dto.getName());
                        categoryRepository.save(x);
                        return x;
                    }
            ));
        }

    public ResponseEntity<?> deleteCategory(Long id) {

        Optional<Category> category = categoryRepository.findById(id);

        if (category.isEmpty()) {
            throw new SingleEntityNotFoundException(Category.class, id.toString());
        }
            categoryRepository.deleteById(id);
            return ResponseEntity.status(204).build();
        }
    }

