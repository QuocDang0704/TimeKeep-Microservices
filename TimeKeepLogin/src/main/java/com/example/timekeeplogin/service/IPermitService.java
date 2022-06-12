package com.example.timekeeplogin.service;

import com.example.timekeeplogin.dtos.PermitDto.PermitOutputDto;
import com.example.timekeeplogin.dtos.PermitDto.PermitInputDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IPermitService {
    PermitOutputDto PermitOutputDto(PermitInputDto permit);
    List<PermitOutputDto> getAll();
    PermitOutputDto getPermitById(int id);
    PermitOutputDto updatePermit(PermitInputDto permit, int id);
    void deletePermit(int id);
}
