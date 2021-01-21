package com.jm.app;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jm.serializer.PostSerializer;


@JsonSerialize(using = PostSerializer.class)
public class Post {
	
	public String userId; 
    public Date postedOn;
    public Long postId;
     @JsonIgnore
    public String imagesJSON ;
     
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public Date getPostedOn() {
		return postedOn;
	}
	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}
	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	public String getImagesJSON() {
		return imagesJSON;
	}
	 
	public void setImagesJSON(String imagesJSON) {
		this.imagesJSON = imagesJSON;
	}
	@Override
	public String toString() {
		return "Post [mapper=" + ", userId=" + userId + ", postedOn=" + postedOn + ", postId=" + postId
				+ ", imagesJSON=" + imagesJSON + "]";
	}
     

}
