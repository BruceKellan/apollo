package com.ctrip.framework.apollo.portal.entity.model;


import com.ctrip.framework.apollo.core.enums.Env;
import com.ctrip.framework.apollo.core.utils.StringUtils;

/**
 * Namespace 配置发布Model
 */
public class NamespaceReleaseModel implements Verifiable {

  private String appId;
  private String env;
  private String clusterName;
  private String namespaceName;
  private String releaseTitle;
  private String releaseComment;
  private String releasedBy;

  /**
   * 紧急发布功能，可通过设置 PortalDB 的 ServerConfig 的"emergencyPublish.supported.envs" 配置开启对应的 Env 们。
   * 例如，emergencyPublish.supported.envs = dev
   */
  private boolean isEmergencyPublish;

  @Override
  public boolean isInvalid() {
    return StringUtils.isContainEmpty(appId, env, clusterName, namespaceName, releaseTitle);
  }

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public Env getEnv() {
    return Env.valueOf(env);
  }

  public void setEnv(String env) {
    this.env = env;
  }

  public String getClusterName() {
    return clusterName;
  }

  public void setClusterName(String clusterName) {
    this.clusterName = clusterName;
  }

  public String getNamespaceName() {
    return namespaceName;
  }

  public void setNamespaceName(String namespaceName) {
    this.namespaceName = namespaceName;
  }

  public String getReleaseTitle() {
    return releaseTitle;
  }

  public void setReleaseTitle(String releaseTitle) {
    this.releaseTitle = releaseTitle;
  }

  public String getReleaseComment() {
    return releaseComment;
  }

  public void setReleaseComment(String releaseComment) {
    this.releaseComment = releaseComment;
  }

  public String getReleasedBy() {
    return releasedBy;
  }

  public void setReleasedBy(String releasedBy) {
    this.releasedBy = releasedBy;
  }

  public boolean isEmergencyPublish() {
    return isEmergencyPublish;
  }

  public void setEmergencyPublish(boolean emergencyPublish) {
    isEmergencyPublish = emergencyPublish;
  }
}
