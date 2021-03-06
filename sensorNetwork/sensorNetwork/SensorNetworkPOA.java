package sensorNetwork;


/**
* sensorNetwork/SensorNetworkPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from SensorNetwork.idl
* Saturday, March 28, 2015 10:12:30 AM GMT-03:00
*/

public abstract class SensorNetworkPOA extends org.omg.PortableServer.Servant
 implements sensorNetwork.SensorNetworkOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("addSensorToNetwork", new java.lang.Integer (0));
    _methods.put ("deleteSensorFromNetwork", new java.lang.Integer (1));
    _methods.put ("updateTemperatureValueToSensor", new java.lang.Integer (2));
    _methods.put ("updatePhValueToSensor", new java.lang.Integer (3));
    _methods.put ("updateColorValueToSensor", new java.lang.Integer (4));
    _methods.put ("getSensors", new java.lang.Integer (5));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // sensorNetwork/SensorNetwork/addSensorToNetwork
       {
         sensorNetwork.Sensor sensor = sensorNetwork.SensorHelper.read (in);
         this.addSensorToNetwork (sensor);
         out = $rh.createReply();
         break;
       }

       case 1:  // sensorNetwork/SensorNetwork/deleteSensorFromNetwork
       {
         sensorNetwork.Sensor sensor = sensorNetwork.SensorHelper.read (in);
         this.deleteSensorFromNetwork (sensor);
         out = $rh.createReply();
         break;
       }

       case 2:  // sensorNetwork/SensorNetwork/updateTemperatureValueToSensor
       {
         sensorNetwork.Sensor sensor = sensorNetwork.SensorHelper.read (in);
         int temperature = in.read_long ();
         this.updateTemperatureValueToSensor (sensor, temperature);
         out = $rh.createReply();
         break;
       }

       case 3:  // sensorNetwork/SensorNetwork/updatePhValueToSensor
       {
         sensorNetwork.Sensor sensor = sensorNetwork.SensorHelper.read (in);
         int ph = in.read_long ();
         this.updatePhValueToSensor (sensor, ph);
         out = $rh.createReply();
         break;
       }

       case 4:  // sensorNetwork/SensorNetwork/updateColorValueToSensor
       {
         sensorNetwork.Sensor sensor = sensorNetwork.SensorHelper.read (in);
         int color = in.read_long ();
         this.updateColorValueToSensor (sensor, color);
         out = $rh.createReply();
         break;
       }

       case 5:  // sensorNetwork/SensorNetwork/getSensors
       {
         sensorNetwork.Sensor $result[] = null;
         $result = this.getSensors ();
         out = $rh.createReply();
         sensorNetwork.SensorsHelper.write (out, $result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:sensorNetwork/SensorNetwork:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public SensorNetwork _this() 
  {
    return SensorNetworkHelper.narrow(
    super._this_object());
  }

  public SensorNetwork _this(org.omg.CORBA.ORB orb) 
  {
    return SensorNetworkHelper.narrow(
    super._this_object(orb));
  }


} // class SensorNetworkPOA
