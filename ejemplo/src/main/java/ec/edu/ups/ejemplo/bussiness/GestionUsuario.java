package ec.edu.ups.ejemplo.bussiness;

import java.util.List;
import ec.edu.ups.ejemplo.dao.UsuarioDao;
import ec.edu.ups.ejemplo.model.Usuario;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionUsuario {

	@Inject
    private UsuarioDao usuarioDao;

    public void saveUser(Usuario usuario) {
        Usuario usr = usuarioDao.read(usuario.getId());
        if (usr != null) {
            usuarioDao.update(usuario);
        } else {
            usuarioDao.insert(usuario);
        }
    }

    public List<Usuario> listUser() {
        return usuarioDao.getAll();
    }
    
    public Usuario searchUserbyUsername(String username) {
        return usuarioDao.findByUsername(username);
    }
}
