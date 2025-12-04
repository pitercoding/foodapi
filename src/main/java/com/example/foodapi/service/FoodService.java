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

    public void deleteById(Long id) {foodRepository.deleteById(id);}

    public Food updateById(Long id, Food food) {
        return foodRepository.findById(id)
                .map(existing -> {
                    existing.setName(food.getName());
                    existing.setExpirationDate(food.getExpirationDate());
                    existing.setQuantity(food.getQuantity());
                    return foodRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Food not found with id " + id));
    }
}
