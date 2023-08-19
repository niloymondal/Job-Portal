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
public class posted_job_class {
    String job_id,last_date,job_cat,vacancy;

    public posted_job_class(String job_id, String last_date, String job_cat, String vacancy) {
        this.job_id = job_id;
        this.last_date = last_date;
        this.job_cat = job_cat;
        this.vacancy = vacancy;
    }

    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public String getLast_date() {
        return last_date;
    }

    public void setLast_date(String last_date) {
        this.last_date = last_date;
    }

    public String getJob_cat() {
        return job_cat;
    }

    public void setJob_cat(String job_cat) {
        this.job_cat = job_cat;
    }

    public String getVacancy() {
        return vacancy;
    }

    public void setVacancy(String vacancy) {
        this.vacancy = vacancy;
    }
    
    
}
