package org.learning.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserserviceApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getUesrs() throws Exception {
        mvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET, "/users").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getUser() throws Exception {
        mvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET, "/user/1")).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\n" +
                        "    \"user\": {\n" +
                        "        \"id\": 1,\n" +
                        "        \"name\": \"Leanne Graham\",\n" +
                        "        \"username\": \"Bret\",\n" +
                        "        \"email\": \"Sincere@april.biz\",\n" +
                        "        \"address\": {\n" +
                        "            \"id\": 1,\n" +
                        "            \"street\": \"Kulas Light\",\n" +
                        "            \"suite\": \"Apt. 556\",\n" +
                        "            \"city\": \"Gwenborough\",\n" +
                        "            \"zipcode\": \"92998-3874\"\n" +
                        "        },\n" +
                        "        \"phone\": \"1-770-736-8031 x56442\",\n" +
                        "        \"website\": \"hildegard.org\",\n" +
                        "        \"company\": {\n" +
                        "            \"id\": 1,\n" +
                        "            \"name\": \"Romaguera-Crona\",\n" +
                        "            \"catchPhrase\": \"Multi-layered client-server neural-net\",\n" +
                        "            \"business\": \"harness real-time e-markets\"\n" +
                        "        }\n" +
                        "    },\n" +
                        "    \"_links\": {\n" +
                        "        \"self\": {\n" +
                        "            \"href\": \"http://localhost/user/1\"\n" +
                        "        }\n" +
                        "    }\n" +
                        "}"));
    }
}
