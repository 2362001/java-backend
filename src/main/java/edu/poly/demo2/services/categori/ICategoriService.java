package edu.poly.demo2.services.categori;

import edu.poly.demo2.dtos.CategoryDTO;
import edu.poly.demo2.models.Category;

import java.util.List;

public interface ICategoriService {
    Category createCategory(CategoryDTO category);
    Category getCategoryById(long id);
    List<Category> getAllCategories();
    Category updateCategory(long categoryId, CategoryDTO category);
    Category deleteCategory(long id) throws Exception;
}
