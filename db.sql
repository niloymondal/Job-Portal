-------------------------------Company Table----------------------------
CREATE TABLE company           -------------------------------done
(
company_id int IDENTITY(1000,1) PRIMARY KEY,
password  varchar(50) NOT NULL,
company_name varchar(50) NOT NULL,
website_url varchar(50) NULL,
company_email varchar(30) NOT NULL unique,
company_contact varchar(11) NOT NULL
)





-------------------------------Job_Information----------------------------
CREATE TABLE Job_Information                -------------------------done
(
job_id int IDENTITY(1000,1) PRIMARY KEY,
company_id int NOT NULL FOREIGN KEY REFERENCES company(company_id),
application_LastDate varchar(20) NOT NULL,
job_category  varchar(30) NOT NULL,
job_requirements  varchar(500) NOT NULL,
job_type varchar(50) NOT NULL,
No_of_vacancy int NOT NULL,
salary  varchar(50) NOT NULL,
form_fee varchar(50) NULL,
age varchar(20) NULL,
job_posting varchar(50) NOT NULL
)

select * from Job_Information

SELECT company.company_name 
FROM company  INNER JOIN Job_Information ON company.company_id = Job_Information.company_id
WHERE Job_Information.job_id = '1013'





-------------------------------applicant----------------------------

CREATE TABLE applicant                     -------------------------------done
(
applicant_id int IDENTITY(1001,1) PRIMARY KEY,
password  varchar(50) NOT NULL,
applicant_name varchar(100) NOT NULL,
applicant_phone varchar(11) NOT NULL,
applicant_email varchar(50) NOT NULL unique,
date_of_birth  varchar(50) NOT NULL,
applicant_age  varchar(50) NOT NULL,
image image NOT NULL, -------------------------
gender  varchar(6) NOT NULL,
present_address varchar(50) NOT NULL,
permanent_address varchar(50) NOT NULL,
education varchar(20) not null
)
select * from applicant



-------------------------------Application_details----------------------------

CREATE TABLE application_details
(
application_id int IDENTITY(1,1) PRIMARY KEY,
job_id int NOT NULL FOREIGN KEY REFERENCES Job_Information(job_id),
applicant_id int NOT NULL FOREIGN KEY REFERENCES applicant(applicant_id),
 skills varchar(50) NOT NULL,
experience varchar(50) NOT NULL,
reason_for_hiring  varchar(200) NOT NULL,
--status  varchar(50) NOT NULL, --------------------
)

ALTER TABLE application_details ADD emp_status varchar (30)

select * from application_details


-------------------------------Employee review----------------------------

CREATE TABLE employee_review                           
(
review_id int IDENTITY(1,1) PRIMARY KEY,
applicant_id int NOT NULL FOREIGN KEY REFERENCES applicant(applicant_id),
company_id int NOT NULL FOREIGN KEY REFERENCES COMPANY(company_id),
previous_company_post varchar(20) NOT NULL,
review varchar(512) NOT NULL,
)


-------------------------------Job Result----------------------------


CREATE TABLE job_result                      
(
result_id int IDENTITY(1,1) PRIMARY KEY,
job_id int NOT NULL FOREIGN KEY REFERENCES Job_Information(job_id),
applicant_id int NOT NULL FOREIGN KEY REFERENCES applicant(applicant_id),
status varchar(50) NOT NULL, ---------------------------------------------
short_message varchar(100) NULL,
interview_location  varchar(50)  NULL,
interview_date varchar(20) NULL
)



-------------------------------Applicant credential----------------------------

CREATE TABLE applicant_credential                    
(
credential_id int IDENTITY(1,1) PRIMARY KEY,
job_id int NOT NULL FOREIGN KEY REFERENCES Job_Information(job_id),
applicant_id int NOT NULL FOREIGN KEY REFERENCES applicant(applicant_id),
image1 image  NULL,
image2 image  NULL,
image3 image  NULL,
image4 image  NULL,
image5 image  NULL,
image6 image  NULL,
doc_name_1 varchar(30) NULL,
doc_name_2 varchar(30) NULL,
doc_name_3 varchar(30) NULL,
doc_name_4 varchar(30) NULL,
doc_name_5 varchar(30) NULL,
doc_name_6 varchar(30) NULL,
 --------------------------------------------------
)

-------------------------------Transection----------------------------


CREATE TABLE transection                    
(
trx_id  varchar(50) PRIMARY KEY,
job_id int NOT NULL FOREIGN KEY REFERENCES Job_Information(job_id),
applicant_id int NOT NULL FOREIGN KEY REFERENCES applicant(applicant_id),
transection_by varchar (15) not null,
status varchar(20) null default 'not verified'
)

SELECT application_details.applicant_id , skills,experience,reason_for_hiring,status,trx_id,transection_by
FROM application_details LEFT JOIN transection
ON application_details.applicant_id = transection.applicant_id WHERE application_details.job_id = '1013'



SELECT application_details.applicant_id , skills,experience,reason_for_hiring,status,trx_id,transection_by ,application_details.job_id
FROM application_details  INNER JOIN transection ON application_details.applicant_id = transection.applicant_id AND application_details.job_id = transection.job_id
WHERE application_details.job_id = '1013'


SELECT  company_contact
FROM Job_Information  INNER JOIN company ON Job_Information.company_id = company.company_id 
WHERE Job_Information.job_id = '1013'



----------------Display Table-----------
select * from company
select * from Job_Information
select * from applicant
select * from application_details
select * from transection
select * from employee_review
select * from job_result
select * from applicant_credential   

select * from Job_Information
select * from application_details


SELECT  application_details.job_id,Job_Information.job_category,Job_Information.job_posting,Job_Information.job_type 
FROM application_details  INNER JOIN Job_Information ON application_details.job_id = Job_Information.job_id WHERE 
application_details.applicant_id = '1001'


select * from  job_result where applicant_id= '1001' AND job_id='1001'




Alter Table applicant drop column FirstName

CREATE TABLE msg                    
(
job_id int NOT NULL FOREIGN KEY REFERENCES Job_Information(job_id),
applicant_id int NOT NULL FOREIGN KEY REFERENCES applicant(applicant_id),
msg varchar (300) not null,
rd varchar(20) null
)
select * from msg

drop table msg