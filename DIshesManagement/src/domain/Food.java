package domain;

public class Food {
    private String foodID;
    private String foodName;
    private String foodTaste;
    private String picPath;
    private String foodPrice;
    private String foodDesc;

    @Override
    public String toString() {
        return "Food{" +
                "foodID='" + foodID + '\'' +
                ", foodName='" + foodName + '\'' +
                ", foodTaste='" + foodTaste + '\'' +
                ", picPath='" + picPath + '\'' +
                ", foodPrice=" + foodPrice +
                ", foodDesc='" + foodDesc + '\'' +
                '}';
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodTaste() {
        return foodTaste;
    }

    public void setFoodTaste(String foodTaste) {
        this.foodTaste = foodTaste;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodDesc() {
        return foodDesc;
    }

    public void setFoodDesc(String foodDesc) {
        this.foodDesc = foodDesc;
    }
}
