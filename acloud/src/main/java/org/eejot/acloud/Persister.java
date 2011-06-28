package org.eejot.acloud;

public interface Persister
{

   public UbiquitousKeyValueStore load() throws PersistException;
   
   public void persist (UbiquitousKeyValueStore kvToPersist) throws PersistException;
   
   public void wipe () throws PersistException;
   
   
}
