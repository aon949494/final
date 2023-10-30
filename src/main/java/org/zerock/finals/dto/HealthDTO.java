package org.zerock.finals.dto;

import lombok.*;

import java.time.LocalDate;
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HealthDTO {
    private String id;
    private int height;
    private int weight;
    private String move;
    private float kal;
    private LocalDate dueDate;
}
