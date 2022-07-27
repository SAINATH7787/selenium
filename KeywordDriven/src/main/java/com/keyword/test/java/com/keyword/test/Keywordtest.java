package com.keyword.test;

import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import com.keyword.engine.KeywordEngine;

public class Keywordtest {

	
	public KeywordEngine KeywordEngine;
	@Test
	public void logintest() throws FileNotFoundException {
		KeywordEngine = new KeywordEngine();
		KeywordEngine.Exec("kdriven");
	}
	
}
