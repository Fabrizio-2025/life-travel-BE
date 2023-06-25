package com.aw.lifetravel.resource.create;

import com.aw.security.domain.model.entity.intermediate.UserHotel;
import com.aw.security.domain.model.entity.intermediate.UserPlan;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserResource {

    private String name;
    private String lastname;
    private Long walletNum;
    private Long walletCredit;
    private Set<UserHotel> userHotel;
    private Set<UserPlan> listPlan;
}
