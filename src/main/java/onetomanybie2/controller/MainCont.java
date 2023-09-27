package onetomanybie2.controller;

import onetomanybie2.dao.CompanyDao;
import onetomanybie2.dao.EmployeeDao;
import onetomanybie2.dto.Company;
import onetomanybie2.dto.Employee;

public class MainCont {
public static void main(String[] args) {
	Company company=new Company();
	company.setName("HCL");
	company.setAddress("Bangalore");
//	
//	CompanyDao companyDao=new CompanyDao();
//	companyDao.saveCompany(company);
////	
//	
//	Employee employee=new Employee();
//	employee.setId(5);
//	employee.setName("naresh");
//	employee.setCompany(company);
//	
//	EmployeeDao dao=new EmployeeDao();
//	dao.saveEmployee( employee);
//	
	
	CompanyDao companyDao=new CompanyDao();
//	companyDao.updateCompany(2, company);
	companyDao.deleteCompany(2);
	
	
}
}
