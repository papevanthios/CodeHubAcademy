/**
 * The Main starts the Business from package use-cases.
 *
 * @author Evanthios Papadopoulos
 * @since 02-Mar-22
 */

package com.travelcompany.eshop;

import com.travelcompany.eshop.usecases.BusinessCase;

public class Main {
    public static void main(String[] args) {
        BusinessCase.userInterface();
    }
}
