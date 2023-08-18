package az.mycompany.bankbootclient.api.response;

import lombok.Data;

@Data
public class RespCustomerById {
    private RespCustomer response;
    private RespStatus respStatus;
}
