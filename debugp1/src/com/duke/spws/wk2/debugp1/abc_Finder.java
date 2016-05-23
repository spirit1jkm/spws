package com.duke.spws.wk2.debugp1;

import java.util.Scanner;

/*This class will prompt user for a String, the sub-String they wish to find in it,
 * and the number of characters after the stringToFind to include in the results 
 * (in addition to stringToFind).
 * Then it will find all occurrences of that string and print it to the console, 
   along with the desired number of follow on characters.*/

public class abc_Finder {

	public static void main(String[] args) {
		String nextTestString = obtainStringInputPrompt();
		String stringToFind = obtainStringToFindPrompt();
		int numCharsAfterStringToFind = obtainNumCharsAfterStringToFindPrompt();
		int locAbc = abc_locFinder(nextTestString,stringToFind);

		System.out.println (abc_Found(nextTestString, locAbc, stringToFind, numCharsAfterStringToFind));
		nextTestString = findNextTestString(nextTestString, locAbc, stringToFind, numCharsAfterStringToFind);

		while((nextTestString.length() >= (stringToFind.length() + numCharsAfterStringToFind))){ 
			String abc_Found = abc_Found(nextTestString, locAbc, stringToFind, numCharsAfterStringToFind);
			System.out.println(abc_Found);
			nextTestString = findNextTestString(nextTestString, locAbc, stringToFind, numCharsAfterStringToFind);
		} 
		System.out.println("exiting program");
		}
		
//Prompts user for the String to search and converts it to lower case; then returns it.
	private static String obtainStringInputPrompt() {
		String testString;

		Scanner testString_Scanner = new Scanner(System.in);
		System.out.println("Enter test String");
		testString = testString_Scanner.nextLine();
		return testString.toLowerCase();
	}
	
//Prompts user for the String to search for in the nextTestString.
	private static String obtainStringToFindPrompt() {
		String stringToFind;

		Scanner stringToFind_Scanner = new Scanner(System.in);
		System.out.println("Enter String to search for");
		stringToFind = stringToFind_Scanner.nextLine();
		stringToFind = stringToFind.toLowerCase();
		return stringToFind;
	}
	
/*Prompts the user for the number of characters that follow the
String they are searching for to include in the results*/
	private static int obtainNumCharsAfterStringToFindPrompt() {
		int numCharsAfterStringToFind;

		Scanner numCharsAfterStringToFind_Scanner = new Scanner(System.in);
		System.out.println("Enter number of characters to include past stringToFind");
		String response = numCharsAfterStringToFind_Scanner.nextLine();
		numCharsAfterStringToFind = Integer.parseInt(response);
		//TODO: add validation (ensure can handle if no characters after stringToFind)
		return numCharsAfterStringToFind;
	}
/*finds the next instance of the stringToFind and returns its Index in subString else 
	it will return length of nextTestString.*/
	private static int abc_locFinder (String nextTestString, String stringToFind) {
		if (nextTestString.contains(stringToFind)) {	
			int locAbc = nextTestString.indexOf(stringToFind);
			return locAbc;
		} else {
			System.out.println("made it thru abc_locFinder");
			return nextTestString.length();
		}
	}

/*finds the next instance of stringToFind and the desired number of follow on characters
	prints them to console and then returns them.*/
	private static String abc_Found(String nextTestString, int locAbc, String stringToFind, int numCharsAfterStringToFind){
		int endAbc_Found = locAbc + (stringToFind.length()  + numCharsAfterStringToFind);
		//TODO: I think validation or error handling needed here
		String abc_Found = nextTestString.substring(locAbc,endAbc_Found) ;
		System.out.println("made thru abc_Found");
		return abc_Found;
	}
	
//Advances to the nextTestString following the stringToFind and its follow on characters requested
	private static String findNextTestString(String nextTestString, int locAbc, String stringToFind, int numCharsAfterStringToFind){
		nextTestString = nextTestString.substring((locAbc + (stringToFind.length()  + numCharsAfterStringToFind)), nextTestString.length());
		System.out.println("made it thru findNextTestString");
		return nextTestString;
	}


}


