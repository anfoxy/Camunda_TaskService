package com.example.task_service.constant;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum StatusTask {

    CREATE(1L,"Create"),
    RUN(2L,"Run"),
    COMPLETE(3L,"Complete"),
    CANCEL(4L,"Cancel");

    private final Long id;
    private final String name;
}
