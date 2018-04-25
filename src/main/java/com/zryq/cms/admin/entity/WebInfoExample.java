package com.zryq.cms.admin.entity;

import java.util.ArrayList;
import java.util.List;

public class WebInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WebInfoExample() {
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

        public Criteria andWebNameIsNull() {
            addCriterion("web_name is null");
            return (Criteria) this;
        }

        public Criteria andWebNameIsNotNull() {
            addCriterion("web_name is not null");
            return (Criteria) this;
        }

        public Criteria andWebNameEqualTo(String value) {
            addCriterion("web_name =", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameNotEqualTo(String value) {
            addCriterion("web_name <>", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameGreaterThan(String value) {
            addCriterion("web_name >", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameGreaterThanOrEqualTo(String value) {
            addCriterion("web_name >=", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameLessThan(String value) {
            addCriterion("web_name <", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameLessThanOrEqualTo(String value) {
            addCriterion("web_name <=", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameLike(String value) {
            addCriterion("web_name like", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameNotLike(String value) {
            addCriterion("web_name not like", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameIn(List<String> values) {
            addCriterion("web_name in", values, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameNotIn(List<String> values) {
            addCriterion("web_name not in", values, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameBetween(String value1, String value2) {
            addCriterion("web_name between", value1, value2, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameNotBetween(String value1, String value2) {
            addCriterion("web_name not between", value1, value2, "webName");
            return (Criteria) this;
        }

        public Criteria andWebDesIsNull() {
            addCriterion("web_des is null");
            return (Criteria) this;
        }

        public Criteria andWebDesIsNotNull() {
            addCriterion("web_des is not null");
            return (Criteria) this;
        }

        public Criteria andWebDesEqualTo(String value) {
            addCriterion("web_des =", value, "webDes");
            return (Criteria) this;
        }

        public Criteria andWebDesNotEqualTo(String value) {
            addCriterion("web_des <>", value, "webDes");
            return (Criteria) this;
        }

        public Criteria andWebDesGreaterThan(String value) {
            addCriterion("web_des >", value, "webDes");
            return (Criteria) this;
        }

        public Criteria andWebDesGreaterThanOrEqualTo(String value) {
            addCriterion("web_des >=", value, "webDes");
            return (Criteria) this;
        }

        public Criteria andWebDesLessThan(String value) {
            addCriterion("web_des <", value, "webDes");
            return (Criteria) this;
        }

        public Criteria andWebDesLessThanOrEqualTo(String value) {
            addCriterion("web_des <=", value, "webDes");
            return (Criteria) this;
        }

        public Criteria andWebDesLike(String value) {
            addCriterion("web_des like", value, "webDes");
            return (Criteria) this;
        }

        public Criteria andWebDesNotLike(String value) {
            addCriterion("web_des not like", value, "webDes");
            return (Criteria) this;
        }

        public Criteria andWebDesIn(List<String> values) {
            addCriterion("web_des in", values, "webDes");
            return (Criteria) this;
        }

        public Criteria andWebDesNotIn(List<String> values) {
            addCriterion("web_des not in", values, "webDes");
            return (Criteria) this;
        }

        public Criteria andWebDesBetween(String value1, String value2) {
            addCriterion("web_des between", value1, value2, "webDes");
            return (Criteria) this;
        }

        public Criteria andWebDesNotBetween(String value1, String value2) {
            addCriterion("web_des not between", value1, value2, "webDes");
            return (Criteria) this;
        }

        public Criteria andWebStateIsNull() {
            addCriterion("web_state is null");
            return (Criteria) this;
        }

        public Criteria andWebStateIsNotNull() {
            addCriterion("web_state is not null");
            return (Criteria) this;
        }

        public Criteria andWebStateEqualTo(String value) {
            addCriterion("web_state =", value, "webState");
            return (Criteria) this;
        }

        public Criteria andWebStateNotEqualTo(String value) {
            addCriterion("web_state <>", value, "webState");
            return (Criteria) this;
        }

        public Criteria andWebStateGreaterThan(String value) {
            addCriterion("web_state >", value, "webState");
            return (Criteria) this;
        }

        public Criteria andWebStateGreaterThanOrEqualTo(String value) {
            addCriterion("web_state >=", value, "webState");
            return (Criteria) this;
        }

        public Criteria andWebStateLessThan(String value) {
            addCriterion("web_state <", value, "webState");
            return (Criteria) this;
        }

        public Criteria andWebStateLessThanOrEqualTo(String value) {
            addCriterion("web_state <=", value, "webState");
            return (Criteria) this;
        }

        public Criteria andWebStateLike(String value) {
            addCriterion("web_state like", value, "webState");
            return (Criteria) this;
        }

        public Criteria andWebStateNotLike(String value) {
            addCriterion("web_state not like", value, "webState");
            return (Criteria) this;
        }

        public Criteria andWebStateIn(List<String> values) {
            addCriterion("web_state in", values, "webState");
            return (Criteria) this;
        }

        public Criteria andWebStateNotIn(List<String> values) {
            addCriterion("web_state not in", values, "webState");
            return (Criteria) this;
        }

        public Criteria andWebStateBetween(String value1, String value2) {
            addCriterion("web_state between", value1, value2, "webState");
            return (Criteria) this;
        }

        public Criteria andWebStateNotBetween(String value1, String value2) {
            addCriterion("web_state not between", value1, value2, "webState");
            return (Criteria) this;
        }

        public Criteria andTempIdIsNull() {
            addCriterion("temp_id is null");
            return (Criteria) this;
        }

        public Criteria andTempIdIsNotNull() {
            addCriterion("temp_id is not null");
            return (Criteria) this;
        }

        public Criteria andTempIdEqualTo(Integer value) {
            addCriterion("temp_id =", value, "tempId");
            return (Criteria) this;
        }

        public Criteria andTempIdNotEqualTo(Integer value) {
            addCriterion("temp_id <>", value, "tempId");
            return (Criteria) this;
        }

        public Criteria andTempIdGreaterThan(Integer value) {
            addCriterion("temp_id >", value, "tempId");
            return (Criteria) this;
        }

        public Criteria andTempIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("temp_id >=", value, "tempId");
            return (Criteria) this;
        }

        public Criteria andTempIdLessThan(Integer value) {
            addCriterion("temp_id <", value, "tempId");
            return (Criteria) this;
        }

        public Criteria andTempIdLessThanOrEqualTo(Integer value) {
            addCriterion("temp_id <=", value, "tempId");
            return (Criteria) this;
        }

        public Criteria andTempIdIn(List<Integer> values) {
            addCriterion("temp_id in", values, "tempId");
            return (Criteria) this;
        }

        public Criteria andTempIdNotIn(List<Integer> values) {
            addCriterion("temp_id not in", values, "tempId");
            return (Criteria) this;
        }

        public Criteria andTempIdBetween(Integer value1, Integer value2) {
            addCriterion("temp_id between", value1, value2, "tempId");
            return (Criteria) this;
        }

        public Criteria andTempIdNotBetween(Integer value1, Integer value2) {
            addCriterion("temp_id not between", value1, value2, "tempId");
            return (Criteria) this;
        }

        public Criteria andWebAddressIsNull() {
            addCriterion("web_address is null");
            return (Criteria) this;
        }

        public Criteria andWebAddressIsNotNull() {
            addCriterion("web_address is not null");
            return (Criteria) this;
        }

        public Criteria andWebAddressEqualTo(String value) {
            addCriterion("web_address =", value, "webAddress");
            return (Criteria) this;
        }

        public Criteria andWebAddressNotEqualTo(String value) {
            addCriterion("web_address <>", value, "webAddress");
            return (Criteria) this;
        }

        public Criteria andWebAddressGreaterThan(String value) {
            addCriterion("web_address >", value, "webAddress");
            return (Criteria) this;
        }

        public Criteria andWebAddressGreaterThanOrEqualTo(String value) {
            addCriterion("web_address >=", value, "webAddress");
            return (Criteria) this;
        }

        public Criteria andWebAddressLessThan(String value) {
            addCriterion("web_address <", value, "webAddress");
            return (Criteria) this;
        }

        public Criteria andWebAddressLessThanOrEqualTo(String value) {
            addCriterion("web_address <=", value, "webAddress");
            return (Criteria) this;
        }

        public Criteria andWebAddressLike(String value) {
            addCriterion("web_address like", value, "webAddress");
            return (Criteria) this;
        }

        public Criteria andWebAddressNotLike(String value) {
            addCriterion("web_address not like", value, "webAddress");
            return (Criteria) this;
        }

        public Criteria andWebAddressIn(List<String> values) {
            addCriterion("web_address in", values, "webAddress");
            return (Criteria) this;
        }

        public Criteria andWebAddressNotIn(List<String> values) {
            addCriterion("web_address not in", values, "webAddress");
            return (Criteria) this;
        }

        public Criteria andWebAddressBetween(String value1, String value2) {
            addCriterion("web_address between", value1, value2, "webAddress");
            return (Criteria) this;
        }

        public Criteria andWebAddressNotBetween(String value1, String value2) {
            addCriterion("web_address not between", value1, value2, "webAddress");
            return (Criteria) this;
        }

        public Criteria andWebCodeIsNull() {
            addCriterion("web_code is null");
            return (Criteria) this;
        }

        public Criteria andWebCodeIsNotNull() {
            addCriterion("web_code is not null");
            return (Criteria) this;
        }

        public Criteria andWebCodeEqualTo(String value) {
            addCriterion("web_code =", value, "webCode");
            return (Criteria) this;
        }

        public Criteria andWebCodeNotEqualTo(String value) {
            addCriterion("web_code <>", value, "webCode");
            return (Criteria) this;
        }

        public Criteria andWebCodeGreaterThan(String value) {
            addCriterion("web_code >", value, "webCode");
            return (Criteria) this;
        }

        public Criteria andWebCodeGreaterThanOrEqualTo(String value) {
            addCriterion("web_code >=", value, "webCode");
            return (Criteria) this;
        }

        public Criteria andWebCodeLessThan(String value) {
            addCriterion("web_code <", value, "webCode");
            return (Criteria) this;
        }

        public Criteria andWebCodeLessThanOrEqualTo(String value) {
            addCriterion("web_code <=", value, "webCode");
            return (Criteria) this;
        }

        public Criteria andWebCodeLike(String value) {
            addCriterion("web_code like", value, "webCode");
            return (Criteria) this;
        }

        public Criteria andWebCodeNotLike(String value) {
            addCriterion("web_code not like", value, "webCode");
            return (Criteria) this;
        }

        public Criteria andWebCodeIn(List<String> values) {
            addCriterion("web_code in", values, "webCode");
            return (Criteria) this;
        }

        public Criteria andWebCodeNotIn(List<String> values) {
            addCriterion("web_code not in", values, "webCode");
            return (Criteria) this;
        }

        public Criteria andWebCodeBetween(String value1, String value2) {
            addCriterion("web_code between", value1, value2, "webCode");
            return (Criteria) this;
        }

        public Criteria andWebCodeNotBetween(String value1, String value2) {
            addCriterion("web_code not between", value1, value2, "webCode");
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
