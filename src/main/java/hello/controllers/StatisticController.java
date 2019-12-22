package hello.controllers;

import hello.helpers.StatisticService;
import hello.helpers.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticController {

    private StatisticService statisticService;

    @Autowired
    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }


    @PostMapping("/user/add")
    public String add(@RequestBody String inputJson){
        System.out.println(inputJson);
        return statisticService.statisticAdd(inputJson);
    }

    @PostMapping("/user/get")
    public String get(@RequestBody String outputJson) {
        System.out.println(outputJson);
        return statisticService.statisticAdd(outputJson);
    }

}