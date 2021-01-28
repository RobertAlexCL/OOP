import java.util.ArrayList;

/*Proyecto Voluntarios
  Fecha 281018
  Entrega 4
  Archivo voluntario.java*/

/*Clase derivada de usuario.*/
public class voluntario extends usuario {
	/*Sus evnetos.*/
	ArrayList<evento> miseventos = new ArrayList<evento>();
	
	
	/*Crea un nuevo voluntario.*/
	public voluntario(String nombre, String usuario, String contra, int edad) {
		super();
		this.nombre = nombre;
		this.usuario = usuario;
		this.contra = contra;
		this.edad = edad;
		this.tipo = "Voluntario";
	}
	
	/*Muestra sus eventos.*/
	public String mostrarmiseventos(){
		String m="";
		if(miseventos.size()==0) {
			m="Usted no tiene eventos.";
		}
		for(int x=0; x<miseventos.size();x++) {
			m=m+x+" "+(miseventos.get(x).showEvento())+"\n";
		}
		return m;
		
	}
	
	/*Muestra el menu*/
	public String menu(){
		String men="Usuario: "+ nombre +"\n\t1.Ver mis eventos. \n\t2.Ver las organizaciones y sus eventos. \n\t3.Salir de la cuenta.";
		return men;
	}
	
	/*Se une a un movimiento.*/
	public String unirseEvento(evento eve) {
		miseventos.add(eve);
		String m=("Usted se ha unido al eveneto " + eve.getNombre());
		return m;
	}
	
	
}
