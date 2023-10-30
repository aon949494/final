package org.zerock.finals.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private String mid;
    private String mpw;
    private String mname;
    private LocalDate mage;
    private String maddr;
    private String uuid;
}
