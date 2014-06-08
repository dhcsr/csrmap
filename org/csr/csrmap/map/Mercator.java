package org.csr.csrmap.map;

import org.csr.graphics.Point;

public class Mercator extends GeoProjection {
    static double
        ER      = 6371000.0,
        degrad  = 57.29577951,
        PI_4    = 0.785398163;
    double centerX, centerY, mapC;
    
    public Mercator(){
        super();
    }
    
    @Override
    public Point encodePoint(GeoCoords point){
        double X = encodeLon(point.lon()) - centerX;
        double Y = encodeLat(point.lat()) - centerY;
        return new Point((float)X,(float)Y);
    }
    
    @Override
    public GeoCoords decodePoint(Point vpoint){
        double lon = decodeLon( vpoint.getX() + centerX );
        double lat = decodeLat( vpoint.getY() + centerY );
        return new GeoCoords(lon,lat);
    }
    
    @Override
    public void setCenterPoint(GeoCoords point){
        super.setCenterPoint(point);
        mapC = ER / scale * Math.cos(center.lat()/degrad);
        centerY = encodeLat(center.lat());
        centerX = encodeLon(center.lon());
    }
    
    @Override
    public void setScale(double scale){
        super.setScale(scale);
        if(center != null){
            mapC = ER / scale * Math.cos(center.lat()/degrad);
            centerY = encodeLat(center.lat());
            centerX = encodeLon(center.lon());
        }
    }
    
    public static double pos_x(double lon){
        return 0.5 + lon/360.0;
    }
    public static double pos_y(double lat){
        return 0.5 - Math.log(Math.tan( lat/degrad/2 + PI_4 ))/Math.PI/2;
    }
    
    // get <i>lon</i> from <i>x</i>=0..1 (west->east)
    public static double pos_lon(double x){
        return 360.0*(x-0.5);
    }
    
    // get <i>lat</i> from <i>y</i>=0..1 (noth->south)
    public static double pos_lat(double y){
        return (Math.atan( Math.exp(((0.5-y)*Math.PI*2)) )-PI_4)*2*degrad;
    }
    
    public static Point positionIn(GeoCoords coords){
        return new Point(
            (float)( 0.5 + coords.lon()/360.0 ),
            (float)( 0.5 - Math.log(Math.tan( coords.lat()/degrad/2 + PI_4 ))/Math.PI/2 ) );
    }
    
    public static GeoCoords positionOut(Point pnt){
        return new GeoCoords(
            360.0*(pnt.getX()-0.5),
            (Math.atan( Math.exp(((0.5-pnt.getY())*Math.PI*2)) )-PI_4)*2*degrad );
    }
    
    public static double getEarthReadius(){ return ER; }
    
    private double encodeLat(double lat){
        return - mapC * Math.log(Math.tan( lat/degrad/2 + PI_4 ));
    }
    
    private double encodeLon(double lon){
        return (lon/degrad) * mapC;
    }
    
    private double decodeLat(double Y){
        return 2.0 * ( Math.atan( Math.exp(-Y/mapC) ) - PI_4 ) * degrad;
    }
    
    private double decodeLon(double X){
        return X / mapC * degrad;
    }
}
