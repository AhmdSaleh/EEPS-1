import java.io.*;
import java.util.Scanner;


public class Engineer extends Employee{

    private double workingHours;
    private Grade grade ;
    static int numberOfEngineers ;
//
private String Manager,TeamLeader,TeamMemeber;


    public void addEngineer(String name , int id , int age , double workingHours , Grade grade){

        super.setName(name);
        super.setId(id);
        super.setAge(age);
        this.workingHours=workingHours;
        this.grade=grade ;
    }
        //Gaber made a mess :D
       public double CalcSalary(double salary ,double workingHours,Grade grade)
        {
        if( null != this.grade.getPosition() )
            switch (this.grade.getPosition()) {
                case "Manager":
                    this.grade.setpayRate(10*workingHours);
                    this.grade.setTax(this.grade.getpayRate()*0.23);
                    this.salary=this.grade.getpayRate()-this.grade.getTax();
                    break;
                case "TeamLeader":
                    this.grade.setpayRate(8*workingHours);
                    this.grade.setTax(this.grade.getpayRate()*0.20);
                    this.salary=this.grade.getpayRate()-this.grade.getTax();
                    break;
                case "TeamMemeber":
                    this.grade.setpayRate(6*workingHours);
                    this.grade.setTax(this.grade.getpayRate()*0.17);
                    this.salary=this.grade.getpayRate()-this.grade.getTax();
                    break;
                default:
                    System.out.println("There is an Exception here !");
                    break;
            }    
            return salary;
        }

    private void addTotext (String name , int id , int age , double workingHours , Grade grade,double salary) throws IOException {

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



    public void editEngineer(String removeID , String edsalary, String edworkingHours, String edpayRate, String edTax, String edposition ){

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
                    pw.println(tempId+"@"+tempName+"@"+tempAge+"@"+edsalary+"@"+edworkingHours+"@"+edpayRate+"@"+edTax+"@"+edposition);
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
    
    public double getworkingHours() {
        return workingHours;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setworkingHours(double workingHours) {
        this.workingHours = workingHours;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }


    // Add here any methods for the Engineer ...


}

