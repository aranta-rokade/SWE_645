/* Author: Aranta Rokade
 * SWE 645 : Homework 3
 * DataBean Class 
 * */
package bean;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import model.Student;
import model.WinningResult;
import service.StudentService;

@ManagedBean
@RequestScoped
public class SurveyBean {
	
	// Properties
	private Student student;
	private WinningResult winningResult;
	private List<Student> studentRecords;
	private static String[] recommendOptions = {"Very Likely", "Likely", "Unlikely"};
	
	public SurveyBean() {
		this.student = new Student();
		this.winningResult = new WinningResult();
		this.studentRecords = new ArrayList<Student>();
	}
	
	// Getter-Setter methods
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	public WinningResult getWinningResult() {
		return winningResult;
	}

	public void setWinningResult(WinningResult winningResult) {
		this.winningResult = winningResult;
	}
	
	public List<Student> getStudentRecords() {
		return studentRecords;
	}

	public void setStudentRecords(List<Student> studentRecords) {
		this.studentRecords = studentRecords;
	}
	
	// Action Controller Methods
	public String submitForm() {
		try {
			StudentService ss = new StudentService();
			this.winningResult = ss.processData(this.student.getRaffle());
			ss.save(getStudent());
			if(winningResult.getMean() > 90)
				return "winner-ack";
			else 
				return "simple-ack";
		} catch(Exception e) {
			return "error";
		}
	}
	
	public String listSurvey() {
		try {
			StudentService ss = new StudentService();
			setStudentRecords(ss.getAll());
			return "list-survey";
		} catch (Exception e) {
			return "error";
		}
	}
	
	// Valid Raffle
	public void validateRaffle(FacesContext context, UIComponent component, Object value) 
			throws ValidatorException
	{
		String raffle = value.toString();
		String[] data = raffle.split(",");
		if(data.length < 10) {
			FacesMessage message = new FacesMessage("Enter atleast 10 numbers");
			throw new ValidatorException(message);
		}
		try {
			for (String s : data) {
				int number = Integer.parseInt(s);
				if(number < 1 || number > 100) {
					FacesMessage message = new FacesMessage("Numbers should be 1 through 100");
					throw new ValidatorException(message);
				}
			}	
		}
		catch (NumberFormatException e) {
			FacesMessage message = new FacesMessage("Enter only comma separated numbers");
			throw new ValidatorException(message);
		}
	}
	
	//Auto-Complete Recommend Method
	public List<String> completeRecommend(String text) {
		List<String> matches = new ArrayList<String>();
		for(String option: recommendOptions) {
			if(option.toUpperCase().startsWith(text.toUpperCase()))
				matches.add(option);
		}
		return matches;
	}
	
	//Valid Start Date
	// Reference : https://stackoverflow.com/questions/19093192/date-range-validation
	public void validateStartDate(FacesContext context, UIComponent component, Object value) 
			throws ValidatorException
	{
		if (value == null) {
            return;
        }
		
		UIInput surveyDateComponent = (UIInput) component.getAttributes().get("surveyDateComponent");
		
		if (!surveyDateComponent.isValid()) {
            return; // Already invalidated. Don't care about it then.
        }
		
		Date surveyDate = (Date) surveyDateComponent.getValue();
		if (surveyDate == null) {
            return;
        }
		
		Date startDate = (Date)value;
        
        if (!surveyDate.before(startDate)) {
        	FacesMessage message = new FacesMessage("Possible Start Date should be after Date of Survey");
			throw new ValidatorException(message);
        }
	}
}
