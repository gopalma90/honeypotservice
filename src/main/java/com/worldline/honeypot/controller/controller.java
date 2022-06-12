package com.worldline.honeypot.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@RestController
@RequestMapping(value = "/")
public class controller {
	
	@GetMapping(value = "*")
	public ResponseEntity<StreamingResponseBody> handleAllGetResponse () {
	     StreamingResponseBody responseBody = response -> {
	         while(true) {
	        	 	try {
			            response.write(("Not Found \n").getBytes());
			            Thread.sleep(4000);
			            response.flush();

					} catch (InterruptedException e) {
						
					}	
	        	 	catch( Exception e) {
	        	 		
	        	 	}
	         }
	      };
	      return ResponseEntity.ok()
	            .contentType(MediaType.TEXT_PLAIN)
	            .body(responseBody);
	   }
}
