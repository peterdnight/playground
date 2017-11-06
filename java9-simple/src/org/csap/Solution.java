package org.csap;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

class Solution {
	public static void main ( String[] args ) {
		ArrayList<String> strings = new ArrayList<String>();
		strings.add( "Hello, World!" );
		strings.add( "Welcome to CoderPad." );
		strings.add( "This pad is running Java 8." );

		strings.stream()
			.map( String::toUpperCase )
			.collect( Collectors.toList() );

		for ( String string : strings ) {
			System.out.println( string );
		}
		
		boolean check = checkPalindrome( "aabbaa" ) ;
		System.out.println( "Check: " + check );
		

		int[] test = {-23, 4, -3, 8, -12} ;
		int max = adjacentElementsProduct( test ) ;
		System.out.println( "Check: " + max );
		
		

		System.out.println( "shapeArea: 1 " + (shapeArea(1) == 1 ) );

		System.out.println( "shapeArea: 2 " + (shapeArea(2) == 5 ) );
		
		System.out.println( "shapeArea: 3 " + (shapeArea(3) == 13 ) );
	}
	
	
	static int shapeArea(int n) {
		
		int area = 0 ;
		
		for (int i = 0;  i<((n*2)-1); i++ ) {
			
			if ( i==0 || i%2 == 0 )
				area += n ;
			else 
				area += n-1 ;
		}
		System.out.println( "shapeArea: " + n + ", " + area );
		return area ;

	}

	
	static int adjacentElementsProduct(int[] inputArray) {
	    
		int largestProduct = Integer.MIN_VALUE;
		int length = inputArray.length  ;
		
	    
	    for (int i = 0;  i< length-1; i++ ) {
	    	
	    		int testProduct = inputArray[i] * inputArray[i+1] ;
	    		
	    		if ( testProduct > largestProduct ) {
	    			largestProduct = testProduct ;
	    		}
	    	
	    }
	    
	    return largestProduct ;

	}
	

	
	
	static boolean checkPalindrome(String inputString) {
	    
		
		int length = inputString.length()  ;
	    if ( length == 1) return true;
	    
	    boolean isPal = true;
	    for (int i = 0;  i< length/2; i++ ) {
	    		if ( inputString.charAt( i ) != inputString.charAt( length-1-i ) ) {
	    			isPal = false ;
	    		}
	    }
	    
	    return isPal ;

	}
	
	
	private String replace(String string, char c) {
		
		String result = null;
		
		ConcurrentHashMap<String, String> s;
		
		return result ;
		
	}
}
