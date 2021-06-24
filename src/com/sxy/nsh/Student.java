package com.sxy.nsh;

public class Student {
private String name;
private double score1;
private double score2;
  public Student() {
	 
}
  public Student(String name,double score1,double score2) {
	  this.name=name;
	  this.score1=score1;
	  this.score2=score2;
  }
public double getScore2() {
	return score2;
}
public void setScore2(double score2) {
	this.score2 = score2;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getScore1() {
	return score1;
}
public void setScore1(double score) {
	this.score1 = score;
}
}
