package br.edu.ifce.watermonitoring.server;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

/**
 * Created by jp-desktop on 26/03/2015.
 */

public class ServerControllerWaterMonitoring  {
    public static void main(String args[]){
        try {
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objPoa = orb.resolve_initial_references("RootPOA");

            POA rootPOA = POAHelper.narrow(objPoa);
            org.omg.CORBA.Object obj = orb.resolve_initial_references("NameService");

            NamingContext naming = NamingContextHelper.narrow(obj);

            SensorNetworkImpl sensorNetwork = new SensorNetworkImpl();

            org.omg.CORBA.Object objRef = rootPOA.servant_to_reference(sensorNetwork);
            NameComponent[] name = { new NameComponent("SensorNetwork", "ServerControllerWaterMonitoring") };

            naming.rebind(name, objRef);
            rootPOA.the_POAManager().activate();

            sensorNetwork.start();

            orb.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
