/*Proyecto Voluntarios
  Fecha 281018
  Entrega 4
  Archivo DriverInteraccion.java*/

 /*Importamos el scanner y las librerias necesarias.*/ 
import java.util.Scanner;

import conectorBD.MySQLConexion;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.*;
import java.util.Random;
import java.util.ArrayList;

/*Clase usuario*/ 
public abstract class usuario {
	/*Propiedades
	Todas ellas son protected al ser parte de un tipo de herencia y que a su vez son para una clase abstracta.
	Estas permitiran darle nombre al usuario y un ID. De esta forma heredaran tipos.*/
	
	protected String nombre;
	protected String usuario;
	protected String contra;
	protected int edad;
	protected int ID;
	protected String tipo;

	
	public usuario() {
		
	}

	/*Metodos*/
	/*Getters y Setters de las propiedades.*/
	
	
	public String getContra() {
		return contra;
	}
	public void setContra(String contra) {
		this.contra = contra;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}		
	
}
