package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FoodDaoImpl {
    private static List<Map<String, Object>> db = new ArrayList<>();

    public static void addFood(Map<String, Object> food) {
        db.add(food);
    }

    public static List<Map<String, Object>> getAllFood() {
        return db;
    }

    public static Map<String, Object> getFoodByName(String foodName) {
        for (Map<String, Object> food_map : db) {
            if (foodName.equals(food_map.get("foodName"))){
                return food_map;
            }
        }
        return null;
    }

    public static void updateFood(Map<String, Object> food) {
        // 移除 db 中原来的 food_map，再将新的 food 对象加入 db
        for (Map<String, Object> food_map : db) {
            if (food.get("id").equals(food_map.get("id"))){
                db.remove(food_map);
                break;
            }
        }
        db.add(food);
    }

    public static void deleteFoodById(String id) {
        for (Map<String, Object> food_map : db) {
            if (id.equals(food_map.get("id"))){
                db.remove(food_map);
                break;
            }
        }
    }

}
