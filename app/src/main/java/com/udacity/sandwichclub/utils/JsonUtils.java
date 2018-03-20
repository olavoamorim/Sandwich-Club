package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject file = new JSONObject(json);
            JSONObject name = file.getJSONObject("name");
            String mainName = name.getString("mainName");
            String placeOfOrigin = file.getString("placeOfOrigin");
            String description = file.getString("description");
            String image = file.getString("image");

            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
            ArrayList<String> alsoKnownAsList = new ArrayList<>();
            for(int i=0; i<alsoKnownAs.length(); i++){
                alsoKnownAsList.add(alsoKnownAs.getString(i));
            }

            JSONArray ingredients = file.getJSONArray("ingredients");
            ArrayList<String> ingredientsList = new ArrayList<>();
            for(int i=0; i<ingredients.length(); i++){
                ingredientsList.add(ingredients.getString(i));
            }

            return new Sandwich(mainName, alsoKnownAsList, placeOfOrigin, description, image, ingredientsList);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}