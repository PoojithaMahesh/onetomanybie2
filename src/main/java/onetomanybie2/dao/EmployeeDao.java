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
			
			if(company.getEmployees().isEmpty()) {
//				you are the first employee of that company
//				so im creating a new List of Employee
				List<Employee> employees=new ArrayList<Employee>();
				employees.add(employee);
				company.setEmployees(employees);
			}else {
//				employees are already present in the company
//				so im taking old employees as getEmployess
				List<Employee> employees=company.getEmployees();
				employees.add(employee);
				company.setEmployees(employees);
			}
			entityTransaction.commit();
		
		}else {
			System.out.println("sorry company id is not present");
		}
		
		
		
		
	}
	
	public void updateEmplpoyee(int id,Employee employee) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Employee dbEmployee=entityManager.find(Employee.class, id);
		if(dbEmployee!=null) {
//			id is present
			entityTransaction.begin();
			employee.setId(id);
			employee.setCompany(dbEmployee.getCompany());
			
			entityManager.merge(employee);
			entityTransaction.commit();
		}
		
		
		
		
	}
	
	
	
	public void deleteEMplpoyee(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
//		check whether that company is present or not with the help of id
		Employee dbEmployee=entityManager.find(Employee.class, id);
		if(dbEmployee!=null) {
//			that id is present
			entityTransaction.begin();
			entityManager.remove(dbEmployee);
			entityTransaction.commit();
		}else {
//			id is not presengt
			System.out.println("id is not present");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
