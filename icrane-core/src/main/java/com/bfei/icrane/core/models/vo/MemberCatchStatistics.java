package com.bfei.icrane.core.models.vo;

import com.bfei.icrane.core.models.Member;
import com.bfei.icrane.core.models.PrefSet;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 用户抓取次数 on 2017-12-03.
 */
public class MemberCatchStatistics implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String memberID;
    private String name;
    private String mobile;
    private String password;
    private String weixinId;
    private String gender;
    private Integer coins;
    private Integer catchNumber;//抓取次数
    private Integer catchSucessNumber;//抓中次数
    private Integer replySendNumber;//申请发货次数
    private Integer sendedNumber;//已发货次数
    private Timestamp registerDate;
    private Timestamp modifiedDate;
    private int modifiedBy;
    private Timestamp lastLoginDate;
    private Timestamp lastLogoffDate;
    private boolean onlineFlg;
    private String iconContextPath;
    private String iconFileName;
    private String iconRealPath;
    private Date birthday;
    private Integer watchingDollId; // 玩家进入娃娃机房间的id
    private Long playingDollFlg; //玩家是否在操作娃娃机的标记
    private String easemobUuid;
    private boolean activeFlg;
    private boolean inviteFlg;
    private PrefSet prefset;
    private boolean inviteFlgWeb;
    private String registerFrom;//注册设备
    private String lastLoginFrom;//登录设备
    private String rReward;
    private String lReward;
    private Integer firstLogin;//首充登录 表示 0  为第一次登录
    private Integer firstCharge;//首充充值

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWeixinId() {
        return weixinId;
    }

    public void setWeixinId(String weixinId) {
        this.weixinId = weixinId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public Integer getCatchNumber() {
        return catchNumber;
    }

    public void setCatchNumber(Integer catchNumber) {
        this.catchNumber = catchNumber;
    }

    public Integer getCatchSucessNumber() {
        return catchSucessNumber;
    }

    public void setCatchSucessNumber(Integer catchSucessNumber) {
        this.catchSucessNumber = catchSucessNumber;
    }

    public Integer getReplySendNumber() {
        return replySendNumber;
    }

    public void setReplySendNumber(Integer replySendNumber) {
        this.replySendNumber = replySendNumber;
    }

    public Integer getSendedNumber() {
        return sendedNumber;
    }

    public void setSendedNumber(Integer sendedNumber) {
        this.sendedNumber = sendedNumber;
    }

    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public int getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(int modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Timestamp getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Timestamp lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Timestamp getLastLogoffDate() {
        return lastLogoffDate;
    }

    public void setLastLogoffDate(Timestamp lastLogoffDate) {
        this.lastLogoffDate = lastLogoffDate;
    }

    public boolean isOnlineFlg() {
        return onlineFlg;
    }

    public void setOnlineFlg(boolean onlineFlg) {
        this.onlineFlg = onlineFlg;
    }

    public String getIconContextPath() {
        return iconContextPath;
    }

    public void setIconContextPath(String iconContextPath) {
        this.iconContextPath = iconContextPath;
    }

    public String getIconFileName() {
        return iconFileName;
    }

    public void setIconFileName(String iconFileName) {
        this.iconFileName = iconFileName;
    }

    public String getIconRealPath() {
        return iconRealPath;
    }

    public void setIconRealPath(String iconRealPath) {
        this.iconRealPath = iconRealPath;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getWatchingDollId() {
        return watchingDollId;
    }

    public void setWatchingDollId(Integer watchingDollId) {
        this.watchingDollId = watchingDollId;
    }

    public Long getPlayingDollFlg() {
        return playingDollFlg;
    }

    public void setPlayingDollFlg(Long playingDollFlg) {
        this.playingDollFlg = playingDollFlg;
    }

    public String getEasemobUuid() {
        return easemobUuid;
    }

    public void setEasemobUuid(String easemobUuid) {
        this.easemobUuid = easemobUuid;
    }

    public boolean isActiveFlg() {
        return activeFlg;
    }

    public void setActiveFlg(boolean activeFlg) {
        this.activeFlg = activeFlg;
    }

    public boolean isInviteFlg() {
        return inviteFlg;
    }

    public void setInviteFlg(boolean inviteFlg) {
        this.inviteFlg = inviteFlg;
    }

    public PrefSet getPrefset() {
        return prefset;
    }

    public void setPrefset(PrefSet prefset) {
        this.prefset = prefset;
    }

    public boolean isInviteFlgWeb() {
        return inviteFlgWeb;
    }

    public void setInviteFlgWeb(boolean inviteFlgWeb) {
        this.inviteFlgWeb = inviteFlgWeb;
    }

    public String getRegisterFrom() {
        return registerFrom;
    }

    public void setRegisterFrom(String registerFrom) {
        this.registerFrom = registerFrom;
    }

    public String getLastLoginFrom() {
        return lastLoginFrom;
    }

    public void setLastLoginFrom(String lastLoginFrom) {
        this.lastLoginFrom = lastLoginFrom;
    }

    public String getrReward() {
        return rReward;
    }

    public void setrReward(String rReward) {
        this.rReward = rReward;
    }

    public String getlReward() {
        return lReward;
    }

    public void setlReward(String lReward) {
        this.lReward = lReward;
    }

    public Integer getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(Integer firstLogin) {
        this.firstLogin = firstLogin;
    }

    public Integer getFirstCharge() {
        return firstCharge;
    }

    public void setFirstCharge(Integer firstCharge) {
        this.firstCharge = firstCharge;
    }


}
