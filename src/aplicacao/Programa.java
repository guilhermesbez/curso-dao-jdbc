package aplicacao;

import java.util.List;

import modelo.dao.DaoFactory;
import modelo.dao.VendedorDao;
import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {
		
		VendedorDao vendedorDao = DaoFactory.createVendedorDao();
		
		System.out.println("==Test 1: Vendedor findById====");
		Vendedor vendedor = vendedorDao.findById(24);
		
		System.out.println("Vendedor: " + vendedor);
		
		System.out.println("\n===Test 2: Vendedor findByDepartamento=====");
		Departamento departamento = new Departamento(4, null);
		List<Vendedor> list = vendedorDao.findByDepartamento(departamento);
		
		for (Vendedor obj : list) {
			System.out.println(obj);
		}
	}
}
