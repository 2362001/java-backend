package edu.poly.demo2.services.categori;

import edu.poly.demo2.dtos.CategoryDTO;
import edu.poly.demo2.models.Category;
import edu.poly.demo2.repositories.CategoryRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriService implements  ICategoriService{
    private final CategoryRepositories categoryRepositories;

    @Override
    @Transactional
    public Category createCategory(CategoryDTO categoryDTO) {
        Category newCategory = Category
                .builder()
                .name(categoryDTO.getName())
                .build();
        return categoryRepositories.save(newCategory);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepositories.findAll();
    }

}
