package hello.helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import hello.domain.User;
import hello.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    private Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    public String userAdd(String inputJson) {
        User user = gson.fromJson(inputJson, User.class);
        User userInDb = userRepository.findByEmail(user.getEmail());
        String message;
        Integer status;
        Integer userId;
        if(userInDb == null) {
            userRepository.save(user);
            message = "User saved";
            status = Status.OK_STATUS.getStatusCode();
            userId = userRepository.findByEmail(user.getEmail()).getId();
            return  getJsonString(message, status, userId);
        }else{
            message = "User already exist";
            status = Status.BAD_STATUS.getStatusCode();
        }
        return getJsonString(message, status);
    }


    public String userGet(String outputJson) {
        User user = gson.fromJson(outputJson,User.class);
        String message = "user does not exist";
        Integer status = Status.BAD_STATUS.getStatusCode();
        if(userRepository.existsUserByEmail(user.getEmail())){
            user = userRepository.findByEmail(user.getEmail());
            status = Status.OK_STATUS.getStatusCode();
            message = "user exists";
            return getJsonStringWithUser(user, message, status);
        }
        else
        {
            status = Status.BAD_STATUS.getStatusCode();
            message = "user not exist";
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

    private String getJsonString(String message, Integer status, Integer id) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("status",status);
        jsonObject.addProperty("message",message);
        jsonObject.addProperty("id", id);
        String jsonToClient = jsonObject.toString();

        return jsonToClient;
    }

    private String getJsonStringWithUser(User user, String message, Integer status) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("status",status);
        jsonObject.addProperty("message",message);

        jsonObject.add("user",gson.toJsonTree(user));
        String jsonToClient = jsonObject.toString();

        return jsonToClient;
    }
}
