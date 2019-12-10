package org.hjjang.aws.email;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class AwsSesService {

    @Autowired
    private AmazonSimpleEmailService sesClient;

    @PostConstruct
    public void sendEmailExecutor(){
        sendEmail();
    }
    public void sendEmail(){
        Content subjectContent = new Content("메일 제목");
        Content bodyContent = new Content("메일 바디");
        Body body = new Body().withHtml(bodyContent);

        List emailList = new ArrayList();
        emailList.add("수신자이메일");

        Destination destination = new Destination(emailList);
        Message message = new Message(subjectContent, body);

        SendEmailRequest request = new SendEmailRequest()
                .withSource("발신자이메일")
                .withDestination(destination)
                .withMessage(message);
        sesClient.sendEmail(request);
    }

}
