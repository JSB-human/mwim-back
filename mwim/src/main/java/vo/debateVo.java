package vo;

import java.util.Date;

import lombok.Data;

@Data
public class debateVo {
	int debate_no;
	String title;
	String description;
	String opinion1;
	String opinion2;
	String maker;
	Date writeTime;
}
