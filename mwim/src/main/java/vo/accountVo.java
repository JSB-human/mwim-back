package vo;

import java.util.Date;

import lombok.Data;

@Data
public class accountVo {
	String uid;
	String account_id;
	String email;
	String pwd;
	String name;
	String social;
	Date account_date;
	String nickname;
	String comment;
}
