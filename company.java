import java.util.*;
public class company {
    private String name;
    private String role;
    private float salary;
    private float CGPA;
    private String reg_date_time; 
    public ArrayList<student> reg_students = new ArrayList<>();
    public student selected;

    public company() {
        this.name = "Google";
        this.role = "SDE";
        this.salary = 50;
        this.CGPA = 8.5f;
        this.reg_date_time ="Unknown";
    }

    public company(String name, String role, float salary, float CGPA) {
        this.name = name;
        this.role = role;
        this.salary = salary;
        this.CGPA = CGPA;
    }

    public void update_role(String role) {
        this.role = role;
    }

    public void update_salary(float salary) {
        this.salary = salary;
    }

    public void update_cgpa(float CGPA) {
        this.CGPA = CGPA;
    }

    public void register_drive(String date){
        Institute.reg_companies.add(this);
        this.reg_date_time = date;

    }

    public static void get_available_companies(){
        for (int i = 0; i < Institute.companies.size(); i++) {
            System.out.println((i+1)+")"+Institute.companies.get(i).name);
        }
    }

    public String  get_name(){
        return this.name;
    }

    public float get_cgpa(){
        return this.CGPA;
    }

    public String get_role(){
        return this.role;
    }

    public float get_salary(){
        return this.salary;
    }

}

