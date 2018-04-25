package com.zryq.cms.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andArtTitleIsNull() {
            addCriterion("art_title is null");
            return (Criteria) this;
        }

        public Criteria andArtTitleIsNotNull() {
            addCriterion("art_title is not null");
            return (Criteria) this;
        }

        public Criteria andArtTitleEqualTo(String value) {
            addCriterion("art_title =", value, "artTitle");
            return (Criteria) this;
        }

        public Criteria andArtTitleNotEqualTo(String value) {
            addCriterion("art_title <>", value, "artTitle");
            return (Criteria) this;
        }

        public Criteria andArtTitleGreaterThan(String value) {
            addCriterion("art_title >", value, "artTitle");
            return (Criteria) this;
        }

        public Criteria andArtTitleGreaterThanOrEqualTo(String value) {
            addCriterion("art_title >=", value, "artTitle");
            return (Criteria) this;
        }

        public Criteria andArtTitleLessThan(String value) {
            addCriterion("art_title <", value, "artTitle");
            return (Criteria) this;
        }

        public Criteria andArtTitleLessThanOrEqualTo(String value) {
            addCriterion("art_title <=", value, "artTitle");
            return (Criteria) this;
        }

        public Criteria andArtTitleLike(String value) {
            addCriterion("art_title like", value, "artTitle");
            return (Criteria) this;
        }

        public Criteria andArtTitleNotLike(String value) {
            addCriterion("art_title not like", value, "artTitle");
            return (Criteria) this;
        }

        public Criteria andArtTitleIn(List<String> values) {
            addCriterion("art_title in", values, "artTitle");
            return (Criteria) this;
        }

        public Criteria andArtTitleNotIn(List<String> values) {
            addCriterion("art_title not in", values, "artTitle");
            return (Criteria) this;
        }

        public Criteria andArtTitleBetween(String value1, String value2) {
            addCriterion("art_title between", value1, value2, "artTitle");
            return (Criteria) this;
        }

        public Criteria andArtTitleNotBetween(String value1, String value2) {
            addCriterion("art_title not between", value1, value2, "artTitle");
            return (Criteria) this;
        }

        public Criteria andArtDigestIsNull() {
            addCriterion("art_digest is null");
            return (Criteria) this;
        }

        public Criteria andArtDigestIsNotNull() {
            addCriterion("art_digest is not null");
            return (Criteria) this;
        }

        public Criteria andArtDigestEqualTo(String value) {
            addCriterion("art_digest =", value, "artDigest");
            return (Criteria) this;
        }

        public Criteria andArtDigestNotEqualTo(String value) {
            addCriterion("art_digest <>", value, "artDigest");
            return (Criteria) this;
        }

        public Criteria andArtDigestGreaterThan(String value) {
            addCriterion("art_digest >", value, "artDigest");
            return (Criteria) this;
        }

        public Criteria andArtDigestGreaterThanOrEqualTo(String value) {
            addCriterion("art_digest >=", value, "artDigest");
            return (Criteria) this;
        }

        public Criteria andArtDigestLessThan(String value) {
            addCriterion("art_digest <", value, "artDigest");
            return (Criteria) this;
        }

        public Criteria andArtDigestLessThanOrEqualTo(String value) {
            addCriterion("art_digest <=", value, "artDigest");
            return (Criteria) this;
        }

        public Criteria andArtDigestLike(String value) {
            addCriterion("art_digest like", value, "artDigest");
            return (Criteria) this;
        }

        public Criteria andArtDigestNotLike(String value) {
            addCriterion("art_digest not like", value, "artDigest");
            return (Criteria) this;
        }

        public Criteria andArtDigestIn(List<String> values) {
            addCriterion("art_digest in", values, "artDigest");
            return (Criteria) this;
        }

        public Criteria andArtDigestNotIn(List<String> values) {
            addCriterion("art_digest not in", values, "artDigest");
            return (Criteria) this;
        }

        public Criteria andArtDigestBetween(String value1, String value2) {
            addCriterion("art_digest between", value1, value2, "artDigest");
            return (Criteria) this;
        }

        public Criteria andArtDigestNotBetween(String value1, String value2) {
            addCriterion("art_digest not between", value1, value2, "artDigest");
            return (Criteria) this;
        }

        public Criteria andArtFromIsNull() {
            addCriterion("art_from is null");
            return (Criteria) this;
        }

        public Criteria andArtFromIsNotNull() {
            addCriterion("art_from is not null");
            return (Criteria) this;
        }

        public Criteria andArtFromEqualTo(String value) {
            addCriterion("art_from =", value, "artFrom");
            return (Criteria) this;
        }

        public Criteria andArtFromNotEqualTo(String value) {
            addCriterion("art_from <>", value, "artFrom");
            return (Criteria) this;
        }

        public Criteria andArtFromGreaterThan(String value) {
            addCriterion("art_from >", value, "artFrom");
            return (Criteria) this;
        }

        public Criteria andArtFromGreaterThanOrEqualTo(String value) {
            addCriterion("art_from >=", value, "artFrom");
            return (Criteria) this;
        }

        public Criteria andArtFromLessThan(String value) {
            addCriterion("art_from <", value, "artFrom");
            return (Criteria) this;
        }

        public Criteria andArtFromLessThanOrEqualTo(String value) {
            addCriterion("art_from <=", value, "artFrom");
            return (Criteria) this;
        }

        public Criteria andArtFromLike(String value) {
            addCriterion("art_from like", value, "artFrom");
            return (Criteria) this;
        }

        public Criteria andArtFromNotLike(String value) {
            addCriterion("art_from not like", value, "artFrom");
            return (Criteria) this;
        }

        public Criteria andArtFromIn(List<String> values) {
            addCriterion("art_from in", values, "artFrom");
            return (Criteria) this;
        }

        public Criteria andArtFromNotIn(List<String> values) {
            addCriterion("art_from not in", values, "artFrom");
            return (Criteria) this;
        }

        public Criteria andArtFromBetween(String value1, String value2) {
            addCriterion("art_from between", value1, value2, "artFrom");
            return (Criteria) this;
        }

        public Criteria andArtFromNotBetween(String value1, String value2) {
            addCriterion("art_from not between", value1, value2, "artFrom");
            return (Criteria) this;
        }

        public Criteria andArtAuthorIsNull() {
            addCriterion("art_author is null");
            return (Criteria) this;
        }

        public Criteria andArtAuthorIsNotNull() {
            addCriterion("art_author is not null");
            return (Criteria) this;
        }

        public Criteria andArtAuthorEqualTo(String value) {
            addCriterion("art_author =", value, "artAuthor");
            return (Criteria) this;
        }

        public Criteria andArtAuthorNotEqualTo(String value) {
            addCriterion("art_author <>", value, "artAuthor");
            return (Criteria) this;
        }

        public Criteria andArtAuthorGreaterThan(String value) {
            addCriterion("art_author >", value, "artAuthor");
            return (Criteria) this;
        }

        public Criteria andArtAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("art_author >=", value, "artAuthor");
            return (Criteria) this;
        }

        public Criteria andArtAuthorLessThan(String value) {
            addCriterion("art_author <", value, "artAuthor");
            return (Criteria) this;
        }

        public Criteria andArtAuthorLessThanOrEqualTo(String value) {
            addCriterion("art_author <=", value, "artAuthor");
            return (Criteria) this;
        }

        public Criteria andArtAuthorLike(String value) {
            addCriterion("art_author like", value, "artAuthor");
            return (Criteria) this;
        }

        public Criteria andArtAuthorNotLike(String value) {
            addCriterion("art_author not like", value, "artAuthor");
            return (Criteria) this;
        }

        public Criteria andArtAuthorIn(List<String> values) {
            addCriterion("art_author in", values, "artAuthor");
            return (Criteria) this;
        }

        public Criteria andArtAuthorNotIn(List<String> values) {
            addCriterion("art_author not in", values, "artAuthor");
            return (Criteria) this;
        }

        public Criteria andArtAuthorBetween(String value1, String value2) {
            addCriterion("art_author between", value1, value2, "artAuthor");
            return (Criteria) this;
        }

        public Criteria andArtAuthorNotBetween(String value1, String value2) {
            addCriterion("art_author not between", value1, value2, "artAuthor");
            return (Criteria) this;
        }

        public Criteria andWebIdIsNull() {
            addCriterion("web_id is null");
            return (Criteria) this;
        }

        public Criteria andWebIdIsNotNull() {
            addCriterion("web_id is not null");
            return (Criteria) this;
        }

        public Criteria andWebIdEqualTo(Integer value) {
            addCriterion("web_id =", value, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdNotEqualTo(Integer value) {
            addCriterion("web_id <>", value, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdGreaterThan(Integer value) {
            addCriterion("web_id >", value, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("web_id >=", value, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdLessThan(Integer value) {
            addCriterion("web_id <", value, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdLessThanOrEqualTo(Integer value) {
            addCriterion("web_id <=", value, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdIn(List<Integer> values) {
            addCriterion("web_id in", values, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdNotIn(List<Integer> values) {
            addCriterion("web_id not in", values, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdBetween(Integer value1, Integer value2) {
            addCriterion("web_id between", value1, value2, "webId");
            return (Criteria) this;
        }

        public Criteria andWebIdNotBetween(Integer value1, Integer value2) {
            addCriterion("web_id not between", value1, value2, "webId");
            return (Criteria) this;
        }

        public Criteria andCateIdIsNull() {
            addCriterion("cate_id is null");
            return (Criteria) this;
        }

        public Criteria andCateIdIsNotNull() {
            addCriterion("cate_id is not null");
            return (Criteria) this;
        }

        public Criteria andCateIdEqualTo(Integer value) {
            addCriterion("cate_id =", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdNotEqualTo(Integer value) {
            addCriterion("cate_id <>", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdGreaterThan(Integer value) {
            addCriterion("cate_id >", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cate_id >=", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdLessThan(Integer value) {
            addCriterion("cate_id <", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdLessThanOrEqualTo(Integer value) {
            addCriterion("cate_id <=", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdIn(List<Integer> values) {
            addCriterion("cate_id in", values, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdNotIn(List<Integer> values) {
            addCriterion("cate_id not in", values, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdBetween(Integer value1, Integer value2) {
            addCriterion("cate_id between", value1, value2, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cate_id not between", value1, value2, "cateId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateUsernameIsNull() {
            addCriterion("create_username is null");
            return (Criteria) this;
        }

        public Criteria andCreateUsernameIsNotNull() {
            addCriterion("create_username is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUsernameEqualTo(String value) {
            addCriterion("create_username =", value, "createUsername");
            return (Criteria) this;
        }

        public Criteria andCreateUsernameNotEqualTo(String value) {
            addCriterion("create_username <>", value, "createUsername");
            return (Criteria) this;
        }

        public Criteria andCreateUsernameGreaterThan(String value) {
            addCriterion("create_username >", value, "createUsername");
            return (Criteria) this;
        }

        public Criteria andCreateUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("create_username >=", value, "createUsername");
            return (Criteria) this;
        }

        public Criteria andCreateUsernameLessThan(String value) {
            addCriterion("create_username <", value, "createUsername");
            return (Criteria) this;
        }

        public Criteria andCreateUsernameLessThanOrEqualTo(String value) {
            addCriterion("create_username <=", value, "createUsername");
            return (Criteria) this;
        }

        public Criteria andCreateUsernameLike(String value) {
            addCriterion("create_username like", value, "createUsername");
            return (Criteria) this;
        }

        public Criteria andCreateUsernameNotLike(String value) {
            addCriterion("create_username not like", value, "createUsername");
            return (Criteria) this;
        }

        public Criteria andCreateUsernameIn(List<String> values) {
            addCriterion("create_username in", values, "createUsername");
            return (Criteria) this;
        }

        public Criteria andCreateUsernameNotIn(List<String> values) {
            addCriterion("create_username not in", values, "createUsername");
            return (Criteria) this;
        }

        public Criteria andCreateUsernameBetween(String value1, String value2) {
            addCriterion("create_username between", value1, value2, "createUsername");
            return (Criteria) this;
        }

        public Criteria andCreateUsernameNotBetween(String value1, String value2) {
            addCriterion("create_username not between", value1, value2, "createUsername");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(Integer value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(Integer value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(Integer value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(Integer value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<Integer> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<Integer> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNull() {
            addCriterion("publish_time is null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNotNull() {
            addCriterion("publish_time is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeEqualTo(Date value) {
            addCriterion("publish_time =", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotEqualTo(Date value) {
            addCriterion("publish_time <>", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThan(Date value) {
            addCriterion("publish_time >", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("publish_time >=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThan(Date value) {
            addCriterion("publish_time <", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThanOrEqualTo(Date value) {
            addCriterion("publish_time <=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIn(List<Date> values) {
            addCriterion("publish_time in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotIn(List<Date> values) {
            addCriterion("publish_time not in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeBetween(Date value1, Date value2) {
            addCriterion("publish_time between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotBetween(Date value1, Date value2) {
            addCriterion("publish_time not between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishUsernameIsNull() {
            addCriterion("publish_username is null");
            return (Criteria) this;
        }

        public Criteria andPublishUsernameIsNotNull() {
            addCriterion("publish_username is not null");
            return (Criteria) this;
        }

        public Criteria andPublishUsernameEqualTo(String value) {
            addCriterion("publish_username =", value, "publishUsername");
            return (Criteria) this;
        }

        public Criteria andPublishUsernameNotEqualTo(String value) {
            addCriterion("publish_username <>", value, "publishUsername");
            return (Criteria) this;
        }

        public Criteria andPublishUsernameGreaterThan(String value) {
            addCriterion("publish_username >", value, "publishUsername");
            return (Criteria) this;
        }

        public Criteria andPublishUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("publish_username >=", value, "publishUsername");
            return (Criteria) this;
        }

        public Criteria andPublishUsernameLessThan(String value) {
            addCriterion("publish_username <", value, "publishUsername");
            return (Criteria) this;
        }

        public Criteria andPublishUsernameLessThanOrEqualTo(String value) {
            addCriterion("publish_username <=", value, "publishUsername");
            return (Criteria) this;
        }

        public Criteria andPublishUsernameLike(String value) {
            addCriterion("publish_username like", value, "publishUsername");
            return (Criteria) this;
        }

        public Criteria andPublishUsernameNotLike(String value) {
            addCriterion("publish_username not like", value, "publishUsername");
            return (Criteria) this;
        }

        public Criteria andPublishUsernameIn(List<String> values) {
            addCriterion("publish_username in", values, "publishUsername");
            return (Criteria) this;
        }

        public Criteria andPublishUsernameNotIn(List<String> values) {
            addCriterion("publish_username not in", values, "publishUsername");
            return (Criteria) this;
        }

        public Criteria andPublishUsernameBetween(String value1, String value2) {
            addCriterion("publish_username between", value1, value2, "publishUsername");
            return (Criteria) this;
        }

        public Criteria andPublishUsernameNotBetween(String value1, String value2) {
            addCriterion("publish_username not between", value1, value2, "publishUsername");
            return (Criteria) this;
        }

        public Criteria andPublishUserIdIsNull() {
            addCriterion("publish_user_id is null");
            return (Criteria) this;
        }

        public Criteria andPublishUserIdIsNotNull() {
            addCriterion("publish_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andPublishUserIdEqualTo(String value) {
            addCriterion("publish_user_id =", value, "publishUserId");
            return (Criteria) this;
        }

        public Criteria andPublishUserIdNotEqualTo(String value) {
            addCriterion("publish_user_id <>", value, "publishUserId");
            return (Criteria) this;
        }

        public Criteria andPublishUserIdGreaterThan(String value) {
            addCriterion("publish_user_id >", value, "publishUserId");
            return (Criteria) this;
        }

        public Criteria andPublishUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("publish_user_id >=", value, "publishUserId");
            return (Criteria) this;
        }

        public Criteria andPublishUserIdLessThan(String value) {
            addCriterion("publish_user_id <", value, "publishUserId");
            return (Criteria) this;
        }

        public Criteria andPublishUserIdLessThanOrEqualTo(String value) {
            addCriterion("publish_user_id <=", value, "publishUserId");
            return (Criteria) this;
        }

        public Criteria andPublishUserIdLike(String value) {
            addCriterion("publish_user_id like", value, "publishUserId");
            return (Criteria) this;
        }

        public Criteria andPublishUserIdNotLike(String value) {
            addCriterion("publish_user_id not like", value, "publishUserId");
            return (Criteria) this;
        }

        public Criteria andPublishUserIdIn(List<String> values) {
            addCriterion("publish_user_id in", values, "publishUserId");
            return (Criteria) this;
        }

        public Criteria andPublishUserIdNotIn(List<String> values) {
            addCriterion("publish_user_id not in", values, "publishUserId");
            return (Criteria) this;
        }

        public Criteria andPublishUserIdBetween(String value1, String value2) {
            addCriterion("publish_user_id between", value1, value2, "publishUserId");
            return (Criteria) this;
        }

        public Criteria andPublishUserIdNotBetween(String value1, String value2) {
            addCriterion("publish_user_id not between", value1, value2, "publishUserId");
            return (Criteria) this;
        }

        public Criteria andArtTopIsNull() {
            addCriterion("art_top is null");
            return (Criteria) this;
        }

        public Criteria andArtTopIsNotNull() {
            addCriterion("art_top is not null");
            return (Criteria) this;
        }

        public Criteria andArtTopEqualTo(Integer value) {
            addCriterion("art_top =", value, "artTop");
            return (Criteria) this;
        }

        public Criteria andArtTopNotEqualTo(Integer value) {
            addCriterion("art_top <>", value, "artTop");
            return (Criteria) this;
        }

        public Criteria andArtTopGreaterThan(Integer value) {
            addCriterion("art_top >", value, "artTop");
            return (Criteria) this;
        }

        public Criteria andArtTopGreaterThanOrEqualTo(Integer value) {
            addCriterion("art_top >=", value, "artTop");
            return (Criteria) this;
        }

        public Criteria andArtTopLessThan(Integer value) {
            addCriterion("art_top <", value, "artTop");
            return (Criteria) this;
        }

        public Criteria andArtTopLessThanOrEqualTo(Integer value) {
            addCriterion("art_top <=", value, "artTop");
            return (Criteria) this;
        }

        public Criteria andArtTopIn(List<Integer> values) {
            addCriterion("art_top in", values, "artTop");
            return (Criteria) this;
        }

        public Criteria andArtTopNotIn(List<Integer> values) {
            addCriterion("art_top not in", values, "artTop");
            return (Criteria) this;
        }

        public Criteria andArtTopBetween(Integer value1, Integer value2) {
            addCriterion("art_top between", value1, value2, "artTop");
            return (Criteria) this;
        }

        public Criteria andArtTopNotBetween(Integer value1, Integer value2) {
            addCriterion("art_top not between", value1, value2, "artTop");
            return (Criteria) this;
        }

        public Criteria andArtStateIsNull() {
            addCriterion("art_state is null");
            return (Criteria) this;
        }

        public Criteria andArtStateIsNotNull() {
            addCriterion("art_state is not null");
            return (Criteria) this;
        }

        public Criteria andArtStateEqualTo(Integer value) {
            addCriterion("art_state =", value, "artState");
            return (Criteria) this;
        }

        public Criteria andArtStateNotEqualTo(Integer value) {
            addCriterion("art_state <>", value, "artState");
            return (Criteria) this;
        }

        public Criteria andArtStateGreaterThan(Integer value) {
            addCriterion("art_state >", value, "artState");
            return (Criteria) this;
        }

        public Criteria andArtStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("art_state >=", value, "artState");
            return (Criteria) this;
        }

        public Criteria andArtStateLessThan(Integer value) {
            addCriterion("art_state <", value, "artState");
            return (Criteria) this;
        }

        public Criteria andArtStateLessThanOrEqualTo(Integer value) {
            addCriterion("art_state <=", value, "artState");
            return (Criteria) this;
        }

        public Criteria andArtStateIn(List<Integer> values) {
            addCriterion("art_state in", values, "artState");
            return (Criteria) this;
        }

        public Criteria andArtStateNotIn(List<Integer> values) {
            addCriterion("art_state not in", values, "artState");
            return (Criteria) this;
        }

        public Criteria andArtStateBetween(Integer value1, Integer value2) {
            addCriterion("art_state between", value1, value2, "artState");
            return (Criteria) this;
        }

        public Criteria andArtStateNotBetween(Integer value1, Integer value2) {
            addCriterion("art_state not between", value1, value2, "artState");
            return (Criteria) this;
        }

        public Criteria andShowStartTimeIsNull() {
            addCriterion("show_start_time is null");
            return (Criteria) this;
        }

        public Criteria andShowStartTimeIsNotNull() {
            addCriterion("show_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andShowStartTimeEqualTo(Date value) {
            addCriterion("show_start_time =", value, "showStartTime");
            return (Criteria) this;
        }

        public Criteria andShowStartTimeNotEqualTo(Date value) {
            addCriterion("show_start_time <>", value, "showStartTime");
            return (Criteria) this;
        }

        public Criteria andShowStartTimeGreaterThan(Date value) {
            addCriterion("show_start_time >", value, "showStartTime");
            return (Criteria) this;
        }

        public Criteria andShowStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("show_start_time >=", value, "showStartTime");
            return (Criteria) this;
        }

        public Criteria andShowStartTimeLessThan(Date value) {
            addCriterion("show_start_time <", value, "showStartTime");
            return (Criteria) this;
        }

        public Criteria andShowStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("show_start_time <=", value, "showStartTime");
            return (Criteria) this;
        }

        public Criteria andShowStartTimeIn(List<Date> values) {
            addCriterion("show_start_time in", values, "showStartTime");
            return (Criteria) this;
        }

        public Criteria andShowStartTimeNotIn(List<Date> values) {
            addCriterion("show_start_time not in", values, "showStartTime");
            return (Criteria) this;
        }

        public Criteria andShowStartTimeBetween(Date value1, Date value2) {
            addCriterion("show_start_time between", value1, value2, "showStartTime");
            return (Criteria) this;
        }

        public Criteria andShowStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("show_start_time not between", value1, value2, "showStartTime");
            return (Criteria) this;
        }

        public Criteria andShowEndTimeIsNull() {
            addCriterion("show_end_time is null");
            return (Criteria) this;
        }

        public Criteria andShowEndTimeIsNotNull() {
            addCriterion("show_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andShowEndTimeEqualTo(Date value) {
            addCriterion("show_end_time =", value, "showEndTime");
            return (Criteria) this;
        }

        public Criteria andShowEndTimeNotEqualTo(Date value) {
            addCriterion("show_end_time <>", value, "showEndTime");
            return (Criteria) this;
        }

        public Criteria andShowEndTimeGreaterThan(Date value) {
            addCriterion("show_end_time >", value, "showEndTime");
            return (Criteria) this;
        }

        public Criteria andShowEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("show_end_time >=", value, "showEndTime");
            return (Criteria) this;
        }

        public Criteria andShowEndTimeLessThan(Date value) {
            addCriterion("show_end_time <", value, "showEndTime");
            return (Criteria) this;
        }

        public Criteria andShowEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("show_end_time <=", value, "showEndTime");
            return (Criteria) this;
        }

        public Criteria andShowEndTimeIn(List<Date> values) {
            addCriterion("show_end_time in", values, "showEndTime");
            return (Criteria) this;
        }

        public Criteria andShowEndTimeNotIn(List<Date> values) {
            addCriterion("show_end_time not in", values, "showEndTime");
            return (Criteria) this;
        }

        public Criteria andShowEndTimeBetween(Date value1, Date value2) {
            addCriterion("show_end_time between", value1, value2, "showEndTime");
            return (Criteria) this;
        }

        public Criteria andShowEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("show_end_time not between", value1, value2, "showEndTime");
            return (Criteria) this;
        }

        public Criteria andOpenCommenIsNull() {
            addCriterion("open_commen is null");
            return (Criteria) this;
        }

        public Criteria andOpenCommenIsNotNull() {
            addCriterion("open_commen is not null");
            return (Criteria) this;
        }

        public Criteria andOpenCommenEqualTo(Integer value) {
            addCriterion("open_commen =", value, "openCommen");
            return (Criteria) this;
        }

        public Criteria andOpenCommenNotEqualTo(Integer value) {
            addCriterion("open_commen <>", value, "openCommen");
            return (Criteria) this;
        }

        public Criteria andOpenCommenGreaterThan(Integer value) {
            addCriterion("open_commen >", value, "openCommen");
            return (Criteria) this;
        }

        public Criteria andOpenCommenGreaterThanOrEqualTo(Integer value) {
            addCriterion("open_commen >=", value, "openCommen");
            return (Criteria) this;
        }

        public Criteria andOpenCommenLessThan(Integer value) {
            addCriterion("open_commen <", value, "openCommen");
            return (Criteria) this;
        }

        public Criteria andOpenCommenLessThanOrEqualTo(Integer value) {
            addCriterion("open_commen <=", value, "openCommen");
            return (Criteria) this;
        }

        public Criteria andOpenCommenIn(List<Integer> values) {
            addCriterion("open_commen in", values, "openCommen");
            return (Criteria) this;
        }

        public Criteria andOpenCommenNotIn(List<Integer> values) {
            addCriterion("open_commen not in", values, "openCommen");
            return (Criteria) this;
        }

        public Criteria andOpenCommenBetween(Integer value1, Integer value2) {
            addCriterion("open_commen between", value1, value2, "openCommen");
            return (Criteria) this;
        }

        public Criteria andOpenCommenNotBetween(Integer value1, Integer value2) {
            addCriterion("open_commen not between", value1, value2, "openCommen");
            return (Criteria) this;
        }

        public Criteria andColuIdIsNull() {
            addCriterion("colu_id is null");
            return (Criteria) this;
        }

        public Criteria andColuIdIsNotNull() {
            addCriterion("colu_id is not null");
            return (Criteria) this;
        }

        public Criteria andColuIdEqualTo(Integer value) {
            addCriterion("colu_id =", value, "coluId");
            return (Criteria) this;
        }

        public Criteria andColuIdNotEqualTo(Integer value) {
            addCriterion("colu_id <>", value, "coluId");
            return (Criteria) this;
        }

        public Criteria andColuIdGreaterThan(Integer value) {
            addCriterion("colu_id >", value, "coluId");
            return (Criteria) this;
        }

        public Criteria andColuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("colu_id >=", value, "coluId");
            return (Criteria) this;
        }

        public Criteria andColuIdLessThan(Integer value) {
            addCriterion("colu_id <", value, "coluId");
            return (Criteria) this;
        }

        public Criteria andColuIdLessThanOrEqualTo(Integer value) {
            addCriterion("colu_id <=", value, "coluId");
            return (Criteria) this;
        }

        public Criteria andColuIdIn(List<Integer> values) {
            addCriterion("colu_id in", values, "coluId");
            return (Criteria) this;
        }

        public Criteria andColuIdNotIn(List<Integer> values) {
            addCriterion("colu_id not in", values, "coluId");
            return (Criteria) this;
        }

        public Criteria andColuIdBetween(Integer value1, Integer value2) {
            addCriterion("colu_id between", value1, value2, "coluId");
            return (Criteria) this;
        }

        public Criteria andColuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("colu_id not between", value1, value2, "coluId");
            return (Criteria) this;
        }

        public Criteria andColuNameIsNull() {
            addCriterion("colu_name is null");
            return (Criteria) this;
        }

        public Criteria andColuNameIsNotNull() {
            addCriterion("colu_name is not null");
            return (Criteria) this;
        }

        public Criteria andColuNameEqualTo(String value) {
            addCriterion("colu_name =", value, "coluName");
            return (Criteria) this;
        }

        public Criteria andColuNameNotEqualTo(String value) {
            addCriterion("colu_name <>", value, "coluName");
            return (Criteria) this;
        }

        public Criteria andColuNameGreaterThan(String value) {
            addCriterion("colu_name >", value, "coluName");
            return (Criteria) this;
        }

        public Criteria andColuNameGreaterThanOrEqualTo(String value) {
            addCriterion("colu_name >=", value, "coluName");
            return (Criteria) this;
        }

        public Criteria andColuNameLessThan(String value) {
            addCriterion("colu_name <", value, "coluName");
            return (Criteria) this;
        }

        public Criteria andColuNameLessThanOrEqualTo(String value) {
            addCriterion("colu_name <=", value, "coluName");
            return (Criteria) this;
        }

        public Criteria andColuNameLike(String value) {
            addCriterion("colu_name like", value, "coluName");
            return (Criteria) this;
        }

        public Criteria andColuNameNotLike(String value) {
            addCriterion("colu_name not like", value, "coluName");
            return (Criteria) this;
        }

        public Criteria andColuNameIn(List<String> values) {
            addCriterion("colu_name in", values, "coluName");
            return (Criteria) this;
        }

        public Criteria andColuNameNotIn(List<String> values) {
            addCriterion("colu_name not in", values, "coluName");
            return (Criteria) this;
        }

        public Criteria andColuNameBetween(String value1, String value2) {
            addCriterion("colu_name between", value1, value2, "coluName");
            return (Criteria) this;
        }

        public Criteria andColuNameNotBetween(String value1, String value2) {
            addCriterion("colu_name not between", value1, value2, "coluName");
            return (Criteria) this;
        }

        public Criteria andCreateGroupIdIsNull() {
            addCriterion("create_group_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateGroupIdIsNotNull() {
            addCriterion("create_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateGroupIdEqualTo(Integer value) {
            addCriterion("create_group_id =", value, "createGroupId");
            return (Criteria) this;
        }

        public Criteria andCreateGroupIdNotEqualTo(Integer value) {
            addCriterion("create_group_id <>", value, "createGroupId");
            return (Criteria) this;
        }

        public Criteria andCreateGroupIdGreaterThan(Integer value) {
            addCriterion("create_group_id >", value, "createGroupId");
            return (Criteria) this;
        }

        public Criteria andCreateGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_group_id >=", value, "createGroupId");
            return (Criteria) this;
        }

        public Criteria andCreateGroupIdLessThan(Integer value) {
            addCriterion("create_group_id <", value, "createGroupId");
            return (Criteria) this;
        }

        public Criteria andCreateGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("create_group_id <=", value, "createGroupId");
            return (Criteria) this;
        }

        public Criteria andCreateGroupIdIn(List<Integer> values) {
            addCriterion("create_group_id in", values, "createGroupId");
            return (Criteria) this;
        }

        public Criteria andCreateGroupIdNotIn(List<Integer> values) {
            addCriterion("create_group_id not in", values, "createGroupId");
            return (Criteria) this;
        }

        public Criteria andCreateGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("create_group_id between", value1, value2, "createGroupId");
            return (Criteria) this;
        }

        public Criteria andCreateGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("create_group_id not between", value1, value2, "createGroupId");
            return (Criteria) this;
        }

        public Criteria andCreateGroupNameIsNull() {
            addCriterion("create_group_name is null");
            return (Criteria) this;
        }

        public Criteria andCreateGroupNameIsNotNull() {
            addCriterion("create_group_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreateGroupNameEqualTo(String value) {
            addCriterion("create_group_name =", value, "createGroupName");
            return (Criteria) this;
        }

        public Criteria andCreateGroupNameNotEqualTo(String value) {
            addCriterion("create_group_name <>", value, "createGroupName");
            return (Criteria) this;
        }

        public Criteria andCreateGroupNameGreaterThan(String value) {
            addCriterion("create_group_name >", value, "createGroupName");
            return (Criteria) this;
        }

        public Criteria andCreateGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("create_group_name >=", value, "createGroupName");
            return (Criteria) this;
        }

        public Criteria andCreateGroupNameLessThan(String value) {
            addCriterion("create_group_name <", value, "createGroupName");
            return (Criteria) this;
        }

        public Criteria andCreateGroupNameLessThanOrEqualTo(String value) {
            addCriterion("create_group_name <=", value, "createGroupName");
            return (Criteria) this;
        }

        public Criteria andCreateGroupNameLike(String value) {
            addCriterion("create_group_name like", value, "createGroupName");
            return (Criteria) this;
        }

        public Criteria andCreateGroupNameNotLike(String value) {
            addCriterion("create_group_name not like", value, "createGroupName");
            return (Criteria) this;
        }

        public Criteria andCreateGroupNameIn(List<String> values) {
            addCriterion("create_group_name in", values, "createGroupName");
            return (Criteria) this;
        }

        public Criteria andCreateGroupNameNotIn(List<String> values) {
            addCriterion("create_group_name not in", values, "createGroupName");
            return (Criteria) this;
        }

        public Criteria andCreateGroupNameBetween(String value1, String value2) {
            addCriterion("create_group_name between", value1, value2, "createGroupName");
            return (Criteria) this;
        }

        public Criteria andCreateGroupNameNotBetween(String value1, String value2) {
            addCriterion("create_group_name not between", value1, value2, "createGroupName");
            return (Criteria) this;
        }


        public Criteria andCreateArtContentLike(String value) {
            addCriterion("art_content like", value, "createGroupName");
            return (Criteria) this;
        }
    }


    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }


    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
