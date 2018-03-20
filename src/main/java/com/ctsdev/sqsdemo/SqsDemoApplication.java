package com.ctsdev.sqsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.core.env.ResourceIdResolver;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;

//import org.springframework.cloud.aws.core.env.ResourceIdResolver;
import org.springframework.context.annotation.Bean;
//import com.amazonaws.services.sqs.AmazonSQSAsync;

//import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
//import com.amazonaws.regions.Regions;
//import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSAsync;
//import com.amazonaws.services.sqs.AmazonSQSAsyncClient;
//import com.amazonaws.services.sqs.buffered.AmazonSQSBufferedAsyncClient;

@SpringBootApplication
public class SqsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqsDemoApplication.class, args);
	}

	@Bean
    public QueueMessagingTemplate queueMessagingTemplate(AmazonSQSAsync amazonSqs, ResourceIdResolver resourceIdResolver) {
        return new QueueMessagingTemplate(amazonSqs, resourceIdResolver);
    }

	/*@Bean
	public QueueMessagingTemplate queueMessagingTemplate() {
		return new QueueMessagingTemplate(amazonSQS());
	}*/

	/*@Bean(destroyMethod = "shutdown")
	public AmazonSQSAsync amazonSQS() {
		AmazonSQSAsyncClient amazonSQSAsyncClient = new AmazonSQSAsyncClient(new DefaultAWSCredentialsProviderChain());

		amazonSQSAsyncClient.setRegion(com.amazonaws.regions.Region.getRegion(Regions.US_EAST_2));//EU_CENTRAL_1
		return new AmazonSQSBufferedAsyncClient(amazonSQSAsyncClient);
	}*/
	
	/*@Bean(name = "amazonSQS", destroyMethod = "shutdown")
	public AmazonSQSAsync amazonSQSClient() {
	    AmazonSQSAsyncClient awsSQSAsyncClient;
	    if (useProxy.equalsIgnoreCase("Y")) {
			ClientConfiguration clientConfig = new ClientConfiguration();
			clientConfig.setProxyHost("proxy.xyz.com");
			clientConfig.setProxyPort(8085);

			awsSQSAsyncClient = new AmazonSQSAsyncClient(new DefaultAWSCredentialsProviderChain(), clientConfig);
	    } else {
			awsSQSAsyncClient = new AmazonSQSAsyncClient(new DefaultAWSCredentialsProviderChain());
	    }
			
	    awsSQSAsyncClient.setRegion(Region.getRegion(Regions.fromName("us-east-1")));
	    return awsSQSAsyncClient;
	}*/
}
