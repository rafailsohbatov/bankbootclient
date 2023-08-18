package az.mycompany.bankbootclient.controller;

import az.mycompany.bankbootclient.api.request.ReqCustomer;
import az.mycompany.bankbootclient.api.request.ReqToken;
import az.mycompany.bankbootclient.api.response.*;
import az.mycompany.bankbootclient.util.Utility;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
    public @ResponseBody ModelAndView getCustomerById(@PathVariable("custId") Long customerId) {
        ModelAndView model = new ModelAndView("getCustomerById");
        ;
        try {
            String url = apiUrl + "customer/GetCustomerById?custId=" + customerId;
            String resultJson = utility.sendGet(url);
            RespCustomerById respCustomerById = objectMapper.readValue(resultJson, RespCustomerById.class);
            if (respCustomerById.getRespStatus().getCode() == 1) {
                model.addObject("customer", respCustomerById.getResponse());
            } else {
                model.addObject("message", respCustomerById.getRespStatus().getMessage());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return model;
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
                model.addObject("customerList", respCustomerList.getResponse());
            } else {
                model.addObject("message", respCustomerList.getRespStatus().getMessage());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return model;
    }

    @GetMapping("/NewCustomerView")
    public ModelAndView newCustomerView() {
        ModelAndView model = new ModelAndView("customer/newCustomer");
        return model;
    }

    @PostMapping("/addCustomer")
    public @ResponseBody String addCustomer(@RequestBody ReqCustomer reqCustomer) {
        String resultMsg = "error";
        try {
            System.out.println("test");
            RespUser respUser = (RespUser) request.getSession(false).getAttribute("respUser");
            ReqToken reqToken = new ReqToken();
            reqToken.setUserId(respUser.getRespToken().getUserId());
            reqToken.setToken(respUser.getRespToken().getToken());
            reqCustomer.setReqToken(reqToken);
            String url = apiUrl + "/customer/AddCustomer";
            String reqCustomerJson = objectMapper.writeValueAsString(reqCustomer);
            String result = utility.sendPost(url, reqCustomerJson);
            RespCustomerList respCustomerList = objectMapper.readValue(result, RespCustomerList.class);
            System.out.println(respCustomerList.getRespStatus().getCode());
            if (respCustomerList.getRespStatus().getCode() == 1) {
                resultMsg = "success";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resultMsg;
    }
}
