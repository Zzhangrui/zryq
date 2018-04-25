package com.zryq.cms.admin.entity;

import java.util.ArrayList;
import java.util.List;

public class ColumnExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ColumnExample() {
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

        public Criteria andColuDesIsNull() {
            addCriterion("colu_des is null");
            return (Criteria) this;
        }

        public Criteria andColuDesIsNotNull() {
            addCriterion("colu_des is not null");
            return (Criteria) this;
        }

        public Criteria andColuDesEqualTo(String value) {
            addCriterion("colu_des =", value, "coluDes");
            return (Criteria) this;
        }

        public Criteria andColuDesNotEqualTo(String value) {
            addCriterion("colu_des <>", value, "coluDes");
            return (Criteria) this;
        }

        public Criteria andColuDesGreaterThan(String value) {
            addCriterion("colu_des >", value, "coluDes");
            return (Criteria) this;
        }

        public Criteria andColuDesGreaterThanOrEqualTo(String value) {
            addCriterion("colu_des >=", value, "coluDes");
            return (Criteria) this;
        }

        public Criteria andColuDesLessThan(String value) {
            addCriterion("colu_des <", value, "coluDes");
            return (Criteria) this;
        }

        public Criteria andColuDesLessThanOrEqualTo(String value) {
            addCriterion("colu_des <=", value, "coluDes");
            return (Criteria) this;
        }

        public Criteria andColuDesLike(String value) {
            addCriterion("colu_des like", value, "coluDes");
            return (Criteria) this;
        }

        public Criteria andColuDesNotLike(String value) {
            addCriterion("colu_des not like", value, "coluDes");
            return (Criteria) this;
        }

        public Criteria andColuDesIn(List<String> values) {
            addCriterion("colu_des in", values, "coluDes");
            return (Criteria) this;
        }

        public Criteria andColuDesNotIn(List<String> values) {
            addCriterion("colu_des not in", values, "coluDes");
            return (Criteria) this;
        }

        public Criteria andColuDesBetween(String value1, String value2) {
            addCriterion("colu_des between", value1, value2, "coluDes");
            return (Criteria) this;
        }

