package com.example.task_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class KafkaMessage implements Serializable {
    private String id;
    private Map<String,Object> variables;
    private String status;
    private String nameProcess;
}