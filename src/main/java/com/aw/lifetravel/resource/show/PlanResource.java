package com.aw.lifetravel.resource.show;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class PlanResource {
    private Long planId;
    private String name;
    private String details;
    private Long price;
    private Long days;
}
