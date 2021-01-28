import java.util.ArrayList;

/*Proyecto Voluntarios
  Fecha 281018
  Entrega 4
  Archivo evento.java*/

/*clase evento.*/
public class evento {
	/*variables que se necesitan para un evento y un arraylist de voluntarios que asisten.*/
	String fecha;

	String lugar;
	String nombre;
	ArrayList<voluntario> volunt = new ArrayList<voluntario>();
	
	/*constructor de evento.*/
	public evento(String fecha, String lugar, String nombre) {
		super();
		this.fecha = fecha;
		this.lugar = lugar;
		this.nombre = nombre;
	}
	
	/*agregar  voluntario y mostrar registros del evento.*/
	public void agregarvoluntario(voluntario vol) {
		volunt.add(vol);
	}
	public String showEvento() {
		String eve=("Evento "+nombre+ "\nEste evento se llevara a cabo en la fecha " +fecha+" y en el lugar "+lugar);	
		return eve;
	}
	
	public String calcularGentePresente() {
		String pre ="La cantidad de gente presente sera " + volunt.size();
		return pre;
	}
	
	public void nuevoVoluntario(voluntario vol) {
		volunt.add(vol);
	}
	
	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getLugar() {
		return lugar;
	}


	public void setLugar(String lugar) {
		this.lugar = lugar;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
