package com.zensar.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zensar.beans.Now;

public class NowCustomSerializer extends JsonDeserializer<Now> {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*@Override
    public Now deserialize(
            final JsonParser jp, final DeserializationContext ctxt)
            throws IOException {
        final ObjectMapper mapper = (ObjectMapper) ctxt.findInjectableValue(
                ObjectMapper.class.getName(),
                null,
                null);
        final String json = jp.getValueAsString();
        System.out.println(json);
        return mapper.readValue(json, Now.class);
    }*/

  

    @Override
    public Now deserialize(JsonParser jsonParser, DeserializationContext
            deserializationContext) throws IOException {
    	String text = jsonParser.getText();
    	Now now = new Now();
    	if(!text.startsWith("{")) {
    		now.setFrom(Double.parseDouble(text));
    		now.setTo(0.0);
    		return now;
    	} else {
    		jsonParser.nextTextValue();
    		now.setFrom(Double.parseDouble(jsonParser.nextTextValue()));
    		jsonParser.nextTextValue();
    		now.setTo(Double.parseDouble(jsonParser.nextTextValue()));
    	}
    	
    	 return now;
        
    }
 
   
}