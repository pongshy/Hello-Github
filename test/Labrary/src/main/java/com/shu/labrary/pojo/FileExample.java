package com.shu.labrary.pojo;

import java.util.ArrayList;
import java.util.List;

public class FileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FileExample() {
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

        public Criteria andFileidIsNull() {
            addCriterion("fileId is null");
            return (Criteria) this;
        }

        public Criteria andFileidIsNotNull() {
            addCriterion("fileId is not null");
            return (Criteria) this;
        }

        public Criteria andFileidEqualTo(Integer value) {
            addCriterion("fileId =", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidNotEqualTo(Integer value) {
            addCriterion("fileId <>", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidGreaterThan(Integer value) {
            addCriterion("fileId >", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fileId >=", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidLessThan(Integer value) {
            addCriterion("fileId <", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidLessThanOrEqualTo(Integer value) {
            addCriterion("fileId <=", value, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidIn(List<Integer> values) {
            addCriterion("fileId in", values, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidNotIn(List<Integer> values) {
            addCriterion("fileId not in", values, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidBetween(Integer value1, Integer value2) {
            addCriterion("fileId between", value1, value2, "fileid");
            return (Criteria) this;
        }

        public Criteria andFileidNotBetween(Integer value1, Integer value2) {
            addCriterion("fileId not between", value1, value2, "fileid");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNull() {
            addCriterion("filename is null");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNotNull() {
            addCriterion("filename is not null");
            return (Criteria) this;
        }

        public Criteria andFilenameEqualTo(String value) {
            addCriterion("filename =", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotEqualTo(String value) {
            addCriterion("filename <>", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThan(String value) {
            addCriterion("filename >", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThanOrEqualTo(String value) {
            addCriterion("filename >=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThan(String value) {
            addCriterion("filename <", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThanOrEqualTo(String value) {
            addCriterion("filename <=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLike(String value) {
            addCriterion("filename like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotLike(String value) {
            addCriterion("filename not like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameIn(List<String> values) {
            addCriterion("filename in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotIn(List<String> values) {
            addCriterion("filename not in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameBetween(String value1, String value2) {
            addCriterion("filename between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotBetween(String value1, String value2) {
            addCriterion("filename not between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilesrcIsNull() {
            addCriterion("filesrc is null");
            return (Criteria) this;
        }

        public Criteria andFilesrcIsNotNull() {
            addCriterion("filesrc is not null");
            return (Criteria) this;
        }

        public Criteria andFilesrcEqualTo(String value) {
            addCriterion("filesrc =", value, "filesrc");
            return (Criteria) this;
        }

        public Criteria andFilesrcNotEqualTo(String value) {
            addCriterion("filesrc <>", value, "filesrc");
            return (Criteria) this;
        }

        public Criteria andFilesrcGreaterThan(String value) {
            addCriterion("filesrc >", value, "filesrc");
            return (Criteria) this;
        }

        public Criteria andFilesrcGreaterThanOrEqualTo(String value) {
            addCriterion("filesrc >=", value, "filesrc");
            return (Criteria) this;
        }

        public Criteria andFilesrcLessThan(String value) {
            addCriterion("filesrc <", value, "filesrc");
            return (Criteria) this;
        }

        public Criteria andFilesrcLessThanOrEqualTo(String value) {
            addCriterion("filesrc <=", value, "filesrc");
            return (Criteria) this;
        }

        public Criteria andFilesrcLike(String value) {
            addCriterion("filesrc like", value, "filesrc");
            return (Criteria) this;
        }

        public Criteria andFilesrcNotLike(String value) {
            addCriterion("filesrc not like", value, "filesrc");
            return (Criteria) this;
        }

        public Criteria andFilesrcIn(List<String> values) {
            addCriterion("filesrc in", values, "filesrc");
            return (Criteria) this;
        }

        public Criteria andFilesrcNotIn(List<String> values) {
            addCriterion("filesrc not in", values, "filesrc");
            return (Criteria) this;
        }

        public Criteria andFilesrcBetween(String value1, String value2) {
            addCriterion("filesrc between", value1, value2, "filesrc");
            return (Criteria) this;
        }

        public Criteria andFilesrcNotBetween(String value1, String value2) {
            addCriterion("filesrc not between", value1, value2, "filesrc");
            return (Criteria) this;
        }

        public Criteria andFiletypeIsNull() {
            addCriterion("filetype is null");
            return (Criteria) this;
        }

        public Criteria andFiletypeIsNotNull() {
            addCriterion("filetype is not null");
            return (Criteria) this;
        }

        public Criteria andFiletypeEqualTo(String value) {
            addCriterion("filetype =", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeNotEqualTo(String value) {
            addCriterion("filetype <>", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeGreaterThan(String value) {
            addCriterion("filetype >", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeGreaterThanOrEqualTo(String value) {
            addCriterion("filetype >=", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeLessThan(String value) {
            addCriterion("filetype <", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeLessThanOrEqualTo(String value) {
            addCriterion("filetype <=", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeLike(String value) {
            addCriterion("filetype like", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeNotLike(String value) {
            addCriterion("filetype not like", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeIn(List<String> values) {
            addCriterion("filetype in", values, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeNotIn(List<String> values) {
            addCriterion("filetype not in", values, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeBetween(String value1, String value2) {
            addCriterion("filetype between", value1, value2, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeNotBetween(String value1, String value2) {
            addCriterion("filetype not between", value1, value2, "filetype");
            return (Criteria) this;
        }

        public Criteria andFilestatusIsNull() {
            addCriterion("filestatus is null");
            return (Criteria) this;
        }

        public Criteria andFilestatusIsNotNull() {
            addCriterion("filestatus is not null");
            return (Criteria) this;
        }

        public Criteria andFilestatusEqualTo(String value) {
            addCriterion("filestatus =", value, "filestatus");
            return (Criteria) this;
        }

        public Criteria andFilestatusNotEqualTo(String value) {
            addCriterion("filestatus <>", value, "filestatus");
            return (Criteria) this;
        }

        public Criteria andFilestatusGreaterThan(String value) {
            addCriterion("filestatus >", value, "filestatus");
            return (Criteria) this;
        }

        public Criteria andFilestatusGreaterThanOrEqualTo(String value) {
            addCriterion("filestatus >=", value, "filestatus");
            return (Criteria) this;
        }

        public Criteria andFilestatusLessThan(String value) {
            addCriterion("filestatus <", value, "filestatus");
            return (Criteria) this;
        }

        public Criteria andFilestatusLessThanOrEqualTo(String value) {
            addCriterion("filestatus <=", value, "filestatus");
            return (Criteria) this;
        }

        public Criteria andFilestatusLike(String value) {
            addCriterion("filestatus like", value, "filestatus");
            return (Criteria) this;
        }

        public Criteria andFilestatusNotLike(String value) {
            addCriterion("filestatus not like", value, "filestatus");
            return (Criteria) this;
        }

        public Criteria andFilestatusIn(List<String> values) {
            addCriterion("filestatus in", values, "filestatus");
            return (Criteria) this;
        }

        public Criteria andFilestatusNotIn(List<String> values) {
            addCriterion("filestatus not in", values, "filestatus");
            return (Criteria) this;
        }

        public Criteria andFilestatusBetween(String value1, String value2) {
            addCriterion("filestatus between", value1, value2, "filestatus");
            return (Criteria) this;
        }

        public Criteria andFilestatusNotBetween(String value1, String value2) {
            addCriterion("filestatus not between", value1, value2, "filestatus");
            return (Criteria) this;
        }

        public Criteria andFilemoreIsNull() {
            addCriterion("filemore is null");
            return (Criteria) this;
        }

        public Criteria andFilemoreIsNotNull() {
            addCriterion("filemore is not null");
            return (Criteria) this;
        }

        public Criteria andFilemoreEqualTo(String value) {
            addCriterion("filemore =", value, "filemore");
            return (Criteria) this;
        }

        public Criteria andFilemoreNotEqualTo(String value) {
            addCriterion("filemore <>", value, "filemore");
            return (Criteria) this;
        }

        public Criteria andFilemoreGreaterThan(String value) {
            addCriterion("filemore >", value, "filemore");
            return (Criteria) this;
        }

        public Criteria andFilemoreGreaterThanOrEqualTo(String value) {
            addCriterion("filemore >=", value, "filemore");
            return (Criteria) this;
        }

        public Criteria andFilemoreLessThan(String value) {
            addCriterion("filemore <", value, "filemore");
            return (Criteria) this;
        }

        public Criteria andFilemoreLessThanOrEqualTo(String value) {
            addCriterion("filemore <=", value, "filemore");
            return (Criteria) this;
        }

        public Criteria andFilemoreLike(String value) {
            addCriterion("filemore like", value, "filemore");
            return (Criteria) this;
        }

        public Criteria andFilemoreNotLike(String value) {
            addCriterion("filemore not like", value, "filemore");
            return (Criteria) this;
        }

        public Criteria andFilemoreIn(List<String> values) {
            addCriterion("filemore in", values, "filemore");
            return (Criteria) this;
        }

        public Criteria andFilemoreNotIn(List<String> values) {
            addCriterion("filemore not in", values, "filemore");
            return (Criteria) this;
        }

        public Criteria andFilemoreBetween(String value1, String value2) {
            addCriterion("filemore between", value1, value2, "filemore");
            return (Criteria) this;
        }

        public Criteria andFilemoreNotBetween(String value1, String value2) {
            addCriterion("filemore not between", value1, value2, "filemore");
            return (Criteria) this;
        }

        public Criteria andNewsidIsNull() {
            addCriterion("newsid is null");
            return (Criteria) this;
        }

        public Criteria andNewsidIsNotNull() {
            addCriterion("newsid is not null");
            return (Criteria) this;
        }

        public Criteria andNewsidEqualTo(Integer value) {
            addCriterion("newsid =", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidNotEqualTo(Integer value) {
            addCriterion("newsid <>", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidGreaterThan(Integer value) {
            addCriterion("newsid >", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("newsid >=", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidLessThan(Integer value) {
            addCriterion("newsid <", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidLessThanOrEqualTo(Integer value) {
            addCriterion("newsid <=", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidIn(List<Integer> values) {
            addCriterion("newsid in", values, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidNotIn(List<Integer> values) {
            addCriterion("newsid not in", values, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidBetween(Integer value1, Integer value2) {
            addCriterion("newsid between", value1, value2, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidNotBetween(Integer value1, Integer value2) {
            addCriterion("newsid not between", value1, value2, "newsid");
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