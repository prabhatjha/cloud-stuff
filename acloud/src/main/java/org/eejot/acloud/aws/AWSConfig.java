package org.eejot.acloud.aws;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author prabhat
 *
 */

public class AWSConfig
{

   private static final Log log = LogFactory.getLog(AWSConfig.class);
   private static AWSConfig awsConfig = null;

   private String accessKey;
   private String secretKey;
   private String bucketName;
   private String configFileName;

   private AWSConfig() {

   }
   public static AWSConfig getAWSConfig()  {
      if (awsConfig != null)
         return awsConfig;
      Properties awsProps = new Properties();
      try
      {

         awsProps.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("aws.properties"));
         
         String access = awsProps.getProperty("AWSAccessKey");
         String secret = awsProps.getProperty("AWSSecretKey");
         String bucketName = awsProps.getProperty("AWSS3BucketName");
         String configFileName = awsProps.getProperty("CloudConfigFileName");

         awsConfig = new AWSConfig();
         awsConfig.accessKey = access;
         awsConfig.secretKey = secret;
         awsConfig.bucketName = bucketName;
         awsConfig.configFileName = configFileName;
      }catch (FileNotFoundException e)
      {
         log.fatal("Could not read the properties file with AWS info");
         log.error(e);
      }
      catch (IOException e)
      {
         log.error(e);
      }
      return awsConfig;
   }

   public String getAccessKey()
   {
      return accessKey;
   }  
   public String getSecreteKey()
   {
      return secretKey;
   }

   public String getBucketName() {
      return bucketName;
   }
   
   public String getConfigFileName()
   {
      return configFileName;
   }
  
   public static void main (String[] args) {
      AWSConfig conf = AWSConfig.getAWSConfig();
      System.out.println( conf.getAccessKey());
      System.out.println( conf.getSecreteKey());
      System.out.println( conf.getBucketName());

   }

}
