/*
 *              CSRMap
 *             CSR, 2014
 * <http://info.dcsr.ru/projects/csrmap/>
 *             
 * Geographic projection abstract class
 */

package org.csr.csrmap.map;

import org.csr.graphics.Point;

public abstract class GeoProjection {
    protected GeoCoords center;
    protected double scale;     // meters per pixel
    
    // Encode geo-point into projection
    public abstract Point encodePoint(GeoCoords point);
    
    // Decode geo-point from projection
    public abstract GeoCoords decodePoint(Point vpoint);
    
    // Encode array of geo-points into projection
    public Point[] encodePoints(GeoCoords[] points) {
        Point[] vpoints = new Point[points.length];
        for(int i=0; i<vpoints.length; i++)
            vpoints[i] = encodePoint(points[i]);
        return vpoints;
    }
    
    // Decode array of geo-points from projection
    public GeoCoords[] decodePoints(Point[] vpoints) {
        GeoCoords[] points = new GeoCoords[vpoints.length];
        for(int i=0; i<points.length; i++)
            points[i] = decodePoint(vpoints[i]);
        return points;
    }
    
    // Set center point of the projection
    public void setCenterPoint(GeoCoords point) {
        center = point;
    }
    
    // Get center point of the projection
    public GeoCoords getCenterPoint() {
        return center;
    }
    
    // Set scale of the projection
    public void setScale(double scale) {
        this.scale = scale;
    }
    
    // Get scale of the projection
    public double getScale() {
        return scale;
    }
    
    /*
     * Following methods are used for tile mapping
     */
    
    public double getAbsolX(double lon, double lat) {
        throw new UnsupportedOperationException();
    }
    
    public double getAbsolY(double lon, double lat) {
        throw new UnsupportedOperationException();
    }
    
    public double getAbsolLon(double x, double y) {
        throw new UnsupportedOperationException();
    }
    
    public double getAbsolLat(double x, double y) {
        throw new UnsupportedOperationException();
    }
} 

