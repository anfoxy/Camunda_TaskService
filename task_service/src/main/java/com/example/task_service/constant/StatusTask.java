package com.example.task_service.constant;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum StatusTask {

    CREATE(1L,"Create"),
    RUN(2L,"Run"),
    COMPLETE(3L,"Complete"),
    COMPLETE_TIMER(4L,"CompleteTimer"),
    CANCEL(5L,"Cancel");

    private final Long id;
    private final String name;

    public static StatusTask getById(Long id) {
        for (StatusTask statusTask: StatusTask.values()){
            if(statusTask.id.equals(id)) {
                return statusTask;
            }
        }
        return null;
    }

}
