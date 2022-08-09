package vo;

import java.util.Date;

import lombok.Data;

@Data
public class gameReplyVo {
	int reply_no;
	int game_type;
	int game_no;
	String nickname;
	String writer;
	String content;
	Date writeTime;
}
