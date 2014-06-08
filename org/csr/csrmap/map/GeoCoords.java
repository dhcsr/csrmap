/*
 *              CSRMap
 *             CSR, 2014
 * <http://info.dcsr.ru/projects/csrmap/>
 *             
 * Geographic coordinates of 3D point:
 *  - longitude (degrees, positive for N)
 *  - latitude (degrees, positive for E)
 *  - altitude (meters, above WGS84)
 */

package org.csr.csrmap.map;

public class GeoCoords {
    private double clon, clat;      // degrees
    private double calt;            // meters above WGS84
    
    // 3D constructor
    public GeoCoords(double lon, double lat, double alt) {
        clon = lon;
        clat = lat;
        calt = alt;
    }
    
    // 2D constructor
    public GeoCoords(double lon, double lat) {
        clon = lon;
        clat = lat;
        calt = Double.NaN;
    }
    
    // Get longitude (in degrees)
    public double lon() { return clon; }
    
    // Get latitude (in degrees)
    public double lat() { return clat; }
    
    // Get latitude (in meters above WGS84)
    public double alt() { return calt; }
}
