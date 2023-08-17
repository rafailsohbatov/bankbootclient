package az.mycompany.bankbootclient.api.request;

import lombok.Data;

@Data
public class ReqToken {

    private Long userId;
    private String token;

}
