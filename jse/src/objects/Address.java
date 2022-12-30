package objects;

public class Address {
	// Constants - 1
	public static final String CITYNAME = "No CityName";
	public static final String DISTRICTNAME = "No DistrictName";
	public static final String STREETNAME = "No StreetName";

	// Object's properties - 0
	private String cityName;
	private String districtName;
	private String streetName;

	// Constructor methods - 2
	public Address() {
		this(Address.CITYNAME, Address.DISTRICTNAME, Address.STREETNAME);
	}

	public Address(String cityName, String districtName, String streetName) {
		this.cityName = cityName;
		this.districtName = districtName;
		this.streetName = streetName;
	}
	
	public Address(Address addr) {
		this(addr.getCityName(), addr.getDistrictName(), addr.getStreetName());
	}

	// Getter methods - 3
	public String getCityName() {
		return cityName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public String getStreetName() {
		return streetName;
	}

	// Setter methods - 4
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	// Other methods - 5
	@Override
	public String toString() {
		return "Address [cityName=" + cityName + ", districtName=" + districtName + ", streetName=" + streetName + "]";
	}

	
	
}
