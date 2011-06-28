package com.ideawheel.acloud;

import org.eejot.acloud.aws.AWSConfig;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author prabhat
 * 
 * Unit test for simple App.
 */
public class AWSConfigTest  extends TestCase
{
   /**
    * Create the test case
    *
    * @param testName name of the test case
    */
   public AWSConfigTest( String testName )
   {
      super( testName );
   }

   /**
    * @return the suite of tests being tested
    */
   public static Test suite()
   {
      return new TestSuite( AWSConfigTest.class );
   }

   /**
    * Rigourous Test :-)
    */
   public void testSuccessfullyLoadingConfig()
   {
      assertTrue( AWSConfig.getAWSConfig() != null);
      assertTrue( AWSConfig.getAWSConfig().getConfigFileName().equals("CLOUD_FILE_TO_MONITOR"));
   }
}
