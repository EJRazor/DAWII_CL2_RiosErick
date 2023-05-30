package pe.edu.cibertec.DAWII_CL2_RiosErick.model.bd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdUsuario;

    @Column(name="Nombres")
    private String Nombres;
    @Column(name="Apellidos")
    private String Apellidos;
    @Column(name="Email")
    public String email;
    @Column(name="NomUsuario")
    public String nomusuario;
    @Column(name="PassUsuario")
    private String PassUsuario;
}
