package org.eejot.acloud;

import java.io.Serializable;
import java.util.Date;

public class KVEvent implements Serializable
{

   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   
   public enum Event {REMOTE_UPDATE,INITAL_SYNC_CHANGE,OVER_QUOTA};
   
   private Date timestamp;
   
   private Event event;   
   
   
   /**
    * Set of keys involved with an event
    */
   
   private String[] keys;

   public Date getTimestamp()
   {
      return timestamp;
   }

   public void setTimestamp(Date timestamp)
   {
      this.timestamp = timestamp;
   }

   public Event getEvent()
   {
      return event;
   }

   public void setEvent(Event event)
   {
      this.event = event;
   }

   public String[] getKeys()
   {
      return keys;
   }

   public void setKey(String[] keys)
   {
      this.keys = keys;
   }
   
   
}
