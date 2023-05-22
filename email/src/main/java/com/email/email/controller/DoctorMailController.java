package com.email.email.controller;


import com.email.email.dto.request.SendEmails;
import com.email.email.services.DoctorMailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sendEmail")
@AllArgsConstructor
public class DoctorMailController {
    private DoctorMailService doctorMailService;

    @PostMapping("/send")
    public String sendEmail(@RequestBody SendEmails sendEmails){
        String retMail = doctorMailService.sendMail(sendEmails);
        return "mail sent successfully!!";
    }
}
