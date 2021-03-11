package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("----- Test department findById -----");
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		Department dep = depDao.findById(2);
		System.out.println(dep);

		System.out.println("\n----- Test department Insert -----");
		Department newDep = new Department(null, "Attendance");
		depDao.insert(newDep);
		System.out.println("Inserted ! new Id: " + newDep.getId());

		System.out.println("\n----- Test department Update -----");
		newDep = depDao.findById(3);
		newDep.setName("TI");
		depDao.update(newDep);
		System.out.println("Update Completed!");

		System.out.println("\n----- Test department DeleteById -----");
		System.out.print("Enter Id for delete test: ");
		int id = sc.nextInt();
		depDao.deleteById(id);

		System.out.println("\n----- Test department FindAll -----");
		List<Department> list = depDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}

		sc.close();

	}

}
