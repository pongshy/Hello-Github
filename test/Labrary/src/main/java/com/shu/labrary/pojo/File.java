package com.shu.labrary.pojo;

public class File {
    private Integer fileid;

    private String filename;

    private String filesrc;

    private String filetype;

    private String filestatus;

    private String filemore;

    private Integer newsid;

    public Integer getFileid() {
        return fileid;
    }

    public void setFileid(Integer fileid) {
        this.fileid = fileid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getFilesrc() {
        return filesrc;
    }

    public void setFilesrc(String filesrc) {
        this.filesrc = filesrc == null ? null : filesrc.trim();
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype == null ? null : filetype.trim();
    }

    public String getFilestatus() {
        return filestatus;
    }

    public void setFilestatus(String filestatus) {
        this.filestatus = filestatus == null ? null : filestatus.trim();
    }

    public String getFilemore() {
        return filemore;
    }

    public void setFilemore(String filemore) {
        this.filemore = filemore == null ? null : filemore.trim();
    }

    public Integer getNewsid() {
        return newsid;
    }

    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }
}