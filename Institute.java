import java.util.*;
public class Institute {
    public static String student_start="2020/09/12 10:00";
    public static String student_end="2020/09/12 11:00";
    public static String company_start;
    public static String company_end;
    // make a list of all applicants that can be appended to from Main.java
    public static ArrayList<student> students = new ArrayList<>();
    public static ArrayList<student> applicants = new ArrayList<>();
    public static ArrayList<company> companies = new ArrayList<>();
    public static ArrayList<company> reg_companies = new ArrayList<>();

    public static void open_student_reg(String date1, String date2){

        if(date1.compareTo(Institute.company_end)>=0){
            Institute.student_start = date1;
            Institute.student_end = date2;
        }
        else{
            System.out.println("Student registration cannot be opened before company registration is closed");
        }
    }

    public static void open_company_reg(String date1, String date2){
        Institute.company_start = date1;
        Institute.company_end = date2;
    }

    public static void get_student_reg(){
        System.out.println("No.of students registered: "+Institute.applicants.size());
    }

    public static void get_company_reg(){
        System.out.println("No.pf companies registered: "+Institute.reg_companies.size());
    }

    public static int get_offered(){
        int count = 0;
        for (int i = 0; i < Institute.applicants.size(); i++) {
            if(Institute.applicants.get(i).offer_status=="Offered"){
                count++;
            }
        }
        return count;
    }

    public static int get_unoffered(){
        int count = 0;
        for (int i = 0; i < Institute.applicants.size(); i++) {
            if(Institute.applicants.get(i).offer_status=="Unoffered"){
                count++;
        }
    }
        return count;
    }

    public static int get_blocked(){
        int count = 0;
        for (int i = 0; i < Institute.applicants.size(); i++) {
            if(Institute.applicants.get(i).offer_status=="Blocked"){
                count++;
        }
    }
        return count;
    }

    public static void get_company_details(String name){
        int i;
        for(i=0;i<Institute.reg_companies.size();i++){
            if(Institute.reg_companies.get(i).get_name().equals(name)){
                break;
            }
        }
        if(i==Institute.reg_companies.size()){
            System.out.println("Company not found");
        }
        else{
            System.out.println("Name: "+Institute.reg_companies.get(i).get_name());
            System.out.println("Role: "+Institute.reg_companies.get(i).get_role());
            System.out.println("Package: "+Institute.reg_companies.get(i).get_salary());
            System.out.println("CGPA criteria: "+Institute.reg_companies.get(i).get_cgpa());
            System.out.println("Selected student: "+Institute.reg_companies.get(i).selected.name+" Roll no. "+Institute.reg_companies.get(i).selected.roll);
        }
    }

    public static void get_student_details(String name, int roll){
        int i;
        for(i=0;i<Institute.applicants.size();i++){
            if(Institute.students.get(i).roll==roll && Institute.students.get(i).name.equals(name)){
                break;
            }
        }
        if(i==Institute.students.size()){
            System.out.println("Student not found");
        }
        else{
            // print applied companies
            System.out.println("Applied companies: ");
            for(int j=0;j<Institute.applicants.get(i).applied_companies.size();j++){
                System.out.println(Institute.applicants.get(i).applied_companies.get(j).get_name());
                if(Institute.applicants.get(i).applied_companies.get(j).selected==Institute.applicants.get(i)){
                    System.out.println("Status: Offered");
                }
                else{
                    System.out.println("Status: Unoffered");
                }
            }
        }
    }

    public static void get_avg(){
        int count=0;
        int sum=0;
        for(int i=0;i<Institute.applicants.size();i++){
            if(Institute.applicants.get(i).offer_status=="Offered"){
                count++;
                sum+=Institute.applicants.get(i).offer.get_salary();
            }
        }
        System.out.println("Average package offered: "+sum/count);
    }

    public static void get_reg_companies(){
        for(int i=0;i<Institute.reg_companies.size();i++){
            System.out.println((i+1)+")"+Institute.reg_companies.get(i).get_name());
        }
    }

    public static void get_company_results(company c){
        Random rand = new Random();
        int index = rand.nextInt(c.reg_students.size());
        c.selected = c.reg_students.get(index);
        if(c.selected.offer_status=="Offered"){
            if(c.selected.offer.get_salary()<c.get_salary()){
                c.selected.offer = c;
            }}
        else{
            c.selected.offer_status = "Offered";
            c.selected.offer = c;
        }
        
        
        System.out.println("Selected student: "+c.selected.name+"\nRoll no. "+c.selected.roll+"\nCGPA: "+c.selected.CGPA+"\nBranch: "+c.selected.branch);
    }
        
    }

