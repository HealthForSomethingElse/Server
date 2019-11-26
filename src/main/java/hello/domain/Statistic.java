package hello.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Statistic
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private int height;
    private int weight;
    private int stepsAmount;
    private int caloriesLost;
    private float distanceTraveled;
    private int drunkWaterGlasses;
    private enum exerciseName
    {
        Ilya,
        Jirniy
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getStepsAmount() {
        return stepsAmount;
    }

    public void setStepsAmount(int stepsAmount) {
        this.stepsAmount = stepsAmount;
    }

    public int getCaloriesLost() {
        return caloriesLost;
    }

    public void setCaloriesLost(int caloriesLost) {
        this.caloriesLost = caloriesLost;
    }

    public float getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(float distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public int getDrunkWaterGlasses() {
        return drunkWaterGlasses;
    }

    public void setDrunkWaterGlasses(int drunkWaterGlasses) {
        this.drunkWaterGlasses = drunkWaterGlasses;
    }
}
