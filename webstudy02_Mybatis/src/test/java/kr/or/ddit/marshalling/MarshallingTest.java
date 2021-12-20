package kr.or.ddit.marshalling;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *	마샬링: 특정 시스템 방식으로 표현되고 있는 native data를 공통 표현 방식(xml, json)으로 바꾸는 작업
 * 	언마샬링: 공통 표현 방식의 데이터를 native 표현으로 바꾸는 작업.
 * 	
 * 	
 * 	
 *	
 */


public class MarshallingTest {
	
	@Test
	public void unmashallingTest() throws IOException{
		File jsonFile = new File("d:/sample.json");
		String tmp = null;
		StringBuffer json = new StringBuffer();
		try(
			FileReader reader = new FileReader(jsonFile);
			BufferedReader br = new BufferedReader(reader);	
		){
			while((tmp=br.readLine()) != null) {
				json.append(tmp);
			}
			System.out.println(json);
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> target = mapper.readValue(json.toString(), HashMap.class);
			System.out.println(target);
		}
		
	}
	
	
	
	
	public void marshallingTest() throws IOException {
		Map<String, Object> target = new HashMap<String, Object>();
		target.put("key1", "value1");//엔트리 하나
		target.put("key2", 234);
		target.put("key3", Collections.singletonMap("innerKey1", "innerValue1")); //맵도 객체여서 맵안에 맵을 넣을수 있다. 
		target.put("key4", new int[]{1,2});
//		{"key1":"value1","key2":234,"key3":{"innerKey1":"innerValue1"},"key4":[1,2]}
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(target);
		System.out.println(json);
		
		File jsonFile = new File("d:/sample.json");
		try(
			FileWriter out = new FileWriter(jsonFile);
			BufferedWriter bw = new BufferedWriter(out);
		){
			bw.write(json);
		}
	}

}
