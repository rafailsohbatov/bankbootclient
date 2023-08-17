package az.mycompany.bankbootclient.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RespCustomer {

    private Long customerId;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String address;
    private String phone;
    private String dob;
    private String cif;
    private String fin;
    private String seria;
}
