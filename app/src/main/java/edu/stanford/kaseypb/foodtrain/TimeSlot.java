package edu.stanford.kaseypb.foodtrain;

import android.util.Log;

import com.parse.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by kaseybaughan on 3/11/16.
 */
public class TimeSlot {

    //TODO: driver
    public ArrayList<String> stores;
    public Integer maxNumberOfDeliveries;
    public Integer numberOfDeliveriesAlreadyScheduled;
    public Integer allDeliveriesFilled;
    public Date startTime;
    public Date endTime;
    public Integer maxNumberOfItems;
    public Double price;
    public Double priceForAdditionalDeliveries;
    public Double pricePerItem;
    public Integer howMuchTimeToAllowTimeSlotBeforeTakingDown;
    public Date takeDownTime;
    public Double deliveryAreaLatitude;
    public Double deliveryAreaLongitude;
    public Double deliveryAreaRadius;
    public Boolean cancelled;

    public ArrayList<String> getStores() {
        List<String> storesPfList = pfObject.getList(ParseFields.STORES.getField());
        return new ArrayList<String>(storesPfList);
    }

    public Integer getMaxNumberOfDeliveries() {
        return maxNumberOfDeliveries;
    }

    public Integer getNumberOfDeliveriesAlreadyScheduled() {
        return numberOfDeliveriesAlreadyScheduled;
    }

    public Integer getAllDeliveriesFilled() {
        return allDeliveriesFilled;
    }

    public Date getStartTime() {
        return pfObject.getDate(ParseFields.START_TIME.getField());
    }

    public Date getEndTime() {
        return pfObject.getDate(ParseFields.END_TIME.getField());
    }

    public Integer getMaxNumberOfItems() {
        return maxNumberOfItems;
    }

    public Double getPrice() {
        return price;
    }

    public Double getPriceForAdditionalDeliveries() {
        return priceForAdditionalDeliveries;
    }

    public Double getPricePerItem() {
        return pricePerItem;
    }

    public Integer getHowMuchTimeToAllowTimeSlotBeforeTakingDown() {
        return howMuchTimeToAllowTimeSlotBeforeTakingDown;
    }

    public Date getTakeDownTime() {
        return takeDownTime;
    }

    public Double getDeliveryAreaLatitude() {
        return deliveryAreaLatitude;
    }

    public Double getDeliveryAreaLongitude() {
        return deliveryAreaLongitude;
    }

    public Double getDeliveryAreaRadius() {
        return deliveryAreaRadius;
    }

    public Boolean getCancelled() {
        return cancelled;
    }



    public static String parseClassName = "timeSlot";

    public enum ParseFields {
        DRIVER("driver"),
        STORES("stores"),
        MAX_NUMBER_OF_DELIVERIES("maxNumberOfDeliveries"),
        NUMBER_OF_DELIVERIES_ALREADY_SCHEDULED("numberOfDeliveriesAlreadyScheduled"),
        ALL_DELIVERIES_FILLED("allDeliveriesFilled"),
        START_TIME("startTime"),
        END_TIME("endTime"),
        MAX_NUMBER_OF_ITEMS("maxNumberOfItems"),
        PRICE("price"),
        PRICE_FOR_ADDITIONAL_DELIVERIES("priceForAdditionalDeliveries"),
        PRICE_PER_ITEM("pricePerItem"),
        HOW_MUCH_TIME_TO_ALLOW_TIME_SLOT_BEFORE_TAKING_DOWN("howMuchTimeToAllowTimeSlotBeforeTakingDown"),
        TAKE_DOWN_TIME("takeDownTime"),
        DELIVERY_AREA("deliveryArea"),
        DELIVERY_RADIUS("deliveryRadius"),
        CANCELLED("cancelled");

        private final String fieldName;

        private ParseFields(String name) {
            this.fieldName = name;
        }

        public String getField() {
            return this.fieldName;
        }
    }

    public ParseObject pfObject = ParseObject.create(parseClassName);

    public TimeSlot(ParseObject pfObj) {
        pfObject = pfObj;
    }

}

