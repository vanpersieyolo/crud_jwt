package com.example.demo.controller;

import com.example.demo.payload.LoginRequest;
import com.example.demo.payload.ResponseData;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PublicController {
    @GetMapping("/time")
    public long getTime(){
        return System.currentTimeMillis();
    }

    @PostMapping("/login")
    public ResponseData login() {
        ResponseData responseData = new ResponseData();
//        responseData.setData(request);
        responseData.setStatus("success");
        return responseData;
    }
}
