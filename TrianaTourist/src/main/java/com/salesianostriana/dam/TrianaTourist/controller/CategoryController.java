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
    public ResponseEntity<Category> create(@Valid @RequestBody CreateCategoryDto dto){

        return categoryService.saveCategory(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> edit(@Valid @RequestBody CreateCategoryDto dto, @PathVariable("id") Long id){

        return categoryService.editCategory(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){

        return  categoryService.deleteCategory(id);
    }

}
