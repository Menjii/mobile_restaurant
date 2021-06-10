package pl.pwsztar.mobilerestaurant.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import pl.pwsztar.mobilerestaurant.model.dtos.FoodDto;
import pl.pwsztar.mobilerestaurant.model.dtos.LoginResponse;
import pl.pwsztar.mobilerestaurant.model.dtos.ProductDto;
import pl.pwsztar.mobilerestaurant.model.dtos.ShoppingCard;

public class ShoppingCardUtils {
    private static final String SHOPPING_CARD_KEY = "SHOPPING_CARD";
    public static ShoppingCard getItems(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(SHOPPING_CARD_KEY, null);
        if( json == null ) {
            clear(context);
            return new ShoppingCard();
        }
        return gson.fromJson(json, ShoppingCard.class);
    }

    public static int getSize(Context context) {
//        clear(context);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(SHOPPING_CARD_KEY, null);
        if( json == null ) {
            clear(context);
            return 0;
        }
        return gson.fromJson(json, ShoppingCard.class).getItems().size();
    }

    public static void addItem(Context context, FoodDto item) {
        ShoppingCard card = getItems(context);
        boolean exist = false;
        for( ProductDto product : card.getItems() ) {
            if( product.getFood().getId() == item.getId() ) {
                product.setCount(product.getCount() + 1);
                exist = true;
                break;
            }
        }

        if( !exist ) {
            ProductDto newProduct = new ProductDto();
            newProduct.setFood(item);
            card.getItems().add(newProduct);
        }

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(card);
        prefsEditor.putString(SHOPPING_CARD_KEY, json);
        prefsEditor.apply();
    }

    public static void removeItem(Context context, FoodDto item) {
        ShoppingCard card = getItems(context);
        for( ProductDto product : card.getItems() ) {
            if( product.getFood().getId() == item.getId() ) {
                product.setCount(product.getCount() - 1);
                if( product.getCount() == 0 ) {
                    card.getItems().remove(product);
                }
                break;
            }
        }

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(card);
        prefsEditor.putString(SHOPPING_CARD_KEY, json);
        prefsEditor.apply();
    }

    public static void clear(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(new ShoppingCard());
        prefsEditor.putString(SHOPPING_CARD_KEY, json);
        prefsEditor.apply();
    }
}
