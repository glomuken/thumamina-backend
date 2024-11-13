package com.gkm.thumamina.service;

import com.gkm.thumamina.exception.RecordNotFoundException;
import com.gkm.thumamina.model.dto.CategoryDto;
import com.gkm.thumamina.model.entity.Category;
import com.gkm.thumamina.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public CategoryDto saveCategory(CategoryDto categoryDto){
        Category category = new Category();
        category.setDescription(categoryDto.getDescription());
        category.setName(categoryDto.getName());
        categoryRepository.save(category);
        return categoryDto;
    }

    public Category getCategory(Long id){
        return categoryRepository.findById(id).orElseThrow(()->new RecordNotFoundException("Category not found"));
    }

    public void deleteCategory(Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(()->new RecordNotFoundException("Category not found"));
        category.setIsDeleted(true);
        categoryRepository.save(category);
    }
}