package com.email.email.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
@Builder
public class MailMessenger {
    private String name;

    private String email;
}
