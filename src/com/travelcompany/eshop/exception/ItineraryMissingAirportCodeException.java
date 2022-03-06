/**
 * The ItineraryMissingAirportCodeException class extends Exception class in order to handle itinerary missing airport code
 * for departure or destination.
 *
 * @author Evanthios Papadopoulos
 * @since 02-Mar-22
 */

package com.travelcompany.eshop.exception;

public class ItineraryMissingAirportCodeException extends Exception{
    public ItineraryMissingAirportCodeException(String message) {
        super(message);
    }
}
