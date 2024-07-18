package com.web_site.real_estate.controllers;

import com.web_site.real_estate.models.FeedbackForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FeedbackFormController {

    @Value("${emailOfSender}")
    private String emailOfSender;

    @Value("${emailOfRecipient}")
    private String emailOfRecipient;

    @Autowired
    private JavaMailSender mailSender;
    private void sendFeedbackEmail(FeedbackForm feedbackForm) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailOfSender);
        message.setTo(emailOfRecipient);
        message.setSubject("Feedback message");
        if (feedbackForm.getEmail() != null)
            message.setText(
                    "Name of client: " + feedbackForm.getName() + "\n" +
                            "Email: " + feedbackForm.getEmail() + "\n" +
                            "Phone: " + feedbackForm.getPhone() + "\n" +
                            "Question: " + feedbackForm.getQuestion()
            );
        else if (feedbackForm.getQuestion() != null)
            message.setText(
                    "Name of client: " + feedbackForm.getName() + "\n" +
                            "Phone: " + feedbackForm.getPhone() + "\n" +
                            "Question: " + feedbackForm.getQuestion()
            );
        else
            message.setText(
                    "Name of client: " + feedbackForm.getName() + "\n" +
                            "Phone: " + feedbackForm.getPhone()
            );
        mailSender.send(message);
    }

    @PostMapping("/contact-us")
    public String processFeedbackFormOnContactUs(@ModelAttribute FeedbackForm feedbackForm, Model model) {
        sendFeedbackEmail(feedbackForm);
        return "redirect:/contact-us";
    }

    @PostMapping("/district/{district_name}")
    public String processFeedbackFormOnDistrict(@ModelAttribute FeedbackForm feedbackForm, Model model) {
        sendFeedbackEmail(feedbackForm);
        return "redirect:/district/{district_name}";
    }

    @PostMapping("/organisation/{developer_name}")
    public String processFeedbackFormOnDeveloper(@ModelAttribute FeedbackForm feedbackForm, Model model) {
        sendFeedbackEmail(feedbackForm);
        return "redirect:/organisation/{developer_name}";
    }

    @PostMapping("/complex/{complex_name}")
    public String processFeedbackFormOnComplex(@ModelAttribute FeedbackForm feedbackForm, Model model) {
        sendFeedbackEmail(feedbackForm);
        return "redirect:/complex/{complex_name}";
    }

    @PostMapping("/property/{bedrooms}-bedrooms-in-{complexName}-{id}")
    public String processFeedbackFormOnProperty(@ModelAttribute FeedbackForm feedbackForm, Model model) {
        sendFeedbackEmail(feedbackForm);
        return "redirect:/property/{bedrooms}-bedrooms-in-{complexName}-{id}";
    }

    @PostMapping("/")
    public String processFeedbackFormOnHome(@ModelAttribute FeedbackForm feedbackForm, Model model) {
        sendFeedbackEmail(feedbackForm);
        return "redirect:/";
    }

//    @PostMapping("/district/{district_name}")
//    public String processFeedbackForm(@RequestParam String name, @RequestParam String phone, @RequestParam(required = false) String email , @RequestParam(required = false) String question, Model model) {
//        FeedbackForm feedbackForm = new FeedbackForm(name, phone, email, question);
//        sendFeedbackEmail(feedbackForm);
//        return "redirect:/contact-us";
//    }



}
