package com.example.demo.controller;

import com.example.demo.model.AppUser;
import com.example.demo.model.AppUserDetail;
import com.example.demo.payload.LoginRequest;
import com.example.demo.payload.LoginResponse;
import com.example.demo.payload.RandomStuff;
import com.example.demo.payload.ResponseData;
import com.example.demo.repo.UserRepository;
import com.example.demo.sercurity.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/login")
    public LoginResponse  authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(), loginRequest.getPassword()
                        )
                );
//        ResponseData rs = new ResponseData();
//        if(loginRequest.getUsername().equals("test") && loginRequest.getPassword().equals("password")) {
//            String jwt = tokenProvider.generateToken((AppUserDetail) authentication.getPrincipal());
//            rs.setStatus("success");
//            rs.setData(new LoginResponse(jwt));
//        } else {
//            rs.setStatus("error");
//            rs.setMessage("username or password wrong");
//        }
//        return rs;
        SecurityContextHolder.getContext().setAuthentication(authentication);

//         Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken((AppUserDetail) authentication.getPrincipal());
//        String jwt = "AAA";
        System.out.println("-----------" + jwt);
        return new LoginResponse(jwt);
    }
    @GetMapping("/random")
    public RandomStuff randomStuff(){
        return new RandomStuff("JWT Hợp lệ mới có thể thấy được message này");
    }
}
