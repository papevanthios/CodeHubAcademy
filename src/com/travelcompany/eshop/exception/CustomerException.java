/**
 * The CustomerException class extends Exception class in order to handle customer missing data or missing customer id.
 *
 * @author Evanthios Papadopoulos
 * @since 02-Mar-22
 */

package com.travelcompany.eshop.exception;

public class CustomerException extends Exception{
    public CustomerException(String message){
        super(message);
    }
}
