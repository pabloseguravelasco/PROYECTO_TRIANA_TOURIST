package com.salesianostriana.dam.TrianaTourist.controller;

import com.salesianostriana.dam.TrianaTourist.dto.CategoryDto.CreateCategoryDto;
import com.salesianostriana.dam.TrianaTourist.dto.CategoryDto.GetCategoryDto;
import com.salesianostriana.dam.TrianaTourist.model.Category;
import com.salesianostriana.dam.TrianaTourist.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.apache.tomcat.jni.Mmap.delete;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<List<GetCategoryDto>> findAll(){

        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<GetCategoryDto>> findOne(@PathVariable("id") Long id){

        return categoryService.findById(id);
    }
    @PostMapping("/")
    public ResponseEntity<Category> create(@Valid @RequestBody CreateCategoryDto createCategoryDto){

        return categoryService.save(createCategoryDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> edit(@Valid @RequestBody CreateCategoryDto categoryDto, @PathVariable("id") Long id){

        return categoryService.edit(id, categoryDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){

        return  categoryService.delete(id);
    }

}
