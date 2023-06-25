package com.aw.security.domain.model.entity;

import com.aw.security.domain.model.entity.intermediate.UserHotel;
import com.aw.security.domain.model.entity.intermediate.UserPlan;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@With
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    @NotNull
    private Long walletNum;
    @NotNull
    private Long walletCredit;
    @OneToMany(mappedBy = "user")
    private Set<UserHotel> userHotel;
    @OneToMany(mappedBy = "user")
    private Set<UserPlan> listPlan;

}
