package com.example.usersdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// Test bijarreb el CRUD kello: create, read, update, delete
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void fullCrudFlow() throws Exception {
        String body = """
                {"name":"Ali","email":"ali@test.com","password":"secret123"}
                """;

        // CREATE
        mvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Ali"))
                .andExpect(jsonPath("$.password").doesNotExist()); // encapsulation ✅

        // Nafs el email marra tenye => 409
        mvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(status().isConflict());

        // READ
        mvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));

        // UPDATE
        mvc.perform(put("/api/users/1").contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"name":"Ali Hassan","email":"ali@test.com","password":"secret123"}
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Ali Hassan"));

        // VALIDATION: email ghalat => 400
        mvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"name":"X","email":"mesh-email","password":"123"}
                                """))
                .andExpect(status().isBadRequest());

        // DELETE
        mvc.perform(delete("/api/users/1"))
                .andExpect(status().isNoContent());

        // Ba3d el delete => 404
        mvc.perform(get("/api/users/1"))
                .andExpect(status().isNotFound());
    }
}
