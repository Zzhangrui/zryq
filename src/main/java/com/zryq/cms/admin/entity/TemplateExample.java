package com.zryq.cms.admin.entity;

import java.util.ArrayList;
import java.util.List;

public class TemplateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TemplateExample() {
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

        public Criteria andTempNameIsNull() {
            addCriterion("temp_name is null");
            return (Criteria) this;
        }

        public Criteria andTempNameIsNotNull() {
            addCriterion("temp_name is not null");
            return (Criteria) this;
        }

        public Criteria andTempNameEqualTo(String value) {
            addCriterion("temp_name =", value, "tempName");
            return (Criteria) this;
        }

        public Criteria andTempNameNotEqualTo(String value) {
            addCriterion("temp_name <>", value, "tempName");
            return (Criteria) this;
        }

        public Criteria andTempNameGreaterThan(String value) {
            addCriterion("temp_name >", value, "tempName");
            return (Criteria) this;
        }

        public Criteria andTempNameGreaterThanOrEqualTo(String value) {
            addCriterion("temp_name >=", value, "tempName");
            return (Criteria) this;
        }

        public Criteria andTempNameLessThan(String value) {
            addCriterion("temp_name <", value, "tempName");
            return (Criteria) this;
        }

        public Criteria andTempNameLessThanOrEqualTo(String value) {
            addCriterion("temp_name <=", value, "tempName");
            return (Criteria) this;
        }

        public Criteria andTempNameLike(String value) {
            addCriterion("temp_name like", value, "tempName");
            return (Criteria) this;
        }

        public Criteria andTempNameNotLike(String value) {
            addCriterion("temp_name not like", value, "tempName");
            return (Criteria) this;
        }

        public Criteria andTempNameIn(List<String> values) {
            addCriterion("temp_name in", values, "tempName");
            return (Criteria) this;
        }

        public Criteria andTempNameNotIn(List<String> values) {
            addCriterion("temp_name not in", values, "tempName");
            return (Criteria) this;
        }

        public Criteria andTempNameBetween(String value1, String value2) {
            addCriterion("temp_name between", value1, value2, "tempName");
            return (Criteria) this;
        }

        public Criteria andTempNameNotBetween(String value1, String value2) {
            addCriterion("temp_name not between", value1, value2, "tempName");
            return (Criteria) this;
        }

        public Criteria andTempStateIsNull() {
            addCriterion("temp_state is null");
            return (Criteria) this;
        }

        public Criteria andTempStateIsNotNull() {
            addCriterion("temp_state is not null");
            return (Criteria) this;
        }

        public Criteria andTempStateEqualTo(Integer value) {
            addCriterion("temp_state =", value, "tempState");
            return (Criteria) this;
        }

        public Criteria andTempStateNotEqualTo(Integer value) {
            addCriterion("temp_state <>", value, "tempState");
            return (Criteria) this;
        }

        public Criteria andTempStateGreaterThan(Integer value) {
            addCriterion("temp_state >", value, "tempState");
            return (Criteria) this;
        }

