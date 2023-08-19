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
public class view_application_details_class {
    String applicant_id , skills,experience,reason_for_hiring,status,trx_id,transection_by,emp_status;

    public view_application_details_class(String applicant_id, String skills, String experience, String reason_for_hiring, String status, String trx_id, String transection_by ,String emp_status) {
        this.applicant_id = applicant_id;
        this.skills = skills;
        this.experience = experience;
        this.reason_for_hiring = reason_for_hiring;
        this.status = status;
        this.trx_id = trx_id;
        this.transection_by = transection_by;
        this.emp_status=emp_status;
    }

    public String getEmp_status() {
        return emp_status;
    }

    public void setEmp_status(String emp_status) {
        this.emp_status = emp_status;
    }

    public String getApplicant_id() {
        return applicant_id;
    }

    public void setApplicant_id(String applicant_id) {
        this.applicant_id = applicant_id;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getReason_for_hiring() {
        return reason_for_hiring;
    }

    public void setReason_for_hiring(String reason_for_hiring) {
        this.reason_for_hiring = reason_for_hiring;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrx_id() {
        return trx_id;
    }

    public void setTrx_id(String trx_id) {
        this.trx_id = trx_id;
    }

    public String getTransection_by() {
        return transection_by;
    }

    public void setTransection_by(String transection_by) {
        this.transection_by = transection_by;
    }
    
}
