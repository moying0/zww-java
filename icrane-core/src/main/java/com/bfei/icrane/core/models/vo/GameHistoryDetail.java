package com.bfei.icrane.core.models.vo;

import com.bfei.icrane.common.util.PropFileManager;

import java.io.Serializable;
import java.util.Date;

public class GameHistoryDetail implements Serializable {

    private static final long serialVersionUID = -553342729243143224L;
    private static final int DENY = -1;
    private static final int AUDITING = 0;
    private static final int RETURNCOINS = 1;
    private static final int RETURNDOLL = 2;
    private static final int NORMAL = 3;
    static PropFileManager propFileMgr = new PropFileManager("interface.properties");

    private Integer historyId;

    private String name;

    private Date catchDate;

    private String catchStatus;

    private String tbimgContextPath;

    private String tbimgFileName;

    private String tbimgRealPath;

    private Integer expenseCoin;
    /**
     * 游戏局数
     */
    private String gameNum;
    /**
     * 游戏视频
     */
    private String videoUrl;

    private Integer dollId;

    //审核状态
    private Integer checkState = 3;

    //oss验证地址
    private String stsTokenUrl;

    public String getStsTokenUrl() {
        return stsTokenUrl;
    }

    public void setStsTokenUrl(Integer memberId, String token) {
        this.stsTokenUrl = propFileMgr.getProperty("aliyun.sts") + "?userId=" + memberId + "&token=" + token;
    }

    public String getCheckState() {
        switch (checkState) {
            case DENY:
                return "未通过";
            case AUDITING:
                return "待审核";
            case RETURNCOINS:
                return "审核通过退还金币";
            case RETURNDOLL:
                return "审核通过补发娃娃";
            case NORMAL:
                return "未申诉";
            default:
                return "状态异常";
        }
    }

    public void setCheckState(Integer checkState) {
        this.checkState = checkState;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCatchDate() {
        return catchDate;
    }

    public void setCatchDate(Date catchDate) {
        this.catchDate = catchDate;
    }

    public String getCatchStatus() {
        return catchStatus;
    }

    public void setCatchStatus(String catchStatus) {
        this.catchStatus = catchStatus;
    }

    public String getTbimgContextPath() {
        return tbimgContextPath;
    }

    public void setTbimgContextPath(String tbimgContextPath) {
        this.tbimgContextPath = tbimgContextPath;
    }

    public String getTbimgFileName() {
        return tbimgFileName;
    }

    public void setTbimgFileName(String tbimgFileName) {
        this.tbimgFileName = tbimgFileName;
    }

    public String getTbimgRealPath() {
        return tbimgRealPath;
    }

    public void setTbimgRealPath(String tbimgRealPath) {
        this.tbimgRealPath = tbimgRealPath;
    }

    public Integer getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Integer historyId) {
        this.historyId = historyId;
    }

    public Integer getExpenseCoin() {
        return expenseCoin;
    }

    public void setExpenseCoin(Integer expenseCoin) {
        this.expenseCoin = expenseCoin;
    }


    public String getGameNum() {
        return gameNum;
    }

    public void setGameNum(String gameNum) {
        this.gameNum = gameNum;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Integer getDollId() {
        return dollId;
    }

    public void setDollId(Integer dollId) {
        this.dollId = dollId;
    }


}
