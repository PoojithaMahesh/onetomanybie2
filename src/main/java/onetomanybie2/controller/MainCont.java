package onetomanybie2.controller;

import onetomanybie2.dao.CompanyDao;
import onetomanybie2.dao.EmployeeDao;
import onetomanybie2.dto.Company;
import onetomanybie2.dto.Employee;

public class MainCont {
public static void main(String[] args) {
	Company company=new Company();
	company.setId(2);
	company.setName("TcSS");
	company.setAddress("Bangalore");
	
//	CompanyDao companyDao=new CompanyDao();
//	companyDao.saveCompany(company);
//	
	
	Employee employee=new Employee();
	employee.setId(5);
	employee.setName("naresh");
	employee.setCompany(company);
	
	EmployeeDao dao=new EmployeeDao();
	dao.saveEmployee( employee);
	
	
	
}
}
