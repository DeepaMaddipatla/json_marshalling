package com.jm.main;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.jm.app.Post;
import com.jm.serializer.PostSerializer;

public class JsonTest {

	public static void main(String[] args) {
		Post post = getObjectData();
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
			String json = mapper.writeValueAsString(post);
			System.out.println(json);

		}catch (IOException e){
			e.printStackTrace();
		}

	}
	private static Post getObjectData() {
		Post post = new Post();
		String var = "[{\"type\":\"image\",\"url\":\"azureblob.com/1\",\"aspect\":10,\"height\":11,\"width\":12,\"rotation\":13},{\"type\":\"image\",\"url\":\"azureblob.com/1\",\"aspect\":10,\"height\":11,\"width\":12,\"rotation\":13}]";
		post.setUserId("90862");
		post.setPostedOn(new Date());
		post.setPostId(897654L);
		post.setImagesJSON(var);
		return post;
	}

}
