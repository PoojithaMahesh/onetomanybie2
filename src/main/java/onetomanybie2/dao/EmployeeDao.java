package onetomanybie2.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomanybie2.dto.Company;
import onetomanybie2.dto.Employee;

public class EmployeeDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	
	public void saveEmployee(Employee employee) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Company company=entityManager.find(Company.class,employee.getCompany().getId() );
	
		if(company!=null) {
			entityTransaction.begin();
			entityManager.persist(employee);
			
	
//				employees are already present in the company
				List<Employee> employees=company.getEmployees();
				employees.add(employee);
				company.setEmployees(employees);
			
			
			
			
			
			entityTransaction.commit();
			
			
			
			
		}else {
			System.out.println("sorry company id is not present");
		}
		
		
		
		
	}
}
