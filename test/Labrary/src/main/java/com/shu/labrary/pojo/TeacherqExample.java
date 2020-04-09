package com.shu.labrary.pojo;

import java.util.ArrayList;
import java.util.List;

public class TeacherqExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeacherqExample() {
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

        public Criteria andAbsentIsNull() {
            addCriterion("absent is null");
            return (Criteria) this;
        }

        public Criteria andAbsentIsNotNull() {
            addCriterion("absent is not null");
            return (Criteria) this;
        }

        public Criteria andAbsentEqualTo(Integer value) {
            addCriterion("absent =", value, "absent");
            return (Criteria) this;
        }

        public Criteria andAbsentNotEqualTo(Integer value) {
            addCriterion("absent <>", value, "absent");
            return (Criteria) this;
        }

        public Criteria andAbsentGreaterThan(Integer value) {
            addCriterion("absent >", value, "absent");
            return (Criteria) this;
        }

        public Criteria andAbsentGreaterThanOrEqualTo(Integer value) {
            addCriterion("absent >=", value, "absent");
            return (Criteria) this;
        }

        public Criteria andAbsentLessThan(Integer value) {
            addCriterion("absent <", value, "absent");
            return (Criteria) this;
        }

        public Criteria andAbsentLessThanOrEqualTo(Integer value) {
            addCriterion("absent <=", value, "absent");
            return (Criteria) this;
        }

        public Criteria andAbsentIn(List<Integer> values) {
            addCriterion("absent in", values, "absent");
            return (Criteria) this;
        }

        public Criteria andAbsentNotIn(List<Integer> values) {
            addCriterion("absent not in", values, "absent");
            return (Criteria) this;
        }

        public Criteria andAbsentBetween(Integer value1, Integer value2) {
            addCriterion("absent between", value1, value2, "absent");
            return (Criteria) this;
        }

        public Criteria andAbsentNotBetween(Integer value1, Integer value2) {
            addCriterion("absent not between", value1, value2, "absent");
            return (Criteria) this;
        }

        public Criteria andStudentmarkIsNull() {
            addCriterion("studentMark is null");
            return (Criteria) this;
        }

        public Criteria andStudentmarkIsNotNull() {
            addCriterion("studentMark is not null");
            return (Criteria) this;
        }

        public Criteria andStudentmarkEqualTo(Double value) {
            addCriterion("studentMark =", value, "studentmark");
            return (Criteria) this;
        }

        public Criteria andStudentmarkNotEqualTo(Double value) {
            addCriterion("studentMark <>", value, "studentmark");
            return (Criteria) this;
        }

        public Criteria andStudentmarkGreaterThan(Double value) {
            addCriterion("studentMark >", value, "studentmark");
            return (Criteria) this;
        }

        public Criteria andStudentmarkGreaterThanOrEqualTo(Double value) {
            addCriterion("studentMark >=", value, "studentmark");
            return (Criteria) this;
        }

        public Criteria andStudentmarkLessThan(Double value) {
            addCriterion("studentMark <", value, "studentmark");
            return (Criteria) this;
        }

        public Criteria andStudentmarkLessThanOrEqualTo(Double value) {
            addCriterion("studentMark <=", value, "studentmark");
            return (Criteria) this;
        }

        public Criteria andStudentmarkIn(List<Double> values) {
            addCriterion("studentMark in", values, "studentmark");
            return (Criteria) this;
        }

        public Criteria andStudentmarkNotIn(List<Double> values) {
            addCriterion("studentMark not in", values, "studentmark");
            return (Criteria) this;
        }

        public Criteria andStudentmarkBetween(Double value1, Double value2) {
            addCriterion("studentMark between", value1, value2, "studentmark");
            return (Criteria) this;
        }

        public Criteria andStudentmarkNotBetween(Double value1, Double value2) {
            addCriterion("studentMark not between", value1, value2, "studentmark");
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

        public Criteria andRequsetidIsNull() {
            addCriterion("requsetId is null");
            return (Criteria) this;
        }

        public Criteria andRequsetidIsNotNull() {
            addCriterion("requsetId is not null");
            return (Criteria) this;
        }

        public Criteria andRequsetidEqualTo(Integer value) {
            addCriterion("requsetId =", value, "requsetid");
            return (Criteria) this;
        }

        public Criteria andRequsetidNotEqualTo(Integer value) {
            addCriterion("requsetId <>", value, "requsetid");
            return (Criteria) this;
        }

        public Criteria andRequsetidGreaterThan(Integer value) {
            addCriterion("requsetId >", value, "requsetid");
            return (Criteria) this;
        }

        public Criteria andRequsetidGreaterThanOrEqualTo(Integer value) {
            addCriterion("requsetId >=", value, "requsetid");
            return (Criteria) this;
        }

        public Criteria andRequsetidLessThan(Integer value) {
            addCriterion("requsetId <", value, "requsetid");
            return (Criteria) this;
        }

        public Criteria andRequsetidLessThanOrEqualTo(Integer value) {
            addCriterion("requsetId <=", value, "requsetid");
            return (Criteria) this;
        }

        public Criteria andRequsetidIn(List<Integer> values) {
            addCriterion("requsetId in", values, "requsetid");
            return (Criteria) this;
        }

        public Criteria andRequsetidNotIn(List<Integer> values) {
            addCriterion("requsetId not in", values, "requsetid");
            return (Criteria) this;
        }

        public Criteria andRequsetidBetween(Integer value1, Integer value2) {
            addCriterion("requsetId between", value1, value2, "requsetid");
            return (Criteria) this;
        }

        public Criteria andRequsetidNotBetween(Integer value1, Integer value2) {
            addCriterion("requsetId not between", value1, value2, "requsetid");
            return (Criteria) this;
        }

        public Criteria andTeacheridIsNull() {
            addCriterion("teacherId is null");
            return (Criteria) this;
        }

        public Criteria andTeacheridIsNotNull() {
            addCriterion("teacherId is not null");
            return (Criteria) this;
        }

        public Criteria andTeacheridEqualTo(Integer value) {
            addCriterion("teacherId =", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotEqualTo(Integer value) {
            addCriterion("teacherId <>", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridGreaterThan(Integer value) {
            addCriterion("teacherId >", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridGreaterThanOrEqualTo(Integer value) {
            addCriterion("teacherId >=", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridLessThan(Integer value) {
            addCriterion("teacherId <", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridLessThanOrEqualTo(Integer value) {
            addCriterion("teacherId <=", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridIn(List<Integer> values) {
            addCriterion("teacherId in", values, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotIn(List<Integer> values) {
            addCriterion("teacherId not in", values, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridBetween(Integer value1, Integer value2) {
            addCriterion("teacherId between", value1, value2, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotBetween(Integer value1, Integer value2) {
            addCriterion("teacherId not between", value1, value2, "teacherid");
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