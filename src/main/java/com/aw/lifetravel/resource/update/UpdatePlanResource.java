package com.aw.lifetravel.resource.update;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePlanResource {
    private String name;

    private String details;

    private Long price;

    private Long days;
}
