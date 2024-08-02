package ec.edu.ups.ejemplo.services;

import java.util.List;
import ec.edu.ups.ejemplo.bussiness.GestionUsuario;
import ec.edu.ups.ejemplo.model.Usuario;
import ec.edu.ups.ejemplo.bussiness.GestionUsuario;
import ec.edu.ups.ejemplo.services.Respuesta;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/usuarios")
public class UsuarioService {

	@Inject
	private GestionUsuario gestionUsuarios;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Usuario usuario) {
		try {
			// Llama al método de negocio para guardar el usuario
			gestionUsuarios.saveUser(usuario);
			// Retorna una respuesta exitosa con el usuario creado
			return Response.ok(usuario).build();
		} catch (Exception e) {
			// Manejo de excepciones, en caso de error se imprime la traza del error
			e.printStackTrace();
			// Retorna una respuesta de error con un mensaje personalizado
			return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> list() {
		// Llama al método de negocio para listar los usuarios y retorna la lista
		return gestionUsuarios.listUser();
	}

	@GET
	@Path("/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserByUsername(@PathParam("username") String username) {
		// Busca el usuario por nombre de usuario utilizando la lógica de negocio
		Usuario usuario = gestionUsuarios.searchUserbyUsername(username);
		if (usuario != null) {
			// Si el usuario se encuentra, retorna una respuesta exitosa con el usuario
			return Response.ok(usuario).build();
		} else {
			// Si no se encuentra, retorna un estado 404 con un mensaje de error
			return Response.status(404).entity(new Respuesta(Respuesta.ERROR, "Usuario no encontrado")).build();
		}
	}
}
