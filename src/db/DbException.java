package db;

public class DbException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;

	//Exce��o personalisada
	public DbException(String msg) {
		super(msg);
	}
}
