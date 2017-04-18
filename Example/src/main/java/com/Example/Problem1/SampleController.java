package com.Example.Problem1;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	
	String template="Welcome, %s!";
	private static AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/welcomeScreen")
	public Sample welcomScreen(@RequestParam(value="name", defaultValue="User") String name){
		return new Sample(counter.incrementAndGet(), String.format(template, name));
	}
}
