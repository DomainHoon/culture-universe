package com.sejong.cultureuniverse.service.reservation;

import com.sejong.cultureuniverse.dto.performances.SeatsDTO;
import com.sejong.cultureuniverse.entity.Member;
import com.sejong.cultureuniverse.entity.reservation.Reservation;
import com.sejong.cultureuniverse.entity.reservation.Seats;
import com.sejong.cultureuniverse.entity.reservation.SeatsReservation;
import com.sejong.cultureuniverse.mapper.SeatsMapper;
import com.sejong.cultureuniverse.repository.MemberRepository;
import com.sejong.cultureuniverse.repository.reservation.ReservationRepository;
import com.sejong.cultureuniverse.repository.reservation.SeatsRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReservationService {
    
    private final ReservationRepository reservationRepository;
    private final MemberRepository memberRepository;
    private final SeatsRepository seatsRepository;
    
    public List<SeatsDTO> getSeatsList(Long scheduleCode) {
        List<Seats> seatsList = seatsRepository.findSeatsByScheduleScheduleCode(
            scheduleCode);
        return seatsList.stream().map(SeatsMapper.INSTANCE::seatsToDto)
            .collect(Collectors.toList());
        
    }
    
    @Transactional
    public Long reservation(Long userIdx, Long seatsNo) {
        Optional<Member> findMember = memberRepository.findById(userIdx);
        Optional<Seats> findSeats = seatsRepository.findById(seatsNo);
        if (findMember.isEmpty() || findSeats.isEmpty()) {
            return null;
        }
        Member member = findMember.get();
        Seats seat = findSeats.get();
    
        SeatsReservation seatsReservation = SeatsReservation.createSeatsReservation(seat,
            seat.getPrice());
    
        Reservation reservation = Reservation.createReservation(member, seatsReservation);
    
        reservationRepository.save(reservation);
        return reservation.getReservationId();
        
    }
    
    @Transactional
    public void cancelReservation(Long reservationId) {
        Optional<Reservation> findOrder = reservationRepository.findById(reservationId);
        findOrder.ifPresent(Reservation::cancel);
    }
    
}
