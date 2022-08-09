package com.mwim.controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mwim.service.mwimService;

import vo.accountVo;
import vo.addressVo;
import vo.balanceVo;
import vo.debateVo;
import vo.debate_opinionVo;
import vo.gameReplyVo;
import vo.jokeVo;
import vo.voteVo;
import vo.worldVo;
import vo.world_replyVo;

@RestController
@RequestMapping("/springApi")
@CrossOrigin(origins = {"http://localhost:3000"})
public class mwimController {
	
	@Autowired
	mwimService service;
	
	//account
	@PostMapping("/account/insert")
	public int AddAccount(@RequestBody accountVo vo) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if(vo.getSocial().equals("email") ) {
			String Password = encoder.encode(vo.getPwd());			
			vo.setPwd(Password);
		}
		return service.addAccount(vo);
	}
	
	
	
	@GetMapping("/account/select/{accountId}")
	public accountVo GetAccount(@PathVariable("accountId") String accountId) {
		accountVo vo = new accountVo();
		vo.setAccount_id(accountId);
		return service.GetAccount(vo);
	}
	
	@GetMapping("/account/getNickname/{nickname}")
	public accountVo GetNickname(@PathVariable("nickname") String nickname) {
		accountVo vo = new accountVo();
		vo.setNickname(nickname);
		return service.GetNickname(vo);
	}
	
	@GetMapping("/account/getUid/{uid}")
	public accountVo GetUid(@PathVariable("uid") String uid) {
		accountVo vo = new accountVo();
		vo.setUid(uid);
		return service.GetUid(vo);
	}
	
	@GetMapping("/account/sendMail")
	public String checkMail(@RequestParam("code") String code, @RequestParam("email") String email) {
		String str = "";
		SendMail mail = new SendMail();
		try {
			mail.Mailing(code, email);
			str = "send";
		} catch (Exception e) {
			e.printStackTrace();
			str = "fail";
		}
		return str;
	}
	
	@PostMapping("/account/login")
	public String emailLogin(@RequestBody accountVo vo) {
		String result = "";
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		accountVo id = new accountVo();
		try {
			id = service.GetAccount(vo);
		} catch (Exception e) {
			e.printStackTrace();
			result = "틀림";
			return result;
		}
		try {
			if(encoder.matches(vo.getPwd() ,id.getPwd())) {
				result = "일치";
			}else {
				result = "틀림";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@PutMapping("/account/changePwd")
	public int ChangePwd(@RequestBody accountVo vo) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		int i = 0;
		try {
			String Password = encoder.encode(vo.getPwd());			
			vo.setPwd(Password);
			i = service.ChangePwd(vo);		
		} catch (Exception e) {
			i = 2;
		}
		return i;
	}
	
	@PutMapping("/account/changeNickname")
	public int ChangeNickname(@RequestBody accountVo vo) {
		int i = 0;
		try {
			i = service.ChangeNickname(vo);
		} catch (Exception e) {
			e.printStackTrace();
			i = 2;
		}
		return i;
	}
	
	// world
	@PostMapping("/world/add")
	public int addWorld(@RequestBody worldVo vo) {
		return service.addWorld(vo);
	}
	
	@GetMapping("/world/get/{account_id}")
	public List<worldVo> getWorld(@PathVariable("account_id") String account_id) {
		accountVo vo = new accountVo();
		vo.setAccount_id(account_id);
		return service.getWorld(vo);
	}
	
	@PostMapping("/worldReply/add")
	public int addWorldReply(@RequestBody world_replyVo vo) {
		return service.addWorldReply(vo);
	}
	@GetMapping("/worldReply/get/{world_no}")
	public List<world_replyVo> getWorldReply(@PathVariable("world_no") int world_no){
		worldVo vo = new worldVo();
		vo.setWorld_no(world_no);
		return service.getWorldReply(vo);
	}
	
	
	// balance game
	@GetMapping("/play/balance/getby/rand")
	public balanceVo GetBalance(){
		return service.GetBalance();
	}
	
	@GetMapping("/play/balance/get/{game_no}")
	public balanceVo GetBalanceByNo(@PathVariable("game_no") String game_no){
		int no = Integer.parseInt(game_no);
		balanceVo vo = new balanceVo();
		vo.setGame_no(no);
		return service.GetBalanceByNo(vo);
	}
	
	@PostMapping ("/play/balance/add")
	public int AddBalance(@RequestBody balanceVo vo) {
		return service.AddBalance(vo);
	}
	
	@PutMapping("/play/balance/choice")
	public int balanceChoice(@RequestBody balanceVo vo) {
		int num = 0;
		if(vo.getPick1() == 1) {
			num = service.balanceChoiceL(vo);
		}else {
			num = service.balanceChoiceR(vo);
		}
		return num;
	}
	
	@GetMapping("/play/balance/list/first")
	public List<balanceVo> balanceFirstList(){
		return service.balanceFirstList();
	}
	
	@GetMapping("/play/balance/list/{game_no}")
	public List<balanceVo> balanceList(@PathVariable("game_no") int game_no){
		balanceVo vo = new balanceVo();
		vo.setGame_no(game_no);
		return service.balanceList(vo);
	}
	
	//game_reply
	@PostMapping("/game_reply/add")
	public int AddGameReply(@RequestBody gameReplyVo vo) {
		return service.addGameReply(vo);
	}
	
	@GetMapping("/game_reply/select")
	public List<gameReplyVo> GetGameReply(@RequestParam("game_no") String game_no, @RequestParam("game_type") String game_type ){
		gameReplyVo vo = new gameReplyVo();
		vo.setGame_no(Integer.parseInt(game_no));
		vo.setGame_type(Integer.parseInt(game_type));
		return service.getGameReply(vo);
	}
	
	//vote
	@PostMapping("/vote/add")
	public int AddVote(@RequestBody voteVo vo) {
		return service.addVote(vo);
	}
	
	@GetMapping("/vote/view/rand")
	public voteVo GetVoteRand() {
		return service.getVoteRand();
	}
	
	@GetMapping("/vote/view/no/{vote_no}")
	public voteVo getVoteByNo(@PathVariable("vote_no") int vote_no) {
		voteVo vo = new voteVo();
		vo.setVote_no(vote_no);
		return service.getVoteByNo(vo);
	}
	
	@SuppressWarnings({ "unchecked" })
	@PutMapping("/play/vote/choice")
	public int voteChoice(@RequestBody voteVo vo) throws ParseException {
		voteVo data = getVoteByNo(vo.getVote_no());
		String compare = vo.getVote();
		String str = data.getVote();
		JSONParser parser = new JSONParser();
		
		JSONArray arr = (JSONArray)parser.parse(str);
		JSONArray newArr = new JSONArray();
		for(int i = 0; i < arr.size(); i++) {
			JSONObject obj = new JSONObject((JSONObject) arr.get(i));
			String subject = obj.get("subject").toString();
			if(subject.equals(compare)) {
				int count = Integer.parseInt(obj.get("count").toString());
				obj.put("count", count+1);
			}
			newArr.add(obj);
		}
		voteVo updateVo = new voteVo();
		updateVo.setVote_no(vo.getVote_no());
		updateVo.setVote(newArr.toJSONString());
		
		return service.updateVote(updateVo);
	}
	
	// joke
	@PostMapping("/joke/add")
	public int addJoke(@RequestBody jokeVo vo) {
		return service.addJoke(vo);
	}
	
	@GetMapping("/joke/get/rand")
	public jokeVo getRandJoke() {
		return service.getRandJoke();
	}
	
	@GetMapping("/joke/get/{joke_no}")
	public jokeVo getJokeByNum(@PathVariable("joke_no") int joke_no) {
		jokeVo vo = new jokeVo();
		vo.setJoke_no(joke_no);
		return service.getJokeByNum(vo);
	}
	
	// debate
	@PostMapping("/debate/add")
	public int addDebate(@RequestBody debateVo vo) {
		return service.addDebate(vo);
	}
	
	@GetMapping("/debate/getRand")
	public debateVo randDebate() {
		return service.randDebate();
	}
	
	@GetMapping("/debate/get/{debate_no}")
	public debateVo getDebateByNo(@PathVariable("debate_no") int debate_no) {
		debateVo vo = new debateVo();
		vo.setDebate_no(debate_no);
		return service.getDebateByNo(vo);
	}
	
	@PostMapping("/debate_opinion/add")
	public int addDebateOpinion(@RequestBody debate_opinionVo vo) {
		return service.addDebateOpinion(vo);
	}
	
	@GetMapping("/debate_opinion/get/{debate_no}/{opinion_no}")
	public List<debate_opinionVo> getDebateOpinionByNo(@PathVariable("debate_no") int debate_no, @PathVariable("opinion_no") int opinion_no){
		debate_opinionVo vo = new debate_opinionVo();
		vo.setDebate_no(debate_no);
		vo.setOpinion_no(opinion_no);
		return service.getDebateOpinionByNo(vo);
	 }
	
	@GetMapping("/debate_list/{page}")
	public List<debateVo> getDebateList(debateVo vo){
		
		return service.getDebateList(vo);
	}
	
	// address
	@PostMapping("/address/add")
	public int addAddress(@RequestBody addressVo vo) {
		return service.addAddress(vo);
	}
	
}
