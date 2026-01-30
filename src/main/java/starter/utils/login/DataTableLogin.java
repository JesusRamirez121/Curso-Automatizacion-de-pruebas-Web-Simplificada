package starter.utils.login;

import io.cucumber.java.DataTableType;
import starter.models.LoginModel;

import java.util.Map;

public class DataTableLogin {
    @DataTableType
    public LoginModel mapToLoginModel(Map<String, String> entry) {
        return LoginModel.builder()
                .username(entry.get("username"))
                .password(entry.get("password"))
                .build();
    }
}
