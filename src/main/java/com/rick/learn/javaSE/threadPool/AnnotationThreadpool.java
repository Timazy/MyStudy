package com.rick.learn.javaSE.threadPool;

import java.io.IOException;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/*
*	@author : Rick
*	@date : May 9, 2019
*	
*/
@EnableScheduling
public class AnnotationThreadpool {

	@Scheduled(fixedRate = 1000)
	public void job() {
		System.out.print("scheduled once");
	}
	
}
