package com.mwim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mwim.mapper.mwimMapper;

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

@Service
public class mwimService {
	
	@Autowired
	public mwimMapper mapper;
	
	// account
	public int addAccount(accountVo vo) {
		return mapper.AddAccount(vo);
	}
	
	public accountVo GetAccount(accountVo vo) {
		return mapper.GetAccount(vo);
	}
	
	public accountVo GetNickname(accountVo vo) {
		return mapper.GetNickname(vo);
	}
	
	public accountVo GetUid(accountVo vo) {
		return mapper.GetUid(vo);
	}
	
	public int ChangePwd(accountVo vo) {
		return mapper.ChangePwd(vo);
	}
	public int ChangeNickname(accountVo vo) {
		return mapper.ChangeNickname(vo);
	}
	
	//world
	public int addWorld(worldVo vo) {
		return mapper.addWorld(vo);
	}
	public List<worldVo> getWorld(accountVo vo) {
		return mapper.getWorld(vo);
	}
	
	public int addWorldReply(world_replyVo vo) {
		return mapper.addWorldReply(vo);
	}
	public List<world_replyVo> getWorldReply(worldVo vo){
		return mapper.getWorldReply(vo);
	}
	//balance
	public balanceVo GetBalance() {
		return mapper.GetBalance();
	}
	
	public balanceVo GetBalanceByNo(balanceVo vo) {
		return mapper.GetBalanceByNo(vo);
	}
	
	public int AddBalance(balanceVo vo) {
		return mapper.AddBalance(vo);
	}
	public int balanceChoiceL(balanceVo vo) {
		return mapper.balanceChoiceL(vo);
	}
	public int balanceChoiceR(balanceVo vo) {
		return mapper.balanceChoiceR(vo);
	}
	public List<balanceVo> balanceFirstList(){
		return mapper.balanceFirstList();
	}
	public List<balanceVo> balanceList(balanceVo vo){
		return mapper.balanceList(vo);
	}
	
	//game_reply
	public int addGameReply(gameReplyVo vo) {
		return mapper.addGameReply(vo);
	}
	public List<gameReplyVo> getGameReply (gameReplyVo vo) {
		return mapper.getGameReply(vo);
	}
	
	//vote
	public int addVote(voteVo vo) {
		return mapper.addVote(vo);
	}
	public voteVo getVoteRand() {
		return mapper.getVoteRand();
	}
	public voteVo getVoteByNo(voteVo vo) {
		return mapper.getVoteByNo(vo);
	}
	public int updateVote(voteVo vo) {
		return mapper.updateVote(vo);
	}
	
	//joke
	public int addJoke(jokeVo vo) {
		return mapper.addJoke(vo);
	}
	
	public jokeVo getRandJoke() {
		return mapper.getRandJoke();
	}
	
	public jokeVo getJokeByNum(jokeVo vo) {
		return mapper.getJokeByNum(vo);
	}

	//debate
	public int addDebate(debateVo vo) {
		return mapper.addDebate(vo);
	}
	public debateVo randDebate() {
		return mapper.randDebate();
	}
	public debateVo getDebateByNo(debateVo vo) {
		return mapper.getDebateByNo(vo);
	}
	public int addDebateOpinion(debate_opinionVo vo) {
		return mapper.addDebateOpinion(vo);
	}
	public List<debate_opinionVo> getDebateOpinionByNo(debate_opinionVo vo){
		return mapper.getDebateOpinionByNo(vo);
	}
	public List<debateVo> getDebateList(debateVo vo) {
		return mapper.getDebateList(vo);
	}
	//address
	public int addAddress(addressVo vo) {
		return mapper.addAddress(vo);
	}
}

