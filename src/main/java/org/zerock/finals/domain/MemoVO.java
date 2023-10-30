package org.zerock.finals.domain;

import lombok.*;

import java.time.LocalDate;
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemoVO {
    private Long tno;
    private String title;
    private String memo;
    private LocalDate dueDate;
    private String id;
}
