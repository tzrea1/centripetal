package com.joyboys.system.domain;

import com.joyboys.common.annotation.Excel;
import com.joyboys.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 党史内容学习文件对象 ph_study_file
 *
 * @author joyboys
 * @date 2023-05-08
 */
public class PhStudyFile extends BaseEntity {

  private static final long serialVersionUID = 1L;

  /**
   * 党史内容学习活动相关文件ID
   */
  private Long studyfileId;

  /**
   * 所属党史内容学习活动ID
   */
  @Excel(name = "所属党史内容学习活动ID")
  private Long phStudyId;

  /**
   * 文件url
   */
  @Excel(name = "文件url")
  private String fileUrl;

  /**
   * 文件名称
   */
  @Excel(name = "文件名称")
  private String fileName;

  /**
   * 文件类型
   */
  @Excel(name = "文件类型")
  private String fileType;

  public Long getStudyfileId() {
    return studyfileId;
  }

  public void setStudyfileId(Long studyfileId) {
    this.studyfileId = studyfileId;
  }

  public Long getPhStudyId() {
    return phStudyId;
  }

  public void setPhStudyId(Long phStudyId) {
    this.phStudyId = phStudyId;
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

  public String getFileType() {
    return fileType;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
        .append("studyfileId", getStudyfileId())
        .append("phStudyId", getPhStudyId())
        .append("fileUrl", getFileUrl())
        .append("fileName", getFileName())
        .append("fileType", getFileType())
        .toString();
  }
}
