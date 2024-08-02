package ec.edu.ups.ejemplo.services;

public class Respuesta {

	private int codigo; // Código de la respuesta (OK o ERROR)
	private String mensaje; // Mensaje descriptivo de la respuesta

	// Constantes para representar estados de respuesta
	public static int OK = 1;
	public static int ERROR = 99;

	/**
	 * Constructor para crear una instancia de Respuesta con un código y mensaje.
	 */
	public Respuesta(int codigo, String mensaje) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
	}

	// Métodos getters y setters para acceder y modificar los atributos
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
