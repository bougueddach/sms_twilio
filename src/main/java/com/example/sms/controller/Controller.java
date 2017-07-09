package com.example.sms.controller;

import com.example.sms.Model.ModelSMS;
import org.springframework.ui.Model;
import com.twilio.exception.TwilioException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;


/**
 * Created by macbook on 7/7/17.
 */

@org.springframework.stereotype.Controller
public class Controller extends WebMvcConfigurerAdapter{

    public static final String ACCOUNT_SID="AC6e10a7a7a5b45f546465e62e624386aa";
    public static final String AUTH_TOKEN="bf471e22ba407fc8fa159506fa0d6c92";
    public static final String TWILIO_NUMBER = "+12012989241";

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/result").setViewName("result");
        registry.addViewController("/error").setViewName("error");
    }

    @GetMapping("/")
    public String init(Model ModelSMS){
        ModelSMS.addAttribute("sms", new ModelSMS());
        return "index";
    }


    @PostMapping("/")
    public String sendSMS( ModelSMS sms) throws TwilioException{
        try{
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

            Message mail = Message.creator(new PhoneNumber(sms.getphoneNm()),// Destinataire
                    new PhoneNumber(TWILIO_NUMBER),// Recepteur
                    "Message de la part de Mr. BOUGUEDDACH: "+sms.getmessage()).create();

            System.out.println(mail.getSid());
            return "redirect:/result";
        }catch(TwilioException e){
            return "redirect:/error";
        }

    }

}
