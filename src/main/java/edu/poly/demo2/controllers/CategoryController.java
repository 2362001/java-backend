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
    public ResponseEntity<ResponseObject> createCategory(
            @Valid @RequestBody CategoryDTO categoryDTO,
            BindingResult result) {
        if(result.hasErrors()) {
            List<String> errorMessages = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.ok().body(ResponseObject.builder()
                    .message(errorMessages.toString())
                    .status(HttpStatus.BAD_REQUEST)
                    .data(null)
                    .build());

        }
        Category category = categoriService.createCategory(categoryDTO);
        return ResponseEntity.ok().body(ResponseObject.builder()
                .message("Create category successfully")
                .status(HttpStatus.OK)
                .data(category)
                .build());
    }

    @GetMapping("get")
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
