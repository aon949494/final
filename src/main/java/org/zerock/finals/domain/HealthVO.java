package org.zerock.finals.domain;

import lombok.*;

import java.time.LocalDate;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HealthVO {
    private String id;
    private int height;
    private int weight;
    private String move;
    private float kal;
    private LocalDate dueDate;
}