        public Criteria andTempStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("temp_state >=", value, "tempState");
            return (Criteria) this;
        }

        public Criteria andTempStateLessThan(Integer value) {
            addCriterion("temp_state <", value, "tempState");
            return (Criteria) this;
        }

        public Criteria andTempStateLessThanOrEqualTo(Integer value) {
            addCriterion("temp_state <=", value, "tempState");
            return (Criteria) this;
        }

        public Criteria andTempStateIn(List<Integer> values) {
            addCriterion("temp_state in", values, "tempState");
            return (Criteria) this;
        }

        public Criteria andTempStateNotIn(List<Integer> values) {
            addCriterion("temp_state not in", values, "tempState");
            return (Criteria) this;
        }

        public Criteria andTempStateBetween(Integer value1, Integer value2) {
            addCriterion("temp_state between", value1, value2, "tempState");
            return (Criteria) this;
        }

        public Criteria andTempStateNotBetween(Integer value1, Integer value2) {
            addCriterion("temp_state not between", value1, value2, "tempState");
            return (Criteria) this;
        }

        public Criteria andTempPathIsNull() {
            addCriterion("temp_path is null");
            return (Criteria) this;
        }

        public Criteria andTempPathIsNotNull() {
            addCriterion("temp_path is not null");
            return (Criteria) this;
        }

        public Criteria andTempPathEqualTo(String value) {
            addCriterion("temp_path =", value, "tempPath");
            return (Criteria) this;
        }

        public Criteria andTempPathNotEqualTo(String value) {
            addCriterion("temp_path <>", value, "tempPath");
            return (Criteria) this;
        }

        public Criteria andTempPathGreaterThan(String value) {
            addCriterion("temp_path >", value, "tempPath");
            return (Criteria) this;
        }

        public Criteria andTempPathGreaterThanOrEqualTo(String value) {
            addCriterion("temp_path >=", value, "tempPath");
            return (Criteria) this;
        }

        public Criteria andTempPathLessThan(String value) {
            addCriterion("temp_path <", value, "tempPath");
            return (Criteria) this;
        }

        public Criteria andTempPathLessThanOrEqualTo(String value) {
            addCriterion("temp_path <=", value, "tempPath");
            return (Criteria) this;
        }

        public Criteria andTempPathLike(String value) {
            addCriterion("temp_path like", value, "tempPath");
            return (Criteria) this;
        }

        public Criteria andTempPathNotLike(String value) {
            addCriterion("temp_path not like", value, "tempPath");
            return (Criteria) this;
        }

        public Criteria andTempPathIn(List<String> values) {
            addCriterion("temp_path in", values, "tempPath");
            return (Criteria) this;
        }

        public Criteria andTempPathNotIn(List<String> values) {
            addCriterion("temp_path not in", values, "tempPath");
            return (Criteria) this;
        }

        public Criteria andTempPathBetween(String value1, String value2) {
            addCriterion("temp_path between", value1, value2, "tempPath");
            return (Criteria) this;
        }

        public Criteria andTempPathNotBetween(String value1, String value2) {
            addCriterion("temp_path not between", value1, value2, "tempPath");
            return (Criteria) this;
        }

        public Criteria andTempTypeIsNull() {
            addCriterion("temp_type is null");
            return (Criteria) this;
        }

        public Criteria andTempTypeIsNotNull() {
            addCriterion("temp_type is not null");
            return (Criteria) this;
        }

        public Criteria andTempTypeEqualTo(String value) {
            addCriterion("temp_type =", value, "tempType");
            return (Criteria) this;
        }

        public Criteria andTempTypeNotEqualTo(String value) {
            addCriterion("temp_type <>", value, "tempType");
            return (Criteria) this;
        }

        public Criteria andTempTypeGreaterThan(String value) {
            addCriterion("temp_type >", value, "tempType");
            return (Criteria) this;
        }

        public Criteria andTempTypeGreaterThanOrEqualTo(String value) {
            addCriterion("temp_type >=", value, "tempType");
            return (Criteria) this;
        }

        public Criteria andTempTypeLessThan(String value) {
            addCriterion("temp_type <", value, "tempType");
            return (Criteria) this;
        }

        public Criteria andTempTypeLessThanOrEqualTo(String value) {
            addCriterion("temp_type <=", value, "tempType");
            return (Criteria) this;
        }

        public Criteria andTempTypeLike(String value) {
            addCriterion("temp_type like", value, "tempType");
            return (Criteria) this;
        }

        public Criteria andTempTypeNotLike(String value) {
            addCriterion("temp_type not like", value, "tempType");
            return (Criteria) this;
        }

        public Criteria andTempTypeIn(List<String> values) {
            addCriterion("temp_type in", values, "tempType");
            return (Criteria) this;
        }

        public Criteria andTempTypeNotIn(List<String> values) {
            addCriterion("temp_type not in", values, "tempType");
            return (Criteria) this;
        }

        public Criteria andTempTypeBetween(String value1, String value2) {
            addCriterion("temp_type between", value1, value2, "tempType");
            return (Criteria) this;
        }

        public Criteria andTempTypeNotBetween(String value1, String value2) {
            addCriterion("temp_type not between", value1, value2, "tempType");
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

        public Criteria andTempDesIsNull() {
            addCriterion("temp_des is null");
            return (Criteria) this;
        }

        public Criteria andTempDesIsNotNull() {
            addCriterion("temp_des is not null");
            return (Criteria) this;
        }

        public Criteria andTempDesEqualTo(String value) {
            addCriterion("temp_des =", value, "tempDes");
            return (Criteria) this;
        }

        public Criteria andTempDesNotEqualTo(String value) {
            addCriterion("temp_des <>", value, "tempDes");
            return (Criteria) this;
        }

        public Criteria andTempDesGreaterThan(String value) {
            addCriterion("temp_des >", value, "tempDes");
            return (Criteria) this;
        }

        public Criteria andTempDesGreaterThanOrEqualTo(String value) {
            addCriterion("temp_des >=", value, "tempDes");
            return (Criteria) this;
        }

        public Criteria andTempDesLessThan(String value) {
            addCriterion("temp_des <", value, "tempDes");
            return (Criteria) this;
        }

        public Criteria andTempDesLessThanOrEqualTo(String value) {
            addCriterion("temp_des <=", value, "tempDes");
            return (Criteria) this;
        }

        public Criteria andTempDesLike(String value) {
            addCriterion("temp_des like", value, "tempDes");
            return (Criteria) this;
        }

        public Criteria andTempDesNotLike(String value) {
            addCriterion("temp_des not like", value, "tempDes");
            return (Criteria) this;
        }

        public Criteria andTempDesIn(List<String> values) {
            addCriterion("temp_des in", values, "tempDes");
            return (Criteria) this;
        }

        public Criteria andTempDesNotIn(List<String> values) {
            addCriterion("temp_des not in", values, "tempDes");
            return (Criteria) this;
        }

        public Criteria andTempDesBetween(String value1, String value2) {
            addCriterion("temp_des between", value1, value2, "tempDes");
            return (Criteria) this;
        }

        public Criteria andTempDesNotBetween(String value1, String value2) {
            addCriterion("temp_des not between", value1, value2, "tempDes");
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
