package com.email.email.controller;


import com.email.email.dto.request.SendEmails;
import com.email.email.services.DoctorMailService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sendPatients")
public class PatientsController {

    private DoctorMailService doctorMailService;

    @PostMapping("/sendP")
    public String sendEmail(@RequestBody SendEmails sendEmails){
        doctorMailService.sendMail(sendEmails);
        return "mail sent successfully!!";
    }
}
