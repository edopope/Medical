package com.email.email.services;


import com.email.email.dto.request.EmailNotificationRequest;
import com.email.email.dto.request.SendEmails;

public interface DoctorMailService {
    String sendHtmlMail(EmailNotificationRequest request);
    String sendMail(SendEmails sendEmails);
}
