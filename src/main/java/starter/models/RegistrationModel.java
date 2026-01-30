package starter.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationModel {
    private String nombres;
    private String apellidos;
    private String edad;
    private String pais;
    private String sexo;
    private String email;
    private String dia;
    private String foto;

}
