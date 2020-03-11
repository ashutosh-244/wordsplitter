package com.ashu.wordspitterandcheker.readable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class SplitingOriginalWordReadable {
	Set<String> allWords;
	private int count=0;
	//For Junit Testing give predefined list of known words 
	public SplitingOriginalWordReadable(Set<String> allWords)
	{
		this.allWords=allWords;
		
	}
	//Public Constructor, also loads all the words from file
	public SplitingOriginalWordReadable() throws IOException {
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
		// allWords.forEach(System.out::println);
	}
	

	//This method is splitting each word at each index position and passes the substrings 
	//for checking
	public void splitEachWordAtEachIndexPosition() {
		allWords.stream().forEach(word -> {
			int count = 0;
	       // if(count )
			for(char c:word.toCharArray())
			{

		     	checkForIndividualWordAvailability(word, 
						word.substring(0, count + 1), word.substring(count + 1));
		     	count++;
			}

		});
	}
	//This method Checks for the each split word if its present in the set of words of dictionary
	private void checkForIndividualWordAvailability(String originalWord, String firstWord, String secondWord) {

		if (allWords.contains(firstWord) && allWords.contains(secondWord) && (firstWord+secondWord).length()==6 && secondWord.length()>0) {
			this.setFirstWord(firstWord);
			this.setSecondWord(secondWord);
		//	System.out.println(">>>>> Readable (" + "Given_Word='" + originalWord + '\'' + " first_Word '" + firstWord + '\''
			//		+ " second_Word '" + secondWord + '\'' + ')'+"<<<<<<<<<<<<<<<");
			count++;
		}

	}
	
	

	
	public void setFirstWord(String firstWord) {
		this.firstWord = firstWord;
	}
	public void setSecondWord(String secondWord) {
		this.secondWord = secondWord;
	}
	private  String firstWord;
    private String secondWord;
    public String getFirstWord() {
		return firstWord;
	}
	public String getSecondWord() {
		return secondWord;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
