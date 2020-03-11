package com.ashu.wordspitterandcheker;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;


import org.junit.BeforeClass;
import org.junit.Test;

import com.ashu.wordspitterandcheker.faster.SplitingOriginalWordFaster;
import com.ashu.wordspitterandcheker.readable.SplitingOriginalWordReadable;

public class SpllitingOriginalWordTest {
	Set <String> knownWordList;
	@BeforeClass
	public void loadKnownWords(){
		knownWordList=new HashSet<String> ();
	 	knownWordList.add("constrain");
		
	}
    @Test
    public void testWordPairAbcWithZeroSplit() {
    	SplitingOriginalWordReadable wordPair = new SplitingOriginalWordReadable(knownWordList);

        assertEquals("First Word Spliited and matched Successfully", wordPair.getFirstWord(), "con");
        assertEquals("Second Word Spliited and matched Successfully", wordPair.getSecondWord(), "strain");

    }
    

}

