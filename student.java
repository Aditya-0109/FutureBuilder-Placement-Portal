import java.util.*;
public class student {
    public String name;
    public String branch;
    public int roll;
    public float CGPA;
    public String offer_status;
    private String reg_date_time;
    private float salary;
    public company offer;
    public ArrayList<company> applied_companies = new ArrayList<>();
    public ArrayList<company> eligible_companies = new ArrayList<>();
    
    public student(String name, String branch, int roll, float CGPA) {
        this.name = name;
        this.branch = branch;
        this.roll = roll;
        this.CGPA = CGPA;
        this.offer_status = "Unoffered";
    }
    public void register_drive(String date){
        Institute.applicants.add(this);
        this.reg_date_time = date;
    }

    public void register_company(company c){
        this.applied_companies.add(c);
        c.reg_students.add(this);
    }
    public void get_current_status(){
        if(this.offer_status=="Offered"){
            System.out.println("You have been offered a job at "+this.offer.get_name()+". Please accept the offer.");
        }
        else{
            System.out.println("Current status: "+this.offer_status);
        }
    }   
    
    public void accept_offer(){
        this.salary = this.offer.get_salary();
        System.out.println("Congratulations!"+this.name+"!!!. You have accepted the offer by "+this.offer.get_name());
    }
    public void reject_offer(){
        this.offer_status = "Blocked";
        Institute.applicants.remove(this);
        // making this.eligiible_companies empty
        this.eligible_companies.clear();
        // removing this from all the companies
        for (int i = 0; i < this.applied_companies.size(); i++) {
            this.applied_companies.get(i).reg_students.remove(this);
        }
        // removing this from placement drive
        Institute.applicants.remove(this);
        System.out.println("You have rejected the offer by "+this.offer.get_name());
    }

    private void set_offer_status(String offer_status){
        this.offer_status = offer_status;
    }

    public void update_cgpa(float CGPA_new) {
        this.CGPA = CGPA_new;
    }
    public void get_available_companies(){
        if(this.offer_status=="Offered"){
            for(int j=0;j<Institute.reg_companies.size();j++){
                if(Institute.reg_companies.get(j).get_salary()<3*(this.offer.get_salary())){
                this.eligible_companies.remove(Institute.reg_companies.get(j));
                this.set_offer_status("Unoffered");
                }
                else{
                    // add registered company to eligible if not already present and salary is greater than 3 times of offered salary
                    if(!this.eligible_companies.contains(Institute.reg_companies.get(j))){
                        if(Institute.reg_companies.get(j).get_salary()>3*(this.offer.get_salary())){
                        this.eligible_companies.add(Institute.reg_companies.get(j));}
                    }
                    
                }
            }
            for (int j=0;j<this.eligible_companies.size();j++){
                System.out.println(j+1+")"+this.eligible_companies.get(j).get_name());
            }    
        }
        else if(this.offer_status=="Unoffered"){
            for(int j=0;j<Institute.reg_companies.size();j++){
                if(this.CGPA>=Institute.reg_companies.get(j).get_cgpa()){
                    System.out.println(j+1+")"+Institute.reg_companies.get(j).get_name()+"\nRole:"+Institute.reg_companies.get(j).get_role()+"\nCGPA:"+Institute.reg_companies.get(j).get_cgpa()+"\nPackage:"+Institute.reg_companies.get(j).get_salary());
                    this.eligible_companies.add(Institute.reg_companies.get(j));
                }
            }}
        else{
            System.out.println("You have no available companies");
        }
    }
}