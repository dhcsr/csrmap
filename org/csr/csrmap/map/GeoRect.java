package org.csr.csrmap.map;

public class GeoRect {
    protected double cnorth, csouth, cwest, ceast;
    
    // TODO: 180 meredian
    
    public GeoRect(double west, double east, double north, double south) {
        cnorth = north;
        csouth = south;
        cwest  = west;
        ceast  = east;
    }
    
    public GeoRect(GeoCoords pnts[]) {
        double minlon=180, maxlon=-180, minlat=90, maxlat=-90;
        for(GeoCoords pnt: pnts){
            if(pnt.lon() < minlon)
                minlon = pnt.lon();
            if(pnt.lon() > maxlon)
                maxlon = pnt.lon();
            if(pnt.lat() < minlat)
                minlat = pnt.lat();
            if(pnt.lat() > maxlat)
                maxlat = pnt.lat();
        }
        cnorth = maxlat;
        csouth = minlat;
        ceast  = maxlon;
        cwest  = minlon;
    }
    
    public boolean isInside(GeoCoords pnt) {
        return pnt.lon()<ceast && pnt.lon()>cwest && pnt.lat()<cnorth && pnt.lon()>csouth;
    }
    
    public boolean isIntersect(GeoRect rect) {
        return !( rect.csouth > cnorth || rect.cnorth < csouth || rect.cwest > ceast || rect.ceast < cwest );
    }
    
    public double north() { return cnorth; }
    public double south() { return csouth; }
    public double west()  { return cwest;  }
    public double east()  { return ceast;  }
    public GeoCoords cNW() { return new GeoCoords(cwest,cnorth); }
    public GeoCoords cNE() { return new GeoCoords(ceast,cnorth); }
    public GeoCoords cSW() { return new GeoCoords(cwest,csouth); }
    public GeoCoords cSE() { return new GeoCoords(ceast,csouth); }
}
