package org.eejot.acloud;

import java.util.ArrayList;
import java.util.List;

import org.eejot.acloud.aws.AmazonS3Persister;

public class UbiquitousKeyValueService 
{     

   private List <KVEventListener> eventListeners = new ArrayList<KVEventListener> ();
   private Persister persister = new AmazonS3Persister();
   private static UbiquitousKeyValueService ubiquitousKVService = new UbiquitousKeyValueService();


   private UbiquitousKeyValueService () {

   }
   public static UbiquitousKeyValueService getInstance () {
      return ubiquitousKVService;
   }

   public UbiquitousKeyValueStore getUbiquitousKeyValueStore () {
      return UbiquitousKeyValueStore.getInstance();
   }

   public Persister getPersister () {
      return persister;
   }    

   public void setPersister (Persister persister) {
      this.persister = persister; 
   }


   public void addKVEventListener (KVEventListener listener) {
      eventListeners.add(listener);
   }

   public void removeKVEventListener (KVEventListener listener) {
      eventListeners.remove(listener);
   }

   public void fireEvents(KVEvent event) {
      for (KVEventListener listener:  eventListeners) {
         listener.onEvent(event);
      }
   }
}
