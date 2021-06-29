package modelo.dao;

import db.DB;
import modelo.dao.impl.DepartamentoDaoJDBC;
import modelo.dao.impl.VendedorDaoJDBC;

public class DaoFactory {

	//Metodo para não expor os metodos e atributos da classe
	public static VendedorDao createVendedorDao() {
		return new VendedorDaoJDBC(DB.getConnection());
	}
	
	//Metodo para não expor os metodos e atributos da classe
	public static DepartamentoDao createDepartamentoDao(){
		return new DepartamentoDaoJDBC();
	}
}
