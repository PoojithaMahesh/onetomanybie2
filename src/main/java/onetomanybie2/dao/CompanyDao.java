package onetomanybie2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomanybie2.dto.Company;
import onetomanybie2.dto.Employee;

public class CompanyDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	
	public void saveCompany(Company company) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(company);
		entityTransaction.commit();
	}
	
	public void updateCompany(int id,Company company) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
//		check whether that company is present or not with the help of id
		Company dbCompany=entityManager.find(Company.class, id);
		if(dbCompany!=null) {
//			that id is present
			entityTransaction.begin();
			company.setId(id);
			company.setEmployees(dbCompany.getEmployees());
			entityManager.merge(company);
			
			entityTransaction.commit();
		}else {
//			id is not presengt
		}
		
		
		
	}
	
	
	
	public void deleteCompany(int id) {
//		id=1 hcl  this company is having 3 emp adesh pavithra 
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
//		check whether that company is present or not with the help of id
		Company dbCompany=entityManager.find(Company.class, id);
//		id=1 hcl  this company is having 3 emp adesh pavithra 
		if(dbCompany!=null) {
//			that id is present
			entityTransaction.begin();
			List<Employee> employees=dbCompany.getEmployees();
//			adesh pavithra 
			for(Employee employee:employees) {
//				adesh is the 1st=hcl
//				pavithra is the 1st=hcl
				employee.setCompany(null);
//				adesh is having null in its companyId col
//				pavithra is having null in its companyId col
			}
			entityManager.remove(dbCompany);
			entityTransaction.commit();
		}else {
//			id is not presengt
			System.out.println("id is not present");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
