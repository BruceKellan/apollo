package com.ctrip.framework.apollo.core.dto;

/**
 * Apollo 配置通知 DTO
 * @author Jason Song(song_s@ctrip.com)
 */
public class ApolloConfigNotification {

  /**
   * Namespace 名字
   */
  private String namespaceName;

  /**
   * 最新通知编号
   * 目前使用 `ReleaseMessage.id` 。
   */
  private long notificationId;

  /**
   * 通知消息集合，因为存在多线程修改和读取
   */
  private volatile ApolloNotificationMessages messages;

  public ApolloConfigNotification() {
  }

  public ApolloConfigNotification(String namespaceName, long notificationId) {
    this.namespaceName = namespaceName;
    this.notificationId = notificationId;
  }

  public String getNamespaceName() {
    return namespaceName;
  }

  public long getNotificationId() {
    return notificationId;
  }

  public void setNamespaceName(String namespaceName) {
    this.namespaceName = namespaceName;
  }

  public ApolloNotificationMessages getMessages() {
    return messages;
  }

  public void setMessages(ApolloNotificationMessages messages) {
    this.messages = messages;
  }

  public void addMessage(String key, long notificationId) {
    // A. 单例，双重判断锁，第一重判断，增加性能
    if (this.messages == null) {
      // B. synchronized 使改代码同一时间只能有一个线程执行
      synchronized (this) {
        // C. 走完所有步骤时，可能有线程在B处阻塞住，此时该线程获取了对象锁后，进入同步代码块时，需要再次校验。
        if (this.messages == null) {
          this.messages = new ApolloNotificationMessages();
        }
      }
    }
    this.messages.put(key, notificationId);
  }

  @Override
  public String toString() {
    return "ApolloConfigNotification{" +
        "namespaceName='" + namespaceName + '\'' +
        ", notificationId=" + notificationId +
        '}';
  }
}
