package com.aw.security.domain.model.entity.intermediate;

import com.aw.lifetravel.domain.model.entity.Plan;
import com.aw.security.domain.model.entity.User;
import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@With
@Entity
@Table(name = "UserPlan")
public class UserPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="user_id",nullable = true)
    private User user;
    @ManyToOne
    @JoinColumn(name="plan_id",nullable = true)
    private Plan plans;

}
