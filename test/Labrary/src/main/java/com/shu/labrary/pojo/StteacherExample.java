package com.shu.labrary.pojo;

import java.util.ArrayList;
import java.util.List;

public class StteacherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StteacherExample() {
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

        public Criteria andStteacheridIsNull() {
            addCriterion("stteacherid is null");
            return (Criteria) this;
        }

        public Criteria andStteacheridIsNotNull() {
            addCriterion("stteacherid is not null");
            return (Criteria) this;
        }

        public Criteria andStteacheridEqualTo(Integer value) {
            addCriterion("stteacherid =", value, "stteacherid");
            return (Criteria) this;
        }

        public Criteria andStteacheridNotEqualTo(Integer value) {
            addCriterion("stteacherid <>", value, "stteacherid");
            return (Criteria) this;
        }

        public Criteria andStteacheridGreaterThan(Integer value) {
            addCriterion("stteacherid >", value, "stteacherid");
            return (Criteria) this;
        }

        public Criteria andStteacheridGreaterThanOrEqualTo(Integer value) {
            addCriterion("stteacherid >=", value, "stteacherid");
            return (Criteria) this;
        }

        public Criteria andStteacheridLessThan(Integer value) {
            addCriterion("stteacherid <", value, "stteacherid");
            return (Criteria) this;
        }

        public Criteria andStteacheridLessThanOrEqualTo(Integer value) {
            addCriterion("stteacherid <=", value, "stteacherid");
            return (Criteria) this;
        }

        public Criteria andStteacheridIn(List<Integer> values) {
            addCriterion("stteacherid in", values, "stteacherid");
            return (Criteria) this;
        }

        public Criteria andStteacheridNotIn(List<Integer> values) {
            addCriterion("stteacherid not in", values, "stteacherid");
            return (Criteria) this;
        }

        public Criteria andStteacheridBetween(Integer value1, Integer value2) {
            addCriterion("stteacherid between", value1, value2, "stteacherid");
            return (Criteria) this;
        }

        public Criteria andStteacheridNotBetween(Integer value1, Integer value2) {
            addCriterion("stteacherid not between", value1, value2, "stteacherid");
            return (Criteria) this;
        }

        public Criteria andStteachernameIsNull() {
            addCriterion("stteachername is null");
            return (Criteria) this;
        }

        public Criteria andStteachernameIsNotNull() {
            addCriterion("stteachername is not null");
            return (Criteria) this;
        }

        public Criteria andStteachernameEqualTo(String value) {
            addCriterion("stteachername =", value, "stteachername");
            return (Criteria) this;
        }

        public Criteria andStteachernameNotEqualTo(String value) {
            addCriterion("stteachername <>", value, "stteachername");
            return (Criteria) this;
        }

        public Criteria andStteachernameGreaterThan(String value) {
            addCriterion("stteachername >", value, "stteachername");
            return (Criteria) this;
        }

        public Criteria andStteachernameGreaterThanOrEqualTo(String value) {
            addCriterion("stteachername >=", value, "stteachername");
            return (Criteria) this;
        }

        public Criteria andStteachernameLessThan(String value) {
            addCriterion("stteachername <", value, "stteachername");
            return (Criteria) this;
        }

        public Criteria andStteachernameLessThanOrEqualTo(String value) {
            addCriterion("stteachername <=", value, "stteachername");
            return (Criteria) this;
        }

        public Criteria andStteachernameLike(String value) {
            addCriterion("stteachername like", value, "stteachername");
            return (Criteria) this;
        }

        public Criteria andStteachernameNotLike(String value) {
            addCriterion("stteachername not like", value, "stteachername");
            return (Criteria) this;
        }

        public Criteria andStteachernameIn(List<String> values) {
            addCriterion("stteachername in", values, "stteachername");
            return (Criteria) this;
        }

        public Criteria andStteachernameNotIn(List<String> values) {
            addCriterion("stteachername not in", values, "stteachername");
            return (Criteria) this;
        }

        public Criteria andStteachernameBetween(String value1, String value2) {
            addCriterion("stteachername between", value1, value2, "stteachername");
            return (Criteria) this;
        }

        public Criteria andStteachernameNotBetween(String value1, String value2) {
            addCriterion("stteachername not between", value1, value2, "stteachername");
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

        public Criteria andDepartmentidIsNull() {
            addCriterion("departmentid is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentidIsNotNull() {
            addCriterion("departmentid is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentidEqualTo(Integer value) {
            addCriterion("departmentid =", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotEqualTo(Integer value) {
            addCriterion("departmentid <>", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidGreaterThan(Integer value) {
            addCriterion("departmentid >", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("departmentid >=", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidLessThan(Integer value) {
            addCriterion("departmentid <", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidLessThanOrEqualTo(Integer value) {
            addCriterion("departmentid <=", value, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidIn(List<Integer> values) {
            addCriterion("departmentid in", values, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotIn(List<Integer> values) {
            addCriterion("departmentid not in", values, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidBetween(Integer value1, Integer value2) {
            addCriterion("departmentid between", value1, value2, "departmentid");
            return (Criteria) this;
        }

        public Criteria andDepartmentidNotBetween(Integer value1, Integer value2) {
            addCriterion("departmentid not between", value1, value2, "departmentid");
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