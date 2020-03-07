package com.ts.server.mask.domain;

import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;
import java.util.Objects;

/**
 * 外出注册
 *
 * @author TS Goup
 */
public class GoRegister {
    @ApiModelProperty("编号")
    private long id;
    @ApiModelProperty("乡镇")
    private String area;
    @ApiModelProperty("村")
    private String village;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("身份证号")
    private String idCard;
    @ApiModelProperty("性别")
    private String sex;
    @ApiModelProperty("联系电话")
    private String mobile;
    @ApiModelProperty("外出省份")
    private String province;
    @ApiModelProperty("外出城市")
    private String city;
    @ApiModelProperty("外出省")
    private String county;
    @ApiModelProperty("技能")
    private String skill;
    @ApiModelProperty("本县地址")
    private String couAddress;
    @ApiModelProperty("是否在疫区")
    private boolean inpArea;
    @ApiModelProperty("是否贫困户")
    private boolean poverty;
    @ApiModelProperty("是否有政府统一安排出务工乘车需求")
    private boolean driver;
    @ApiModelProperty("外出时间")
    private String goDate;
    @ApiModelProperty("创建时间")
    private Date createTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getCouAddress() {
        return couAddress;
    }

    public void setCouAddress(String couAddress) {
        this.couAddress = couAddress;
    }

    public boolean isInpArea() {
        return inpArea;
    }

    public void setInpArea(boolean inpArea) {
        this.inpArea = inpArea;
    }

    public boolean isPoverty() {
        return poverty;
    }

    public void setPoverty(boolean poverty) {
        this.poverty = poverty;
    }

    public boolean isDriver() {
        return driver;
    }

    public void setDriver(boolean driver) {
        this.driver = driver;
    }

    public String getGoDate() {
        return goDate;
    }

    public void setGoDate(String goDate) {
        this.goDate = goDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoRegister that = (GoRegister) o;
        return id == that.id &&
                inpArea == that.inpArea &&
                poverty == that.poverty &&
                driver == that.driver &&
                Objects.equals(area, that.area) &&
                Objects.equals(village, that.village) &&
                Objects.equals(name, that.name) &&
                Objects.equals(idCard, that.idCard) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(mobile, that.mobile) &&
                Objects.equals(province, that.province) &&
                Objects.equals(city, that.city) &&
                Objects.equals(county, that.county) &&
                Objects.equals(skill, that.skill) &&
                Objects.equals(couAddress, that.couAddress) &&
                Objects.equals(goDate, that.goDate) &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, area, village, name, idCard, sex, mobile, province, city, county, skill, couAddress, inpArea, poverty, driver, goDate, createTime);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("area", area)
                .append("village", village)
                .append("name", name)
                .append("idCard", idCard)
                .append("sex", sex)
                .append("mobile", mobile)
                .append("province", province)
                .append("city", city)
                .append("county", county)
                .append("skill", skill)
                .append("couAddress", couAddress)
                .append("inpArea", inpArea)
                .append("poverty", poverty)
                .append("driver", driver)
                .append("goDate", goDate)
                .append("createTime", createTime)
                .toString();
    }
}
