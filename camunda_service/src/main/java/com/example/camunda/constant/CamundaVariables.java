package com.example.camunda.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CamundaVariables {

    START_DATE("startDate"),
    ID_BASE_TASK("idBaseTask");

    private final String name;
}
