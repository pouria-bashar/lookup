package com.pba.lookup.response;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

public class JsonResponse extends ResourceSupport  {

	 private final String content;

	    @JsonCreator
	    public JsonResponse(@JsonProperty("content") String content) {
	        this.content = content;
	    }

	    public String getContent() {
	        return content;
	    }
	
	
}
