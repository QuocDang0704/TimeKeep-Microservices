package com.example.timekeeplogin.service;


import com.example.timekeeplogin.dtos.timekeep.TestCheckInCheckOut;
import com.example.timekeeplogin.dtos.timekeep.TimeKeepBaseDto;
import com.example.timekeeplogin.dtos.timekeep.TimeKeepOutputByMonthDto;
import com.example.timekeeplogin.dtos.timekeep.TimeKeepOutputFullDto;
import com.example.timekeeplogin.entity.TimeKeepEntity;

import java.util.Date;
import java.util.List;

public interface ITimeKeepService {
    TimeKeepOutputFullDto createTimeKeep(TimeKeepBaseDto timeKeepBaseDto);
    List<TimeKeepOutputFullDto> getAll();
    TimeKeepOutputFullDto getTimeKeepById(int id);
    TimeKeepOutputFullDto updateTimeKeep(TimeKeepBaseDto timeKeepBaseDto);
    boolean deleteTimeKeep(int id);
    TimeKeepOutputFullDto findByStartTime(Date starttime, Integer id);
    List<TimeKeepOutputByMonthDto> getTimeKeepToMonth(Integer idStaff, Integer month);
    TimeKeepEntity testCheckInCheckOut(TestCheckInCheckOut input);
    List<TimeKeepOutputByMonthDto> findAllByIdStaff(Integer idStaff);
}