        public Criteria andColuDesNotBetween(String value1, String value2) {
            addCriterion("colu_des not between", value1, value2, "coluDes");
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

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Integer value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Integer value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Integer value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Integer value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Integer> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Integer> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Integer value1, Integer value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andOpenCommentIsNull() {
            addCriterion("open_comment is null");
            return (Criteria) this;
        }

        public Criteria andOpenCommentIsNotNull() {
            addCriterion("open_comment is not null");
            return (Criteria) this;
        }

        public Criteria andOpenCommentEqualTo(Integer value) {
            addCriterion("open_comment =", value, "openComment");
            return (Criteria) this;
        }

        public Criteria andOpenCommentNotEqualTo(Integer value) {
            addCriterion("open_comment <>", value, "openComment");
            return (Criteria) this;
        }

        public Criteria andOpenCommentGreaterThan(Integer value) {
            addCriterion("open_comment >", value, "openComment");
            return (Criteria) this;
        }

        public Criteria andOpenCommentGreaterThanOrEqualTo(Integer value) {
            addCriterion("open_comment >=", value, "openComment");
            return (Criteria) this;
        }

        public Criteria andOpenCommentLessThan(Integer value) {
            addCriterion("open_comment <", value, "openComment");
            return (Criteria) this;
        }

        public Criteria andOpenCommentLessThanOrEqualTo(Integer value) {
            addCriterion("open_comment <=", value, "openComment");
            return (Criteria) this;
        }

        public Criteria andOpenCommentIn(List<Integer> values) {
            addCriterion("open_comment in", values, "openComment");
            return (Criteria) this;
        }

        public Criteria andOpenCommentNotIn(List<Integer> values) {
            addCriterion("open_comment not in", values, "openComment");
            return (Criteria) this;
        }

        public Criteria andOpenCommentBetween(Integer value1, Integer value2) {
            addCriterion("open_comment between", value1, value2, "openComment");
            return (Criteria) this;
        }

        public Criteria andOpenCommentNotBetween(Integer value1, Integer value2) {
            addCriterion("open_comment not between", value1, value2, "openComment");
            return (Criteria) this;
        }

        public Criteria andPositionIsNull() {
            addCriterion("position is null");
            return (Criteria) this;
        }

        public Criteria andPositionIsNotNull() {
            addCriterion("position is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEqualTo(String value) {
            addCriterion("position =", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotEqualTo(String value) {
            addCriterion("position <>", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThan(String value) {
            addCriterion("position >", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(String value) {
            addCriterion("position >=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThan(String value) {
            addCriterion("position <", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThanOrEqualTo(String value) {
            addCriterion("position <=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLike(String value) {
            addCriterion("position like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotLike(String value) {
            addCriterion("position not like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionIn(List<String> values) {
            addCriterion("position in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotIn(List<String> values) {
            addCriterion("position not in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionBetween(String value1, String value2) {
            addCriterion("position between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotBetween(String value1, String value2) {
            addCriterion("position not between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andColuTypeIsNull() {
            addCriterion("colu_type is null");
            return (Criteria) this;
        }

        public Criteria andColuTypeIsNotNull() {
            addCriterion("colu_type is not null");
            return (Criteria) this;
        }

        public Criteria andColuTypeEqualTo(String value) {
            addCriterion("colu_type =", value, "coluType");
            return (Criteria) this;
        }

        public Criteria andColuTypeNotEqualTo(String value) {
            addCriterion("colu_type <>", value, "coluType");
            return (Criteria) this;
        }

        public Criteria andColuTypeGreaterThan(String value) {
            addCriterion("colu_type >", value, "coluType");
            return (Criteria) this;
        }

        public Criteria andColuTypeGreaterThanOrEqualTo(String value) {
            addCriterion("colu_type >=", value, "coluType");
            return (Criteria) this;
        }

        public Criteria andColuTypeLessThan(String value) {
            addCriterion("colu_type <", value, "coluType");
            return (Criteria) this;
        }

        public Criteria andColuTypeLessThanOrEqualTo(String value) {
            addCriterion("colu_type <=", value, "coluType");
            return (Criteria) this;
        }

        public Criteria andColuTypeLike(String value) {
            addCriterion("colu_type like", value, "coluType");
            return (Criteria) this;
        }

        public Criteria andColuTypeNotLike(String value) {
            addCriterion("colu_type not like", value, "coluType");
            return (Criteria) this;
        }

        public Criteria andColuTypeIn(List<String> values) {
            addCriterion("colu_type in", values, "coluType");
            return (Criteria) this;
        }

        public Criteria andColuTypeNotIn(List<String> values) {
            addCriterion("colu_type not in", values, "coluType");
            return (Criteria) this;
        }

        public Criteria andColuTypeBetween(String value1, String value2) {
            addCriterion("colu_type between", value1, value2, "coluType");
            return (Criteria) this;
        }

        public Criteria andColuTypeNotBetween(String value1, String value2) {
            addCriterion("colu_type not between", value1, value2, "coluType");
            return (Criteria) this;
        }

        public Criteria andColuLevelIsNull() {
            addCriterion("colu_level is null");
            return (Criteria) this;
        }

        public Criteria andColuLevelIsNotNull() {
            addCriterion("colu_level is not null");
            return (Criteria) this;
        }

        public Criteria andColuLevelEqualTo(Integer value) {
            addCriterion("colu_level =", value, "coluLevel");
            return (Criteria) this;
        }

        public Criteria andColuLevelNotEqualTo(Integer value) {
            addCriterion("colu_level <>", value, "coluLevel");
            return (Criteria) this;
        }

        public Criteria andColuLevelGreaterThan(Integer value) {
            addCriterion("colu_level >", value, "coluLevel");
            return (Criteria) this;
        }

        public Criteria andColuLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("colu_level >=", value, "coluLevel");
            return (Criteria) this;
        }

        public Criteria andColuLevelLessThan(Integer value) {
            addCriterion("colu_level <", value, "coluLevel");
            return (Criteria) this;
        }

        public Criteria andColuLevelLessThanOrEqualTo(Integer value) {
            addCriterion("colu_level <=", value, "coluLevel");
            return (Criteria) this;
        }

        public Criteria andColuLevelIn(List<Integer> values) {
            addCriterion("colu_level in", values, "coluLevel");
            return (Criteria) this;
        }

        public Criteria andColuLevelNotIn(List<Integer> values) {
            addCriterion("colu_level not in", values, "coluLevel");
            return (Criteria) this;
        }

        public Criteria andColuLevelBetween(Integer value1, Integer value2) {
            addCriterion("colu_level between", value1, value2, "coluLevel");
            return (Criteria) this;
        }

        public Criteria andColuLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("colu_level not between", value1, value2, "coluLevel");
            return (Criteria) this;
        }

        public Criteria andColuImgPathIsNull() {
            addCriterion("colu_img_path is null");
            return (Criteria) this;
        }

        public Criteria andColuImgPathIsNotNull() {
            addCriterion("colu_img_path is not null");
            return (Criteria) this;
        }

        public Criteria andColuImgPathEqualTo(String value) {
            addCriterion("colu_img_path =", value, "coluImgPath");
            return (Criteria) this;
        }

        public Criteria andColuImgPathNotEqualTo(String value) {
            addCriterion("colu_img_path <>", value, "coluImgPath");
            return (Criteria) this;
        }

        public Criteria andColuImgPathGreaterThan(String value) {
            addCriterion("colu_img_path >", value, "coluImgPath");
            return (Criteria) this;
        }

        public Criteria andColuImgPathGreaterThanOrEqualTo(String value) {
            addCriterion("colu_img_path >=", value, "coluImgPath");
            return (Criteria) this;
        }

        public Criteria andColuImgPathLessThan(String value) {
            addCriterion("colu_img_path <", value, "coluImgPath");
            return (Criteria) this;
        }

        public Criteria andColuImgPathLessThanOrEqualTo(String value) {
            addCriterion("colu_img_path <=", value, "coluImgPath");
            return (Criteria) this;
        }

        public Criteria andColuImgPathLike(String value) {
            addCriterion("colu_img_path like", value, "coluImgPath");
            return (Criteria) this;
        }

        public Criteria andColuImgPathNotLike(String value) {
            addCriterion("colu_img_path not like", value, "coluImgPath");
            return (Criteria) this;
        }

        public Criteria andColuImgPathIn(List<String> values) {
            addCriterion("colu_img_path in", values, "coluImgPath");
            return (Criteria) this;
        }

        public Criteria andColuImgPathNotIn(List<String> values) {
            addCriterion("colu_img_path not in", values, "coluImgPath");
            return (Criteria) this;
        }

        public Criteria andColuImgPathBetween(String value1, String value2) {
            addCriterion("colu_img_path between", value1, value2, "coluImgPath");
            return (Criteria) this;
        }

        public Criteria andColuImgPathNotBetween(String value1, String value2) {
            addCriterion("colu_img_path not between", value1, value2, "coluImgPath");
            return (Criteria) this;
        }

        public Criteria andColuImgNameIsNull() {
            addCriterion("colu_img_name is null");
            return (Criteria) this;
        }

        public Criteria andColuImgNameIsNotNull() {
            addCriterion("colu_img_name is not null");
            return (Criteria) this;
        }

        public Criteria andColuImgNameEqualTo(String value) {
            addCriterion("colu_img_name =", value, "coluImgName");
            return (Criteria) this;
        }

        public Criteria andColuImgNameNotEqualTo(String value) {
            addCriterion("colu_img_name <>", value, "coluImgName");
            return (Criteria) this;
        }

        public Criteria andColuImgNameGreaterThan(String value) {
            addCriterion("colu_img_name >", value, "coluImgName");
            return (Criteria) this;
        }

        public Criteria andColuImgNameGreaterThanOrEqualTo(String value) {
            addCriterion("colu_img_name >=", value, "coluImgName");
            return (Criteria) this;
        }

        public Criteria andColuImgNameLessThan(String value) {
            addCriterion("colu_img_name <", value, "coluImgName");
            return (Criteria) this;
        }

        public Criteria andColuImgNameLessThanOrEqualTo(String value) {
            addCriterion("colu_img_name <=", value, "coluImgName");
            return (Criteria) this;
        }

        public Criteria andColuImgNameLike(String value) {
            addCriterion("colu_img_name like", value, "coluImgName");
            return (Criteria) this;
        }

        public Criteria andColuImgNameNotLike(String value) {
            addCriterion("colu_img_name not like", value, "coluImgName");
            return (Criteria) this;
        }

        public Criteria andColuImgNameIn(List<String> values) {
            addCriterion("colu_img_name in", values, "coluImgName");
            return (Criteria) this;
        }

        public Criteria andColuImgNameNotIn(List<String> values) {
            addCriterion("colu_img_name not in", values, "coluImgName");
            return (Criteria) this;
        }

        public Criteria andColuImgNameBetween(String value1, String value2) {
            addCriterion("colu_img_name between", value1, value2, "coluImgName");
            return (Criteria) this;
        }

        public Criteria andColuImgNameNotBetween(String value1, String value2) {
            addCriterion("colu_img_name not between", value1, value2, "coluImgName");
            return (Criteria) this;
        }

        public Criteria andColuDefaultIsNull() {
            addCriterion("colu_default is null");
            return (Criteria) this;
        }

        public Criteria andColuDefaultIsNotNull() {
            addCriterion("colu_default is not null");
            return (Criteria) this;
        }

        public Criteria andColuDefaultEqualTo(Integer value) {
            addCriterion("colu_default =", value, "coluDefault");
            return (Criteria) this;
        }

        public Criteria andColuDefaultNotEqualTo(Integer value) {
            addCriterion("colu_default <>", value, "coluDefault");
            return (Criteria) this;
        }

        public Criteria andColuDefaultGreaterThan(Integer value) {
            addCriterion("colu_default >", value, "coluDefault");
            return (Criteria) this;
        }

        public Criteria andColuDefaultGreaterThanOrEqualTo(Integer value) {
            addCriterion("colu_default >=", value, "coluDefault");
            return (Criteria) this;
        }

        public Criteria andColuDefaultLessThan(Integer value) {
            addCriterion("colu_default <", value, "coluDefault");
            return (Criteria) this;
        }

        public Criteria andColuDefaultLessThanOrEqualTo(Integer value) {
            addCriterion("colu_default <=", value, "coluDefault");
            return (Criteria) this;
        }

        public Criteria andColuDefaultIn(List<Integer> values) {
            addCriterion("colu_default in", values, "coluDefault");
            return (Criteria) this;
        }

        public Criteria andColuDefaultNotIn(List<Integer> values) {
            addCriterion("colu_default not in", values, "coluDefault");
            return (Criteria) this;
        }

        public Criteria andColuDefaultBetween(Integer value1, Integer value2) {
            addCriterion("colu_default between", value1, value2, "coluDefault");
            return (Criteria) this;
        }

        public Criteria andColuDefaultNotBetween(Integer value1, Integer value2) {
            addCriterion("colu_default not between", value1, value2, "coluDefault");
            return (Criteria) this;
        }

        public Criteria andShareInIsNull() {
            addCriterion("share_in is null");
            return (Criteria) this;
        }

        public Criteria andShareInIsNotNull() {
            addCriterion("share_in is not null");
            return (Criteria) this;
        }

        public Criteria andShareInEqualTo(Integer value) {
            addCriterion("share_in =", value, "shareIn");
            return (Criteria) this;
        }

        public Criteria andShareInNotEqualTo(Integer value) {
            addCriterion("share_in <>", value, "shareIn");
            return (Criteria) this;
        }

        public Criteria andShareInGreaterThan(Integer value) {
            addCriterion("share_in >", value, "shareIn");
            return (Criteria) this;
        }

        public Criteria andShareInGreaterThanOrEqualTo(Integer value) {
            addCriterion("share_in >=", value, "shareIn");
            return (Criteria) this;
        }

        public Criteria andShareInLessThan(Integer value) {
            addCriterion("share_in <", value, "shareIn");
            return (Criteria) this;
        }

        public Criteria andShareInLessThanOrEqualTo(Integer value) {
            addCriterion("share_in <=", value, "shareIn");
            return (Criteria) this;
        }

        public Criteria andShareInIn(List<Integer> values) {
            addCriterion("share_in in", values, "shareIn");
            return (Criteria) this;
        }

        public Criteria andShareInNotIn(List<Integer> values) {
            addCriterion("share_in not in", values, "shareIn");
            return (Criteria) this;
        }

        public Criteria andShareInBetween(Integer value1, Integer value2) {
            addCriterion("share_in between", value1, value2, "shareIn");
            return (Criteria) this;
        }

        public Criteria andShareInNotBetween(Integer value1, Integer value2) {
            addCriterion("share_in not between", value1, value2, "shareIn");
            return (Criteria) this;
        }

        public Criteria andShareOutIsNull() {
            addCriterion("share_out is null");
            return (Criteria) this;
        }

        public Criteria andShareOutIsNotNull() {
            addCriterion("share_out is not null");
            return (Criteria) this;
        }

        public Criteria andShareOutEqualTo(Integer value) {
            addCriterion("share_out =", value, "shareOut");
            return (Criteria) this;
        }

        public Criteria andShareOutNotEqualTo(Integer value) {
            addCriterion("share_out <>", value, "shareOut");
            return (Criteria) this;
        }

        public Criteria andShareOutGreaterThan(Integer value) {
            addCriterion("share_out >", value, "shareOut");
            return (Criteria) this;
        }

        public Criteria andShareOutGreaterThanOrEqualTo(Integer value) {
            addCriterion("share_out >=", value, "shareOut");
            return (Criteria) this;
        }

        public Criteria andShareOutLessThan(Integer value) {
            addCriterion("share_out <", value, "shareOut");
            return (Criteria) this;
        }

        public Criteria andShareOutLessThanOrEqualTo(Integer value) {
            addCriterion("share_out <=", value, "shareOut");
            return (Criteria) this;
        }

        public Criteria andShareOutIn(List<Integer> values) {
            addCriterion("share_out in", values, "shareOut");
            return (Criteria) this;
        }

        public Criteria andShareOutNotIn(List<Integer> values) {
            addCriterion("share_out not in", values, "shareOut");
            return (Criteria) this;
        }

        public Criteria andShareOutBetween(Integer value1, Integer value2) {
            addCriterion("share_out between", value1, value2, "shareOut");
            return (Criteria) this;
        }

        public Criteria andShareOutNotBetween(Integer value1, Integer value2) {
            addCriterion("share_out not between", value1, value2, "shareOut");
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
