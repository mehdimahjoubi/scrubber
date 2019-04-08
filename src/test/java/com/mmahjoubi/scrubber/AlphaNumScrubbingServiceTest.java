package com.mmahjoubi.scrubber;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AlphaNumScrubbingServiceTest {

	@Autowired
	private ScrubbingService scrubbingingService;
	
	@Test
	public void shouldScrub() throws Exception {
		assertThat(scrubbingingService.scrub("Test123 @$$ - -=="), equalTo("Test123"));
	}
}
