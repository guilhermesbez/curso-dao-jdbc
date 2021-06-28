package db;

public class DbIntegrityException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	//Exceção personalizada de erro de Integridade
	public DbIntegrityException(String msg) {
		super(msg);
	}
	
}
