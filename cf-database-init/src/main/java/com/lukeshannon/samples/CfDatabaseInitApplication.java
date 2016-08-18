package com.lukeshannon.samples;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CfDatabaseInitApplication {

	public static void main(String[] args) {
		SpringApplication.run(CfDatabaseInitApplication.class, args);
	}
}

@RestController
class SampleController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/")
	public String home() {
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("joshua");
		//args with go here
		Map<String, Object> inParamMap = new HashMap<String, Object>();
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
		Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
		System.out.println(simpleJdbcCallResult);
		return simpleJdbcCallResult.toString();
		
	}
	
}
