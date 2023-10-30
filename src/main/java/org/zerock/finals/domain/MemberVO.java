package org.zerock.finals.domain;

import lombok.*;

import java.time.LocalDate;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
    private String mid;
    private String mpw;
    private String mname;
    private LocalDate mage;
    private String maddr;
    private String uuid;
}
