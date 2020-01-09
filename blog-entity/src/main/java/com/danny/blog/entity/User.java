package com.danny.blog.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class User implements Serializable {

    @Id
    private String userId;

    private String groupId;

    private String userName;

    private String userPwd;

    private String userPhone;

    private String userSex;

    private String userQq;

    private String userEmail;

    private String userAddress;

    private Long userMark;

    private String userRankId;

    private String userLastLoginIp;

    private Date userBirthday;

    private String userDescription;

    private String userImageUrl;

    private String userSchool;

    private Date userRegisterTime;

    private String userRegisterIp;

    private Date userLastLoginTime;

    private String userWeibo;

    private String userBloodType;

    private String userSays;

    private Integer userLock;

    private Integer userFreeze;

    private String userPower;

    public String getUserId() {
        return userId;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getUserSex() {
        return userSex;
    }

    public String getUserQq() {
        return userQq;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public Long getUserMark() {
        return userMark;
    }

    public String getUserRankId() {
        return userRankId;
    }

    public String getUserLastLoginIp() {
        return userLastLoginIp;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public String getUserSchool() {
        return userSchool;
    }

    public Date getUserRegisterTime() {
        return userRegisterTime;
    }

    public String getUserRegisterIp() {
        return userRegisterIp;
    }

    public Date getUserLastLoginTime() {
        return userLastLoginTime;
    }

    public String getUserWeibo() {
        return userWeibo;
    }

    public String getUserBloodType() {
        return userBloodType;
    }

    public String getUserSays() {
        return userSays;
    }

    public Integer getUserLock() {
        return userLock;
    }

    public Integer getUserFreeze() {
        return userFreeze;
    }

    public String getUserPower() {
        return userPower;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public void setUserQq(String userQq) {
        this.userQq = userQq;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public void setUserMark(Long userMark) {
        this.userMark = userMark;
    }

    public void setUserRankId(String userRankId) {
        this.userRankId = userRankId;
    }

    public void setUserLastLoginIp(String userLastLoginIp) {
        this.userLastLoginIp = userLastLoginIp;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }

    public void setUserSchool(String userSchool) {
        this.userSchool = userSchool;
    }

    public void setUserRegisterTime(Date userRegisterTime) {
        this.userRegisterTime = userRegisterTime;
    }

    public void setUserRegisterIp(String userRegisterIp) {
        this.userRegisterIp = userRegisterIp;
    }

    public void setUserLastLoginTime(Date userLastLoginTime) {
        this.userLastLoginTime = userLastLoginTime;
    }

    public void setUserWeibo(String userWeibo) {
        this.userWeibo = userWeibo;
    }

    public void setUserBloodType(String userBloodType) {
        this.userBloodType = userBloodType;
    }

    public void setUserSays(String userSays) {
        this.userSays = userSays;
    }

    public void setUserLock(Integer userLock) {
        this.userLock = userLock;
    }

    public void setUserFreeze(Integer userFreeze) {
        this.userFreeze = userFreeze;
    }

    public void setUserPower(String userPower) {
        this.userPower = userPower;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", groupId='" + groupId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userQq='" + userQq + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userMark=" + userMark +
                ", userRankId='" + userRankId + '\'' +
                ", userLastLoginIp='" + userLastLoginIp + '\'' +
                ", userBirthday=" + userBirthday +
                ", userDescription='" + userDescription + '\'' +
                ", userImageUrl='" + userImageUrl + '\'' +
                ", userSchool='" + userSchool + '\'' +
                ", userRegisterTime=" + userRegisterTime +
                ", userRegisterIp='" + userRegisterIp + '\'' +
                ", userLastLoginTime=" + userLastLoginTime +
                ", userWeibo='" + userWeibo + '\'' +
                ", userBloodType='" + userBloodType + '\'' +
                ", userSays='" + userSays + '\'' +
                ", userLock=" + userLock +
                ", userFreeze=" + userFreeze +
                ", userPower='" + userPower + '\'' +
                '}';
    }
}