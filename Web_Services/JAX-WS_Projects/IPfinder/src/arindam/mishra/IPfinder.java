package arindam.mishra;
import net.webservicex.*;
public class IPfinder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length!=1){
			System.out.println("Enter one IP address");
		}
		else{
			String ipAddress =args[0];
			GeoIPService ipService = new GeoIPService();
			GeoIPServiceSoap geoIPserviceSoap =ipService.getGeoIPServiceSoap();
			GeoIP geoIP=geoIPserviceSoap.getGeoIP(ipAddress);
			System.out.println(geoIP.getCountryName());
		}
			

	}

}
