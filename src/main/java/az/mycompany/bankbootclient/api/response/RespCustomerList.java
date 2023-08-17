package az.mycompany.bankbootclient.api.response;

import lombok.Data;

import java.util.List;

@Data
public class RespCustomerList {
    private List<RespCustomer> response;
    private RespStatus respStatus;
}
