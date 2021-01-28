import java.util.ArrayList;

/*Proyecto Voluntarios
  Fecha 281018
  Entrega 4
  Archivo movimiento.java*/

/*Clase derivada de usuario como administrador movimiento*/
public class movimiento extends usuario{
	//Un array list de los eventos que tiene el movimiento.
	
	ArrayList<evento> events = new ArrayList<evento>();
	String ODS;
	/*Instancia un nuevo movimiento*/
	public movimiento(String nombre, String usuario, String contra, String ODS) {
		super();
		this.nombre = nombre;
		this.usuario = usuario;
		this.contra = contra;
		this.ODS = ODS;
		this.tipo = "Movimiento";
	}
	
	/*Genera eventos.*/
	public String generarEvento(String fecha, String lugar, String nombre) {
		evento event =new evento(fecha,lugar,nombre);
		events.add(event);
		String m="Nuevo Evento Creado";
		return m;
	}
	
	/*Muestra menu*/
	public String menu(){
		String men="Usuario: "+ nombre +"\n\t1.Crear un evento. \n\t2.Ver los eventos. \n\t3.Salir de la cuenta.";
		return men;
	}
	
	/*Muestra eventos*/
	public String mostrareventos(){
		String m="";
		if(events.size()==0) {
			m="No existen eventos en este movimiento.";
		}
		for(int x=0; x<events.size();x++) {
			m=m+"\t\t "+(x+1)+" "+(events.get(x).showEvento())+"\n";
		}
		return m;
		
	}
}
