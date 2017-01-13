package com.am.chat.model;

import com.am.chat.common.model.Pagination;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pagination pagination;

    public UserExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIsNull() {
            addCriterion("phonenumber is null");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIsNotNull() {
            addCriterion("phonenumber is not null");
            return (Criteria) this;
        }

        public Criteria andPhonenumberEqualTo(Integer value) {
            addCriterion("phonenumber =", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotEqualTo(Integer value) {
            addCriterion("phonenumber <>", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberGreaterThan(Integer value) {
            addCriterion("phonenumber >", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("phonenumber >=", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLessThan(Integer value) {
            addCriterion("phonenumber <", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLessThanOrEqualTo(Integer value) {
            addCriterion("phonenumber <=", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIn(List<Integer> values) {
            addCriterion("phonenumber in", values, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotIn(List<Integer> values) {
            addCriterion("phonenumber not in", values, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberBetween(Integer value1, Integer value2) {
            addCriterion("phonenumber between", value1, value2, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotBetween(Integer value1, Integer value2) {
            addCriterion("phonenumber not between", value1, value2, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andHeadimageIsNull() {
            addCriterion("headimage is null");
            return (Criteria) this;
        }

        public Criteria andHeadimageIsNotNull() {
            addCriterion("headimage is not null");
            return (Criteria) this;
        }

        public Criteria andHeadimageEqualTo(String value) {
            addCriterion("headimage =", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageNotEqualTo(String value) {
            addCriterion("headimage <>", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageGreaterThan(String value) {
            addCriterion("headimage >", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageGreaterThanOrEqualTo(String value) {
            addCriterion("headimage >=", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageLessThan(String value) {
            addCriterion("headimage <", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageLessThanOrEqualTo(String value) {
            addCriterion("headimage <=", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageLike(String value) {
            addCriterion("headimage like", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageNotLike(String value) {
            addCriterion("headimage not like", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageIn(List<String> values) {
            addCriterion("headimage in", values, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageNotIn(List<String> values) {
            addCriterion("headimage not in", values, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageBetween(String value1, String value2) {
            addCriterion("headimage between", value1, value2, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageNotBetween(String value1, String value2) {
            addCriterion("headimage not between", value1, value2, "headimage");
            return (Criteria) this;
        }

        public Criteria andIntroIsNull() {
            addCriterion("intro is null");
            return (Criteria) this;
        }

        public Criteria andIntroIsNotNull() {
            addCriterion("intro is not null");
            return (Criteria) this;
        }

        public Criteria andIntroEqualTo(String value) {
            addCriterion("intro =", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotEqualTo(String value) {
            addCriterion("intro <>", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroGreaterThan(String value) {
            addCriterion("intro >", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroGreaterThanOrEqualTo(String value) {
            addCriterion("intro >=", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroLessThan(String value) {
            addCriterion("intro <", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroLessThanOrEqualTo(String value) {
            addCriterion("intro <=", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroLike(String value) {
            addCriterion("intro like", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotLike(String value) {
            addCriterion("intro not like", value, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroIn(List<String> values) {
            addCriterion("intro in", values, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotIn(List<String> values) {
            addCriterion("intro not in", values, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroBetween(String value1, String value2) {
            addCriterion("intro between", value1, value2, "intro");
            return (Criteria) this;
        }

        public Criteria andIntroNotBetween(String value1, String value2) {
            addCriterion("intro not between", value1, value2, "intro");
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

        public Criteria andCommentsIsNull() {
            addCriterion("comments is null");
            return (Criteria) this;
        }

        public Criteria andCommentsIsNotNull() {
            addCriterion("comments is not null");
            return (Criteria) this;
        }

        public Criteria andCommentsEqualTo(String value) {
            addCriterion("comments =", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotEqualTo(String value) {
            addCriterion("comments <>", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThan(String value) {
            addCriterion("comments >", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThanOrEqualTo(String value) {
            addCriterion("comments >=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThan(String value) {
            addCriterion("comments <", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThanOrEqualTo(String value) {
            addCriterion("comments <=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLike(String value) {
            addCriterion("comments like", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotLike(String value) {
            addCriterion("comments not like", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsIn(List<String> values) {
            addCriterion("comments in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotIn(List<String> values) {
            addCriterion("comments not in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsBetween(String value1, String value2) {
            addCriterion("comments between", value1, value2, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotBetween(String value1, String value2) {
            addCriterion("comments not between", value1, value2, "comments");
            return (Criteria) this;
        }

        public Criteria andK1IsNull() {
            addCriterion("k1 is null");
            return (Criteria) this;
        }

        public Criteria andK1IsNotNull() {
            addCriterion("k1 is not null");
            return (Criteria) this;
        }

        public Criteria andK1EqualTo(String value) {
            addCriterion("k1 =", value, "k1");
            return (Criteria) this;
        }

        public Criteria andK1NotEqualTo(String value) {
            addCriterion("k1 <>", value, "k1");
            return (Criteria) this;
        }

        public Criteria andK1GreaterThan(String value) {
            addCriterion("k1 >", value, "k1");
            return (Criteria) this;
        }

        public Criteria andK1GreaterThanOrEqualTo(String value) {
            addCriterion("k1 >=", value, "k1");
            return (Criteria) this;
        }

        public Criteria andK1LessThan(String value) {
            addCriterion("k1 <", value, "k1");
            return (Criteria) this;
        }

        public Criteria andK1LessThanOrEqualTo(String value) {
            addCriterion("k1 <=", value, "k1");
            return (Criteria) this;
        }

        public Criteria andK1Like(String value) {
            addCriterion("k1 like", value, "k1");
            return (Criteria) this;
        }

        public Criteria andK1NotLike(String value) {
            addCriterion("k1 not like", value, "k1");
            return (Criteria) this;
        }

        public Criteria andK1In(List<String> values) {
            addCriterion("k1 in", values, "k1");
            return (Criteria) this;
        }

        public Criteria andK1NotIn(List<String> values) {
            addCriterion("k1 not in", values, "k1");
            return (Criteria) this;
        }

        public Criteria andK1Between(String value1, String value2) {
            addCriterion("k1 between", value1, value2, "k1");
            return (Criteria) this;
        }

        public Criteria andK1NotBetween(String value1, String value2) {
            addCriterion("k1 not between", value1, value2, "k1");
            return (Criteria) this;
        }

        public Criteria andK2IsNull() {
            addCriterion("k2 is null");
            return (Criteria) this;
        }

        public Criteria andK2IsNotNull() {
            addCriterion("k2 is not null");
            return (Criteria) this;
        }

        public Criteria andK2EqualTo(Integer value) {
            addCriterion("k2 =", value, "k2");
            return (Criteria) this;
        }

        public Criteria andK2NotEqualTo(Integer value) {
            addCriterion("k2 <>", value, "k2");
            return (Criteria) this;
        }

        public Criteria andK2GreaterThan(Integer value) {
            addCriterion("k2 >", value, "k2");
            return (Criteria) this;
        }

        public Criteria andK2GreaterThanOrEqualTo(Integer value) {
            addCriterion("k2 >=", value, "k2");
            return (Criteria) this;
        }

        public Criteria andK2LessThan(Integer value) {
            addCriterion("k2 <", value, "k2");
            return (Criteria) this;
        }

        public Criteria andK2LessThanOrEqualTo(Integer value) {
            addCriterion("k2 <=", value, "k2");
            return (Criteria) this;
        }

        public Criteria andK2In(List<Integer> values) {
            addCriterion("k2 in", values, "k2");
            return (Criteria) this;
        }

        public Criteria andK2NotIn(List<Integer> values) {
            addCriterion("k2 not in", values, "k2");
            return (Criteria) this;
        }

        public Criteria andK2Between(Integer value1, Integer value2) {
            addCriterion("k2 between", value1, value2, "k2");
            return (Criteria) this;
        }

        public Criteria andK2NotBetween(Integer value1, Integer value2) {
            addCriterion("k2 not between", value1, value2, "k2");
            return (Criteria) this;
        }

        public Criteria andK3IsNull() {
            addCriterion("k3 is null");
            return (Criteria) this;
        }

        public Criteria andK3IsNotNull() {
            addCriterion("k3 is not null");
            return (Criteria) this;
        }

        public Criteria andK3EqualTo(Date value) {
            addCriterion("k3 =", value, "k3");
            return (Criteria) this;
        }

        public Criteria andK3NotEqualTo(Date value) {
            addCriterion("k3 <>", value, "k3");
            return (Criteria) this;
        }

        public Criteria andK3GreaterThan(Date value) {
            addCriterion("k3 >", value, "k3");
            return (Criteria) this;
        }

        public Criteria andK3GreaterThanOrEqualTo(Date value) {
            addCriterion("k3 >=", value, "k3");
            return (Criteria) this;
        }

        public Criteria andK3LessThan(Date value) {
            addCriterion("k3 <", value, "k3");
            return (Criteria) this;
        }

        public Criteria andK3LessThanOrEqualTo(Date value) {
            addCriterion("k3 <=", value, "k3");
            return (Criteria) this;
        }

        public Criteria andK3In(List<Date> values) {
            addCriterion("k3 in", values, "k3");
            return (Criteria) this;
        }

        public Criteria andK3NotIn(List<Date> values) {
            addCriterion("k3 not in", values, "k3");
            return (Criteria) this;
        }

        public Criteria andK3Between(Date value1, Date value2) {
            addCriterion("k3 between", value1, value2, "k3");
            return (Criteria) this;
        }

        public Criteria andK3NotBetween(Date value1, Date value2) {
            addCriterion("k3 not between", value1, value2, "k3");
            return (Criteria) this;
        }

        public Criteria andK4IsNull() {
            addCriterion("k4 is null");
            return (Criteria) this;
        }

        public Criteria andK4IsNotNull() {
            addCriterion("k4 is not null");
            return (Criteria) this;
        }

        public Criteria andK4EqualTo(Date value) {
            addCriterionForJDBCTime("k4 =", value, "k4");
            return (Criteria) this;
        }

        public Criteria andK4NotEqualTo(Date value) {
            addCriterionForJDBCTime("k4 <>", value, "k4");
            return (Criteria) this;
        }

        public Criteria andK4GreaterThan(Date value) {
            addCriterionForJDBCTime("k4 >", value, "k4");
            return (Criteria) this;
        }

        public Criteria andK4GreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("k4 >=", value, "k4");
            return (Criteria) this;
        }

        public Criteria andK4LessThan(Date value) {
            addCriterionForJDBCTime("k4 <", value, "k4");
            return (Criteria) this;
        }

        public Criteria andK4LessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("k4 <=", value, "k4");
            return (Criteria) this;
        }

        public Criteria andK4In(List<Date> values) {
            addCriterionForJDBCTime("k4 in", values, "k4");
            return (Criteria) this;
        }

        public Criteria andK4NotIn(List<Date> values) {
            addCriterionForJDBCTime("k4 not in", values, "k4");
            return (Criteria) this;
        }

        public Criteria andK4Between(Date value1, Date value2) {
            addCriterionForJDBCTime("k4 between", value1, value2, "k4");
            return (Criteria) this;
        }

        public Criteria andK4NotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("k4 not between", value1, value2, "k4");
            return (Criteria) this;
        }

        public Criteria andK5IsNull() {
            addCriterion("k5 is null");
            return (Criteria) this;
        }

        public Criteria andK5IsNotNull() {
            addCriterion("k5 is not null");
            return (Criteria) this;
        }

        public Criteria andK5EqualTo(String value) {
            addCriterion("k5 =", value, "k5");
            return (Criteria) this;
        }

        public Criteria andK5NotEqualTo(String value) {
            addCriterion("k5 <>", value, "k5");
            return (Criteria) this;
        }

        public Criteria andK5GreaterThan(String value) {
            addCriterion("k5 >", value, "k5");
            return (Criteria) this;
        }

        public Criteria andK5GreaterThanOrEqualTo(String value) {
            addCriterion("k5 >=", value, "k5");
            return (Criteria) this;
        }

        public Criteria andK5LessThan(String value) {
            addCriterion("k5 <", value, "k5");
            return (Criteria) this;
        }

        public Criteria andK5LessThanOrEqualTo(String value) {
            addCriterion("k5 <=", value, "k5");
            return (Criteria) this;
        }

        public Criteria andK5Like(String value) {
            addCriterion("k5 like", value, "k5");
            return (Criteria) this;
        }

        public Criteria andK5NotLike(String value) {
            addCriterion("k5 not like", value, "k5");
            return (Criteria) this;
        }

        public Criteria andK5In(List<String> values) {
            addCriterion("k5 in", values, "k5");
            return (Criteria) this;
        }

        public Criteria andK5NotIn(List<String> values) {
            addCriterion("k5 not in", values, "k5");
            return (Criteria) this;
        }

        public Criteria andK5Between(String value1, String value2) {
            addCriterion("k5 between", value1, value2, "k5");
            return (Criteria) this;
        }

        public Criteria andK5NotBetween(String value1, String value2) {
            addCriterion("k5 not between", value1, value2, "k5");
            return (Criteria) this;
        }

        public Criteria andK6IsNull() {
            addCriterion("k6 is null");
            return (Criteria) this;
        }

        public Criteria andK6IsNotNull() {
            addCriterion("k6 is not null");
            return (Criteria) this;
        }

        public Criteria andK6EqualTo(String value) {
            addCriterion("k6 =", value, "k6");
            return (Criteria) this;
        }

        public Criteria andK6NotEqualTo(String value) {
            addCriterion("k6 <>", value, "k6");
            return (Criteria) this;
        }

        public Criteria andK6GreaterThan(String value) {
            addCriterion("k6 >", value, "k6");
            return (Criteria) this;
        }

        public Criteria andK6GreaterThanOrEqualTo(String value) {
            addCriterion("k6 >=", value, "k6");
            return (Criteria) this;
        }

        public Criteria andK6LessThan(String value) {
            addCriterion("k6 <", value, "k6");
            return (Criteria) this;
        }

        public Criteria andK6LessThanOrEqualTo(String value) {
            addCriterion("k6 <=", value, "k6");
            return (Criteria) this;
        }

        public Criteria andK6Like(String value) {
            addCriterion("k6 like", value, "k6");
            return (Criteria) this;
        }

        public Criteria andK6NotLike(String value) {
            addCriterion("k6 not like", value, "k6");
            return (Criteria) this;
        }

        public Criteria andK6In(List<String> values) {
            addCriterion("k6 in", values, "k6");
            return (Criteria) this;
        }

        public Criteria andK6NotIn(List<String> values) {
            addCriterion("k6 not in", values, "k6");
            return (Criteria) this;
        }

        public Criteria andK6Between(String value1, String value2) {
            addCriterion("k6 between", value1, value2, "k6");
            return (Criteria) this;
        }

        public Criteria andK6NotBetween(String value1, String value2) {
            addCriterion("k6 not between", value1, value2, "k6");
            return (Criteria) this;
        }

        public Criteria andK8IsNull() {
            addCriterion("k8 is null");
            return (Criteria) this;
        }

        public Criteria andK8IsNotNull() {
            addCriterion("k8 is not null");
            return (Criteria) this;
        }

        public Criteria andK8EqualTo(String value) {
            addCriterion("k8 =", value, "k8");
            return (Criteria) this;
        }

        public Criteria andK8NotEqualTo(String value) {
            addCriterion("k8 <>", value, "k8");
            return (Criteria) this;
        }

        public Criteria andK8GreaterThan(String value) {
            addCriterion("k8 >", value, "k8");
            return (Criteria) this;
        }

        public Criteria andK8GreaterThanOrEqualTo(String value) {
            addCriterion("k8 >=", value, "k8");
            return (Criteria) this;
        }

        public Criteria andK8LessThan(String value) {
            addCriterion("k8 <", value, "k8");
            return (Criteria) this;
        }

        public Criteria andK8LessThanOrEqualTo(String value) {
            addCriterion("k8 <=", value, "k8");
            return (Criteria) this;
        }

        public Criteria andK8Like(String value) {
            addCriterion("k8 like", value, "k8");
            return (Criteria) this;
        }

        public Criteria andK8NotLike(String value) {
            addCriterion("k8 not like", value, "k8");
            return (Criteria) this;
        }

        public Criteria andK8In(List<String> values) {
            addCriterion("k8 in", values, "k8");
            return (Criteria) this;
        }

        public Criteria andK8NotIn(List<String> values) {
            addCriterion("k8 not in", values, "k8");
            return (Criteria) this;
        }

        public Criteria andK8Between(String value1, String value2) {
            addCriterion("k8 between", value1, value2, "k8");
            return (Criteria) this;
        }

        public Criteria andK8NotBetween(String value1, String value2) {
            addCriterion("k8 not between", value1, value2, "k8");
            return (Criteria) this;
        }

        public Criteria andK9IsNull() {
            addCriterion("k9 is null");
            return (Criteria) this;
        }

        public Criteria andK9IsNotNull() {
            addCriterion("k9 is not null");
            return (Criteria) this;
        }

        public Criteria andK9EqualTo(String value) {
            addCriterion("k9 =", value, "k9");
            return (Criteria) this;
        }

        public Criteria andK9NotEqualTo(String value) {
            addCriterion("k9 <>", value, "k9");
            return (Criteria) this;
        }

        public Criteria andK9GreaterThan(String value) {
            addCriterion("k9 >", value, "k9");
            return (Criteria) this;
        }

        public Criteria andK9GreaterThanOrEqualTo(String value) {
            addCriterion("k9 >=", value, "k9");
            return (Criteria) this;
        }

        public Criteria andK9LessThan(String value) {
            addCriterion("k9 <", value, "k9");
            return (Criteria) this;
        }

        public Criteria andK9LessThanOrEqualTo(String value) {
            addCriterion("k9 <=", value, "k9");
            return (Criteria) this;
        }

        public Criteria andK9Like(String value) {
            addCriterion("k9 like", value, "k9");
            return (Criteria) this;
        }

        public Criteria andK9NotLike(String value) {
            addCriterion("k9 not like", value, "k9");
            return (Criteria) this;
        }

        public Criteria andK9In(List<String> values) {
            addCriterion("k9 in", values, "k9");
            return (Criteria) this;
        }

        public Criteria andK9NotIn(List<String> values) {
            addCriterion("k9 not in", values, "k9");
            return (Criteria) this;
        }

        public Criteria andK9Between(String value1, String value2) {
            addCriterion("k9 between", value1, value2, "k9");
            return (Criteria) this;
        }

        public Criteria andK9NotBetween(String value1, String value2) {
            addCriterion("k9 not between", value1, value2, "k9");
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