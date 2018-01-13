package com.spsolutions.grand.domain;

import com.spsolutions.grand.domain.common.CommonDomain;

public class EdgeDocument extends CommonDomain {
    private String fileName;
    private String filePath;
    private String altPath;
    private String ext;
    private long fileSizeBytes;

    public String getAltPath() {
        return altPath;
    }

    public void setAltPath(String altPath) {
        this.altPath = altPath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public long getFileSizeBytes() {
        return fileSizeBytes;
    }

    public void setFileSizeBytes(long fileSizeBytes) {
        this.fileSizeBytes = fileSizeBytes;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }
}
