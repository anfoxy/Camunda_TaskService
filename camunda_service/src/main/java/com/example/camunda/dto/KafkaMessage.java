package com.example.camunda.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class KafkaMessage implements Serializable {
    private String id;
    private String user;
    private String status;
    private Long idBaseTask;
    private String nameProcess;
}