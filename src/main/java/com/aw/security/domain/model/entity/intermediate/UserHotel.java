package com.aw.security.domain.model.entity.intermediate;

import com.aw.lifetravel.domain.model.entity.Hotel;
import com.aw.security.domain.model.entity.User;
import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@With
@Entity
@Table(name = "UserHotel")
public class UserHotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="user_id",nullable = true)
    private User user;
    @ManyToOne
    @JoinColumn(name="hotel_id",nullable = true)
    private Hotel hotel;

}
