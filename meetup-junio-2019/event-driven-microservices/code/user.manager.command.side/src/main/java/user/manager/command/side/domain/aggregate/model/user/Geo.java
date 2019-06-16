package user.manager.command.side.domain.aggregate.model.user;

import lombok.Value;

@Value
public class Geo {
	
    private final Identifier geoId;
    private final Location city;
    private final Location comune;
    private final Location province;
    private final Location region;
    private final Location country;
    private final Double latitude;
    private final Double longitude;
    
    
	public Geo(Identifier geoId, Location city, Location comune, Location province, Location region, Location country, Double latitude,Double longitude) {	
		this.geoId = geoId;
		this.city =  city;				
		this.comune = comune;				
		this.province = province;				
		this.region = region;				
		this.country = country;
		//
		this.latitude = new Double(latitude);
		this.longitude = new Double(longitude);
	}    
	
	@Override
	protected Object clone() throws CloneNotSupportedException {		
		return new Geo(geoId, city, comune, province, region, country, latitude, longitude);
	}
}
     
              
