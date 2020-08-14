package ru.mike.serviceA.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class MsgA {
    private String msg;
    private String lng;
    private Coordinates coordinates;
}
