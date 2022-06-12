package com.example.timekeepv1.VO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class VOLogin {

    private Integer id;
    private String namePosition;
    private String name;
    private Boolean gender;
    private String email;
    private String adress;
    private Integer idPosition;
    private String image;
}
