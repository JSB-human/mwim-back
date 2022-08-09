package vo;

import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;

import com.fasterxml.jackson.databind.util.JSONPObject;

import lombok.Data;

@Data
public class voteVo {
	int vote_no;
	String maker;
	String title;
	String vote;
	Date add_time;
}
