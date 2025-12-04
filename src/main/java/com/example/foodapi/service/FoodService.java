package com.example.foodapi.service;

import com.example.foodapi.model.Food;
import com.example.foodapi.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> getAll() {return foodRepository.findAll();}

    public Food save(Food food) {return foodRepository.save(food);}

    public void delete(Long id) {foodRepository.deleteById(id);}
}
