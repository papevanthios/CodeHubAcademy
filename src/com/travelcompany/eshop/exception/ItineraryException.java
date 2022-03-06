/**
 * The ItineraryException class extends Exception class in order to handle itinerary missing data or missing itinerary id.
 *
 * @author Evanthios Papadopoulos
 * @since 02-Mar-22
 */

package com.travelcompany.eshop.exception;

public class ItineraryException extends Exception{
    public ItineraryException(String message){
        super(message);
    }
}
