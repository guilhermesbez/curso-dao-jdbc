package modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
				Departamento dep = instantiateDepartamento(rs);
				Vendedor obj = instantiateVendedor(rs, dep);
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
	
	//Metodo para fazer o sql no banco
	private Vendedor instantiateVendedor(ResultSet rs, Departamento dep) throws SQLException {
		Vendedor obj = new Vendedor();
		obj.setId(rs.getInt("Id"));
		obj.setNome(rs.getString("Nome"));
		obj.setEmail(rs.getString("Email"));
		obj.setDataNascimento(rs.getDate("DataNascimento"));
		obj.setSalarioBase(rs.getDouble("SalarioBase"));
		obj.setDepartamento(dep);
		return obj;
	}
	
	//Metodo para fazer o sql no banco
	private Departamento instantiateDepartamento(ResultSet rs) throws SQLException {
		Departamento dep = new Departamento();
		dep.setId(rs.getInt("DepartamentoId"));
		dep.setNome(rs.getString("DepName"));
		return dep;
	}

	@Override
	public List<Vendedor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vendedor> findByDepartamento(Departamento departamento) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT vendedor.*,departamento.Nome as DepName "
					+ "FROM vendedor INNER JOIN departamento "
					+ "ON vendedor.departamentoId = departamento.Id "
					+ "WHERE departamentoId = ? "
					+ "ORDER BY Nome");
			
			st.setInt(1, departamento.getId());
			rs = st.executeQuery();
			
			List<Vendedor> list = new ArrayList<Vendedor>();
			Map<Integer, Departamento> map = new HashMap<>();
			
			while (rs.next()) {
				
				Departamento dep = instantiateDepartamento(rs);
				
				if(dep == null) {
					dep = instantiateDepartamento(rs);
					map.put(rs.getInt("DepartamentoId"), dep);
				}
								
				Vendedor obj = instantiateVendedor(rs, dep);
				list.add(obj);
			}
			return list;			
		}
		catch (SQLException e) {
			throw new DbException(e.getLocalizedMessage());
		}
		finally {
			DB.closeStatment(st);
			DB.closeResultSet(rs);
		}
	}

	
}
