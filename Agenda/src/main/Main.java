package main;

import dto.DomicilioDTO;
import modelo.Agenda;
import persistencia.conexion.Conexion;
import persistencia.dao.mysql.DAOSQLFactory;
import persistencia.dao.mysql.DomicilioDAOSQL;
import presentacion.controlador.Controlador;
import presentacion.vista.Vista;

public class Main {

	public static void main(String[] args) {
//		Vista vista = new Vista();
//		Agenda modelo = new Agenda(new DAOSQLFactory());
//		Controlador controlador = new Controlador(vista, modelo);
//		controlador.inicializar();
		DomicilioDTO d= new DomicilioDTO(3, "MMM---AAA", 433, 2223, 2112, 1);
		DomicilioDAOSQL dw= new DomicilioDAOSQL();
	    System.out.println(dw.update(d));
	}
}
