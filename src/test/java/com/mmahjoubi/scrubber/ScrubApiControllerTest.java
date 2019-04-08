package com.mmahjoubi.scrubber;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(ScrubApiController.class)
public class ScrubApiControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private ScrubbingService scrubbingingService;

    @Test
    public void shouldReturnTheSameJson() throws Exception {
        this.mockMvc.perform(post("/api/scrub")
        		.contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(new InputForm("test")))
        		.accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("textField", equalTo("test")));
    }
}