package com.cqxxty.security.admin.utils;

public class VerifyImage {
    String srcImage;    //原图Base64码值
    String cutImage;    //滑块Base64
    Integer XPosition;  //取滑块的坐标点 (X,Y)
    Integer YPosition;
    Integer srcImageWidth;
    Integer srcImageHeight;

    public VerifyImage(String srcImage, String cutImage, Integer XPosition, Integer YPosition, Integer srcImageWidth, Integer srcImageHeight) {
        this.srcImage = srcImage;
        this.cutImage = cutImage;
        this.XPosition = XPosition;
        this.YPosition = YPosition;
        this.srcImageWidth = srcImageWidth;
        this.srcImageHeight = srcImageHeight;
    }


    public void setCutImage(String cutImage) {
        this.cutImage = cutImage;
    }

    public void setXPosition(Integer XPosition) {
        this.XPosition = XPosition;
    }

    public void setYPosition(Integer YPosition) {
        this.YPosition = YPosition;
    }

    public void setSrcImage(String srcImage) {
        this.srcImage = srcImage;
    }

    public String getSrcImage() {
        return srcImage;
    }

    public Integer getSrcImageWidth() {
        return srcImageWidth;
    }

    public void setSrcImageWidth(Integer srcImageWidth) {
        this.srcImageWidth = srcImageWidth;
    }

    public Integer getSrcImageHeight() {
        return srcImageHeight;
    }

    public void setSrcImageHeight(Integer srcImageHeight) {
        this.srcImageHeight = srcImageHeight;
    }

    public String getCutImage() {
        return cutImage;
    }

    public Integer getXPosition() {
        return XPosition;
    }

    public Integer getYPosition() {
        return YPosition;
    }


    @Override
    public String toString() {
        return "VerifyImage{" +
                "srcImage='" + srcImage + '\'' +
                ", cutImage='" + cutImage + '\'' +
                ", XPosition=" + XPosition +
                ", YPosition=" + YPosition +
                '}';
    }
}
