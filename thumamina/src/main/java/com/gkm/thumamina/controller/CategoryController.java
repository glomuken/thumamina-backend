package com.gkm.thumamina.controller;

import com.gkm.thumamina.model.dto.CategoryDto;
import com.gkm.thumamina.model.entity.Category;
import com.gkm.thumamina.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
@RequiredArgsConstructor
@Tag(name = "Categories API")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    @Operation(summary = "Get all categories")
    public List<Category> getAll(){
        return categoryService.getAllCategories();
    }

    @GetMapping("{id}")
    @Operation
    private Category getById(@PathVariable Long id){
        return categoryService.getCategory(id);
    }

    @PostMapping
    @Operation(summary = "Add category")
    public CategoryDto addCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.saveCategory(categoryDto);
    }

    @DeleteMapping("delete/{id}")
    @Operation(summary = "delete Category")
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}
