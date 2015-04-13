package org.arindam.reflection;

public class AppTest{
	 
	private int counter;
 
	public void print(){
		System.out.println("printIt() no param");
	}
 
	public void printString(String temp){
		System.out.println("printIt() with param String : " + temp);
	}
 
	public void printInt(int temp){
		System.out.println("printIt() with param int : " + temp);
	}
 
	public void setCounter(int counter){
		this.counter = counter;
		System.out.println("setCounter() set counter to : " + counter);
	}
 
	public void printCounter(){
		System.out.println("printCounter() : " + this.counter);
	}
}
