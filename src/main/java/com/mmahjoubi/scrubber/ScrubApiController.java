package com.mmahjoubi.scrubber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ScrubApiController {
	
	@Autowired
	private ScrubbingService scrubbingingService;
	    
    @PostMapping("/scrub")
    @ResponseBody
    public InputForm scrub(@RequestBody InputForm inputForm) {
        scrubbingingService.scrub(inputForm.getTextField());
        return inputForm;
    }
    
}
