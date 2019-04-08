package com.mmahjoubi.scrubber;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AlphaNumScrubbingService implements ScrubbingService {
	
	private static final Pattern ALPHANUM = Pattern.compile("[^a-zA-Z0-9]+");
	
	private Logger logger = LoggerFactory.getLogger(AlphaNumScrubbingService.class);

	@Override
	public String scrub(String text) {
		String scrubbed = ALPHANUM.matcher(text).replaceAll("");
		logger.info("Scrubbed input: {}", scrubbed);		
		return scrubbed;
	}

}
