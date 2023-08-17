package az.mycompany.bankbootclient.controller;

import az.mycompany.bankbootclient.api.request.ReqUser;
import az.mycompany.bankbootclient.api.response.RespToken;
import az.mycompany.bankbootclient.api.response.RespUser;
import az.mycompany.bankbootclient.util.Utility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
public class LoginController {
    @Value("${api.url}")
    private String apiUrl;
    ObjectMapper objectMapper = new ObjectMapper();

    private final HttpServletRequest request;
    private final Utility utility;

    @GetMapping({"/", "/LoginView"})
    public ModelAndView loginView(@RequestParam(value = "message",required = false) String message) {
        ModelAndView model = new ModelAndView("login");
        model.addObject("message",message);
        return model;
    }

    @PostMapping("/login")
    public RedirectView login(@RequestParam String username, @RequestParam String password) {
        RedirectView redirectView = null;
        try {
            if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
                ReqUser reqUser = new ReqUser();
                reqUser.setUsername(username);
                reqUser.setPassword(password);
                String reqUserJson = objectMapper.writeValueAsString(reqUser);
                String url = apiUrl + "user/Login";
                String resultJson = utility.sendPost(url, reqUserJson);
                RespUser respUser = objectMapper.readValue(resultJson, RespUser.class);
                if (respUser.getRespStatus().getCode() == 1) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("respUser", respUser);
                    redirectView = new RedirectView("/client/GetCustomerList");
                } else {
                    redirectView = new RedirectView("/client/LoginView");
                    redirectView.addStaticAttribute("message", respUser.getRespStatus().getMessage());
                }
            } else {
                redirectView = new RedirectView("/client/LoginView");
                redirectView.addStaticAttribute("message", "Username Or Password Invalid");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return redirectView;
    }
}
