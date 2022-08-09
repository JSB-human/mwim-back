package vo;

import java.util.Date;

import lombok.Data;

@Data
public class world_replyVo {
	int reply_no;
	int world_no;
	String uid;
	String nickname;
	String comment;
	String pic;
	Date writeTime;
}
