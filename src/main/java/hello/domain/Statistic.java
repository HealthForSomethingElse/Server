package hello.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "statistic", schema = "public")
public class Statistic
{
    @Id
    private Date date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;

    private Integer stepsAmount;
    private Integer caloriesLost;
    private Float distanceTraveled;
    private Integer drunkWaterGlasses;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getStepsAmount() {
        return stepsAmount;
    }

    public void setStepsAmount(int stepsAmount) {
        this.stepsAmount = stepsAmount;
    }

    public Integer getCaloriesLost() {
        return caloriesLost;
    }

    public void setCaloriesLost(int caloriesLost) {
        this.caloriesLost = caloriesLost;
    }

    public Float getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(float distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public Integer getDrunkWaterGlasses() {
        return drunkWaterGlasses;
    }

    public void setDrunkWaterGlasses(int drunkWaterGlasses) {
        this.drunkWaterGlasses = drunkWaterGlasses;
    }
}
