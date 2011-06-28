package org.eejot.acloud.aws;

import java.util.Date;
import java.util.TimerTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eejot.acloud.KVEvent;
import org.eejot.acloud.KVEvent.Event;
import org.eejot.acloud.UbiquitousKeyValueService;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

/**
 * 
 * @author prabhat
 *
 */

public class AmazonS3Poller extends TimerTask
{

   private static final Log log = LogFactory.getLog(AmazonS3Poller.class);
   private AWSConfig awsConf = AWSConfig.getAWSConfig();
   private AmazonS3Client s3Client = new AmazonS3Client(new BasicAWSCredentials(awsConf.getAccessKey(), awsConf.getSecreteKey()));
   private Date lastModified = new Date();



   @Override
   public void run()
   {
      GetObjectRequest objectRequest = new GetObjectRequest(awsConf.getBucketName(),awsConf.getConfigFileName());

      if(lastModified != null )
      {
         objectRequest.setModifiedSinceConstraint(lastModified);
      }

      S3Object s3Object = s3Client.getObject(objectRequest);     

      if(s3Object != null)
      {  log.info("Changes found on S3. Going to get the details and fire events");
      KVEvent event = new KVEvent ();
      event.setEvent(Event.REMOTE_UPDATE);
      event.setTimestamp(s3Object.getObjectMetadata().getLastModified());
      event.setKey(new String[]{awsConf.getConfigFileName()});
      UbiquitousKeyValueService.getInstance().fireEvents(event);         
      }
      else {
         log.debug ("Did not find any change on S3");
      }


   }

}
