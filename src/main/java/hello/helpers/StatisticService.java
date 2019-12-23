package hello.helpers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import hello.domain.Statistic;
import hello.repos.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StatisticService {

    private final StatisticRepository statisticRepository;

    @Autowired
    public StatisticService(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    private Gson gson = new Gson();

    public String statisticAdd(String inputJson) {
        Statistic statisticFromClient = gson.fromJson(inputJson, Statistic.class);
        String message;
        Integer status;
            statisticRepository.save(statisticFromClient);
            message = "Statistic saved";
            System.out.println("statistic saved" + inputJson);
            status = Status.OK_STATUS.getStatusCode();
        return getJsonString(message, status);
    }


    public String statisticGet(String outputJson) {
        Statistic statisticFromServer = gson.fromJson(outputJson,Statistic.class);
        String message;
        Integer status;
        if(statisticRepository.existsStatisticByUserIdAndDate(statisticFromServer.getUserId(), statisticFromServer.getDate())){
            statisticFromServer = statisticRepository.findByUserIdAndDate(statisticFromServer.getUserId(), statisticFromServer.getDate());
            status = Status.OK_STATUS.getStatusCode();
            message = "User exists";
            System.out.println("user exist" + outputJson);
            return getJsonStringWithStatistic(statisticFromServer, message, status);
        }
        else
        {
            status = Status.BAD_STATUS.getStatusCode();
            message = "User not exist";
            System.out.println("user not exist" + outputJson);
        }
        return getJsonString(message, status);
    }

    private String getJsonString(String message, Integer status) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("status",status);
        jsonObject.addProperty("message",message);
        String jsonToClient = jsonObject.toString();

        return jsonToClient;
    }

    private String getJsonStringWithStatistic(Statistic statistic, String message, Integer status) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("status",status);
        jsonObject.addProperty("message",message);

        jsonObject.add("statistic",gson.toJsonTree(statistic));
        String jsonToClient = jsonObject.toString();

        return jsonToClient;
    }
}