package com.aw.lifetravel.resource.show;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class HotelResource {
    private Long hotelId;
    private String name;
    private String details;
    private Long price;
    private Date startDate;
    private Date endDate;
}
