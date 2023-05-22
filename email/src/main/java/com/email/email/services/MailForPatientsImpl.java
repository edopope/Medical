package com.email.email.services;

import com.email.email.dto.request.EmailNotificationRequest;
import com.email.email.dto.request.MailMessenger;
import com.email.email.dto.request.SendEmails;
import com.email.email.mailConfig.MailConfig;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class MailForPatientsImpl implements MailForPatientsService {
    //TODO:collect the react frontend link and simply hardcode it inside since its not bound to change!
    private static final String USER_VERIFICATION_BASE_URLS = "netnaija.com";
    private static final String WELCOME_MAIL_TEMPLATE_LOCATION_PATIENT = "C:\\Users\\DELL\\Downloads\\uber_deluxe-working\\mediConnect247-backend\\admin\\src\\main\\resources\\welcomeNoteForPatients.txt";


    private final MailConfig mailConfig;

    @Override
    public String sendHtmlMail(EmailNotificationRequest request) {
        RestTemplate restTemplates = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("api-key", mailConfig.getApiKey());
        HttpEntity<EmailNotificationRequest> requestEntity = new HttpEntity<>(request, headers);

        ResponseEntity<String> response =
                restTemplates.postForEntity(mailConfig.getMailUrl(), requestEntity, String.class);
        log.info("res->{}", response);
        return response.getBody();
    }


    @Override
    public String sendMailForPatients(SendEmails sendEmails) {
//TODO: in the name do like a dto.getName() method to automatically get the name from the user instead of hard coding it!!
        String message = getMailTemplate();
        String baseUrl = generateVerificationLink();
        EmailNotificationRequest request = EmailNotificationRequest.builder()
                //TODO:same as for name use like a get method to get the email instead of hardcoding it!!
                .to(List.of(new MailMessenger(sendEmails.getFirstName(), sendEmails.getEmailUrl())))
                .htmlContent(String.format(message, sendEmails.getFirstName(), baseUrl))
                .build();
        return sendHtmlMail(request);
    }

    public static String generateVerificationLink(){
        return USER_VERIFICATION_BASE_URLS;
    }
    public static String getMailTemplate(){
        try (BufferedReader reader = new BufferedReader(new FileReader(
                WELCOME_MAIL_TEMPLATE_LOCATION_PATIENT))){
            return reader.lines().collect(Collectors.joining());
        }catch (IOException exception){
            throw new IllegalArgumentException(exception.getMessage());
        }



}
}