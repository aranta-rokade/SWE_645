/* Author: Aranta Rokade
 * SWE 645 : Homework 3
 * DataBean Class 
 * */
package model;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.Date;
import java.util.Arrays;
import java.util.List;

public class Student {

	//private String studentID;
	private String firstName;
	private String lastName;
    private String address;
    private Integer zipcode;
    private String city;
    private String state;
    private String phone;
    private String email;
    private Date surveyDate;
    
    private Date startDate;
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
	public Integer getZipcode() {
		return zipcode;
	}
	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
		Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://18.222.189.234/SWE645_HW4/webresources/zipcodes/");
        WebTarget resourceWebTarget;
        resourceWebTarget = target.path(this.zipcode.toString());
       
        Invocation.Builder invocationBuilder = resourceWebTarget.request(MediaType.TEXT_PLAIN);
        Response response = invocationBuilder.get();
        
        String s = response.readEntity(String.class);
        setState(s.split("-")[1]);
        setCity(s.split("-")[0]);
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
	public Date getSurveyDate() {
		return surveyDate;
	}
	public void setSurveyDate(Date date) {
		this.surveyDate = date;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date date) {
		this.startDate = date;
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
				 getStartDate() + "|" +
				 String.join(",", getLikes()) + "|" + 
				 getInterest() + "|" + 
				 getRecommend() + "|" + 
				 getComments() + "|" + 
				 getRaffle() + "|" + 
				 System.getProperty("line.separator");
	}
	
	@SuppressWarnings("deprecation")
	public void getStudent(String line) {
		String[] a = line.split("\\|", -1);
		setFirstName(a[0]);
		setLastName(a[1]);
		setAddress(a[2]);
		setCity(a[3]);
		setState(a[4]);
		setZipcode(Integer.parseInt(a[5]));
		setPhone(a[6]);
		setEmail(a[7]);
		setSurveyDate(new Date(a[8]));
		setStartDate(new Date(a[9]));
		setLikes(Arrays.asList((a[10].split(","))));
		setInterest(a[11]);
		setRecommend(a[12]);
		setComments(a[13]);
		setRaffle(a[14]);
	}
}
