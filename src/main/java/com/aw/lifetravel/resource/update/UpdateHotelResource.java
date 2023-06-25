package com.aw.lifetravel.resource.update;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdateHotelResource {
    private String name;
    private String details;
    private Long price;
    private Date startDate;
    private Date endDate;
}
