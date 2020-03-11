package com.ashu.wordspitterandcheker.faster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class SplitingOriginalWordFaster {
	Set<String> allWords;
    
	//For Junit Testing give predefined list of known words 
	private int count=0;
	public SplitingOriginalWordFaster(Set<String> allWords)
	{
		this.allWords=allWords;
		
	}
	//Public Constructor, also loads all the words from file
	public SplitingOriginalWordFaster() throws IOException {
		
		// Getting All the words from dictionary into Set
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream is = classloader.getResourceAsStream("wordlist.txt");
		allWords=new HashSet<String>();
		 try (BufferedReader buffer = new BufferedReader(new InputStreamReader(is))) {
			 String line = buffer.readLine();
				while (line != null) {
					allWords.add(line);
					// read next line
					line = buffer.readLine();
				}
	        }
		
	}
	
	/***Also only split and check those words whose length is 6 characters
	This method is splitting each word at each index position and passes the substrings 
	or checking  *******/
	public void splitEachWordAtEachIndexPosition() {
		//Here we are only taking the words whose length is 6 characters as our problem statement
		allWords.stream().filter(word->word.length()==6).forEach(word -> {
				greedyCheckingOfWords(word);
			});
	}
	
	
	/*******This is greedy approach where individual word search starts from char at 0th index and loops ends as
	soon as both words match  ************/
	//This method Checks for the each split word if its present in the set of words of dictionary
	public  void greedyCheckingOfWords(String originalWord)
	{
	        final char[] chars= originalWord.toCharArray();
	        final StringBuilder firstWord = new StringBuilder();
	        final StringBuilder secondWord = new StringBuilder(originalWord);
	        boolean bothWordsExists = false;

	        for (int i = 0; i < chars.length && !bothWordsExists ; i++) {
	            final char currentChar = chars[i];
	            firstWord.append(currentChar);
	            secondWord.delete(0,firstWord.length()-1);
	            bothWordsExists = allWords.contains(firstWord.toString()) && (allWords.contains(secondWord.toString())&&secondWord.length()>0);
	        }

	        if (bothWordsExists) {
			//	System.out.println(">>>>>>>>>> (" + "Faster ='" + originalWord + '\'' + " first_Word '" + firstWord + '\''
					//	+ " second_Word '" + secondWord + '\'' + ')'+"<<<<<<<<<<<<<<<");
				count++;

			}

	

	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
