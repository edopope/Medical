package com.email.email.services;


import com.email.email.dto.request.EmailNotificationRequest;
import com.email.email.dto.request.SendEmails;

public interface MailForPatientsService {
    String sendHtmlMail(EmailNotificationRequest request);
    String sendMailForPatients(SendEmails sendEmails);
}

 