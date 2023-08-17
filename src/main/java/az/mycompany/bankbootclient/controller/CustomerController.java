package az.mycompany.bankbootclient.controller;

import az.mycompany.bankbootclient.api.request.ReqToken;
import az.mycompany.bankbootclient.api.response.RespCustomer;
import az.mycompany.bankbootclient.api.response.RespCustomerList;
import az.mycompany.bankbootclient.api.response.RespUser;
import az.mycompany.bankbootclient.util.Utility;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    @Value("${api.url}")
    private String apiUrl;
    @Value("${api.userId}")
    private String apiUserId;
    @Value("${api.token}")
    private String apiToken;
    private final Utility utility;
    private final HttpServletRequest request;

    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/GetCustomerById/{custId}")
    public @ResponseBody String getCustomerById(@PathVariable("custId") Long customerId) {
        String url = apiUrl + "customer/GetCustomerById?custId=" + customerId;
        String result = utility.sendGet(url);
        return result;
    }

    @GetMapping("/GetCustomerList")
    public ModelAndView getCustomerList() {
        ModelAndView model = new ModelAndView("index");
        RespUser respUser = (RespUser) request.getSession(false).getAttribute("respUser");
        try {
            String url = apiUrl + "customer/GetCustomerList";
            ReqToken reqToken = new ReqToken();
            reqToken.setUserId(respUser.getRespToken().getUserId());
            reqToken.setToken(respUser.getRespToken().getToken());
            String reqTokenJson = objectMapper.writeValueAsString(reqToken);
            String result = utility.sendPost(url, reqTokenJson);
            RespCustomerList respCustomerList = objectMapper.readValue(result, RespCustomerList.class);
            if (respCustomerList.getRespStatus().getCode() == 1) {
                model.addObject("customerList",respCustomerList.getResponse());
            } else {
                model.addObject("message",respCustomerList.getRespStatus().getMessage());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return model;
    }
}
