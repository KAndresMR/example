package ec.edu.ups.ejemplo.dao;

import java.util.List;
import ec.edu.ups.ejemplo.model.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class UsuarioDao {

	@PersistenceContext
	private EntityManager em; // EntityManager para interactuar con la base de datos

	public void insert(Usuario usuario) {
		em.persist(usuario); // Persistir el objeto usuario en la base de datos
	}

	public void update(Usuario usuario) {
		em.merge(usuario); // Actualiza el objeto usuario en la base de datos
	}

	public Usuario read(int id) {
		return em.find(Usuario.class, id); // Encuentra y retorna el usuario por ID
	}

	public List<Usuario> getAll() {
		String jpql = "SELECT u FROM Usuario u"; // JPQL para seleccionar todos los usuarios
		Query q = em.createQuery(jpql, Usuario.class); // Crea la consulta
		return q.getResultList(); // Retorna la lista de usuarios
	}

	public Usuario findByUsername(String username) {
		String jpql = "SELECT u FROM Usuario u WHERE u.username = :username"; // JPQL para buscar por nombre de usuario
		Query q = em.createQuery(jpql, Usuario.class); // Crea la consulta
		q.setParameter("username", username); // Establece el parámetro de consulta
		return (Usuario) q.getSingleResult(); // Retorna el único resultado
	}

}
