package pe.edu.cibertec.DAWII_CL2_RiosErick.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL2_RiosErick.model.bd.Usuario;

@Service
public class UsuarioDetalleService implements UserDetailsService {

    @Autowired
    private UsuarioService usuS;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuS.findByNomusuario(username);

        if(usuario== null) {
            throw new UsernameNotFoundException("Usuario no encontrado con nombre:" + username);
        }
        return org.springframework.security.core.userdetails.User.withUsername(usuario.getNomusuario()).password(usuario.getPassUsuario()).build();
    }
}
