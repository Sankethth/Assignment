package com.example.Cricket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CricketApplication {

	public static void main(String[] args) {
		SpringApplication.run(CricketApplication.class, args);
	}

	@GetMapping(value = "/startMatch")
	public ScoreBoard startMatch() throws JsonProcessingException {

		OdiMatch odiMatch = new OdiMatch();
		odiMatch.startMatch();
		return new ScoreBoard(odiMatch);
		 //odiMatch.setScoreBoard(odiMatch);
		//ObjectMapper mapper= new ObjectMapper();
		// return odiMatch.getScoreBoard();
		//BattingScoreBoard battingScoreBoard = new BattingScoreBoard()
		//return "hello";
	}
}
