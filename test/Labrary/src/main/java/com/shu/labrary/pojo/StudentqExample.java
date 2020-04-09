package com.shu.labrary.pojo;

import java.util.ArrayList;
import java.util.List;

public class StudentqExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentqExample() {
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

        public Criteria andOntimeIsNull() {
            addCriterion("onTime is null");
            return (Criteria) this;
        }

        public Criteria andOntimeIsNotNull() {
            addCriterion("onTime is not null");
            return (Criteria) this;
        }

        public Criteria andOntimeEqualTo(Integer value) {
            addCriterion("onTime =", value, "ontime");
            return (Criteria) this;
        }

        public Criteria andOntimeNotEqualTo(Integer value) {
            addCriterion("onTime <>", value, "ontime");
            return (Criteria) this;
        }

        public Criteria andOntimeGreaterThan(Integer value) {
            addCriterion("onTime >", value, "ontime");
            return (Criteria) this;
        }

        public Criteria andOntimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("onTime >=", value, "ontime");
            return (Criteria) this;
        }

        public Criteria andOntimeLessThan(Integer value) {
            addCriterion("onTime <", value, "ontime");
            return (Criteria) this;
        }

        public Criteria andOntimeLessThanOrEqualTo(Integer value) {
            addCriterion("onTime <=", value, "ontime");
            return (Criteria) this;
        }

        public Criteria andOntimeIn(List<Integer> values) {
            addCriterion("onTime in", values, "ontime");
            return (Criteria) this;
        }

        public Criteria andOntimeNotIn(List<Integer> values) {
            addCriterion("onTime not in", values, "ontime");
            return (Criteria) this;
        }

        public Criteria andOntimeBetween(Integer value1, Integer value2) {
            addCriterion("onTime between", value1, value2, "ontime");
            return (Criteria) this;
        }

        public Criteria andOntimeNotBetween(Integer value1, Integer value2) {
            addCriterion("onTime not between", value1, value2, "ontime");
            return (Criteria) this;
        }

        public Criteria andTeachermarkIsNull() {
            addCriterion("teacherMark is null");
            return (Criteria) this;
        }

        public Criteria andTeachermarkIsNotNull() {
            addCriterion("teacherMark is not null");
            return (Criteria) this;
        }

        public Criteria andTeachermarkEqualTo(Double value) {
            addCriterion("teacherMark =", value, "teachermark");
            return (Criteria) this;
        }

        public Criteria andTeachermarkNotEqualTo(Double value) {
            addCriterion("teacherMark <>", value, "teachermark");
            return (Criteria) this;
        }

        public Criteria andTeachermarkGreaterThan(Double value) {
            addCriterion("teacherMark >", value, "teachermark");
            return (Criteria) this;
        }

        public Criteria andTeachermarkGreaterThanOrEqualTo(Double value) {
            addCriterion("teacherMark >=", value, "teachermark");
            return (Criteria) this;
        }

        public Criteria andTeachermarkLessThan(Double value) {
            addCriterion("teacherMark <", value, "teachermark");
            return (Criteria) this;
        }

        public Criteria andTeachermarkLessThanOrEqualTo(Double value) {
            addCriterion("teacherMark <=", value, "teachermark");
            return (Criteria) this;
        }

        public Criteria andTeachermarkIn(List<Double> values) {
            addCriterion("teacherMark in", values, "teachermark");
            return (Criteria) this;
        }

        public Criteria andTeachermarkNotIn(List<Double> values) {
            addCriterion("teacherMark not in", values, "teachermark");
            return (Criteria) this;
        }

        public Criteria andTeachermarkBetween(Double value1, Double value2) {
            addCriterion("teacherMark between", value1, value2, "teachermark");
            return (Criteria) this;
        }

        public Criteria andTeachermarkNotBetween(Double value1, Double value2) {
            addCriterion("teacherMark not between", value1, value2, "teachermark");
            return (Criteria) this;
        }

        public Criteria andMsgmarkIsNull() {
            addCriterion("msgMark is null");
            return (Criteria) this;
        }

        public Criteria andMsgmarkIsNotNull() {
            addCriterion("msgMark is not null");
            return (Criteria) this;
        }

        public Criteria andMsgmarkEqualTo(Integer value) {
            addCriterion("msgMark =", value, "msgmark");
            return (Criteria) this;
        }

        public Criteria andMsgmarkNotEqualTo(Integer value) {
            addCriterion("msgMark <>", value, "msgmark");
            return (Criteria) this;
        }

        public Criteria andMsgmarkGreaterThan(Integer value) {
            addCriterion("msgMark >", value, "msgmark");
            return (Criteria) this;
        }

        public Criteria andMsgmarkGreaterThanOrEqualTo(Integer value) {
            addCriterion("msgMark >=", value, "msgmark");
            return (Criteria) this;
        }

        public Criteria andMsgmarkLessThan(Integer value) {
            addCriterion("msgMark <", value, "msgmark");
            return (Criteria) this;
        }

        public Criteria andMsgmarkLessThanOrEqualTo(Integer value) {
            addCriterion("msgMark <=", value, "msgmark");
            return (Criteria) this;
        }

        public Criteria andMsgmarkIn(List<Integer> values) {
            addCriterion("msgMark in", values, "msgmark");
            return (Criteria) this;
        }

        public Criteria andMsgmarkNotIn(List<Integer> values) {
            addCriterion("msgMark not in", values, "msgmark");
            return (Criteria) this;
        }

        public Criteria andMsgmarkBetween(Integer value1, Integer value2) {
            addCriterion("msgMark between", value1, value2, "msgmark");
            return (Criteria) this;
        }

        public Criteria andMsgmarkNotBetween(Integer value1, Integer value2) {
            addCriterion("msgMark not between", value1, value2, "msgmark");
            return (Criteria) this;
        }

        public Criteria andAdviceIsNull() {
            addCriterion("advice is null");
            return (Criteria) this;
        }

        public Criteria andAdviceIsNotNull() {
            addCriterion("advice is not null");
            return (Criteria) this;
        }

        public Criteria andAdviceEqualTo(String value) {
            addCriterion("advice =", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceNotEqualTo(String value) {
            addCriterion("advice <>", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceGreaterThan(String value) {
            addCriterion("advice >", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceGreaterThanOrEqualTo(String value) {
            addCriterion("advice >=", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceLessThan(String value) {
            addCriterion("advice <", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceLessThanOrEqualTo(String value) {
            addCriterion("advice <=", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceLike(String value) {
            addCriterion("advice like", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceNotLike(String value) {
            addCriterion("advice not like", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceIn(List<String> values) {
            addCriterion("advice in", values, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceNotIn(List<String> values) {
            addCriterion("advice not in", values, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceBetween(String value1, String value2) {
            addCriterion("advice between", value1, value2, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceNotBetween(String value1, String value2) {
            addCriterion("advice not between", value1, value2, "advice");
            return (Criteria) this;
        }

        public Criteria andRequestidIsNull() {
            addCriterion("requestId is null");
            return (Criteria) this;
        }

        public Criteria andRequestidIsNotNull() {
            addCriterion("requestId is not null");
            return (Criteria) this;
        }

        public Criteria andRequestidEqualTo(Integer value) {
            addCriterion("requestId =", value, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidNotEqualTo(Integer value) {
            addCriterion("requestId <>", value, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidGreaterThan(Integer value) {
            addCriterion("requestId >", value, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidGreaterThanOrEqualTo(Integer value) {
            addCriterion("requestId >=", value, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidLessThan(Integer value) {
            addCriterion("requestId <", value, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidLessThanOrEqualTo(Integer value) {
            addCriterion("requestId <=", value, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidIn(List<Integer> values) {
            addCriterion("requestId in", values, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidNotIn(List<Integer> values) {
            addCriterion("requestId not in", values, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidBetween(Integer value1, Integer value2) {
            addCriterion("requestId between", value1, value2, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidNotBetween(Integer value1, Integer value2) {
            addCriterion("requestId not between", value1, value2, "requestid");
            return (Criteria) this;
        }

        public Criteria andStudentidIsNull() {
            addCriterion("studentId is null");
            return (Criteria) this;
        }

        public Criteria andStudentidIsNotNull() {
            addCriterion("studentId is not null");
            return (Criteria) this;
        }

        public Criteria andStudentidEqualTo(Integer value) {
            addCriterion("studentId =", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotEqualTo(Integer value) {
            addCriterion("studentId <>", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidGreaterThan(Integer value) {
            addCriterion("studentId >", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("studentId >=", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidLessThan(Integer value) {
            addCriterion("studentId <", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidLessThanOrEqualTo(Integer value) {
            addCriterion("studentId <=", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidIn(List<Integer> values) {
            addCriterion("studentId in", values, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotIn(List<Integer> values) {
            addCriterion("studentId not in", values, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidBetween(Integer value1, Integer value2) {
            addCriterion("studentId between", value1, value2, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotBetween(Integer value1, Integer value2) {
            addCriterion("studentId not between", value1, value2, "studentid");
            return (Criteria) this;
        }

        public Criteria andFinishIsNull() {
            addCriterion("finish is null");
            return (Criteria) this;
        }

        public Criteria andFinishIsNotNull() {
            addCriterion("finish is not null");
            return (Criteria) this;
        }

        public Criteria andFinishEqualTo(Integer value) {
            addCriterion("finish =", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishNotEqualTo(Integer value) {
            addCriterion("finish <>", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishGreaterThan(Integer value) {
            addCriterion("finish >", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishGreaterThanOrEqualTo(Integer value) {
            addCriterion("finish >=", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishLessThan(Integer value) {
            addCriterion("finish <", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishLessThanOrEqualTo(Integer value) {
            addCriterion("finish <=", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishIn(List<Integer> values) {
            addCriterion("finish in", values, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishNotIn(List<Integer> values) {
            addCriterion("finish not in", values, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishBetween(Integer value1, Integer value2) {
            addCriterion("finish between", value1, value2, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishNotBetween(Integer value1, Integer value2) {
            addCriterion("finish not between", value1, value2, "finish");
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