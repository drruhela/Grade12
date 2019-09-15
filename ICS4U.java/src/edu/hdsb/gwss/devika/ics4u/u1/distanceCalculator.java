/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.devika.ics4u.u1;

import java.util.Scanner;

/**
 *
 * @author drruh
 */
public class distanceCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //getting and storing input
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        
        System.out.print("Place 1: ");
        String place1 = input.next();
        
        System.out.print("Latitude (in degrees): ");
        double lat1 = input.nextDouble();
        
        System.out.print("Longitude (in degrees): ");
        double lon1 = input.nextDouble();
        
        System.out.println("");
        
        System.out.print("Place 2: ");
        String place2 = input.next();
        
        System.out.print("Latitude (in degrees): ");
        double lat2 = input.nextDouble();
        
        System.out.print("Longitude (in degrees): ");
        double lon2 = input.nextDouble();

        //Converting degrees to radians
        double CONVERTER = 57.2958;
        lat1 = lat1 / CONVERTER;
        lon1 = lon1 / CONVERTER;
        
        lat2 = lat2 / CONVERTER;
        lon2 = lon2 / CONVERTER;
        
        //Finding the distance
        double RADIUS = 6378.8;
        double distance = RADIUS * Math.acos( (Math.sin(lat1) * Math.sin(lat2)) + (Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2 - lon1)));
        
        System.out.println(("The distance between " + place1 + " and " + place2 + " is " + distance + "."));
        

        
    }
    
}
