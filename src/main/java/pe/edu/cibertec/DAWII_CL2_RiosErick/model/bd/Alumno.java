package pe.edu.cibertec.DAWII_CL2_RiosErick.model.bd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Alumno")
public class Alumno {

    @Id
    private String idalumno;

    @Column(name="apealumno")
    private String apealumno;

    @Column (name="nomalumno")
    private String nomalumno;

    @Column(name="IdEsp")
    private String idesp;

    @Column(name="Proce")
    private char proce;
}
