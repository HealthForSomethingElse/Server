package hello.domain;

import javax.persistence.*;

@Entity
@Table(name = "statistic")
public class Statistic
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private int stepsAmount;
    private int caloriesLost;
    private float distanceTraveled;
    private int drunkWaterGlasses;
    private String exerciseName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }
}
