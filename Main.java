import java.util.*;
public class Main {
    public static void main(String[] args) {
        while(true){
            System.out.println("Welcome to FutureBuilder\n1)Enter the application\n2)Exit the application");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            if (choice == 1) {
                while(true){
                    System.out.println("Choose the mode:\n1)Enter as student mode\n2)Enter as company mode\n3)Enter as Placement Cell mode\n4)Return to main menu");
                    int choice1 = sc.nextInt();
                    if(choice1==1){
                        while(true){
                            System.out.println("1)Enter as a student(Give Student name and roll no.)\n2)Add Students\n3)Back");
                            int choice2 = sc.nextInt();
                            String w3 = sc.nextLine();
                            if(choice2==1){
                                String name= sc.nextLine();
                                int roll = sc.nextInt();
                                for(int i=0;i<Institute.students.size();i++){
                                    if(Institute.students.get(i).roll==roll){
                                        while(true){
                                            System.out.println("Welcome "+ name+"!!\n"+"1)Register for the drive\n2)Register for a company\n3)Get all available companies\n4)Get current status\n5)Update CGPA\n6)Accept offer\n7)Reject offer\n8)Back");
                                            int choice3 = sc.nextInt();
                                            String w4 = sc.nextLine();
                                            if(choice3==1){
                                                System.out.println("Enter the registration date and time in the format yyyy/MM/dd HH:mm");
                                                String reg_time = sc.nextLine();                                
                                                if(reg_time.compareTo(Institute.student_start)>=0 && reg_time.compareTo(Institute.student_end)<=0){
                                                    System.out.println(Institute.students.get(i).name+" has registered for the drive");
                                                    System.out.println("Your details are:\nName:"+Institute.students.get(i).name+"\nRoll:"+Institute.students.get(i).roll+"\nCGPA:"+Institute.students.get(i).CGPA+"\nBranch:"+Institute.students.get(i).branch);
                                                    Institute.students.get(i).register_drive(reg_time);
                                                }
                                                else{
                                                    System.out.println("Registration date and time is not in the range");
                                                }
                                            }
                                            else if(choice3==2){
                                                if(Institute.students.get(i).offer_status!="Blocked"){
                                                for(int j=0;j<Institute.reg_companies.size();j++){
                                                    System.out.println(j+1+")"+Institute.reg_companies.get(j).get_name());
                                                }
                                                    int choice4 = sc.nextInt();
                                                    System.out.println(Institute.reg_companies.get(choice4-1).get_name());
                                                    System.out.println("Registered for "+Institute.reg_companies.get(choice4-1).get_role()+" role at "+ Institute.reg_companies.get(choice4-1).get_name());
                                                    Institute.students.get(i).register_company(Institute.reg_companies.get(choice4-1));
                                                }
                                                else{
                                                    System.out.println("You are blocked from the placement drive");
                                                }
                                            }
                                            else if(choice3==3){
                                                Institute.students.get(i).get_available_companies();
                                            }
                                            else if(choice3==4){
                                                Institute.students.get(i).get_current_status();;
                                            }
                                            else if(choice3==5){
                                                System.out.println("Enter new CGPA");
                                                float cgpa = sc.nextFloat();
                                                Institute.students.get(i).update_cgpa(cgpa);
                                                System.out.println("CGPA updated");
                                            }
                                            else if(choice3==6){
                                                Institute.students.get(i).accept_offer();
                                            }
                                            else if(choice3==7){
                                                Institute.students.get(i).reject_offer();
                                            }
                                            else if(choice3==8){
                                                break;
                                            }
                                        }
                                    } }}
                            else if(choice2==2){
                                System.out.println("Enter no. of students to be added:");
                                int n = sc.nextInt();
                                String w= sc.nextLine();
                                for(int i=0;i<n;i++){
                                    System.out.println("Please enter student's name,rno,cgpa,branch(in order)");
                                    String name = sc.nextLine();
                                    int roll = sc.nextInt();
                                    float CGPA = sc.nextFloat();
                                    String w1 = sc.nextLine();
                                    String branch = sc.nextLine();
                                    student obj = new student(name, branch, roll, CGPA);
                                    Institute.students.add(obj);
                                }  }
                            else if(choice2==3){
                                break;
                            }
                            else{
                                System.out.println("Invalid input");
                            }
                        }
                    }
                    else if(choice1==2){
                        while(true){
                            System.out.println("1)Add company and details(name,role,CTC(LPA),CGPA cutoff)\n2)Choose company\n3)Get available companies\n4)Back");
                            int choice2 = sc.nextInt();
                            String w3 = sc.nextLine();
                            if(choice2==1){
                                String name = sc.nextLine();
                                String role = sc.nextLine();
                                int ctc = sc.nextInt();
                                float cgpa = sc.nextFloat();
                                company new_company = new company(name, role, ctc, cgpa);
                                Institute.companies.add(new_company);
                            }

                            else if(choice2==2){
                                company.get_available_companies();
                                int choice3 = sc.nextInt();
                                System.out.println("You have chosen "+Institute.companies.get(choice3-1).get_name());
                                while(true){
                                    System.out.println("1)Update Role\n2)Update Package\n3)Update CGPA criteria\n4)Register to Institue drive\n5)Back");
                                    int choice4 = sc.nextInt();
                                    String w4 = sc.nextLine();
                                    if(choice4==1){
                                        System.out.println("Enter new role");
                                        String role = sc.nextLine();
                                        Institute.companies.get(choice3-1).update_role(role);
                                        System.out.println("Role updated");
                                    }
                                    else if(choice4==2){
                                        System.out.println("Enter new package");
                                        int ctc = sc.nextInt();
                                        Institute.companies.get(choice3-1).update_salary(ctc);
                                        System.out.println("Package updated");
                                    }
                                    else if(choice4==3){
                                        System.out.println("Enter new CGPA criteria");
                                        float cgpa = sc.nextFloat();
                                        Institute.companies.get(choice3-1).update_cgpa(cgpa);
                                        System.out.println("CGPA criteria updated");
                                    }
                                    else if(choice4==4){
                                        System.out.println("Enter the registration date and time in the format dd/mm/yyyy hh:mm");
                                        String date = sc.nextLine();
                                        if(date.compareTo(Institute.company_start)>=0 && date.compareTo(Institute.company_end)<=0){
                                            Institute.companies.get(choice3-1).register_drive(date);
                                            System.out.println(date+"//registration date and time");
                                            System.out.println("Registered for drive");
                                        }
                                        else{
                                            System.out.println("Registration date and time is not in the range");
                                        }
                                        
                                    }
                                    else if(choice4==5){
                                        break;
                                    }
                                    else{
                                        System.out.println("Invalid input");
                                    }
                                }
                            }
                            else if(choice2==3){
                                company.get_available_companies();
                            }
                            else if(choice2==4){
                                break;
                            }
                            else{
                                System.out.println("Invalid input");
                            }


            }}
                    else if(choice1==3){
                        while(true){
                        System.out.println("Welcome to IIITD Placement Portal");
                        System.out.println("1)Open Student Registrations\n2) Open Company Registrations\n3) Get Number of Student Registrations\n4) Get Number of Company Registrations\n5) Get Number of Offered/Unoffered/Blocked Students\n6) Get Student Details\n7) Get Company Details\n8) Get Average Package\n9) Get Company Process Results\n10) Back");
                        int choice2 = sc.nextInt();
                        String w5 = sc.nextLine();
                        if(choice2==1){
                            System.out.println("Enter the start and end registration date and time in the format dd/mm/yyyy hh:mm");
                            String date1 = sc.nextLine();
                            String date2 = sc.nextLine();
                            Institute.open_student_reg(date1, date2);
                        }
                        else if(choice2==2){
                            System.out.println("Enter the start and end registration date and time in the format dd/mm/yyyy hh:mm");
                            String date1 = sc.nextLine();
                            String date2 = sc.nextLine();
                            Institute.open_company_reg(date1, date2);
                        }
                        else if(choice2==3){
                            Institute.get_student_reg();
                        }
                        else if(choice2==4){
                            Institute.get_company_reg();
                        }
                        else if(choice2==5){
                            System.out.println("Number of offered students: "+Institute.get_offered());
                            System.out.println("Number of unoffered students: "+Institute.get_unoffered());
                            System.out.println("Number of blocked students: "+Institute.get_blocked());
                        }
                        else if(choice2==6){
                            System.out.println("Enter the name and roll no. of the student");
                            String name = sc.nextLine();
                            int roll = sc.nextInt();
                            Institute.get_student_details(name, roll);
                        }
                        else if(choice2==7){
                            System.out.println("Enter the name of the company");
                            String name = sc.nextLine();
                            Institute.get_company_details(name);
                        }
                        else if(choice2==8){
                            Institute.get_avg();
                        }
                        else if(choice2==9){
                            Institute.get_reg_companies();
                            int choice3 = sc.nextInt();
                            String w6 = sc.nextLine();
                            Institute.get_company_results(Institute.reg_companies.get(choice3-1));
                            
                        }
                        else if(choice2==10){
                            break;
                        }
                        else{
                            System.out.println("Invalid input");
                        }
                    }
                    }
                    else if(choice1==4){
                        break;
                    }
                    else{
                        System.out.println("Invalid input");
                    }
        }}
            else if(choice==2){
                break;
            }
            else{
                System.out.println("Invalid input");
            }
    }}}

    
