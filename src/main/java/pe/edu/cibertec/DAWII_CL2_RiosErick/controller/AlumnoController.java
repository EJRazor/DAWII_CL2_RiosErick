package pe.edu.cibertec.DAWII_CL2_RiosErick.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DAWII_CL2_RiosErick.model.bd.Alumno;
import pe.edu.cibertec.DAWII_CL2_RiosErick.service.AlumnoService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="api/rios/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService aservice;

    @GetMapping("")
    public ResponseEntity<List<Alumno>> listarAlumnos(){
        List<Alumno> alumnoList = new ArrayList<>();
        aservice.listarAlumnos().forEach(alumnoList::add);
        if(alumnoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else return new ResponseEntity<>(alumnoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> obtenerAlumnoxId(@PathVariable("id") String id){
        return new ResponseEntity<>(aservice.buscarAlunoxId(id).get(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Alumno> crearAlumno(@RequestBody Alumno alu){
        Alumno nalumno = new Alumno();
        nalumno.setIdalumno(alu.getIdalumno());
        nalumno.setApealumno(alu.getApealumno());
        nalumno.setNomalumno(alu.getNomalumno());
        nalumno.setIdesp(alu.getIdesp());
        nalumno.setProce(alu.getProce());
        return new ResponseEntity<>(aservice.registrar(nalumno), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> actualizarAlumno(@PathVariable("id") String id,@RequestBody Alumno alu){
        Alumno oldalumno = aservice.buscarAlunoxId(id).get();
        oldalumno.setIdalumno(alu.getIdalumno());
        oldalumno.setApealumno(alu.getApealumno());
        oldalumno.setNomalumno(alu.getNomalumno());
        oldalumno.setIdesp(alu.getIdesp());
        oldalumno.setProce(alu.getProce());
        return new ResponseEntity<>(aservice.registrar(oldalumno), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAlumno(@PathVariable("id") String id){
        //return ResponseEntity.status(HttpStatus.OK).body(aservice.eliminarxId(id));
        return new ResponseEntity<>(aservice.eliminarxId(id),HttpStatus.OK);
    }
}
