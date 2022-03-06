/**
 * The TicketException class extends Exception class in order to handle ticket missing data or missing ticket id.
 *
 * @author Evanthios Papadopoulos
 * @since 02-Mar-22
 */

package com.travelcompany.eshop.exception;

public class TicketException extends Exception{
    public TicketException(String message){
        super(message);
    }
}
