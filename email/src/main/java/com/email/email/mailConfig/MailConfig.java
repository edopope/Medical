package com.email.email.mailConfig;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailConfig {
    private String apiKey;
    private String mailUrl;
}
