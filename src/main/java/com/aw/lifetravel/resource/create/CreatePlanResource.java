package com.aw.lifetravel.resource.create;


import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreatePlanResource {

    private String name;

    private String details;

    private Long price;

    private Long days;
}
