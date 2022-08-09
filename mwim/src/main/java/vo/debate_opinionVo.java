package vo;

import java.util.Date;

import lombok.Data;

@Data
public class debate_opinionVo {
	int opinion_no;
	int debate_no;
	int opinion_select;
	String opinion_txt;
	int opinion_like;
	String nickname;
	String maker;
	Date writeTime;
}
