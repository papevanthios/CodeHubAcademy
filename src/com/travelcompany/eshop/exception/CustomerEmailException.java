/**
 * The CustomerEmailException class extends Exception class in order to handle customer email errors.
 *
 * @author Evanthios Papadopoulos
 * @since 02-Mar-22
 */

package com.travelcompany.eshop.exception;

public class CustomerEmailException extends Exception{
    public CustomerEmailException(String message) {
        super(message);
    }
}
