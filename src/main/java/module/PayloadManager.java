package module;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import payloads.Auth;

public class PayloadManager {


    private Auth auth;

    public String createPayload() throws JsonProcessingException {
        auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");

        ObjectMapper objectMapper = new ObjectMapper();
        String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(auth);
        System.out.println(payload);
        return payload;
    }


}
