package com.sejong.cultureuniverse.entity.admin;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.util.Lazy;


@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "admin_seq", sequenceName = "admin_seq", initialValue = 1, allocationSize = 1)
@ToString
public class Admin  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_seq")
    private Long adminIdx;

    private String adminId;
    private String adminPw;

    public Admin(String adminId, String adminPw) {
        this.adminId = adminId;
        this.adminPw = adminPw;
    }

    /*//오버로딩
    public Admin(){

    }
    public Admin(String adminId){

    }*/
}
