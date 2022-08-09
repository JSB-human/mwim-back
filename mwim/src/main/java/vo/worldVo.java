package vo;

import java.util.Date;

import lombok.Data;

@Data
public class worldVo {
	int world_no;
	String maker;
	String nickname;
	String title;
	String url;
	String comment;
	String pic;
	Date write_time;
	int replyCnt;
}
