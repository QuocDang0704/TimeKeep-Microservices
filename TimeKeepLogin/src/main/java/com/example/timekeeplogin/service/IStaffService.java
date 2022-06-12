package com.example.timekeeplogin.service;

import com.example.timekeeplogin.dtos.staff.StaffBaseDto;
import com.example.timekeeplogin.dtos.staff.StaffOutputFullDto;


import java.util.List;

public interface IStaffService {
    StaffOutputFullDto createStaff(StaffBaseDto staff);
    List<StaffOutputFullDto> getAll();
    StaffOutputFullDto getStaffById(int id);
    StaffOutputFullDto updateStaff(StaffBaseDto staff, int id);
    boolean deleteStaff(int id);
    StaffOutputFullDto findStaffEntitiesByEmail(String email);
}
