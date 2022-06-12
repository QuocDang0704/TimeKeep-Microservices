package com.example.timekeeplogin.controller;

import com.example.timekeeplogin.auth.GoogleSocail;
import com.example.timekeeplogin.auth.StaffOutPutLoginDto;
import com.example.timekeeplogin.service.ILoginRedisService;
import com.example.timekeeplogin.service.IStaffService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/apiV1/login")
public class LoginController {
    private final ModelMapper modelMapper = new ModelMapper();
    IStaffService staffService;
    ILoginRedisService loginRedisService;

    public LoginController(IStaffService staffService,
                           ILoginRedisService loginRedisService
                           ) {
        this.staffService = staffService;
        this.loginRedisService = loginRedisService;
    }

    @PostMapping("/socialmediaData")
    public ResponseEntity<StaffOutPutLoginDto> SocialmediaData(
            @RequestBody GoogleSocail user) throws Exception {
        try {
            if (checkDataRedis(user.getEmail())!=null){
                return new ResponseEntity<>(checkDataRedis(user.getEmail()), HttpStatus.OK);
            }
            var output =  staffService.findStaffEntitiesByEmail(user.getEmail());
            if (output == null){
                throw new Exception("khong tim thay user theo email");
                //return null;
            }
            var output2 = modelMapper.map(output, StaffOutPutLoginDto.class);
            output2.setImage(user.getImage());

            if (insertStaffRedis(output2)==null){
                new Throwable("không thể insert staff to redis");
            }
            return new ResponseEntity<>(output2, HttpStatus.OK);
        } catch (Exception e) {
            throw new Exception(e.getMessage()+"");
        }
    }
    private StaffOutPutLoginDto checkDataRedis(String email){
        try {
            StaffOutPutLoginDto staff = loginRedisService.getOneStaffOutLogin(email);
            if (null==staff){
                return null;
            }
            System.out.println("đã đi qua đây hihi về get");
            return staff;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    private StaffOutPutLoginDto insertStaffRedis(StaffOutPutLoginDto staff){
        try {
            if (loginRedisService.saveStaffOutLogin(staff)){
                System.out.println("đã đi qua đây hihi về insert");
                return staff;
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
