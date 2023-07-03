package com.trip.tripinworld;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trip.tripinworld.studentEX.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
class TripInWorldBackendApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void contextLoads() {
    }

    // Student 저장 테스트 참고용
    @Test
    public void saveTest() throws Exception {
        Student student = new Student();
        student.setName("George");
        student.setAddress("Lavender Street");

        this.mockMvc
                .perform(post("/student")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("George"))
                .andExpect(jsonPath("$.address").value("Lavender Street"))
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andReturn();
    }

}
