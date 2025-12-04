package com.example.foodapi.controller;

import com.example.foodapi.model.Food;
import com.example.foodapi.service.FoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    // -------- CRUD -------- //

    //CREATE
    @PostMapping
    public Food create(@RequestBody Food food) {
        return foodService.save(food);
    }

    //READ
    @GetMapping
    public List<Food> getAll() {
        return foodService.getAll();
    }

    //UPDATE
    @PutMapping("/{id}")
    public Food updateById(@PathVariable Long id, @RequestBody Food food) {
        return foodService.updateById(id, food);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        foodService.deleteById(id);
    }

}
