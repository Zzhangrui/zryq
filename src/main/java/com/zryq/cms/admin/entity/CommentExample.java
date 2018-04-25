package com.zryq.cms.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
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

        public Criteria andCommContentIsNull() {
            addCriterion("comm_content is null");
            return (Criteria) this;
        }

        public Criteria andCommContentIsNotNull() {
            addCriterion("comm_content is not null");
            return (Criteria) this;
        }

        public Criteria andCommContentEqualTo(String value) {
            addCriterion("comm_content =", value, "commContent");
            return (Criteria) this;
        }

        public Criteria andCommContentNotEqualTo(String value) {
            addCriterion("comm_content <>", value, "commContent");
            return (Criteria) this;
        }

        public Criteria andCommContentGreaterThan(String value) {
            addCriterion("comm_content >", value, "commContent");
            return (Criteria) this;
        }

        public Criteria andCommContentGreaterThanOrEqualTo(String value) {
            addCriterion("comm_content >=", value, "commContent");
            return (Criteria) this;
        }

        public Criteria andCommContentLessThan(String value) {
            addCriterion("comm_content <", value, "commContent");
            return (Criteria) this;
        }

        public Criteria andCommContentLessThanOrEqualTo(String value) {
            addCriterion("comm_content <=", value, "commContent");
            return (Criteria) this;
        }

        public Criteria andCommContentLike(String value) {
            addCriterion("comm_content like", value, "commContent");
            return (Criteria) this;
        }

        public Criteria andCommContentNotLike(String value) {
            addCriterion("comm_content not like", value, "commContent");
            return (Criteria) this;
        }

        public Criteria andCommContentIn(List<String> values) {
            addCriterion("comm_content in", values, "commContent");
            return (Criteria) this;
        }

        public Criteria andCommContentNotIn(List<String> values) {
            addCriterion("comm_content not in", values, "commContent");
            return (Criteria) this;
        }

        public Criteria andCommContentBetween(String value1, String value2) {
            addCriterion("comm_content between", value1, value2, "commContent");
            return (Criteria) this;
        }

        public Criteria andCommContentNotBetween(String value1, String value2) {
            addCriterion("comm_content not between", value1, value2, "commContent");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIpIsNull() {
            addCriterion("user_ip is null");
            return (Criteria) this;
        }

        public Criteria andUserIpIsNotNull() {
            addCriterion("user_ip is not null");
            return (Criteria) this;
        }

        public Criteria andUserIpEqualTo(String value) {
            addCriterion("user_ip =", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpNotEqualTo(String value) {
            addCriterion("user_ip <>", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpGreaterThan(String value) {
            addCriterion("user_ip >", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpGreaterThanOrEqualTo(String value) {
            addCriterion("user_ip >=", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpLessThan(String value) {
            addCriterion("user_ip <", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpLessThanOrEqualTo(String value) {
            addCriterion("user_ip <=", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpLike(String value) {
            addCriterion("user_ip like", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpNotLike(String value) {
            addCriterion("user_ip not like", value, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpIn(List<String> values) {
            addCriterion("user_ip in", values, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpNotIn(List<String> values) {
            addCriterion("user_ip not in", values, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpBetween(String value1, String value2) {
            addCriterion("user_ip between", value1, value2, "userIp");
            return (Criteria) this;
        }

        public Criteria andUserIpNotBetween(String value1, String value2) {
            addCriterion("user_ip not between", value1, value2, "userIp");
            return (Criteria) this;
        }

        public Criteria andCommTimeIsNull() {
            addCriterion("comm_time is null");
            return (Criteria) this;
        }

        public Criteria andCommTimeIsNotNull() {
            addCriterion("comm_time is not null");
            return (Criteria) this;
        }

        public Criteria andCommTimeEqualTo(Date value) {
            addCriterion("comm_time =", value, "commTime");
            return (Criteria) this;
        }

        public Criteria andCommTimeNotEqualTo(Date value) {
            addCriterion("comm_time <>", value, "commTime");
            return (Criteria) this;
        }

        public Criteria andCommTimeGreaterThan(Date value) {
            addCriterion("comm_time >", value, "commTime");
            return (Criteria) this;
        }

        public Criteria andCommTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("comm_time >=", value, "commTime");
            return (Criteria) this;
        }

        public Criteria andCommTimeLessThan(Date value) {
            addCriterion("comm_time <", value, "commTime");
            return (Criteria) this;
        }

        public Criteria andCommTimeLessThanOrEqualTo(Date value) {
            addCriterion("comm_time <=", value, "commTime");
            return (Criteria) this;
        }

        public Criteria andCommTimeIn(List<Date> values) {
            addCriterion("comm_time in", values, "commTime");
            return (Criteria) this;
        }

        public Criteria andCommTimeNotIn(List<Date> values) {
            addCriterion("comm_time not in", values, "commTime");
            return (Criteria) this;
        }

        public Criteria andCommTimeBetween(Date value1, Date value2) {
            addCriterion("comm_time between", value1, value2, "commTime");
            return (Criteria) this;
        }

        public Criteria andCommTimeNotBetween(Date value1, Date value2) {
            addCriterion("comm_time not between", value1, value2, "commTime");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNull() {
            addCriterion("article_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNotNull() {
            addCriterion("article_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIdEqualTo(Integer value) {
            addCriterion("article_id =", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotEqualTo(Integer value) {
            addCriterion("article_id <>", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThan(Integer value) {
            addCriterion("article_id >", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_id >=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThan(Integer value) {
            addCriterion("article_id <", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThanOrEqualTo(Integer value) {
            addCriterion("article_id <=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIn(List<Integer> values) {
            addCriterion("article_id in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotIn(List<Integer> values) {
            addCriterion("article_id not in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdBetween(Integer value1, Integer value2) {
            addCriterion("article_id between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("article_id not between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIsNull() {
            addCriterion("article_title is null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIsNotNull() {
            addCriterion("article_title is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleEqualTo(String value) {
            addCriterion("article_title =", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotEqualTo(String value) {
            addCriterion("article_title <>", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThan(String value) {
            addCriterion("article_title >", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThanOrEqualTo(String value) {
            addCriterion("article_title >=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThan(String value) {
            addCriterion("article_title <", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThanOrEqualTo(String value) {
            addCriterion("article_title <=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLike(String value) {
            addCriterion("article_title like", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotLike(String value) {
            addCriterion("article_title not like", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIn(List<String> values) {
            addCriterion("article_title in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotIn(List<String> values) {
            addCriterion("article_title not in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleBetween(String value1, String value2) {
            addCriterion("article_title between", value1, value2, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotBetween(String value1, String value2) {
            addCriterion("article_title not between", value1, value2, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andCommStateIsNull() {
            addCriterion("comm_state is null");
            return (Criteria) this;
        }

        public Criteria andCommStateIsNotNull() {
            addCriterion("comm_state is not null");
            return (Criteria) this;
        }

        public Criteria andCommStateEqualTo(Integer value) {
            addCriterion("comm_state =", value, "commState");
            return (Criteria) this;
        }

        public Criteria andCommStateNotEqualTo(Integer value) {
            addCriterion("comm_state <>", value, "commState");
            return (Criteria) this;
        }

        public Criteria andCommStateGreaterThan(Integer value) {
            addCriterion("comm_state >", value, "commState");
            return (Criteria) this;
        }

        public Criteria andCommStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("comm_state >=", value, "commState");
            return (Criteria) this;
        }

        public Criteria andCommStateLessThan(Integer value) {
            addCriterion("comm_state <", value, "commState");
            return (Criteria) this;
        }

        public Criteria andCommStateLessThanOrEqualTo(Integer value) {
            addCriterion("comm_state <=", value, "commState");
            return (Criteria) this;
        }

        public Criteria andCommStateIn(List<Integer> values) {
            addCriterion("comm_state in", values, "commState");
            return (Criteria) this;
        }

        public Criteria andCommStateNotIn(List<Integer> values) {
            addCriterion("comm_state not in", values, "commState");
            return (Criteria) this;
        }

        public Criteria andCommStateBetween(Integer value1, Integer value2) {
            addCriterion("comm_state between", value1, value2, "commState");
            return (Criteria) this;
        }

        public Criteria andCommStateNotBetween(Integer value1, Integer value2) {
            addCriterion("comm_state not between", value1, value2, "commState");
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
