public class Trainee extends Employee{

    private String universityName ;
    private double GPA ;
    private int academicYear ;
    private final double traineesalary = 1500 ;

    public void AddNewTrainee (String name , int id , int age , String universityName , double GPA , int academicYear){

        super.setName(name);
        super.setId(id);
        super.setAge(age);
        this.universityName=universityName;
        this.GPA=GPA;
        this.academicYear=academicYear;

    }
    
    private void addTotext (String name , int id , int age , String universityName , double GPA , int academicYear) throws IOException {

        File file = new File("Trainees.txt");
        FileWriter fw = new FileWriter(file , true);
        PrintWriter pw = new PrintWriter(fw);

        pw.print(id+"@");
        pw.print(String.format("%s@", name));
        pw.print(String.format("%s@", age));
        pw.print(String.format("%s@", salary));
        pw.print(String.format("%s@", universityName));
        pw.print(String.format("%s@", GPA));
        pw.print(String.format("%s@", academicYear));

        pw.close();
    }
    
    public void editTrainee(String removeID , String edname , String edage , String edsalary, String eduniversityName, String edGPA, String edacademicYear){
        String temp = "temp.txt";
        String filepath = "Trainees.txt";

        File oldFile = new File (filepath);
        File newFile = new File (temp);
        String tempId =" " ;
        String tempName = " " ;
        String tempAge = " " ;
        String tempSalary = " ";
        String tempUniversityName=" ";
        String tempGPA = " ";
        String tempAcademicYear=" " ;

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
                tempUniversityName=x.next();
                tempGPA=x.next();
                tempAcademicYear=x.next();

                if (!removeID.equals(tempId)){
                    pw.println(tempId+"@"+tempName+"@"+tempAge+"@"+tempSalary+"@"+tempUniversityName+"@"+tempGPA+"@"+tempAcademicYear);
                }
                else
                {
                    pw.println(tempId+"@"+tempName+"@"+tempAge+"@"+edsalary+"@"+eduniversityName+"@"+edGPA+"@"+edacademicYear);
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
    
    public void deleteTrainee(String removeID){
        String temp = "temp.txt";
        String filepath = "Trainees.txt";
        
        String tempId =" " ;
        String tempName = " " ;
        String tempAge = " " ;
        String tempSalary = " ";
        String tempUniversityName=" ";
        String tempGPA = " ";
        String tempAcademicYear=" " ;

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
                tempUniversityName=x.next();
                tempGPA=x.next();
                tempAcademicYear=x.next();

                if (!removeID.equals(tempId)){
                    pw.println(tempId+"@"+tempName+"@"+tempAge+"@"+tempSalary+"@"+tempUniversityName+"@"+tempGPA+"@"+tempAcademicYear);
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
    
    public void viewTrainees()
    {
    String filepath="Trainees.txt";

        try {
            String id =" ";
            String name=" ";
            String age=" ";
            String salary=" ";
            String universityName=" ";
            String GPA =" ";
            String academicYear=" ";
            
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
                universityName= w.next();
                GPA= w.next();
                academicYear=w.next();
                System.out.println(id+"\n"+name+"\n"+age+"\n"+ universityName+"\n"+GPA+"\n"+academicYear+"\n");
            }
            fr.close();
        } catch (Exception e) {
            System.out.println("There is an Exception here !");
        }
    }
    
    public double getGPA() {
        return GPA;
    }

    public double getSalary() {
        return traineesalary;
    }

    public void setuniversityName(String universityName) {
        universityName = universityName;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public void setacademicYear(int academicYear) {
        academicYear = academicYear;
    }

    public int getacademicYear() {
        return academicYear;
    }

    public String getuniversityName() {
        return universityName;
    }


    // Add here any methods for the Trainee ...


}
