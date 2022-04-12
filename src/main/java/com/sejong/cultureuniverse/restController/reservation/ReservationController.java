package com.sejong.cultureuniverse.restController.reservation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sejong.cultureuniverse.dto.paging.PageRequestDTO;
import com.sejong.cultureuniverse.service.reservation.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@Log4j2
@RequestMapping("/api/reservation")
@RequiredArgsConstructor
public class ReservationController {
    
    private final ScheduleService scheduleService;
    
    @GetMapping(value = "/schedule")
    public String getSchedule(String performCode, PageRequestDTO pageRequestDTO)
        throws JsonProcessingException {
        
        ObjectMapper mapper = new ObjectMapper();
        
        return mapper.registerModule(new JavaTimeModule())
            .writeValueAsString(scheduleService.getScheduleList(performCode, pageRequestDTO));
    }
}
