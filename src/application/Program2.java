package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("----- Test department findById -----");
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		Department dep = depDao.findById(2);
		System.out.println(dep);

		System.out.println("----- Test department Insert -----");
		Department newDep = new Department(null, "Supervisor");
		depDao.insert(newDep);
		System.out.println("Inserted ! new Id: " + newDep.getId());

		System.out.println("----- Test department Update -----");
		newDep = depDao.findById(3);
		newDep.setName("IT");
		depDao.update(newDep);
		System.out.println("Update Completed!");
				
				
		
		sc.close();


	}

}
