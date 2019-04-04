package com.wechat.bus.entity;

import java.util.Date;
import java.util.List;

public class Memorandum {
    private String mId;

    private Date mTime;

    private String mName;

    private String mUid;

    private String mFormid;

    private String mContent;
    // 版本信息
    /**
     * 版本号
     */
    private String version;
    // 分页数据

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getPagenumber() {
        return pagenumber;
    }

    public void setPagenumber(Integer pagenumber) {
        this.pagenumber = pagenumber;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public List<String> getIdlist() {
        return idlist;
    }

    public void setIdlist(List<String> idlist) {
        this.idlist = idlist;
    }

    /**
     * 当前页数(如果不进行分页，该条数据默认为-1)
     */
    private Integer pagenumber;
    /**
     * 每页的数据量
     */
    private Integer pagesize;
    // 操作数据
    /**
     * 根据uuidlist删除信息时使用
     */
    private List<String> idlist;

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId == null ? null : mId.trim();
    }

    public Date getmTime() {
        return mTime;
    }

    public void setmTime(Date mTime) {
        this.mTime = mTime;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName == null ? null : mName.trim();
    }

    public String getmUid() {
        return mUid;
    }

    public void setmUid(String mUid) {
        this.mUid = mUid == null ? null : mUid.trim();
    }

    public String getmFormid() {
        return mFormid;
    }

    public void setmFormid(String mFormid) {
        this.mFormid = mFormid == null ? null : mFormid.trim();
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent == null ? null : mContent.trim();
    }
}