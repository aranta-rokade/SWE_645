package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Student;
import model.WinningResult;

public class StudentService {
	public void save(Student s) throws IOException
	{
		File file = new File("SurveyData.txt");
		FileWriter fw = new FileWriter(file,true);
		
		if(!file.exists()) 
			file.createNewFile();
		
		try {
			fw.write(s.toString());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			fw.close();
		}
	}
	public List<Student> getAll() throws IOException
	{
		List<Student> list = new ArrayList<Student>();
		BufferedReader br = null;
		try {
			FileReader fileReader = new FileReader("SurveyData.txt");
			br = new BufferedReader(fileReader);
			String line = "";
			while ((line = br.readLine()) != null) 
			{
				System.out.print(line);
				Student s = new Student();
				s.getStudent(line);
				list.add(s);
			}
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return list;
	}
	
	public WinningResult processData(String s) {
		String[] data;
		WinningResult w = new WinningResult();
		data = s.split(",");
		
		int[] numbers = new int[data.length];
		for (int i = 0; i < data.length; i++) {
			numbers[i] = Integer.parseInt(data[i]);
		}

		w.setMean(calcMean(numbers));
		w.setStandardDeviation(calcStandardDeviation(numbers));
		return w;
	}
	
	public double calcMean(int n[]) {
		double sum = 0;
		for (int i = 0; i < n.length; i++)
			sum += n[i];
		return sum / n.length;
	}

	public double calcStandardDeviation(int n[]) {
		double mean = calcMean(n);
		double sd = 0;
		for (int i = 0; i < n.length; i++)
			sd += Math.pow(n[i] - mean, 2);
		return (Math.sqrt(sd / n.length));
	}
}
