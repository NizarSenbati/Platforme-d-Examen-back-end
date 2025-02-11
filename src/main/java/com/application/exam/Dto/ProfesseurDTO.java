package com.application.exam.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ProfesseurDTO {
    private int code;

    private String fullName;

    private String Departement;

    private Set<Integer> moduleIds;
}
