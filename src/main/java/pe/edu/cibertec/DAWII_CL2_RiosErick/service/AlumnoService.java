package pe.edu.cibertec.DAWII_CL2_RiosErick.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL2_RiosErick.model.bd.Alumno;
import pe.edu.cibertec.DAWII_CL2_RiosErick.repository.AlumnoRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository arepo;

    public List<Alumno> listarAlumnos(){
        return arepo.findAll();
    }

    public Optional<Alumno> buscarAlunoxId(String id){
        Optional<Alumno> alu = arepo.findById(id);
        if(alu.isEmpty())
            return Optional.empty();
        else return alu;
    }

    public Alumno registrar(Alumno alumno){
        return arepo.save(alumno);
    }

    public HashMap <String, String> eliminarxId(String id){
        HashMap <String, String> respuesta = new HashMap<String, String>();
        arepo.deleteById(id);
        respuesta.put("mensaje","Alumno eliminado correctamente");
        return respuesta;
    }
}
