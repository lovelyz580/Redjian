package com.wechat.bus.entity;

import java.util.List;

public class Record {
    private String recordId;

    private String recordUid;

    private String recordName;

    private String recordContent;

    private Integer recordImgnum;

    private String recordImg;

    public Integer getRecordImgnum() {
        return recordImgnum;
    }

    public void setRecordImgnum(Integer recordImgnum) {
        this.recordImgnum = recordImgnum;
    }

    public Integer getRecordState() {
        return recordState;
    }

    public void setRecordState(Integer recordState) {
        this.recordState = recordState;
    }

    private Integer recordState;

    // 版本信息
    /**
     * 版本号
     */
    private String version;
    // 分页数据
    /**
     * 当前页数(如果不进行分页，该条数据默认为-1)
     */
    private Integer pagenumber;

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
     * 每页的数据量
     */
    private Integer pagesize;
    // 操作数据
    /**
     * 根据uuidlist删除信息时使用
     */
    private List<String> idlist;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId == null ? null : recordId.trim();
    }

    public String getRecordUid() {
        return recordUid;
    }

    public void setRecordUid(String recordUid) {
        this.recordUid = recordUid == null ? null : recordUid.trim();
    }

    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName == null ? null : recordName.trim();
    }

    public String getRecordContent() {
        return recordContent;
    }

    public void setRecordContent(String recordContent) {
        this.recordContent = recordContent == null ? null : recordContent.trim();
    }


    public String getRecordImg() {
        return recordImg;
    }

    public void setRecordImg(String recordImg) {
        this.recordImg = recordImg == null ? null : recordImg.trim();
    }


}