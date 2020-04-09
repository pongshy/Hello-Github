package com.shu.labrary.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NewsExample() {
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

        public Criteria andNewsidIsNull() {
            addCriterion("newsId is null");
            return (Criteria) this;
        }

        public Criteria andNewsidIsNotNull() {
            addCriterion("newsId is not null");
            return (Criteria) this;
        }

        public Criteria andNewsidEqualTo(Integer value) {
            addCriterion("newsId =", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidNotEqualTo(Integer value) {
            addCriterion("newsId <>", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidGreaterThan(Integer value) {
            addCriterion("newsId >", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("newsId >=", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidLessThan(Integer value) {
            addCriterion("newsId <", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidLessThanOrEqualTo(Integer value) {
            addCriterion("newsId <=", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidIn(List<Integer> values) {
            addCriterion("newsId in", values, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidNotIn(List<Integer> values) {
            addCriterion("newsId not in", values, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidBetween(Integer value1, Integer value2) {
            addCriterion("newsId between", value1, value2, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidNotBetween(Integer value1, Integer value2) {
            addCriterion("newsId not between", value1, value2, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsnameIsNull() {
            addCriterion("newsname is null");
            return (Criteria) this;
        }

        public Criteria andNewsnameIsNotNull() {
            addCriterion("newsname is not null");
            return (Criteria) this;
        }

        public Criteria andNewsnameEqualTo(String value) {
            addCriterion("newsname =", value, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameNotEqualTo(String value) {
            addCriterion("newsname <>", value, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameGreaterThan(String value) {
            addCriterion("newsname >", value, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameGreaterThanOrEqualTo(String value) {
            addCriterion("newsname >=", value, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameLessThan(String value) {
            addCriterion("newsname <", value, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameLessThanOrEqualTo(String value) {
            addCriterion("newsname <=", value, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameLike(String value) {
            addCriterion("newsname like", value, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameNotLike(String value) {
            addCriterion("newsname not like", value, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameIn(List<String> values) {
            addCriterion("newsname in", values, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameNotIn(List<String> values) {
            addCriterion("newsname not in", values, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameBetween(String value1, String value2) {
            addCriterion("newsname between", value1, value2, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewsnameNotBetween(String value1, String value2) {
            addCriterion("newsname not between", value1, value2, "newsname");
            return (Criteria) this;
        }

        public Criteria andNewstypeIsNull() {
            addCriterion("newstype is null");
            return (Criteria) this;
        }

        public Criteria andNewstypeIsNotNull() {
            addCriterion("newstype is not null");
            return (Criteria) this;
        }

        public Criteria andNewstypeEqualTo(String value) {
            addCriterion("newstype =", value, "newstype");
            return (Criteria) this;
        }

        public Criteria andNewstypeNotEqualTo(String value) {
            addCriterion("newstype <>", value, "newstype");
            return (Criteria) this;
        }

        public Criteria andNewstypeGreaterThan(String value) {
            addCriterion("newstype >", value, "newstype");
            return (Criteria) this;
        }

        public Criteria andNewstypeGreaterThanOrEqualTo(String value) {
            addCriterion("newstype >=", value, "newstype");
            return (Criteria) this;
        }

        public Criteria andNewstypeLessThan(String value) {
            addCriterion("newstype <", value, "newstype");
            return (Criteria) this;
        }

        public Criteria andNewstypeLessThanOrEqualTo(String value) {
            addCriterion("newstype <=", value, "newstype");
            return (Criteria) this;
        }

        public Criteria andNewstypeLike(String value) {
            addCriterion("newstype like", value, "newstype");
            return (Criteria) this;
        }

        public Criteria andNewstypeNotLike(String value) {
            addCriterion("newstype not like", value, "newstype");
            return (Criteria) this;
        }

        public Criteria andNewstypeIn(List<String> values) {
            addCriterion("newstype in", values, "newstype");
            return (Criteria) this;
        }

        public Criteria andNewstypeNotIn(List<String> values) {
            addCriterion("newstype not in", values, "newstype");
            return (Criteria) this;
        }

        public Criteria andNewstypeBetween(String value1, String value2) {
            addCriterion("newstype between", value1, value2, "newstype");
            return (Criteria) this;
        }

        public Criteria andNewstypeNotBetween(String value1, String value2) {
            addCriterion("newstype not between", value1, value2, "newstype");
            return (Criteria) this;
        }

        public Criteria andNewsstatusIsNull() {
            addCriterion("newsstatus is null");
            return (Criteria) this;
        }

        public Criteria andNewsstatusIsNotNull() {
            addCriterion("newsstatus is not null");
            return (Criteria) this;
        }

        public Criteria andNewsstatusEqualTo(String value) {
            addCriterion("newsstatus =", value, "newsstatus");
            return (Criteria) this;
        }

        public Criteria andNewsstatusNotEqualTo(String value) {
            addCriterion("newsstatus <>", value, "newsstatus");
            return (Criteria) this;
        }

        public Criteria andNewsstatusGreaterThan(String value) {
            addCriterion("newsstatus >", value, "newsstatus");
            return (Criteria) this;
        }

        public Criteria andNewsstatusGreaterThanOrEqualTo(String value) {
            addCriterion("newsstatus >=", value, "newsstatus");
            return (Criteria) this;
        }

        public Criteria andNewsstatusLessThan(String value) {
            addCriterion("newsstatus <", value, "newsstatus");
            return (Criteria) this;
        }

        public Criteria andNewsstatusLessThanOrEqualTo(String value) {
            addCriterion("newsstatus <=", value, "newsstatus");
            return (Criteria) this;
        }

        public Criteria andNewsstatusLike(String value) {
            addCriterion("newsstatus like", value, "newsstatus");
            return (Criteria) this;
        }

        public Criteria andNewsstatusNotLike(String value) {
            addCriterion("newsstatus not like", value, "newsstatus");
            return (Criteria) this;
        }

        public Criteria andNewsstatusIn(List<String> values) {
            addCriterion("newsstatus in", values, "newsstatus");
            return (Criteria) this;
        }

        public Criteria andNewsstatusNotIn(List<String> values) {
            addCriterion("newsstatus not in", values, "newsstatus");
            return (Criteria) this;
        }

        public Criteria andNewsstatusBetween(String value1, String value2) {
            addCriterion("newsstatus between", value1, value2, "newsstatus");
            return (Criteria) this;
        }

        public Criteria andNewsstatusNotBetween(String value1, String value2) {
            addCriterion("newsstatus not between", value1, value2, "newsstatus");
            return (Criteria) this;
        }

        public Criteria andNewsauthIsNull() {
            addCriterion("newsauth is null");
            return (Criteria) this;
        }

        public Criteria andNewsauthIsNotNull() {
            addCriterion("newsauth is not null");
            return (Criteria) this;
        }

        public Criteria andNewsauthEqualTo(String value) {
            addCriterion("newsauth =", value, "newsauth");
            return (Criteria) this;
        }

        public Criteria andNewsauthNotEqualTo(String value) {
            addCriterion("newsauth <>", value, "newsauth");
            return (Criteria) this;
        }

        public Criteria andNewsauthGreaterThan(String value) {
            addCriterion("newsauth >", value, "newsauth");
            return (Criteria) this;
        }

        public Criteria andNewsauthGreaterThanOrEqualTo(String value) {
            addCriterion("newsauth >=", value, "newsauth");
            return (Criteria) this;
        }

        public Criteria andNewsauthLessThan(String value) {
            addCriterion("newsauth <", value, "newsauth");
            return (Criteria) this;
        }

        public Criteria andNewsauthLessThanOrEqualTo(String value) {
            addCriterion("newsauth <=", value, "newsauth");
            return (Criteria) this;
        }

        public Criteria andNewsauthLike(String value) {
            addCriterion("newsauth like", value, "newsauth");
            return (Criteria) this;
        }

        public Criteria andNewsauthNotLike(String value) {
            addCriterion("newsauth not like", value, "newsauth");
            return (Criteria) this;
        }

        public Criteria andNewsauthIn(List<String> values) {
            addCriterion("newsauth in", values, "newsauth");
            return (Criteria) this;
        }

        public Criteria andNewsauthNotIn(List<String> values) {
            addCriterion("newsauth not in", values, "newsauth");
            return (Criteria) this;
        }

        public Criteria andNewsauthBetween(String value1, String value2) {
            addCriterion("newsauth between", value1, value2, "newsauth");
            return (Criteria) this;
        }

        public Criteria andNewsauthNotBetween(String value1, String value2) {
            addCriterion("newsauth not between", value1, value2, "newsauth");
            return (Criteria) this;
        }

        public Criteria andNewstimeIsNull() {
            addCriterion("newstime is null");
            return (Criteria) this;
        }

        public Criteria andNewstimeIsNotNull() {
            addCriterion("newstime is not null");
            return (Criteria) this;
        }

        public Criteria andNewstimeEqualTo(Date value) {
            addCriterion("newstime =", value, "newstime");
            return (Criteria) this;
        }

        public Criteria andNewstimeNotEqualTo(Date value) {
            addCriterion("newstime <>", value, "newstime");
            return (Criteria) this;
        }

        public Criteria andNewstimeGreaterThan(Date value) {
            addCriterion("newstime >", value, "newstime");
            return (Criteria) this;
        }

        public Criteria andNewstimeGreaterThanOrEqualTo(Date value) {
            addCriterion("newstime >=", value, "newstime");
            return (Criteria) this;
        }

        public Criteria andNewstimeLessThan(Date value) {
            addCriterion("newstime <", value, "newstime");
            return (Criteria) this;
        }

        public Criteria andNewstimeLessThanOrEqualTo(Date value) {
            addCriterion("newstime <=", value, "newstime");
            return (Criteria) this;
        }

        public Criteria andNewstimeIn(List<Date> values) {
            addCriterion("newstime in", values, "newstime");
            return (Criteria) this;
        }

        public Criteria andNewstimeNotIn(List<Date> values) {
            addCriterion("newstime not in", values, "newstime");
            return (Criteria) this;
        }

        public Criteria andNewstimeBetween(Date value1, Date value2) {
            addCriterion("newstime between", value1, value2, "newstime");
            return (Criteria) this;
        }

        public Criteria andNewstimeNotBetween(Date value1, Date value2) {
            addCriterion("newstime not between", value1, value2, "newstime");
            return (Criteria) this;
        }

        public Criteria andNewslabelIsNull() {
            addCriterion("newslabel is null");
            return (Criteria) this;
        }

        public Criteria andNewslabelIsNotNull() {
            addCriterion("newslabel is not null");
            return (Criteria) this;
        }

        public Criteria andNewslabelEqualTo(String value) {
            addCriterion("newslabel =", value, "newslabel");
            return (Criteria) this;
        }

        public Criteria andNewslabelNotEqualTo(String value) {
            addCriterion("newslabel <>", value, "newslabel");
            return (Criteria) this;
        }

        public Criteria andNewslabelGreaterThan(String value) {
            addCriterion("newslabel >", value, "newslabel");
            return (Criteria) this;
        }

        public Criteria andNewslabelGreaterThanOrEqualTo(String value) {
            addCriterion("newslabel >=", value, "newslabel");
            return (Criteria) this;
        }

        public Criteria andNewslabelLessThan(String value) {
            addCriterion("newslabel <", value, "newslabel");
            return (Criteria) this;
        }

        public Criteria andNewslabelLessThanOrEqualTo(String value) {
            addCriterion("newslabel <=", value, "newslabel");
            return (Criteria) this;
        }

        public Criteria andNewslabelLike(String value) {
            addCriterion("newslabel like", value, "newslabel");
            return (Criteria) this;
        }

        public Criteria andNewslabelNotLike(String value) {
            addCriterion("newslabel not like", value, "newslabel");
            return (Criteria) this;
        }

        public Criteria andNewslabelIn(List<String> values) {
            addCriterion("newslabel in", values, "newslabel");
            return (Criteria) this;
        }

        public Criteria andNewslabelNotIn(List<String> values) {
            addCriterion("newslabel not in", values, "newslabel");
            return (Criteria) this;
        }

        public Criteria andNewslabelBetween(String value1, String value2) {
            addCriterion("newslabel between", value1, value2, "newslabel");
            return (Criteria) this;
        }

        public Criteria andNewslabelNotBetween(String value1, String value2) {
            addCriterion("newslabel not between", value1, value2, "newslabel");
            return (Criteria) this;
        }

        public Criteria andHavepictureIsNull() {
            addCriterion("havepicture is null");
            return (Criteria) this;
        }

        public Criteria andHavepictureIsNotNull() {
            addCriterion("havepicture is not null");
            return (Criteria) this;
        }

        public Criteria andHavepictureEqualTo(Integer value) {
            addCriterion("havepicture =", value, "havepicture");
            return (Criteria) this;
        }

        public Criteria andHavepictureNotEqualTo(Integer value) {
            addCriterion("havepicture <>", value, "havepicture");
            return (Criteria) this;
        }

        public Criteria andHavepictureGreaterThan(Integer value) {
            addCriterion("havepicture >", value, "havepicture");
            return (Criteria) this;
        }

        public Criteria andHavepictureGreaterThanOrEqualTo(Integer value) {
            addCriterion("havepicture >=", value, "havepicture");
            return (Criteria) this;
        }

        public Criteria andHavepictureLessThan(Integer value) {
            addCriterion("havepicture <", value, "havepicture");
            return (Criteria) this;
        }

        public Criteria andHavepictureLessThanOrEqualTo(Integer value) {
            addCriterion("havepicture <=", value, "havepicture");
            return (Criteria) this;
        }

        public Criteria andHavepictureIn(List<Integer> values) {
            addCriterion("havepicture in", values, "havepicture");
            return (Criteria) this;
        }

        public Criteria andHavepictureNotIn(List<Integer> values) {
            addCriterion("havepicture not in", values, "havepicture");
            return (Criteria) this;
        }

        public Criteria andHavepictureBetween(Integer value1, Integer value2) {
            addCriterion("havepicture between", value1, value2, "havepicture");
            return (Criteria) this;
        }

        public Criteria andHavepictureNotBetween(Integer value1, Integer value2) {
            addCriterion("havepicture not between", value1, value2, "havepicture");
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