package eeps;

import java.io.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EngineerClass extends EmployeeClass{

    private double workingHours;
    private GradeClass grade ;
    static int numberOfEngineers ;


    public double CalcSalary(double workingHours,GradeClass grade)
        {
            if( null != this.grade.getPosition() )
            switch (this.grade.getPosition()) {
                case "Manager":
                    this.grade.setpayRate(10*workingHours);
                    this.grade.setTax(this.grade.getpayRate()*0.23);
                    break;
                case "Team Leader":
                    this.grade.setpayRate(8*workingHours);
                    this.grade.setTax(this.grade.getpayRate()*0.20);
                    break;
                case "Team Memeber":
                    this.grade.setpayRate(6*workingHours);
                    this.grade.setTax(this.grade.getpayRate()*0.17);
                    break;
                default:
                    System.out.println("There is an Exception here !");
                    break;
            }
            double salary=this.grade.getpayRate()-this.grade.getTax();
            return salary;
    }
    
    private int makeID() {
        int id = 0;
        try {

            FileReader fr = new FileReader("EngineersIDs.txt");
            BufferedReader br= new BufferedReader(fr);
            Scanner s = new Scanner(new File("EngineersIDs.txt"));
            while(s.hasNext())
            {
                id=s.nextInt()+1;
            }
            fr.close();
            
            File file = new File("Engineers.txt");
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);
            pw.print(id);
            pw.close();
            
            } catch (Exception e) {
                System.out.println("There is an Exception here !");
            }
        return id;
    } 
    
    public void addEngineer(String name , int age , double workingHours , GradeClass grade){

        super.setName(name);
        this.id = makeID();
        super.setAge(age);
        this.workingHours=workingHours;
        this.grade=grade ;
        this.salary = CalcSalary(workingHours, grade);
        try {
            addTotext (this.name,this.id,this.age,this.workingHours , this.grade,this.salary);
        } catch (IOException e) {
            System.out.println("There is an Exception here !");
        }
        numberOfEngineers++ ;
    }

    private void addTotext (String name , int id , int age , double workingHours , GradeClass grade,double salary) throws IOException {

        File file = new File("Engineers.txt");
        FileWriter fw = new FileWriter(file , true);
        PrintWriter pw = new PrintWriter(fw);

        pw.print(id+"@");
        pw.print(String.format("%s@", name));
        pw.print(String.format("%s@", age));
        pw.print(String.format("%s@", salary));
        pw.print(String.format("%s@", workingHours));
        pw.print(String.format("%s@", grade.getpayRate()));
        pw.print(String.format("%s@", grade.getTax()));
        pw.println(grade.getPosition());

        pw.close();
    }

    public void deleteEngineer(String removeID) {

        String temp = "temp.txt";
        String filepath = "Engineers.txt";
        String tempId =" " ;
        String tempName = " " ;
        String tempAge = " " ;
        String tempSalary = " ";
        String tempWorkingHours=" ";
        String tempPayRate = " ";
        String tempTax=" " ;
        String tempPosition =" " ;

        File oldFile = new File (filepath);
        File newFile = new File (temp);

        try {

            FileWriter fw = new FileWriter(temp,true);
            BufferedWriter bw = new BufferedWriter (fw);
            PrintWriter pw = new PrintWriter (bw) ;

            Scanner x = new Scanner(new File (filepath));
            x.useDelimiter("[@\n]");

            while(x.hasNext()){

                tempId=x.next();
                tempName = x.next();
                tempAge=x.next();
                tempSalary=x.next();
                tempWorkingHours=x.next();
                tempPayRate=x.next();
                tempTax=x.next();
                tempPosition = x.next();

                if (!removeID.equals(tempId)){
                    pw.println(tempId+"@"+tempName+"@"+tempAge+"@"+tempSalary+"@"+tempWorkingHours+"@"+tempPayRate+"@"+tempTax+"@"+tempPosition);
                }
            }

            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File free = new File (filepath);
            newFile.renameTo(free);

        }
        catch (Exception e)
        {
            System.out.println("There is an Exception here !");

        }
    }



    public void editEngineer(String removeID , String edName , String edAge , String edworkingHours , String edposition ){

        String temp = "temp.txt";
        String filepath = "Engineers.txt";

        File oldFile = new File (filepath);
        File newFile = new File (temp);
        String tempId =" " ;
        String tempName = " " ;
        String tempAge = " " ;
        String tempSalary = " ";
        String tempWorkingHours=" ";
        String tempPayRate = " ";
        String tempTax=" " ;
        String tempPosition =" " ;

        try {

            FileWriter fw = new FileWriter(temp,true);
            BufferedWriter bw = new BufferedWriter (fw);
            PrintWriter pw = new PrintWriter (bw) ;

            Scanner x = new Scanner(new File (filepath));
            x.useDelimiter("[@\n]");

            while(x.hasNext()){

                tempId=x.next();
                tempName = x.next();
                tempAge=x.next();
                tempSalary=x.next();
                tempWorkingHours=x.next();
                tempPayRate=x.next();
                tempTax=x.next();
                tempPosition = x.next();

                if (!removeID.equals(tempId)){
                    pw.println(tempId+"@"+tempName+"@"+tempAge+"@"+tempSalary+"@"+tempWorkingHours+"@"+tempPayRate+"@"+tempTax+"@"+tempPosition);
                }
                else
                {
                    pw.println(tempId+"@"+edName+"@"+edAge+"@"+tempSalary+"@"+edworkingHours+"@"+tempPayRate+"@"+tempTax+"@"+edposition);
                }
            }

            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File free = new File (filepath);
            newFile.renameTo(free);

        }
        catch (Exception e)
        {

            System.out.println("There is an Exception here !");

        }
    }
    
    public void viewEngineers(){
        String filepath="Engineers.txt";

        try {
            String id =" ";
            String name=" ";
            String age=" ";
            String salary=" ";
            String workHours=" ";
            String payRate=" ";
            String tax =" ";
            String position=" ";

            FileReader fr = new FileReader(filepath);
            BufferedReader brr= new BufferedReader(fr);
            Scanner w = new Scanner(new File(filepath));
            w.useDelimiter("[@\n]");
            while(w.hasNext())
            {
                id=w.next();
                name=w.next();
                age=w.next();
                salary=w.next();
                workHours = w.next();
                payRate= w.next();
                tax=w.next();
                position = w.next();
                System.out.println(id+"\n"+name+"\n"+age+"\n"+ salary +"\n"+workHours+"\n"+payRate+"\n"+tax+"\n"+position+"\n");
            }
            fr.close();
            } catch (Exception e) {
                System.out.println("There is an Exception here !");
            }
    }
    
    
    public List<List<String>> searchEngineer(String forSearch)
    {
    String filepath="Engineers.txt";

    List<List<String>> searchResults = null;
    
        try {
            String id =" ";
            String name=" ";
            String age=" ";
            String salary=" ";
            String workHours=" ";
            String payRate=" ";
            String tax =" ";
            String position=" ";
            
            
            FileReader fr = new FileReader(filepath);
            BufferedReader brr= new BufferedReader(fr);
            Scanner w = new Scanner(new File(filepath));
            w.useDelimiter("[@\n]");
            while(w.hasNext())
            {
                List<String> results = null;
                
                id=w.next();
                name=w.next();
                age=w.next();
                salary=w.next();
                workHours = w.next();
                payRate= w.next();
                tax=w.next();
                position = w.next();
                
                if(id == forSearch || name == forSearch || age == forSearch || salary == forSearch || workHours == forSearch || payRate == forSearch || tax == forSearch || position == forSearch){
                    
                    results.add(id);
                    results.add(name);
                    results.add(age);
                    results.add(salary);
                    results.add(workHours);
                    results.add(payRate);
                    results.add(tax);
                    results.add(position);

                    searchResults.add(results);
                    
                }
            }
            fr.close();
        } catch (Exception e) {
            System.out.println("There is an Exception here !");
        }
        return searchResults;
    }
    


    public double getworkingHours() {
        return workingHours;
    }

    public GradeClass getGrade() {
        return grade;
    }

    public void setworkingHours(double workingHours) {
        this.workingHours = workingHours;
    }

    public void setGrade(GradeClass grade) {
        this.grade = grade;
    }


    // Add here any methods for the Engineer ...

}

