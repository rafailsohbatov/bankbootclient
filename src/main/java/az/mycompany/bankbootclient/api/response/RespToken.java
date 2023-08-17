package az.mycompany.bankbootclient.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RespToken {

    private Long userId;
    private String token;

}
