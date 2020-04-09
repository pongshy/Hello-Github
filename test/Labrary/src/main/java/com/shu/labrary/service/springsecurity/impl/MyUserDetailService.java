package com.shu.labrary.service.springsecurity.impl;

import com.shu.labrary.mapper.AdminMapper;
import com.shu.labrary.mapper.DepartmentMapper;
import com.shu.labrary.mapper.TeacherMapper;
import com.shu.labrary.pojo.Admin;
import com.shu.labrary.pojo.Department;
import com.shu.labrary.pojo.DepartmentExample;
import com.shu.labrary.pojo.Teacher;
import com.shu.labrary.service.springsecurity.impl.ShuLogin.ShuFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.length() == 8) {
            Admin admin = adminMapper.selectByPrimaryKey(Integer.parseInt(username));
            Department department=new Department();
            String auth = "";
            if (admin == null) {

                Admin newAdmin = new Admin();
                newAdmin.setAdminid(Integer.parseInt(username));

                if (StringUtils.isNotEmpty(ShuFilter.user.getName())) {
                    newAdmin.setName(ShuFilter.user.getName());
                }

                if (StringUtils.isNotEmpty(ShuFilter.user.getDuty())) {
                    if (ShuFilter.user.getDuty().trim().equals("教职工")
                            || ShuFilter.user.getDuty().trim().equals("离退休")) {

                        auth="ROLE_Teacher";
                        newAdmin.setAuth("ROLE_Teacher");
                    }else
                    {
                        auth="ROLE_User";
                        newAdmin.setAuth("ROLE_User");

                    }

                    DepartmentExample departmentExample = new DepartmentExample();
                    departmentExample.createCriteria().andDepartmentnameEqualTo(ShuFilter.user.getDepartment());
                     department = departmentMapper.selectByExample(departmentExample).get(0);

                    newAdmin.setDepartmentid(department.getDepartmentid());
                    newAdmin.setOrganization(department.getDepartmentname());
                    newAdmin.setDuty(ShuFilter.user.getDuty());
                    newAdmin.setOnline(true);
                }
                adminMapper.insert(newAdmin);
                //如果是教师权限，则增加教师表
                if (auth.equals("ROLE_Teacher"))
                {
                    Teacher teacher=new Teacher();
                    teacher.setTeacherid(Integer.parseInt(username));
                    teacher.setTeachername(ShuFilter.user.getName());
                    teacher.setDuty(ShuFilter.user.getDuty());
                    teacher.setOrganization(department.getDepartmentname());
                    teacher.setDepartment1id(department.getDepartmentid());
                    teacher.setFree(true);
                    teacher.setSatisfaction("3");
                    teacher.setCampus("宝山校区");
                    teacher.setBuilding("上海大学宝山校区本部图书馆二楼东侧");
                    teacherMapper.insert(teacher);

                }
            }else
            {
                auth=admin.getAuth();
            }

            String password = ShuFilter.password;
            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            grantedAuthorities.add(new SimpleGrantedAuthority(auth));
            return new User(username, password, grantedAuthorities);
        }
        return null;
    }
}
