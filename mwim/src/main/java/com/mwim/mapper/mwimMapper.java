package com.mwim.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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

@Repository
@Mapper
public interface mwimMapper {
	
	//account
	public int AddAccount(accountVo vo);
	public accountVo GetAccount(accountVo vo);
	public accountVo GetNickname(accountVo vo);
	public accountVo GetUid(accountVo vo);
	public int ChangePwd(accountVo vo);
	public int ChangeNickname(accountVo vo);
	
	//world
	public int addWorld(worldVo vo);
	public List<worldVo> getWorld(accountVo vo);
	
	public int addWorldReply(world_replyVo vo);
	public List<world_replyVo> getWorldReply(worldVo vo);
	
	//balance 
	public balanceVo GetBalance();
	public balanceVo GetBalanceByNo(balanceVo vo);
	public int AddBalance(balanceVo vo);
	public int balanceChoiceL(balanceVo vo);
	public int balanceChoiceR(balanceVo vo);
	public List<balanceVo> balanceFirstList();
	public List<balanceVo> balanceList(balanceVo vo);
	
	
	//game_reply
	public int addGameReply(gameReplyVo vo);
	public List<gameReplyVo> getGameReply(gameReplyVo vo);
	
	//vote
	public voteVo getVoteRand();
	public voteVo getVoteByNo(voteVo vo);
	public int addVote(voteVo vo);
	public int updateVote(voteVo vo);
	
	//joke
	public int addJoke(jokeVo vo);
	public jokeVo getRandJoke();
	public jokeVo getJokeByNum(jokeVo vo);
	
	//debate
	public int addDebate(debateVo vo);
	public debateVo randDebate();
	public debateVo getDebateByNo(debateVo vo);
	public int addDebateOpinion(debate_opinionVo vo);
	public List<debate_opinionVo> getDebateOpinionByNo(debate_opinionVo vo);
	
	//address
	public int addAddress(addressVo vo);
	public List<debateVo> getDebateList(debateVo vo);
}
