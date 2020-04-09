package com.shu.labrary.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EssayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EssayExample() {
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

        public Criteria andEssayidIsNull() {
            addCriterion("essayId is null");
            return (Criteria) this;
        }

        public Criteria andEssayidIsNotNull() {
            addCriterion("essayId is not null");
            return (Criteria) this;
        }

        public Criteria andEssayidEqualTo(Integer value) {
            addCriterion("essayId =", value, "essayid");
            return (Criteria) this;
        }

        public Criteria andEssayidNotEqualTo(Integer value) {
            addCriterion("essayId <>", value, "essayid");
            return (Criteria) this;
        }

        public Criteria andEssayidGreaterThan(Integer value) {
            addCriterion("essayId >", value, "essayid");
            return (Criteria) this;
        }

        public Criteria andEssayidGreaterThanOrEqualTo(Integer value) {
            addCriterion("essayId >=", value, "essayid");
            return (Criteria) this;
        }

        public Criteria andEssayidLessThan(Integer value) {
            addCriterion("essayId <", value, "essayid");
            return (Criteria) this;
        }

        public Criteria andEssayidLessThanOrEqualTo(Integer value) {
            addCriterion("essayId <=", value, "essayid");
            return (Criteria) this;
        }

        public Criteria andEssayidIn(List<Integer> values) {
            addCriterion("essayId in", values, "essayid");
            return (Criteria) this;
        }

        public Criteria andEssayidNotIn(List<Integer> values) {
            addCriterion("essayId not in", values, "essayid");
            return (Criteria) this;
        }

        public Criteria andEssayidBetween(Integer value1, Integer value2) {
            addCriterion("essayId between", value1, value2, "essayid");
            return (Criteria) this;
        }

        public Criteria andEssayidNotBetween(Integer value1, Integer value2) {
            addCriterion("essayId not between", value1, value2, "essayid");
            return (Criteria) this;
        }

        public Criteria andEssaynameIsNull() {
            addCriterion("essayname is null");
            return (Criteria) this;
        }

        public Criteria andEssaynameIsNotNull() {
            addCriterion("essayname is not null");
            return (Criteria) this;
        }

        public Criteria andEssaynameEqualTo(String value) {
            addCriterion("essayname =", value, "essayname");
            return (Criteria) this;
        }

        public Criteria andEssaynameNotEqualTo(String value) {
            addCriterion("essayname <>", value, "essayname");
            return (Criteria) this;
        }

        public Criteria andEssaynameGreaterThan(String value) {
            addCriterion("essayname >", value, "essayname");
            return (Criteria) this;
        }

        public Criteria andEssaynameGreaterThanOrEqualTo(String value) {
            addCriterion("essayname >=", value, "essayname");
            return (Criteria) this;
        }

        public Criteria andEssaynameLessThan(String value) {
            addCriterion("essayname <", value, "essayname");
            return (Criteria) this;
        }

        public Criteria andEssaynameLessThanOrEqualTo(String value) {
            addCriterion("essayname <=", value, "essayname");
            return (Criteria) this;
        }

        public Criteria andEssaynameLike(String value) {
            addCriterion("essayname like", value, "essayname");
            return (Criteria) this;
        }

        public Criteria andEssaynameNotLike(String value) {
            addCriterion("essayname not like", value, "essayname");
            return (Criteria) this;
        }

        public Criteria andEssaynameIn(List<String> values) {
            addCriterion("essayname in", values, "essayname");
            return (Criteria) this;
        }

        public Criteria andEssaynameNotIn(List<String> values) {
            addCriterion("essayname not in", values, "essayname");
            return (Criteria) this;
        }

        public Criteria andEssaynameBetween(String value1, String value2) {
            addCriterion("essayname between", value1, value2, "essayname");
            return (Criteria) this;
        }

        public Criteria andEssaynameNotBetween(String value1, String value2) {
            addCriterion("essayname not between", value1, value2, "essayname");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andEssaysrcIsNull() {
            addCriterion("essaysrc is null");
            return (Criteria) this;
        }

        public Criteria andEssaysrcIsNotNull() {
            addCriterion("essaysrc is not null");
            return (Criteria) this;
        }

        public Criteria andEssaysrcEqualTo(String value) {
            addCriterion("essaysrc =", value, "essaysrc");
            return (Criteria) this;
        }

        public Criteria andEssaysrcNotEqualTo(String value) {
            addCriterion("essaysrc <>", value, "essaysrc");
            return (Criteria) this;
        }

        public Criteria andEssaysrcGreaterThan(String value) {
            addCriterion("essaysrc >", value, "essaysrc");
            return (Criteria) this;
        }

        public Criteria andEssaysrcGreaterThanOrEqualTo(String value) {
            addCriterion("essaysrc >=", value, "essaysrc");
            return (Criteria) this;
        }

        public Criteria andEssaysrcLessThan(String value) {
            addCriterion("essaysrc <", value, "essaysrc");
            return (Criteria) this;
        }

        public Criteria andEssaysrcLessThanOrEqualTo(String value) {
            addCriterion("essaysrc <=", value, "essaysrc");
            return (Criteria) this;
        }

        public Criteria andEssaysrcLike(String value) {
            addCriterion("essaysrc like", value, "essaysrc");
            return (Criteria) this;
        }

        public Criteria andEssaysrcNotLike(String value) {
            addCriterion("essaysrc not like", value, "essaysrc");
            return (Criteria) this;
        }

        public Criteria andEssaysrcIn(List<String> values) {
            addCriterion("essaysrc in", values, "essaysrc");
            return (Criteria) this;
        }

        public Criteria andEssaysrcNotIn(List<String> values) {
            addCriterion("essaysrc not in", values, "essaysrc");
            return (Criteria) this;
        }

        public Criteria andEssaysrcBetween(String value1, String value2) {
            addCriterion("essaysrc between", value1, value2, "essaysrc");
            return (Criteria) this;
        }

        public Criteria andEssaysrcNotBetween(String value1, String value2) {
            addCriterion("essaysrc not between", value1, value2, "essaysrc");
            return (Criteria) this;
        }

        public Criteria andOnlinIsNull() {
            addCriterion("onlin is null");
            return (Criteria) this;
        }

        public Criteria andOnlinIsNotNull() {
            addCriterion("onlin is not null");
            return (Criteria) this;
        }

        public Criteria andOnlinEqualTo(Integer value) {
            addCriterion("onlin =", value, "onlin");
            return (Criteria) this;
        }

        public Criteria andOnlinNotEqualTo(Integer value) {
            addCriterion("onlin <>", value, "onlin");
            return (Criteria) this;
        }

        public Criteria andOnlinGreaterThan(Integer value) {
            addCriterion("onlin >", value, "onlin");
            return (Criteria) this;
        }

        public Criteria andOnlinGreaterThanOrEqualTo(Integer value) {
            addCriterion("onlin >=", value, "onlin");
            return (Criteria) this;
        }

        public Criteria andOnlinLessThan(Integer value) {
            addCriterion("onlin <", value, "onlin");
            return (Criteria) this;
        }

        public Criteria andOnlinLessThanOrEqualTo(Integer value) {
            addCriterion("onlin <=", value, "onlin");
            return (Criteria) this;
        }

        public Criteria andOnlinIn(List<Integer> values) {
            addCriterion("onlin in", values, "onlin");
            return (Criteria) this;
        }

        public Criteria andOnlinNotIn(List<Integer> values) {
            addCriterion("onlin not in", values, "onlin");
            return (Criteria) this;
        }

        public Criteria andOnlinBetween(Integer value1, Integer value2) {
            addCriterion("onlin between", value1, value2, "onlin");
            return (Criteria) this;
        }

        public Criteria andOnlinNotBetween(Integer value1, Integer value2) {
            addCriterion("onlin not between", value1, value2, "onlin");
            return (Criteria) this;
        }

        public Criteria andTeacheridIsNull() {
            addCriterion("teacherid is null");
            return (Criteria) this;
        }

        public Criteria andTeacheridIsNotNull() {
            addCriterion("teacherid is not null");
            return (Criteria) this;
        }

        public Criteria andTeacheridEqualTo(Integer value) {
            addCriterion("teacherid =", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotEqualTo(Integer value) {
            addCriterion("teacherid <>", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridGreaterThan(Integer value) {
            addCriterion("teacherid >", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridGreaterThanOrEqualTo(Integer value) {
            addCriterion("teacherid >=", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridLessThan(Integer value) {
            addCriterion("teacherid <", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridLessThanOrEqualTo(Integer value) {
            addCriterion("teacherid <=", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridIn(List<Integer> values) {
            addCriterion("teacherid in", values, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotIn(List<Integer> values) {
            addCriterion("teacherid not in", values, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridBetween(Integer value1, Integer value2) {
            addCriterion("teacherid between", value1, value2, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotBetween(Integer value1, Integer value2) {
            addCriterion("teacherid not between", value1, value2, "teacherid");
            return (Criteria) this;
        }

        public Criteria andFinishtimeIsNull() {
            addCriterion("finishtime is null");
            return (Criteria) this;
        }

        public Criteria andFinishtimeIsNotNull() {
            addCriterion("finishtime is not null");
            return (Criteria) this;
        }

        public Criteria andFinishtimeEqualTo(Date value) {
            addCriterion("finishtime =", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeNotEqualTo(Date value) {
            addCriterion("finishtime <>", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeGreaterThan(Date value) {
            addCriterion("finishtime >", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("finishtime >=", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeLessThan(Date value) {
            addCriterion("finishtime <", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeLessThanOrEqualTo(Date value) {
            addCriterion("finishtime <=", value, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeIn(List<Date> values) {
            addCriterion("finishtime in", values, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeNotIn(List<Date> values) {
            addCriterion("finishtime not in", values, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeBetween(Date value1, Date value2) {
            addCriterion("finishtime between", value1, value2, "finishtime");
            return (Criteria) this;
        }

        public Criteria andFinishtimeNotBetween(Date value1, Date value2) {
            addCriterion("finishtime not between", value1, value2, "finishtime");
            return (Criteria) this;
        }

        public Criteria andAdminidIsNull() {
            addCriterion("adminId is null");
            return (Criteria) this;
        }

        public Criteria andAdminidIsNotNull() {
            addCriterion("adminId is not null");
            return (Criteria) this;
        }

        public Criteria andAdminidEqualTo(Integer value) {
            addCriterion("adminId =", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidNotEqualTo(Integer value) {
            addCriterion("adminId <>", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidGreaterThan(Integer value) {
            addCriterion("adminId >", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidGreaterThanOrEqualTo(Integer value) {
            addCriterion("adminId >=", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidLessThan(Integer value) {
            addCriterion("adminId <", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidLessThanOrEqualTo(Integer value) {
            addCriterion("adminId <=", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidIn(List<Integer> values) {
            addCriterion("adminId in", values, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidNotIn(List<Integer> values) {
            addCriterion("adminId not in", values, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidBetween(Integer value1, Integer value2) {
            addCriterion("adminId between", value1, value2, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidNotBetween(Integer value1, Integer value2) {
            addCriterion("adminId not between", value1, value2, "adminid");
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