package az.mycompany.bankbootclient.api.response;

import lombok.Data;

@Data
public class RespStatus {
    private Integer code;
    private String message;
}
