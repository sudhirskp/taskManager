package com.indpro.taskManager.Controller;


import com.indpro.taskManager.DTO.Login;
import com.indpro.taskManager.DTO.Register;
import com.indpro.taskManager.Entity.User;
import com.indpro.taskManager.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
//@CrossOrigin(origins = "https://managertaskk.netlify.app" , allowCredentials = "true")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public String register(
            @RequestBody Register request){

        return authService.register(request);
    }

    @PostMapping("/login")
    public User login(
            @RequestBody Login request){

        return authService.login(request);
    }
}
