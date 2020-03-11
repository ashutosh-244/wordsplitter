package com.ashu.wordspitterandcheker.application;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ashu.wordspitterandcheker.faster.SplitingOriginalWordFaster;
import com.ashu.wordspitterandcheker.readable.SplitingOriginalWordReadable;

@SpringBootApplication
public class WordSpitterAndChekerApplication {

	public static void main(String[] args) throws IOException 
	{
		SpringApplication.run(WordSpitterAndChekerApplication.class, args);
		Instant start = Instant.now();
		 
		// new	SplitingOriginalWordReadable().splitEachWordAtEachIndexPosition();
		 
		 SplitingOriginalWordReadable slower=	 new	SplitingOriginalWordReadable();
slower.splitEachWordAtEachIndexPosition();

System.out.println(">>>>>>  slower Count>>>" +slower.getCount());


	 
	    Instant finish = Instant.now();
	 
	    long timeElapsedReadable = Duration.between(start, finish).toMillis();  //in millis
	 
	    Instant  startFaster = Instant.now();
		 
	    SplitingOriginalWordFaster faster=	 new	SplitingOriginalWordFaster();
	 faster.splitEachWordAtEachIndexPosition();


System.out.println(">>>>>>  faster Count>>>" +slower.getCount());
		 Instant  finishFaster = Instant.now();
	 
	    long timeElapsedFaster= Duration.between(startFaster, finishFaster).toMillis();  //in millis
	    
	    System.out.println(">>>>>>>>>>>>>>>>>>>>");
	 

	    System.out.println(">>>>> Time taken by readable program :"+timeElapsedReadable);
	 
	    

	    System.out.println(">>>>>>>>>>>>>>>>>>>>");
	 

	    System.out.println(">>>>> Time taken by Faster program :"+timeElapsedFaster);
	    System.out.println(">>>>>>>>>>>>>>>>>>>>");
	 
	}

}
