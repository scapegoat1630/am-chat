package com.am.chat.model;

import com.am.chat.common.model.Pagination;
import java.util.ArrayList;
import java.util.List;

public class AuthExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pagination pagination;

    public AuthExample() {
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

    public void setPagination(Pagination pagination) {
        this.pagination=pagination;
    }

    public Pagination getPagination() {
        return pagination;
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

        public Criteria andAuthctypeIsNull() {
            addCriterion("authcType is null");
            return (Criteria) this;
        }

        public Criteria andAuthctypeIsNotNull() {
            addCriterion("authcType is not null");
            return (Criteria) this;
        }

        public Criteria andAuthctypeEqualTo(String value) {
            addCriterion("authcType =", value, "authctype");
            return (Criteria) this;
        }

        public Criteria andAuthctypeNotEqualTo(String value) {
            addCriterion("authcType <>", value, "authctype");
            return (Criteria) this;
        }

        public Criteria andAuthctypeGreaterThan(String value) {
            addCriterion("authcType >", value, "authctype");
            return (Criteria) this;
        }

        public Criteria andAuthctypeGreaterThanOrEqualTo(String value) {
            addCriterion("authcType >=", value, "authctype");
            return (Criteria) this;
        }

        public Criteria andAuthctypeLessThan(String value) {
            addCriterion("authcType <", value, "authctype");
            return (Criteria) this;
        }

        public Criteria andAuthctypeLessThanOrEqualTo(String value) {
            addCriterion("authcType <=", value, "authctype");
            return (Criteria) this;
        }

        public Criteria andAuthctypeLike(String value) {
            addCriterion("authcType like", value, "authctype");
            return (Criteria) this;
        }

        public Criteria andAuthctypeNotLike(String value) {
            addCriterion("authcType not like", value, "authctype");
            return (Criteria) this;
        }

        public Criteria andAuthctypeIn(List<String> values) {
            addCriterion("authcType in", values, "authctype");
            return (Criteria) this;
        }

        public Criteria andAuthctypeNotIn(List<String> values) {
            addCriterion("authcType not in", values, "authctype");
            return (Criteria) this;
        }

        public Criteria andAuthctypeBetween(String value1, String value2) {
            addCriterion("authcType between", value1, value2, "authctype");
            return (Criteria) this;
        }

        public Criteria andAuthctypeNotBetween(String value1, String value2) {
            addCriterion("authcType not between", value1, value2, "authctype");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andValIsNull() {
            addCriterion("val is null");
            return (Criteria) this;
        }

        public Criteria andValIsNotNull() {
            addCriterion("val is not null");
            return (Criteria) this;
        }

        public Criteria andValEqualTo(String value) {
            addCriterion("val =", value, "val");
            return (Criteria) this;
        }

        public Criteria andValNotEqualTo(String value) {
            addCriterion("val <>", value, "val");
            return (Criteria) this;
        }

        public Criteria andValGreaterThan(String value) {
            addCriterion("val >", value, "val");
            return (Criteria) this;
        }

        public Criteria andValGreaterThanOrEqualTo(String value) {
            addCriterion("val >=", value, "val");
            return (Criteria) this;
        }

        public Criteria andValLessThan(String value) {
            addCriterion("val <", value, "val");
            return (Criteria) this;
        }

        public Criteria andValLessThanOrEqualTo(String value) {
            addCriterion("val <=", value, "val");
            return (Criteria) this;
        }

        public Criteria andValLike(String value) {
            addCriterion("val like", value, "val");
            return (Criteria) this;
        }

        public Criteria andValNotLike(String value) {
            addCriterion("val not like", value, "val");
            return (Criteria) this;
        }

        public Criteria andValIn(List<String> values) {
            addCriterion("val in", values, "val");
            return (Criteria) this;
        }

        public Criteria andValNotIn(List<String> values) {
            addCriterion("val not in", values, "val");
            return (Criteria) this;
        }

        public Criteria andValBetween(String value1, String value2) {
            addCriterion("val between", value1, value2, "val");
            return (Criteria) this;
        }

        public Criteria andValNotBetween(String value1, String value2) {
            addCriterion("val not between", value1, value2, "val");
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