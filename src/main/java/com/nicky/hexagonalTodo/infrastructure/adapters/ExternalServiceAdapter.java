package com.nicky.hexagonalTodo.infrastructure.adapters;

import com.nicky.hexagonalTodo.domain.models.AdditionalTaskInfo;
import com.nicky.hexagonalTodo.domain.ports.out.ExternalServicePortOut;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ExternalServiceAdapter implements ExternalServicePortOut {

    private final RestTemplate restTemplate;

    public ExternalServiceAdapter(){
        restTemplate = new RestTemplate();
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
        String apiUrl = "https://jsonplaceholder.typicode/todos/" + taskId;
        ResponseEntity<JsonPlaceHolderTodo> response = restTemplate.getForEntity(apiUrl, JsonPlaceHolderTodo.class);
        JsonPlaceHolderTodo todo = response.getBody();

        if(todo == null){
            return null;
        }

        apiUrl = "https://jsonplaceholder.typicode.com/users/" + todo.getUserId();
        ResponseEntity<JsonPlaceHolderUser> responseUser = restTemplate.getForEntity(apiUrl, JsonPlaceHolderUser.class);
        JsonPlaceHolderUser user = responseUser.getBody();

        if(user == null){
            return null;
        }

        return new AdditionalTaskInfo(user.getId(), user.getName(), user.getEmail());
    }

@Data
private static class JsonPlaceHolderTodo {
        private Long id;
        private Long userId;
}

@Data
private static class JsonPlaceHolderUser {
        private Long id;
        private String name;
        private String email;
}

}
