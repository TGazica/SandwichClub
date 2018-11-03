package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        String mainName;
        List<String> alsoKnownAs = new ArrayList<>();
        String placeOfOrigin;
        String description;
        String image;
        List<String> ingredients = new ArrayList<>();
        JSONObject sandwichJSON;
        Sandwich sandwich;

        try {
            sandwichJSON = new JSONObject(json);
            JSONObject name = sandwichJSON.getJSONObject("name");
            mainName = name.getString("mainName");
            JSONArray secondNames = name.getJSONArray("alsoKnownAs");
            for (int i = 0; i< secondNames.length(); i++){
                alsoKnownAs.add(secondNames.get(i).toString());
            }
            placeOfOrigin = sandwichJSON.getString("placeOfOrigin");
            description = sandwichJSON.getString("description");
            image = sandwichJSON.getString("image");

            JSONArray sandwichIngredients = sandwichJSON.getJSONArray("ingredients");

            for (int j = 0; j < sandwichIngredients.length(); j++){
                ingredients.add(sandwichIngredients.get(j).toString());
            }

            sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);

            return sandwich;

        } catch (JSONException e) {
            e.printStackTrace();
        }



        return null;
    }
}
