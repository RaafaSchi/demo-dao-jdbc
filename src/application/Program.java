package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		System.out.println("----- Test seller findByID -----");
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n---- Teste seller findByDepartment -----");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n---- Teste seller findAll -----");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n---- Teste seller insert -----");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4500.0, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New Id: " + newSeller.getId());

		System.out.println("\n---- Teste seller update -----");
		seller = sellerDao.findById(1);
		seller.setName("Rodolfo");
		seller.setEmail("rodolfo@gmail.com");
		sellerDao.update(seller);
		System.out.println("Update Completed");

	}

}
