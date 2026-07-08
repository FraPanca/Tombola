package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tombola {
	
	private List<Integer> tabella;	
	private Random seed;
	
	public Tombola() {
		tabella = new ArrayList<>();
		seed = new Random();	
	}
	
	
	public List<Integer> getTabella() {
		return tabella;
	}
	
	public int getNum() {
		return generateNum();
	}
	
	private int generateNum() {
		int n;
		
		do {
			n = seed.nextInt(90) + 1;
		} while(checkNotPresentNumber(n));
		
		return n;
	}
	
	private boolean checkNotPresentNumber(int num) {
		Integer n = Integer.valueOf(num);
		
		if(tabella.isEmpty() || !tabella.contains(n)) {
			tabella.add(n);
			return false;
		}
			
		return true;
	}
	
	public int numeriRimanenti() {
		return 90 - tabella.size();
	}
	
	public void newGame() {
		tabella = new ArrayList<>();
	}
	
}
