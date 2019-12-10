package org.hjjang.aws.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsSES {

    private String accessKey = "";

    private String secretKey = "";

    @Bean
    public BasicAWSCredentials awsCredentials(){
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey,secretKey);
        return awsCreds;
    }

    @Bean
    public AmazonSimpleEmailService sesClient(AWSCredentials awsCredentials){

        return AmazonSimpleEmailServiceClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .withRegion("us-east-1")
                .build();
    }
}
