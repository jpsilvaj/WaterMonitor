package sensorNetwork;


/**
* sensorNetwork/Sensor.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from SensorNetwork.idl
* Saturday, March 28, 2015 10:12:30 AM GMT-03:00
*/

public final class Sensor implements org.omg.CORBA.portable.IDLEntity
{
  public int id = (int)0;
  public int temperature = (int)0;
  public int ph = (int)0;
  public int color = (int)0;

  public Sensor ()
  {
  } // ctor

  public Sensor (int _id, int _temperature, int _ph, int _color)
  {
    id = _id;
    temperature = _temperature;
    ph = _ph;
    color = _color;
  } // ctor

} // class Sensor
