package com.ts.server.mask.controller.client.form;

import com.ts.server.mask.domain.GoRegister;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 预定提交数据
 *
 * @author TS Group
 */
public class GoRegisterForm {
    @ApiModelProperty(value = "乡镇", required = true)
    @NotBlank
    private String area;
    @ApiModelProperty(value = "姓名", required = true)
    @NotBlank
    private String name;
    @ApiModelProperty(value = "身份证号", required = true)
    @NotBlank
    private String idCard;
    @ApiModelProperty(value = "性别", required = true)
    @NotBlank
    private String sex;
    @ApiModelProperty(value = "联系电话", required = true)
    @NotBlank
    private String mobile;
    @ApiModelProperty(value = "外出省份")
    private String province;
    @ApiModelProperty(value = "外出城市")
    private String city;
    @ApiModelProperty(value = "外出县")
    private String county;
    @ApiModelProperty(value = "技能")
    private String skill;
    @ApiModelProperty(value = "本县地址")
    private String couAddress;
    @ApiModelProperty(value = "是否在疫区", required = true )
    @NotNull
    private Boolean inpArea;
    @ApiModelProperty(value = "是否贫困户", required = true)
    @NotNull
    private Boolean poverty;
    @ApiModelProperty(value = "是否有政府统一安排出务工乘车需求", required = true)
    @NotNull
    private Boolean driver;
    @ApiModelProperty(value = "外出时间")
    private String goDate;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

    public Boolean getInpArea() {
        return inpArea;
    }

    public void setInpArea(Boolean inpArea) {
        this.inpArea = inpArea;
    }

    public Boolean getPoverty() {
        return poverty;
    }

    public void setPoverty(Boolean poverty) {
        this.poverty = poverty;
    }

    public Boolean getDriver() {
        return driver;
    }

    public void setDriver(Boolean driver) {
        this.driver = driver;
    }

    public String getGoDate() {
        return goDate;
    }

    public void setGoDate(String goDate) {
        this.goDate = goDate;
    }

    public GoRegister toDomain(){
        GoRegister t = new GoRegister();

        t.setArea(area);
        t.setName(name);
        t.setIdCard(idCard);
        t.setSex(sex);
        t.setMobile(mobile);
        t.setProvince(province);
        t.setCity(city);
        t.setCounty(county);
        t.setSkill(skill);
        t.setCouAddress(couAddress);
        t.setInpArea(inpArea);
        t.setPoverty(poverty);
        t.setDriver(driver);
        t.setGoDate(goDate);

        return t;
    }
}
