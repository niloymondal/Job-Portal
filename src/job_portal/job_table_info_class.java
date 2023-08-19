/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package job_portal;

/**
 *
 * @author Siham
 */
public class job_table_info_class {
     private String Job_Category,Requirements,Employment_Status,Vacancy,Salary,Maximum_age,Job_Location,Application_fee,LastDate,company_id,job_id;

    public job_table_info_class(String Job_Category, String Requirements, String Employment_Status, String Vacancy, String Salary, String Maximum_age, String Job_Location, String Application_fee,String LastDate,String company_id ,String job_id) {
        this.Job_Category = Job_Category;
        this.Requirements = Requirements;
        this.Employment_Status = Employment_Status;
        this.Vacancy = Vacancy;
        this.Salary = Salary;
        this.Maximum_age = Maximum_age;
        this.Job_Location = Job_Location;
        this.Application_fee = Application_fee;
        this.LastDate = LastDate;
        this.company_id = company_id;
        this.job_id=job_id;
    }

    public String getJob_Category() {
        return Job_Category;
    }

    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public String getLastDate() {
        return LastDate;
    }

    public void setLastDate(String LastDate) {
        this.LastDate = LastDate;
    }

    public String getcompany_id() {
        return company_id;
    }

    public void setcompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getRequirements() {
        return Requirements;
    }

    public String getEmployment_Status() {
        return Employment_Status;
    }

    public String getVacancy() {
        return Vacancy;
    }

    public String getSalary() {
        return Salary;
    }

    public String getMaximum_age() {
        return Maximum_age;
    }

    public String getJob_Location() {
        return Job_Location;
    }

    public String getApplication_fee() {
        return Application_fee;
    }

   

    public void setJob_Category(String Job_Category) {
        this.Job_Category = Job_Category;
    }

    public void setRequirements(String Requirements) {
        this.Requirements = Requirements;
    }

    public void setEmployment_Status(String Employment_Status) {
        this.Employment_Status = Employment_Status;
    }

    public void setVacancy(String Vacancy) {
        this.Vacancy = Vacancy;
    }

    public void setSalary(String Salary) {
        this.Salary = Salary;
    }

    public void setMaximum_age(String Maximum_age) {
        this.Maximum_age = Maximum_age;
    }

    public void setJob_Location(String Job_Location) {
        this.Job_Location = Job_Location;
    }

    public void setApplication_fee(String Application_fee) {
        this.Application_fee = Application_fee;
    }
 
}
