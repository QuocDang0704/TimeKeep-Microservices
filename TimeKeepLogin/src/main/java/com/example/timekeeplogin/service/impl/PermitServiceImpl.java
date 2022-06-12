
package com.example.timekeeplogin.service.impl;
import com.example.timekeeplogin.dtos.PermitDto;
import com.example.timekeeplogin.dtos.PermitDto.PermitOutputDto;
import com.example.timekeeplogin.dtos.PermitDto.PermitInputDto;
import com.example.timekeeplogin.repository.IPermitRepository;
import com.example.timekeeplogin.service.IPermitService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PermitServiceImpl implements IPermitService {
    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private IPermitRepository permitRepository;


    @Override
    public PermitOutputDto PermitOutputDto(PermitInputDto permit) {
        return null;
    }

    @Override
    public List<PermitOutputDto> getAll() {
        return permitRepository.findAll().stream()
                .map(post -> modelMapper.map(post, PermitOutputDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PermitOutputDto getPermitById(int id) {
        return null;
    }

    @Override
    public PermitOutputDto updatePermit(PermitDto.PermitInputDto permit, int id) {
        return null;
    }

    @Override
    public void deletePermit(int id) {

    }
}
