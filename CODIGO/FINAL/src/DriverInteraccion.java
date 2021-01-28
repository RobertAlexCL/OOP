/*Proyecto Voluntarios
  Fecha 281018
  Entrega 4
  Archivo DriverInteraccion.java*/
 
/*Importamos el scanner y las librerias necesarias.*/ 
import java.util.*;

import conectorBD.Conectate;
import conectorBD.MySQLConexion;

import java.text.*;
import java.io.Console;
import java.io.IOException;
import java.sql.Connection;


/*DriverInteraccion es nuestro driver del programa.*/
public class DriverInteraccion {
	MySQLConexion db = new MySQLConexion();
	
	/*main que sera quien ejecute el programa con todos nuestros objetos creados*/
	public static void main(String[] args) {
		/*Primero creamos un scanner para pedir los datos solicitados durante la ejecucion.*/
		/*Creamos un par de usuarios para implementar bd en la ultima entrega.*/
		ArrayList<voluntario> voluns = new ArrayList<voluntario>();
		ArrayList<movimiento> movs = new ArrayList<movimiento>();
		movimiento movcr;
		movcr=new movimiento("Techo","Techo","hola","Pobreza cero");
		movs.add(movcr);
		movcr=new movimiento ("IGER","IGER","iger","Educacion de Calidad");
		movs.add(movcr);
		voluntario uscr;
		uscr=new voluntario("Andres","and123","hola",18);
		voluns.add(uscr);
		uscr=new voluntario("Jorge","jorgee","jorgito",18);
		voluns.add(uscr);
		uscr=new voluntario("Victor","victor","victima",30);
		voluns.add(uscr);
		Scanner leer = new Scanner(System.in);
		String resp="3";
		//usuario user=null;
		/*Se crean mensajes que se utilizaran durante el programa*/
		/*Basicamente esto debe ser un diccionario para ser utilizable.*/
		String ast=("\n*****************************************************");
		String bienvenida=(ast+"\n Bienvenido al sistema de voluntarios por Guatemala." + ast);
		String menuprincipal=("Ingrese la opcion que desea utilizar: \n\t 1.Ingresar al sistema \n\t 2.Crear usuario para convertirte en voluntario \n\t 3.Información sobre la aplicación \n\t 4.Para salir.\n" );
		String error=("Error, la opcion debe ser valida.");
		String info=("Voluntarios por Guatemala nace de la necesidad de cumplir los Objetivos de Desarrolo Humano propuestos por"
				+ "\nla ONU en 2015 para ser alcanzados en año 2030. Este programa pretende enlazar voluntarios con organizaciones"
				+ "\npara resolver dicha problematica. Los ODS con los que se esta trabajando son: "
				+ "\n\t1. Fin de la pobreza." +"\n\t2.Hambre Cero" + "\n\t3.Educacion de Calidad");
		String nom;
		String user;
		String contra;
		String contra2;
		boolean v=false;
		boolean m=false;
		int edad;
		System.out.println(bienvenida);
		/*Segun la opcion realiza lo que se le pide
		Si la opcion es 1 entonces ingresa como usuario en el sistema
		Si la opcion es 2 entonces se va a la opcion de crear un usuario para utilizar el sistema
		Si la opcion es 3 entonces unicamente despliega informacion sobre el sistema.*/	
		do {
			if(resp.equals("1")==false && resp.equals("2")==false && resp.equals("3")==false) {
				System.out.println(error);
			}
			System.out.println(menuprincipal);
			resp= leer.next();
		switch (resp) {
	      case ("1"):
	    	  /*Pide el ingreso de un usuario y verifica que este dentro del sistema.
	    	   Si esta dentro ingresa 
	    	   Esto puede ser como movimiento o como voluntario.*/
				System.out.println("Ingrese su Usuario: ");
				  user= leer.next();
				System.out.println("Ingrese su contraseña: ");
				 String contrasena= leer.next();
				 
				v=false;
				m=false;
				voluntario voladentro=null;
				movimiento movadentro=null;
				for(int x=0; x<voluns.size();x++) {
					voladentro =voluns.get(x);
					if((voladentro.getUsuario().equals(user))&&(voladentro.getContra().equals(contrasena))) {
						v=true;
						break;
					}
				}
				for(int x=0; x<movs.size();x++) {
					movadentro =movs.get(x);
					if((movadentro.getUsuario().equals(user))&&(movadentro.getContra().equals(contrasena))) {
						m=true;
						break;
					}
				}
				String respd="";
				if (v==false && m==false) {
					/*ERROR AL INGRESO*/
					System.out.println("Error. Usuario y contrasena no encontrados.");
				}else if (v==true) {
					/*Ingreso como voluntario*/
					do{
						if(respd.equals("1")==false && respd.equals("2")==false && respd.equals("3")==false && respd.equals("")==false) {
							System.out.println(error);
						}
						System.out.println(voladentro.menu());
						respd=leer.next();
						switch (respd) {
					      case ("1"):
					    	  		System.out.println(voladentro.mostrarmiseventos());
					      			break;
					      case ("2"):
					    	  		for(int x=0; x<movs.size(); x++) {
					    	  			System.out.println("\t"+(x+1)+". "+movs.get(x).getNombre());
					    	  			System.out.println("\t\t"+movs.get(x).mostrareventos());
					    	  		}
					      			break;
					      default:
					    	  break;
							}
					}while(respd.equals("1")==true || respd.equals("2")==true || respd.equals("3")==false);
					v=false;
				}else if(m==true){
					/*Ingreso como movimiento.*/
					do{
						if(respd.equals("1")==false && respd.equals("2")==false && respd.equals("3")==false && respd.equals("")==false) {
							System.out.println(error);
						}
						System.out.println(movadentro.menu());
						respd=leer.next();
						switch (respd) {
					      case ("1"):
					    	  	System.out.println("Ingrese el nombre del evento");
							 	nom= leer.next();
							 	System.out.println("Ingrese la fecha");
							 	String fecha= leer.next();
							 	System.out.println("Ingrese el lugar");
							 	String lugar= leer.next();
							 	System.out.println(movadentro.generarEvento(fecha, lugar, nom));
					      			break;
					      case ("2"):
					    	  		System.out.println("\t"+movadentro.getNombre());
		    	  					System.out.println("\t\t"+movadentro.mostrareventos());
					      			break;
					      default:
					    	  break;
							}
					}while(respd.equals("1")==true || respd.equals("2")==true || respd.equals("3")==false);
					m=false;
				}
	           break;
	      case ("2"):
	    	  /*Pide informacion para crear un voluntario y verifica
	    	   *  que todos los registros sean correctos.*/
	            System.out.println("Ingrese su Nombre");
				 nom= leer.next();
				System.out.println("Ingrese su Usuario");
				 user= leer.next();
				System.out.println("Ingrese su contraseña");
				 contra= leer.next();	
				 boolean error1=false;
				 edad=0;
				 do {
					 try {
					 	System.out.println("Ingrese su edad");
						edad = leer.nextInt();
						if(edad<0 || edad>100) {
							throw new InputMismatchException() ;
						}
						error1=false;
				 } catch (InputMismatchException e) {
						System.out.println("Error. Debe ingresar una edad valida. ");
						break;
						
						
				 }	
				 
				 }while(edad==0);
				 /*Se crea el voluntario y se ve que ya es un voluntario.*/
				 uscr=new voluntario(nom,user,contra,edad);
				System.out.println("Usted es un voluntario. Bienvenido.");
				voluns.add(uscr);
				//Se crea un nuevo usuario con los datos ingresados y es anadido al ArrayList
				 
				 
	            break;
	      case ("3"):
	    	  /*Muestra informacion sobre la aplicacion.*/
	            System.out.println(info);
				
				
	            break;
	      case ("4"):
	    	  break;
	      default:
	           System.out.println("" );
	           break;
	      }
		/*Siempre y cuando el usuario no desee salir y cerrar sesion..*/
	}while (((resp.equals("1")==false) || ((v==false && m==false && resp.equals("1"))|| resp.equals("3")|| resp.equals("2"))) && (resp.equals("4")==false));
	System.out.println("Gracias por utilizar el programa de voluntarios.");
	
	}

}
