package eeps;

public class GradeClass {

    private String position ;
    private double tax ;
    private double payRate ;

    GradeClass (String position , double tax , double payRate ){

        this.position=position ;
        this.tax=tax ;
        this.payRate=payRate ;

    }

    GradeClass() {};

    public double getTax() {
        return tax;
    }

    public double getpayRate() {
        return payRate;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void setpayRate(double payRate) {
        this.payRate = payRate;
    }

    public String getPosition() {
        return position;
    }


}

