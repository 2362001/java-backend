package edu.poly.demo2.controllers;


import edu.poly.demo2.dtos.CategoryDTO;
import edu.poly.demo2.models.Category;
import edu.poly.demo2.responses.ResponseObject;
import edu.poly.demo2.services.categori.CategoriService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/categories")

public class CategoryController {
    private final CategoriService categoriService;

    @PostMapping("")
    public ResponseEntity<String> createCategory(
           ) {

        return ResponseEntity.ok("hello");
    }

    @GetMapping("")
    public ResponseEntity<ResponseObject> getAllCategories(
            @RequestParam("page")     int page,
            @RequestParam("limit")    int limit
    ) {
        List<Category> categories = categoriService.getAllCategories();
        /*
        this.kafkaTemplate.executeInTransaction(status -> {
            categories.forEach(category -> kafkaTemplate.send("get-all-categories", category));
            return null;
        });
         */
        return ResponseEntity.ok(ResponseObject.builder()
                .message("Get list of categories successfully")
                .status(HttpStatus.OK)
                .data(categories)
                .build());
    }
}
