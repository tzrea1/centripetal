package com.joyboys.system.domain;

import com.joyboys.common.annotation.Excel;
import com.joyboys.common.core.domain.BaseEntity;
import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 虚拟场景相关文件对象 scene_file
 *
 * @author joyboys
 * @date 2023-05-10
 */
public class SceneFile extends BaseEntity {

  private static final long serialVersionUID = 1L;

  /**
   * 场景文件id
   */
  private Long scenefileId;

  /**
   * 虚拟场景体验id
   */
  @Excel(name = "虚拟场景体验id")
  private Long sceneId;

  /**
   * 文件url
   */
  @Excel(name = "文件url")
  private String fileUrl;

  /**
   * 文件名
   */
  @Excel(name = "文件名")
  private String fileName;

  /**
   * 文件大小
   */
  @Excel(name = "文件大小")
  private BigDecimal fileSize;

  /**
   * 文件类型
   */
  @Excel(name = "文件类型")
  private String fileType;

  public Long getScenefileId() {
    return scenefileId;
  }

  public void setScenefileId(Long scenefileId) {
    this.scenefileId = scenefileId;
  }

  public Long getSceneId() {
    return sceneId;
  }

  public void setSceneId(Long sceneId) {
    this.sceneId = sceneId;
  }

  public String getFileUrl() {
    return fileUrl;
  }

  public void setFileUrl(String fileUrl) {
    this.fileUrl = fileUrl;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public BigDecimal getFileSize() {
    return fileSize;
  }

  public void setFileSize(BigDecimal fileSize) {
    this.fileSize = fileSize;
  }

  public String getFileType() {
    return fileType;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("scenefileId", getScenefileId())
        .append("sceneId", getSceneId())
        .append("fileUrl", getFileUrl())
        .append("fileName", getFileName())
        .append("fileSize", getFileSize())
        .append("fileType", getFileType())
        .toString();
  }
}
