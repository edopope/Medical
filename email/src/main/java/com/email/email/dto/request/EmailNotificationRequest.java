package com.email.email.dto.request;


import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailNotificationRequest {
   private  final MailMessenger sender = new MailMessenger("MEDIC--CONNECT", "noreply@medic_connect.net");
   // private  final MailMessenger sender = new MailMessenger();
    private List<MailMessenger> to=new ArrayList<>();
    private final String subject="Welcome to medic-connect";
    private String htmlContent;

}
