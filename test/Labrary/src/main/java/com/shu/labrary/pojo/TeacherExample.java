package com.shu.labrary.pojo;

import java.util.ArrayList;
import java.util.List;

public class TeacherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeacherExample() {
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

        public Criteria andTeachernameIsNull() {
            addCriterion("teachername is null");
            return (Criteria) this;
        }

        public Criteria andTeachernameIsNotNull() {
            addCriterion("teachername is not null");
            return (Criteria) this;
        }

        public Criteria andTeachernameEqualTo(String value) {
            addCriterion("teachername =", value, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameNotEqualTo(String value) {
            addCriterion("teachername <>", value, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameGreaterThan(String value) {
            addCriterion("teachername >", value, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameGreaterThanOrEqualTo(String value) {
            addCriterion("teachername >=", value, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameLessThan(String value) {
            addCriterion("teachername <", value, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameLessThanOrEqualTo(String value) {
            addCriterion("teachername <=", value, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameLike(String value) {
            addCriterion("teachername like", value, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameNotLike(String value) {
            addCriterion("teachername not like", value, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameIn(List<String> values) {
            addCriterion("teachername in", values, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameNotIn(List<String> values) {
            addCriterion("teachername not in", values, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameBetween(String value1, String value2) {
            addCriterion("teachername between", value1, value2, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameNotBetween(String value1, String value2) {
            addCriterion("teachername not between", value1, value2, "teachername");
            return (Criteria) this;
        }

        public Criteria andDutyIsNull() {
            addCriterion("duty is null");
            return (Criteria) this;
        }

        public Criteria andDutyIsNotNull() {
            addCriterion("duty is not null");
            return (Criteria) this;
        }

        public Criteria andDutyEqualTo(String value) {
            addCriterion("duty =", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotEqualTo(String value) {
            addCriterion("duty <>", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyGreaterThan(String value) {
            addCriterion("duty >", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyGreaterThanOrEqualTo(String value) {
            addCriterion("duty >=", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyLessThan(String value) {
            addCriterion("duty <", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyLessThanOrEqualTo(String value) {
            addCriterion("duty <=", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyLike(String value) {
            addCriterion("duty like", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotLike(String value) {
            addCriterion("duty not like", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyIn(List<String> values) {
            addCriterion("duty in", values, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotIn(List<String> values) {
            addCriterion("duty not in", values, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyBetween(String value1, String value2) {
            addCriterion("duty between", value1, value2, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotBetween(String value1, String value2) {
            addCriterion("duty not between", value1, value2, "duty");
            return (Criteria) this;
        }

        public Criteria andOrganizationIsNull() {
            addCriterion("organization is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationIsNotNull() {
            addCriterion("organization is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationEqualTo(String value) {
            addCriterion("organization =", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationNotEqualTo(String value) {
            addCriterion("organization <>", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationGreaterThan(String value) {
            addCriterion("organization >", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationGreaterThanOrEqualTo(String value) {
            addCriterion("organization >=", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationLessThan(String value) {
            addCriterion("organization <", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationLessThanOrEqualTo(String value) {
            addCriterion("organization <=", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationLike(String value) {
            addCriterion("organization like", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationNotLike(String value) {
            addCriterion("organization not like", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationIn(List<String> values) {
            addCriterion("organization in", values, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationNotIn(List<String> values) {
            addCriterion("organization not in", values, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationBetween(String value1, String value2) {
            addCriterion("organization between", value1, value2, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationNotBetween(String value1, String value2) {
            addCriterion("organization not between", value1, value2, "organization");
            return (Criteria) this;
        }

        public Criteria andImagesrcIsNull() {
            addCriterion("imagesrc is null");
            return (Criteria) this;
        }

        public Criteria andImagesrcIsNotNull() {
            addCriterion("imagesrc is not null");
            return (Criteria) this;
        }

        public Criteria andImagesrcEqualTo(String value) {
            addCriterion("imagesrc =", value, "imagesrc");
            return (Criteria) this;
        }

        public Criteria andImagesrcNotEqualTo(String value) {
            addCriterion("imagesrc <>", value, "imagesrc");
            return (Criteria) this;
        }

        public Criteria andImagesrcGreaterThan(String value) {
            addCriterion("imagesrc >", value, "imagesrc");
            return (Criteria) this;
        }

        public Criteria andImagesrcGreaterThanOrEqualTo(String value) {
            addCriterion("imagesrc >=", value, "imagesrc");
            return (Criteria) this;
        }

        public Criteria andImagesrcLessThan(String value) {
            addCriterion("imagesrc <", value, "imagesrc");
            return (Criteria) this;
        }

        public Criteria andImagesrcLessThanOrEqualTo(String value) {
            addCriterion("imagesrc <=", value, "imagesrc");
            return (Criteria) this;
        }

        public Criteria andImagesrcLike(String value) {
            addCriterion("imagesrc like", value, "imagesrc");
            return (Criteria) this;
        }

        public Criteria andImagesrcNotLike(String value) {
            addCriterion("imagesrc not like", value, "imagesrc");
            return (Criteria) this;
        }

        public Criteria andImagesrcIn(List<String> values) {
            addCriterion("imagesrc in", values, "imagesrc");
            return (Criteria) this;
        }

        public Criteria andImagesrcNotIn(List<String> values) {
            addCriterion("imagesrc not in", values, "imagesrc");
            return (Criteria) this;
        }

        public Criteria andImagesrcBetween(String value1, String value2) {
            addCriterion("imagesrc between", value1, value2, "imagesrc");
            return (Criteria) this;
        }

        public Criteria andImagesrcNotBetween(String value1, String value2) {
            addCriterion("imagesrc not between", value1, value2, "imagesrc");
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

        public Criteria andOnlineIsNull() {
            addCriterion("online is null");
            return (Criteria) this;
        }

        public Criteria andOnlineIsNotNull() {
            addCriterion("online is not null");
            return (Criteria) this;
        }

        public Criteria andOnlineEqualTo(Integer value) {
            addCriterion("online =", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineNotEqualTo(Integer value) {
            addCriterion("online <>", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineGreaterThan(Integer value) {
            addCriterion("online >", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineGreaterThanOrEqualTo(Integer value) {
            addCriterion("online >=", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineLessThan(Integer value) {
            addCriterion("online <", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineLessThanOrEqualTo(Integer value) {
            addCriterion("online <=", value, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineIn(List<Integer> values) {
            addCriterion("online in", values, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineNotIn(List<Integer> values) {
            addCriterion("online not in", values, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineBetween(Integer value1, Integer value2) {
            addCriterion("online between", value1, value2, "online");
            return (Criteria) this;
        }

        public Criteria andOnlineNotBetween(Integer value1, Integer value2) {
            addCriterion("online not between", value1, value2, "online");
            return (Criteria) this;
        }

        public Criteria andBuildingIsNull() {
            addCriterion("building is null");
            return (Criteria) this;
        }

        public Criteria andBuildingIsNotNull() {
            addCriterion("building is not null");
            return (Criteria) this;
        }

        public Criteria andBuildingEqualTo(String value) {
            addCriterion("building =", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingNotEqualTo(String value) {
            addCriterion("building <>", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingGreaterThan(String value) {
            addCriterion("building >", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingGreaterThanOrEqualTo(String value) {
            addCriterion("building >=", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingLessThan(String value) {
            addCriterion("building <", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingLessThanOrEqualTo(String value) {
            addCriterion("building <=", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingLike(String value) {
            addCriterion("building like", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingNotLike(String value) {
            addCriterion("building not like", value, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingIn(List<String> values) {
            addCriterion("building in", values, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingNotIn(List<String> values) {
            addCriterion("building not in", values, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingBetween(String value1, String value2) {
            addCriterion("building between", value1, value2, "building");
            return (Criteria) this;
        }

        public Criteria andBuildingNotBetween(String value1, String value2) {
            addCriterion("building not between", value1, value2, "building");
            return (Criteria) this;
        }

        public Criteria andCampusIsNull() {
            addCriterion("campus is null");
            return (Criteria) this;
        }

        public Criteria andCampusIsNotNull() {
            addCriterion("campus is not null");
            return (Criteria) this;
        }

        public Criteria andCampusEqualTo(String value) {
            addCriterion("campus =", value, "campus");
            return (Criteria) this;
        }

        public Criteria andCampusNotEqualTo(String value) {
            addCriterion("campus <>", value, "campus");
            return (Criteria) this;
        }

        public Criteria andCampusGreaterThan(String value) {
            addCriterion("campus >", value, "campus");
            return (Criteria) this;
        }

        public Criteria andCampusGreaterThanOrEqualTo(String value) {
            addCriterion("campus >=", value, "campus");
            return (Criteria) this;
        }

        public Criteria andCampusLessThan(String value) {
            addCriterion("campus <", value, "campus");
            return (Criteria) this;
        }

        public Criteria andCampusLessThanOrEqualTo(String value) {
            addCriterion("campus <=", value, "campus");
            return (Criteria) this;
        }

        public Criteria andCampusLike(String value) {
            addCriterion("campus like", value, "campus");
            return (Criteria) this;
        }

        public Criteria andCampusNotLike(String value) {
            addCriterion("campus not like", value, "campus");
            return (Criteria) this;
        }

        public Criteria andCampusIn(List<String> values) {
            addCriterion("campus in", values, "campus");
            return (Criteria) this;
        }

        public Criteria andCampusNotIn(List<String> values) {
            addCriterion("campus not in", values, "campus");
            return (Criteria) this;
        }

        public Criteria andCampusBetween(String value1, String value2) {
            addCriterion("campus between", value1, value2, "campus");
            return (Criteria) this;
        }

        public Criteria andCampusNotBetween(String value1, String value2) {
            addCriterion("campus not between", value1, value2, "campus");
            return (Criteria) this;
        }

        public Criteria andHousenumberIsNull() {
            addCriterion("housenumber is null");
            return (Criteria) this;
        }

        public Criteria andHousenumberIsNotNull() {
            addCriterion("housenumber is not null");
            return (Criteria) this;
        }

        public Criteria andHousenumberEqualTo(String value) {
            addCriterion("housenumber =", value, "housenumber");
            return (Criteria) this;
        }

        public Criteria andHousenumberNotEqualTo(String value) {
            addCriterion("housenumber <>", value, "housenumber");
            return (Criteria) this;
        }

        public Criteria andHousenumberGreaterThan(String value) {
            addCriterion("housenumber >", value, "housenumber");
            return (Criteria) this;
        }

        public Criteria andHousenumberGreaterThanOrEqualTo(String value) {
            addCriterion("housenumber >=", value, "housenumber");
            return (Criteria) this;
        }

        public Criteria andHousenumberLessThan(String value) {
            addCriterion("housenumber <", value, "housenumber");
            return (Criteria) this;
        }

        public Criteria andHousenumberLessThanOrEqualTo(String value) {
            addCriterion("housenumber <=", value, "housenumber");
            return (Criteria) this;
        }

        public Criteria andHousenumberLike(String value) {
            addCriterion("housenumber like", value, "housenumber");
            return (Criteria) this;
        }

        public Criteria andHousenumberNotLike(String value) {
            addCriterion("housenumber not like", value, "housenumber");
            return (Criteria) this;
        }

        public Criteria andHousenumberIn(List<String> values) {
            addCriterion("housenumber in", values, "housenumber");
            return (Criteria) this;
        }

        public Criteria andHousenumberNotIn(List<String> values) {
            addCriterion("housenumber not in", values, "housenumber");
            return (Criteria) this;
        }

        public Criteria andHousenumberBetween(String value1, String value2) {
            addCriterion("housenumber between", value1, value2, "housenumber");
            return (Criteria) this;
        }

        public Criteria andHousenumberNotBetween(String value1, String value2) {
            addCriterion("housenumber not between", value1, value2, "housenumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberIsNull() {
            addCriterion("ordernumber is null");
            return (Criteria) this;
        }

        public Criteria andOrdernumberIsNotNull() {
            addCriterion("ordernumber is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernumberEqualTo(Integer value) {
            addCriterion("ordernumber =", value, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberNotEqualTo(Integer value) {
            addCriterion("ordernumber <>", value, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberGreaterThan(Integer value) {
            addCriterion("ordernumber >", value, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("ordernumber >=", value, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberLessThan(Integer value) {
            addCriterion("ordernumber <", value, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberLessThanOrEqualTo(Integer value) {
            addCriterion("ordernumber <=", value, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberIn(List<Integer> values) {
            addCriterion("ordernumber in", values, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberNotIn(List<Integer> values) {
            addCriterion("ordernumber not in", values, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberBetween(Integer value1, Integer value2) {
            addCriterion("ordernumber between", value1, value2, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberNotBetween(Integer value1, Integer value2) {
            addCriterion("ordernumber not between", value1, value2, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andSatisfactionIsNull() {
            addCriterion("satisfaction is null");
            return (Criteria) this;
        }

        public Criteria andSatisfactionIsNotNull() {
            addCriterion("satisfaction is not null");
            return (Criteria) this;
        }

        public Criteria andSatisfactionEqualTo(String value) {
            addCriterion("satisfaction =", value, "satisfaction");
            return (Criteria) this;
        }

        public Criteria andSatisfactionNotEqualTo(String value) {
            addCriterion("satisfaction <>", value, "satisfaction");
            return (Criteria) this;
        }

        public Criteria andSatisfactionGreaterThan(String value) {
            addCriterion("satisfaction >", value, "satisfaction");
            return (Criteria) this;
        }

        public Criteria andSatisfactionGreaterThanOrEqualTo(String value) {
            addCriterion("satisfaction >=", value, "satisfaction");
            return (Criteria) this;
        }

        public Criteria andSatisfactionLessThan(String value) {
            addCriterion("satisfaction <", value, "satisfaction");
            return (Criteria) this;
        }

        public Criteria andSatisfactionLessThanOrEqualTo(String value) {
            addCriterion("satisfaction <=", value, "satisfaction");
            return (Criteria) this;
        }

        public Criteria andSatisfactionLike(String value) {
            addCriterion("satisfaction like", value, "satisfaction");
            return (Criteria) this;
        }

        public Criteria andSatisfactionNotLike(String value) {
            addCriterion("satisfaction not like", value, "satisfaction");
            return (Criteria) this;
        }

        public Criteria andSatisfactionIn(List<String> values) {
            addCriterion("satisfaction in", values, "satisfaction");
            return (Criteria) this;
        }

        public Criteria andSatisfactionNotIn(List<String> values) {
            addCriterion("satisfaction not in", values, "satisfaction");
            return (Criteria) this;
        }

        public Criteria andSatisfactionBetween(String value1, String value2) {
            addCriterion("satisfaction between", value1, value2, "satisfaction");
            return (Criteria) this;
        }

        public Criteria andSatisfactionNotBetween(String value1, String value2) {
            addCriterion("satisfaction not between", value1, value2, "satisfaction");
            return (Criteria) this;
        }

        public Criteria andFreeIsNull() {
            addCriterion("free is null");
            return (Criteria) this;
        }

        public Criteria andFreeIsNotNull() {
            addCriterion("free is not null");
            return (Criteria) this;
        }

        public Criteria andFreeEqualTo(Boolean value) {
            addCriterion("free =", value, "free");
            return (Criteria) this;
        }

        public Criteria andFreeNotEqualTo(Boolean value) {
            addCriterion("free <>", value, "free");
            return (Criteria) this;
        }

        public Criteria andFreeGreaterThan(Boolean value) {
            addCriterion("free >", value, "free");
            return (Criteria) this;
        }

        public Criteria andFreeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("free >=", value, "free");
            return (Criteria) this;
        }

        public Criteria andFreeLessThan(Boolean value) {
            addCriterion("free <", value, "free");
            return (Criteria) this;
        }

        public Criteria andFreeLessThanOrEqualTo(Boolean value) {
            addCriterion("free <=", value, "free");
            return (Criteria) this;
        }

        public Criteria andFreeIn(List<Boolean> values) {
            addCriterion("free in", values, "free");
            return (Criteria) this;
        }

        public Criteria andFreeNotIn(List<Boolean> values) {
            addCriterion("free not in", values, "free");
            return (Criteria) this;
        }

        public Criteria andFreeBetween(Boolean value1, Boolean value2) {
            addCriterion("free between", value1, value2, "free");
            return (Criteria) this;
        }

        public Criteria andFreeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("free not between", value1, value2, "free");
            return (Criteria) this;
        }

        public Criteria andJobIsNull() {
            addCriterion("job is null");
            return (Criteria) this;
        }

        public Criteria andJobIsNotNull() {
            addCriterion("job is not null");
            return (Criteria) this;
        }

        public Criteria andJobEqualTo(String value) {
            addCriterion("job =", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotEqualTo(String value) {
            addCriterion("job <>", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobGreaterThan(String value) {
            addCriterion("job >", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobGreaterThanOrEqualTo(String value) {
            addCriterion("job >=", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLessThan(String value) {
            addCriterion("job <", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLessThanOrEqualTo(String value) {
            addCriterion("job <=", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLike(String value) {
            addCriterion("job like", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotLike(String value) {
            addCriterion("job not like", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobIn(List<String> values) {
            addCriterion("job in", values, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotIn(List<String> values) {
            addCriterion("job not in", values, "job");
            return (Criteria) this;
        }

        public Criteria andJobBetween(String value1, String value2) {
            addCriterion("job between", value1, value2, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotBetween(String value1, String value2) {
            addCriterion("job not between", value1, value2, "job");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andReservestatusIsNull() {
            addCriterion("reservestatus is null");
            return (Criteria) this;
        }

        public Criteria andReservestatusIsNotNull() {
            addCriterion("reservestatus is not null");
            return (Criteria) this;
        }

        public Criteria andReservestatusEqualTo(Boolean value) {
            addCriterion("reservestatus =", value, "reservestatus");
            return (Criteria) this;
        }

        public Criteria andReservestatusNotEqualTo(Boolean value) {
            addCriterion("reservestatus <>", value, "reservestatus");
            return (Criteria) this;
        }

        public Criteria andReservestatusGreaterThan(Boolean value) {
            addCriterion("reservestatus >", value, "reservestatus");
            return (Criteria) this;
        }

        public Criteria andReservestatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("reservestatus >=", value, "reservestatus");
            return (Criteria) this;
        }

        public Criteria andReservestatusLessThan(Boolean value) {
            addCriterion("reservestatus <", value, "reservestatus");
            return (Criteria) this;
        }

        public Criteria andReservestatusLessThanOrEqualTo(Boolean value) {
            addCriterion("reservestatus <=", value, "reservestatus");
            return (Criteria) this;
        }

        public Criteria andReservestatusIn(List<Boolean> values) {
            addCriterion("reservestatus in", values, "reservestatus");
            return (Criteria) this;
        }

        public Criteria andReservestatusNotIn(List<Boolean> values) {
            addCriterion("reservestatus not in", values, "reservestatus");
            return (Criteria) this;
        }

        public Criteria andReservestatusBetween(Boolean value1, Boolean value2) {
            addCriterion("reservestatus between", value1, value2, "reservestatus");
            return (Criteria) this;
        }

        public Criteria andReservestatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("reservestatus not between", value1, value2, "reservestatus");
            return (Criteria) this;
        }

        public Criteria andDepartment1idIsNull() {
            addCriterion("department1id is null");
            return (Criteria) this;
        }

        public Criteria andDepartment1idIsNotNull() {
            addCriterion("department1id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartment1idEqualTo(Integer value) {
            addCriterion("department1id =", value, "department1id");
            return (Criteria) this;
        }

        public Criteria andDepartment1idNotEqualTo(Integer value) {
            addCriterion("department1id <>", value, "department1id");
            return (Criteria) this;
        }

        public Criteria andDepartment1idGreaterThan(Integer value) {
            addCriterion("department1id >", value, "department1id");
            return (Criteria) this;
        }

        public Criteria andDepartment1idGreaterThanOrEqualTo(Integer value) {
            addCriterion("department1id >=", value, "department1id");
            return (Criteria) this;
        }

        public Criteria andDepartment1idLessThan(Integer value) {
            addCriterion("department1id <", value, "department1id");
            return (Criteria) this;
        }

        public Criteria andDepartment1idLessThanOrEqualTo(Integer value) {
            addCriterion("department1id <=", value, "department1id");
            return (Criteria) this;
        }

        public Criteria andDepartment1idIn(List<Integer> values) {
            addCriterion("department1id in", values, "department1id");
            return (Criteria) this;
        }

        public Criteria andDepartment1idNotIn(List<Integer> values) {
            addCriterion("department1id not in", values, "department1id");
            return (Criteria) this;
        }

        public Criteria andDepartment1idBetween(Integer value1, Integer value2) {
            addCriterion("department1id between", value1, value2, "department1id");
            return (Criteria) this;
        }

        public Criteria andDepartment1idNotBetween(Integer value1, Integer value2) {
            addCriterion("department1id not between", value1, value2, "department1id");
            return (Criteria) this;
        }

        public Criteria andMajorIsNull() {
            addCriterion("major is null");
            return (Criteria) this;
        }

        public Criteria andMajorIsNotNull() {
            addCriterion("major is not null");
            return (Criteria) this;
        }

        public Criteria andMajorEqualTo(String value) {
            addCriterion("major =", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotEqualTo(String value) {
            addCriterion("major <>", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThan(String value) {
            addCriterion("major >", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThanOrEqualTo(String value) {
            addCriterion("major >=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThan(String value) {
            addCriterion("major <", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThanOrEqualTo(String value) {
            addCriterion("major <=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLike(String value) {
            addCriterion("major like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotLike(String value) {
            addCriterion("major not like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorIn(List<String> values) {
            addCriterion("major in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotIn(List<String> values) {
            addCriterion("major not in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorBetween(String value1, String value2) {
            addCriterion("major between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotBetween(String value1, String value2) {
            addCriterion("major not between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andHelpintentionIsNull() {
            addCriterion("helpintention is null");
            return (Criteria) this;
        }

        public Criteria andHelpintentionIsNotNull() {
            addCriterion("helpintention is not null");
            return (Criteria) this;
        }

        public Criteria andHelpintentionEqualTo(String value) {
            addCriterion("helpintention =", value, "helpintention");
            return (Criteria) this;
        }

        public Criteria andHelpintentionNotEqualTo(String value) {
            addCriterion("helpintention <>", value, "helpintention");
            return (Criteria) this;
        }

        public Criteria andHelpintentionGreaterThan(String value) {
            addCriterion("helpintention >", value, "helpintention");
            return (Criteria) this;
        }

        public Criteria andHelpintentionGreaterThanOrEqualTo(String value) {
            addCriterion("helpintention >=", value, "helpintention");
            return (Criteria) this;
        }

        public Criteria andHelpintentionLessThan(String value) {
            addCriterion("helpintention <", value, "helpintention");
            return (Criteria) this;
        }

        public Criteria andHelpintentionLessThanOrEqualTo(String value) {
            addCriterion("helpintention <=", value, "helpintention");
            return (Criteria) this;
        }

        public Criteria andHelpintentionLike(String value) {
            addCriterion("helpintention like", value, "helpintention");
            return (Criteria) this;
        }

        public Criteria andHelpintentionNotLike(String value) {
            addCriterion("helpintention not like", value, "helpintention");
            return (Criteria) this;
        }

        public Criteria andHelpintentionIn(List<String> values) {
            addCriterion("helpintention in", values, "helpintention");
            return (Criteria) this;
        }

        public Criteria andHelpintentionNotIn(List<String> values) {
            addCriterion("helpintention not in", values, "helpintention");
            return (Criteria) this;
        }

        public Criteria andHelpintentionBetween(String value1, String value2) {
            addCriterion("helpintention between", value1, value2, "helpintention");
            return (Criteria) this;
        }

        public Criteria andHelpintentionNotBetween(String value1, String value2) {
            addCriterion("helpintention not between", value1, value2, "helpintention");
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