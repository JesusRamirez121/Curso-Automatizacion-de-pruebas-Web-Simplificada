package starter.utils.registration;

import io.cucumber.java.DataTableType;
import starter.models.RegistrationModel;

import java.util.Map;

public class DataTableRegistration {
    @DataTableType
    public RegistrationModel mapToRegistrationModel(Map<String, String> entry) {
        return RegistrationModel.builder()
                .nombres(entry.get("nombres"))
                .apellidos(entry.get("apellidos"))
                .edad(entry.get("edad"))
                .pais(entry.get("pais"))
                .sexo(entry.get("sexo"))
                .email(entry.get("email"))
                .dia(entry.get("dia"))
                .foto(entry.get("foto"))
                .build();
    }
}
