package edu.poly.demo2.services.categori;

import edu.poly.demo2.dtos.CategoryDTO;
import edu.poly.demo2.models.Category;

import java.util.List;

public interface ICategoriService {
    Category createCategory(CategoryDTO category);
    List<Category> getAllCategories();
}
