package com.cfg.user.service.entities;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Hotel {

    private  String id;
    private String name;
    private String location;
    private String about;
}
