package com.sejong.cultureuniverse.entity.performance;

import static javax.persistence.FetchType.LAZY;

import com.sejong.cultureuniverse.entity.Reservation;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "seats_seq", sequenceName = "seats_seq", allocationSize = 1,initialValue = 1)
public class Seats {

    @Id
    @GeneratedValue(generator = "seats_seq")
    private Long seatNo;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "schedule_code")
    private PerformanceSchedule schedule;

    private Integer rowNo;
    private Integer colNo;

    private Boolean isBooked;
    private Integer price;

}
