package com.zryq.cms.admin.entity;

import java.util.Date;
import javax.persistence.*;
import javax.persistence.Column;

@Table(name = "fly_attention")
public class FlyAttention {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "from_user_id")
    private Integer fromUserId;

    @Column(name = "to_user_id")
    private Integer toUserId;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return from_user_id
     */
    public Integer getFromUserId() {
        return fromUserId;
    }

    /**
     * @param fromUserId
     */
    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    /**
     * @return to_user_id
     */
    public Integer getToUserId() {
        return toUserId;
    }

    /**
     * @param toUserId
     */
    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
