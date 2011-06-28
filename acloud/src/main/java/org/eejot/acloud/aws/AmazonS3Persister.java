package org.eejot.acloud.aws;

import org.eejot.acloud.PersistException;
import org.eejot.acloud.Persister;
import org.eejot.acloud.UbiquitousKeyValueStore;

public class AmazonS3Persister implements Persister
{
   private String s3BucketName;   
   
   
   //private AWSCredential;

   public void AWSS3Persister (String bucketName) {
      this.s3BucketName = bucketName;
    
      
   }   
   
   public void init () {
      //This should setup bucket name and user info so that it can talk to s3
   }

   public void wipe() throws PersistException
   {
      // TODO Auto-generated method stub

   }
   public UbiquitousKeyValueStore load()
   {
      // TODO Auto-generated method stub
      return null;
   }
   public void persist(UbiquitousKeyValueStore kv) throws PersistException
   {
      // TODO Auto-generated method stub
      
   }
  
  

}
