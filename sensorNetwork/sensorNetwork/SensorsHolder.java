package sensorNetwork;


/**
* sensorNetwork/SensorsHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from SensorNetwork.idl
* Saturday, March 28, 2015 10:12:30 AM GMT-03:00
*/

public final class SensorsHolder implements org.omg.CORBA.portable.Streamable
{
  public sensorNetwork.Sensor value[] = null;

  public SensorsHolder ()
  {
  }

  public SensorsHolder (sensorNetwork.Sensor[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = sensorNetwork.SensorsHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    sensorNetwork.SensorsHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return sensorNetwork.SensorsHelper.type ();
  }

}
