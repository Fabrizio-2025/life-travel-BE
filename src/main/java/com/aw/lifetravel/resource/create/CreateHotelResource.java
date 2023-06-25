package com.aw.lifetravel.resource.create;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateHotelResource {
    private String name;
    private String details;
    private Long price;
    private Date startDate;
    private Date endDate;
}
