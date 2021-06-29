package aplicacao;

import modelo.dao.DaoFactory;
import modelo.dao.DepartamentoDao;
import modelo.dao.VendedorDao;
import modelo.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {
		
		VendedorDao vendedorDao = DaoFactory.createVendedorDao();
		DepartamentoDao departamentoDao = DaoFactory.createDepartamentoDao();
		
		
		Vendedor vendedor = vendedorDao.findById(24);
		
		System.out.println("Vendedor: " + vendedor);
		
	}
}
