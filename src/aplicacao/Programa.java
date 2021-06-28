package aplicacao;

import java.util.Date;

import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {
		
		Departamento dep = new Departamento(1, "TI");
		Vendedor vend = new Vendedor(1, "Guilherme", "Gui@gmail.com", new Date(), 3000.0, dep);
		
		System.out.println("Departamento: " + dep);
		System.out.println("Vendedor: " + vend);
		
	}
}
