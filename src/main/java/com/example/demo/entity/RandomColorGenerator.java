package com.example.demo.entity;
import java.util.Random;

public class RandomColorGenerator {
		private static RandomColorGenerator instance;
		private RandomColorGenerator(){}
		private String[] colors = new String[] {"#122824", "#1ED8D0"};
	    private Random rand = new Random();
	    
	    public static RandomColorGenerator getInstance(){
	        if(instance == null){
	            instance = new RandomColorGenerator();
	        }
	        return instance;
	    }
	    
		
		public String getColor() {
			return colors[rand.nextInt(colors.length)];
		}
	    
	    
	
}
