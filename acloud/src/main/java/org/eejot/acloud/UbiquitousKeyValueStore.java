package org.eejot.acloud;

import java.util.Hashtable;


public class UbiquitousKeyValueStore 
{
   private Hashtable<String, Object> backingTable = new Hashtable <String,Object> ();
   
   private static final UbiquitousKeyValueStore singleton = new UbiquitousKeyValueStore();
    
   private UbiquitousKeyValueStore () {
      
   }
   
   public static UbiquitousKeyValueStore getInstance() {
      return singleton;
   }
   
   
   public Integer getIntegerForKey (String key) {
      Object o = backingTable.get(key);
      if (o instanceof Integer)
         return (Integer) o;
      else
         return null;
         
   }
   
   public void setIntegerForKey (String key, Integer value) {
      backingTable.put(key, value);
   }
   
    
   
    public static void main( String[] args )
    {
        UbiquitousKeyValueStore store = new UbiquitousKeyValueStore();
        store.setIntegerForKey("prabhat", 5);
        System.out.println (store.getIntegerForKey("prabhat"));
    }
}
