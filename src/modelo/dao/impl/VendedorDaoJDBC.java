package modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import modelo.dao.VendedorDao;
import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class VendedorDaoJDBC implements VendedorDao{

	//Dependencia com a conexão
	private Connection conn;
	
	public VendedorDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Vendedor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Vendedor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vendedor findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT vendedor.*,departamento.Nome as DepName "
					+ "FROM vendedor INNER JOIN departamento "
					+ "ON vendedor.departamentoId = departamento.Id "
					+ "WHERE vendedor.Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Departamento dep = new Departamento();
				dep.setId(rs.getInt("DepartamentoId"));
				dep.setNome(rs.getString("DepName"));
				Vendedor obj = new Vendedor();
				obj.setId(rs.getInt("Id"));
				obj.setNome(rs.getString("Nome"));
				obj.setEmail(rs.getString("Email"));
				obj.setDataNascimento(rs.getDate("DataNascimento"));
				obj.setSalarioBase(rs.getDouble("SalarioBase"));
				obj.setDepartamento(dep);
				return obj;
			}
			return null;			
		}
		catch (SQLException e) {
			throw new DbException(e.getLocalizedMessage());
		}
		finally {
			DB.closeStatment(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Vendedor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
