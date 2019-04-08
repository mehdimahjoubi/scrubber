package com.mmahjoubi.scrubber;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {

    @Autowired
    private HomeController homeController;

    @Autowired
    private ScrubApiController scrubApiController;

    @Test
    public void contexLoads() throws Exception {
        assertThat(homeController).isNotNull();
        assertThat(scrubApiController).isNotNull();
    }
}