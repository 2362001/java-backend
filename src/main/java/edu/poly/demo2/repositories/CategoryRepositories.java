package edu.poly.demo2.repositories;

import edu.poly.demo2.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositories extends JpaRepository<Category, Long> {
}
