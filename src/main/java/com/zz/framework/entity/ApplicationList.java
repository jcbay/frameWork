package com.zz.framework.entity;

import com.zz.framework.core.BaseEntity;

import java.util.List;

/**
 * Created by Alex.Zhang on 2015/5/27.
 */
public class ApplicationList extends BaseEntity {

    private String appId;

    private String deviceCode;

    private String appName;

    private String fullVersion;

    private String shortVersion;

    private String identifier;

    private Integer bundleSize;

    private Integer dynamicSize;

    private String pickDate;

    private Integer isManaged;

    private List<String> identifierList;

    private String appLock;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getFullVersion() {
        return fullVersion;
    }

    public void setFullVersion(String fullVersion) {
        this.fullVersion = fullVersion;
    }

    public String getShortVersion() {
        return shortVersion;
    }

    public void setShortVersion(String shortVersion) {
        this.shortVersion = shortVersion;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Integer getBundleSize() {
        return bundleSize;
    }

    public void setBundleSize(Integer bundleSize) {
        this.bundleSize = bundleSize;
    }

    public Integer getDynamicSize() {
        return dynamicSize;
    }

    public void setDynamicSize(Integer dynamicSize) {
        this.dynamicSize = dynamicSize;
    }

    public String getPickDate() {
        return pickDate;
    }

    public void setPickDate(String pickDate) {
        this.pickDate = pickDate;
    }

    public Integer getIsManaged() {
        return isManaged;
    }

    public void setIsManaged(Integer isManaged) {
        this.isManaged = isManaged;
    }

    public List<String> getIdentifierList() {
        return identifierList;
    }

    public void setIdentifierList(List<String> identifierList) {
        this.identifierList = identifierList;
    }

    public String getAppLock() {
        return appLock;
    }

    public void setAppLock(String appLock) {
        this.appLock = appLock;
    }
}
