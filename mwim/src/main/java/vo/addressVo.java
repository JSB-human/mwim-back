package vo;

import java.util.Date;

import lombok.Data;

@Data
public class addressVo {
	int address_no;
	String ip;
	String city;
	String country;
	String latitude;
	String longitude;
	String state;
	String page;
	Date actionTime;
}
