package com.manba.simple.domain.entity;

public class ManSimpleUserEntity {
	private Long id;
	private String phone;
	private String password;
	private String nickName;
	private Integer sex;
	private String interesting;
	private String photoUrl;
	private java.util.Date createTime;
	private java.util.Date updateTime;
    
	public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}
	public String getPhone(){
		return phone;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getNickName(){
		return nickName;
	}
	public void setNickName(String nickName){
		this.nickName = nickName;
	}
	public Integer getSex(){
		return sex;
	}
	public void setSex(Integer sex){
		this.sex = sex;
	}
	public String getInteresting(){
		return interesting;
	}
	public void setInteresting(String interesting){
		this.interesting = interesting;
	}
	public String getPhotoUrl(){
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl){
		this.photoUrl = photoUrl;
	}
	public java.util.Date getCreateTime(){
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	public java.util.Date getUpdateTime(){
		return updateTime;
	}
	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime = updateTime;
	}
}