package com.example.camunda.constant;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum StatusTask {

    CREATE(1L,"Create"),
    RUN(2L,"run"),
    COMPLETE(3L,"complete"),
    CANCEL(4L,"cancel");

    private final Long id;
    private final String name;
}
