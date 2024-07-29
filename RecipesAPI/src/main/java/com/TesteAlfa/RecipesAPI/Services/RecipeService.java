package com.TesteAlfa.RecipesAPI.Services;

import com.TesteAlfa.RecipesAPI.Entities.RecipeResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RecipeService {

    private final String API_URL = "https://forkify-api.herokuapp.com/api/search?q=";

    public RecipeResponse getRecipes(String ingredient) {
        RestTemplate restTemplate = new RestTemplate();
        String url = API_URL + ingredient;
        return restTemplate.getForObject(url, RecipeResponse.class);
    }
}