package com.example.timekeeplogin.controller;

import com.example.timekeeplogin.auth.StaffOutPutLoginDto;
import com.example.timekeeplogin.service.ILoginRedisService;
import com.example.timekeeplogin.service.IStaffService;
import io.swagger.models.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/redis")
public class DemoRedisLogin {
    private ILoginRedisService loginRedisService;

    public DemoRedisLogin(
            ILoginRedisService loginRedisService
    ) {
        this.loginRedisService = loginRedisService;
    }

    @GetMapping("/get-data-redis")
    public Map<String, StaffOutPutLoginDto> getDataRedis(){

//        loginRedisService.

        return loginRedisService.getAllStaffOutLogins();
    }
    @GetMapping("/get-data-redis{id}")
    public StaffOutPutLoginDto getDataRedisById(String id){
//        loginRedisService.saveAllStaffOutLogins(
//                Map.of("hong@gmail.com", new StaffOutPutLoginDto(36, "Trưởng Phòng", "Quỳnh Hảo",
//                                true, "hao@gmail.com", "Thanh Hóa", 1, "abc1"),
//                        "hao@gmail.com", new StaffOutPutLoginDto(38, "Trưởng Phòng", "phongTt",
//                                true, "dangquoc07044@gmail.com", "fpoly", 1, "abc2")
//                )
//                        );

        return loginRedisService.getOneStaffOutLogin(id);
    }
    @DeleteMapping
    public HttpStatus deleteRedis(String id){
        try {
            loginRedisService.deleteStaffOutLogin(id);
            return HttpStatus.OK;
        } catch (Exception ex){
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
    @GetMapping("/insert")
    public HttpStatus getDataRedisById() {
        try {
            loginRedisService.saveAllStaffOutLogins(
                    Map.of("hong@gmail.com", new StaffOutPutLoginDto(36, "Trưởng Phòng", "Quỳnh Hảo",
                                    true, "hao@gmail.com", "Thanh Hóa", 1, "abc1"),
                            "hao@gmail.com", new StaffOutPutLoginDto(38, "Trưởng Phòng", "phongTt",
                                    true, "dangquoc07044@gmail.com", "fpoly", 1, "abc2")
                    )
            );
            return HttpStatus.OK;
        } catch (Exception ex){
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

}
