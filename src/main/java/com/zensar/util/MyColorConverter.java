package com.zensar.util;

import java.awt.Color;

public class MyColorConverter {
    

    MyColorConverter(){
    }
/**
 * Get the color from a string name
 * 
 * @param col name of the color
 * @return White if no color is given, otherwise the Color object
 */
static Color getColor(String col) {
	Color color;
    switch (col.toLowerCase()) {
    case "black":
        color = Color.BLACK;
        break;
    case "blue":
        color = Color.BLUE;
        break;
    case "cyan":
        color = Color.CYAN;
        break;
    case "darkgray":
        color = Color.DARK_GRAY;
        break;
    case "gray":
        color = Color.GRAY;
        break;
    case "green":
        color = Color.GREEN;
        break;

    case "yellow":
        color = Color.YELLOW;
        break;
    case "lightgray":
        color = Color.LIGHT_GRAY;
        break;
    case "magneta":
        color = Color.MAGENTA;
        break;
    case "orange":
        color = Color.ORANGE;
        break;
    case "pink":
        color = Color.PINK;
        break;
    case "red":
        color = Color.RED;
        break;
    case "white":
        color = Color.WHITE;
        break;
    default :
    	color = Color.white;
        }
    return color;
    }
}
