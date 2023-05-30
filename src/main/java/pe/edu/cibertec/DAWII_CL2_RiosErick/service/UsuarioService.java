package pe.edu.cibertec.DAWII_CL2_RiosErick.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL2_RiosErick.model.bd.Usuario;
import pe.edu.cibertec.DAWII_CL2_RiosErick.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuRepo;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public Usuario findbyEmail(String email){
        return usuRepo.findByEmail(email);
    }

    public Usuario findByNomusuario(String nomusuario){

        return usuRepo.findByNomusuario(nomusuario);
    }

    public Usuario guardarUsuario (Usuario usu){
        usu.setPassUsuario(bCryptPasswordEncoder.encode(usu.getPassUsuario()));
        return usuRepo.save(usu);
    }



}
