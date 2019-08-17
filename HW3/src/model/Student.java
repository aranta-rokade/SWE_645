/* Author: Aranta Rokade
 * SWE 645 : Homework 3
 * DataBean Class 
 * */
package model;

import java.util.Arrays;
import java.util.List;

public class Student {

	//private String studentID;
	private String firstName;
	private String lastName;
    private String address;
    private String zipcode;
    private String city;
    private String state;
    private String phone;
    private String email;
    private String surveyDate;
    
    private List<String> likes;
    private String interest;   
    private String comments;
    private String recommend;
    private String raffle;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSurveyDate() {
		return surveyDate;
	}
	public void setSurveyDate(String date) {
		this.surveyDate = date;
	}
	public List<String> getLikes() {
		return likes;
	}
	public void setLikes(List<String> likes) {
		this.likes = likes;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	public String getRaffle() {
		return raffle;
	}
	public void setRaffle(String raffle) {
		this.raffle = raffle;
	}
	@Override
	public String toString() {
		return
				 getFirstName() + "|" + 
				 getLastName() + "|" + 
				 getAddress() + "|" + 
				 getCity() + "|" + 
				 getState() + "|" + 
				 getZipcode() + "|" + 
				 getPhone() + "|" + 
				 getEmail() + "|" + 
				 getSurveyDate() + "|" + 
				 String.join(",", getLikes()) + "|" + 
				 getInterest() + "|" + 
				 getRecommend() + "|" + 
				 getComments() + "|" + 
				 getRaffle() + "|" + 
				 System.getProperty("line.separator");
	}
	
	public void getStudent(String line) {
		String[] a = line.split("\\|", -1);
		setFirstName(a[0]);
		setLastName(a[1]);
		setAddress(a[2]);
		setCity(a[3]);
		setState(a[4]);
		setZipcode(a[5]);
		setPhone(a[6]);
		setEmail(a[7]);
		setSurveyDate(a[8]);
		setLikes(Arrays.asList((a[9].split(","))));
		setInterest(a[10]);
		setRecommend(a[11]);
		setComments(a[12]);
		setRaffle(a[13]);
	}
}
