package az.mycompany.bankbootclient.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RespCustomerList {
    private List<RespCustomer> response;
    private RespStatus respStatus;
}
