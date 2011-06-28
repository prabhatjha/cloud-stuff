package org.eejot.acloud.aws;


import java.util.Timer;

public class TrialRun
{

   public static void main (String [] args) {
      Timer timer  = new Timer();      
      timer.schedule( new AmazonS3Poller(),2000);
      //TODO: Fire a separate thread to change S3 file to verify that poller is picking up changes correctly

   }

}
