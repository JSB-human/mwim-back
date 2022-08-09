package vo;

import java.util.Date;

import lombok.Data;

@Data
public class jokeVo {
	int joke_no;
	String title;
	String subject;
	String maker;
	Date writeTime;
}
