package com.TesteAlfa.RecipesAPI.Controllers;

import com.TesteAlfa.RecipesAPI.Entities.RecipeResponse;
import com.TesteAlfa.RecipesAPI.Services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping("/recipes")
    public RecipeResponse getRecipes(@RequestParam String ingredient){
        return recipeService.getRecipes(ingredient);
    }
}
