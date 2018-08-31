package com.zryq.cms.admin.entity;
import javax.persistence.Column;
import java.util.Date;
import javax.persistence.*;

@Table(name = "fly_user")
public class FlyUser {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 密码
     */
    private String password;

    /**
     * 上次登录时间
     */
    @Column(name = "last_login_time")
    private Date lastLoginTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 状态 1:正常  -1锁定
     */
    private String status;

    /**
     * 尝试登录次数
     */
    @Column(name = "try_login_times")
    private Date tryLoginTimes;

    /**
     * UUID
     */
    private String uuid;

    /**
     * 头像图片地址
     */
    @Column(name = "img_path")
    private String imgPath;

    /**
     * 地址
     */
    private String address;

    /**
     * 等级
     */
    private String level;

    /**
     * 0:男  1：女  2：保密
     */
    private Integer sex;

    /**
     * 签名
     */
    private String sign;

    @Transient
    private String rePassword;

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取昵称
     *
     * @return nick_name - 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置昵称
     *
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取上次登录时间
     *
     * @return last_login_time - 上次登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置上次登录时间
     *
     * @param lastLoginTime 上次登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取状态 1:正常  -1锁定
     *
     * @return status - 状态 1:正常  -1锁定
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态 1:正常  -1锁定
     *
     * @param status 状态 1:正常  -1锁定
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取尝试登录次数
     *
     * @return try_login_times - 尝试登录次数
     */
    public Date getTryLoginTimes() {
        return tryLoginTimes;
    }

    /**
     * 设置尝试登录次数
     *
     * @param tryLoginTimes 尝试登录次数
     */
    public void setTryLoginTimes(Date tryLoginTimes) {
        this.tryLoginTimes = tryLoginTimes;
    }

    /**
     * 获取UUID
     *
     * @return uuid - UUID
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置UUID
     *
     * @param uuid UUID
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 获取头像图片地址
     *
     * @return img_path - 头像图片地址
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * 设置头像图片地址
     *
     * @param imgPath 头像图片地址
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    /**
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取等级
     *
     * @return level - 等级
     */
    public String getLevel() {
        return level;
    }

    /**
     * 设置等级
     *
     * @param level 等级
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * 获取0:男  1：女  2：保密
     *
     * @return sex - 0:男  1：女  2：保密
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置0:男  1：女  2：保密
     *
     * @param sex 0:男  1：女  2：保密
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取签名
     *
     * @return sign - 签名
     */
    public String getSign() {
        return sign;
    }

    /**
     * 设置签名
     *
     * @param sign 签名
     */
    public void setSign(String sign) {
        this.sign = sign;
    }
}
