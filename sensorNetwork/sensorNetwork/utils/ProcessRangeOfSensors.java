package sensorNetwork.utils;

/**
 * Created by jp-desktop on 26/03/2015.
 */
public class ProcessRangeOfSensors {

    public static RangeTemperature verifyRangeFromTemperature(int temperature){
        if(temperature < Constants.MAX_TEMPERATURE_COLD){
            return RangeTemperature.COLD;
        }
        else if(temperature > Constants.MIN_TEMPERATURE_HOT){
            return RangeTemperature.HOT;
        }
        return RangeTemperature.NORMAL;
    }

    public static RangePH verifyRangeFromPh(int ph){
        if(ph < Constants.PH_NEUTRAL){
            return RangePH.ACID;
        }
        else if(ph > Constants.PH_NEUTRAL){
            return RangePH.BASE;
        }
        return RangePH.NEUTRAL;
    }

    public static RangeColor verifyRangeFromColor(int color){
        if(color > Constants.MAX_NORMAL_COLOR){
            return RangeColor.POLLUTION;
        }
        return RangeColor.NORMAL;
    }
}
