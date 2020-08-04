package com.ld.model;

import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * @author liudong
 */
public class Material {

    private Long itemId;
    private String itemCode;
    private String itemUom;
    @Length(max = 240)
    private String itemDescription;
    private Date startActiveDate;
    private Date endActiveDate;
    private Boolean enabledFlag;
    private Long objectVersionNumber;
    private Date creationDate;
    private Long createdBy;
    private Long lastUpdatedBy;
    private Date lastUpdateDate;

    //java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.util.Date, java.util.Date, java.lang.Boolean, java.lang.Long, java.util.Date, java.lang.Long, java.lang.Long, java.util.Date

    public Material(Long itemId, String itemCode, String itemUom, String itemDescription, Date startActiveDate, Date endActiveDate, Boolean enabledFlag, Long objectVersionNumber, Date creationDate, Long createdBy, Long lastUpdatedBy, Date lastUpdateDate) {
        this.itemId = itemId;
        this.itemCode = itemCode;
        this.itemUom = itemUom;
        this.itemDescription = itemDescription;
        this.startActiveDate = startActiveDate;
        this.endActiveDate = endActiveDate;
        this.enabledFlag = enabledFlag;
        this.objectVersionNumber = objectVersionNumber;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdateDate = lastUpdateDate;
    }


    public Material() {
    }

    public Long getItemId() {
        return itemId;
    }


    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }


    public String getItemCode() {
        return itemCode;
    }


    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }


    public String getItemUom() {
        return itemUom;
    }


    public void setItemUom(String itemUom) {
        this.itemUom = itemUom == null ? null : itemUom.trim();
    }


    public String getItemDescription() {
        return itemDescription;
    }


    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription == null ? null : itemDescription.trim();
    }


    public Date getStartActiveDate() {
        return startActiveDate;
    }


    public void setStartActiveDate(Date startActiveDate) {
        this.startActiveDate = startActiveDate;
    }


    public Date getEndActiveDate() {
        return endActiveDate;
    }


    public void setEndActiveDate(Date endActiveDate) {
        this.endActiveDate = endActiveDate;
    }


    public Boolean getEnabledFlag() {
        return enabledFlag;
    }


    public void setEnabledFlag(Boolean enabledFlag) {
        this.enabledFlag = enabledFlag;
    }


    public Long getObjectVersionNumber() {
        return objectVersionNumber;
    }


    public void setObjectVersionNumber(Long objectVersionNumber) {
        this.objectVersionNumber = objectVersionNumber;
    }


    public Date getCreationDate() {
        return creationDate;
    }


    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }


    public Long getCreatedBy() {
        return createdBy;
    }


    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }


    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }


    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }


    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }


    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}