package org.zerock.finals.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemoDTO {
    private Long tno;
    private String title;
    private String memo;
    private LocalDate dueDate;
    private String id;
}
