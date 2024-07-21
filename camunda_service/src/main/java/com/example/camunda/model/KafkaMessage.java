package com.example.camunda.model;

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
    private UUID id;
    private String user;
    private Long idBaseTask;
    private String nameProcess;
}