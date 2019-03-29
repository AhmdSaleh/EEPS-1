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
