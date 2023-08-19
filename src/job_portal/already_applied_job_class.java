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
public class already_applied_job_class {
    String job_category,job_posting,job_type,Job_id;

    public already_applied_job_class(String job_category, String job_posting, String job_type ,String Job_id) {
        this.job_category = job_category;
        this.job_posting = job_posting;
        this.job_type = job_type;
        this.Job_id=Job_id;
    }

    public String getJob_id() {
        return Job_id;
    }

    public void setJob_id(String Job_id) {
        this.Job_id = Job_id;
    }

    public String getJob_category() {
        return job_category;
    }

    public void setJob_category(String job_category) {
        this.job_category = job_category;
    }

    public String getJob_posting() {
        return job_posting;
    }

    public void setJob_posting(String job_posting) {
        this.job_posting = job_posting;
    }

    public String getJob_type() {
        return job_type;
    }

    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }
    
}
