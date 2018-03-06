package jp.co.realsys.service;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import jp.co.realsys.dao.VStudentMapper;
import jp.co.realsys.model.VStudent;
import jp.co.realsys.param.VStudentParam;
import jp.co.realsys.util.BeanValidator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VStudentService {

    @Resource
    private VStudentMapper vStudentMapper;

    public void Register(VStudentParam student){
        BeanValidator.check(student);
        VStudent vStudent = VStudent.builder().name(student.getName()).birthday(student.getBirthday())
                .address(student.getAddress()).classid(student.getClassid()).build();
        vStudentMapper.insertSelective(vStudent);
    }

    public void update(VStudentParam studentParam){
        BeanValidator.check(studentParam);
        VStudent before = vStudentMapper.selectByPrimaryKey(studentParam.getId());
        Preconditions.checkNotNull(before,"待更新的学生不存在");
        VStudent after = VStudent.builder().id(studentParam.getId()).name(studentParam.getName())
                .birthday(studentParam.getBirthday()).address(studentParam.getAddress()).classid(studentParam.getClassid()).build();
        vStudentMapper.updateByPrimaryKeySelective(after);
    }

    public List<VStudent> getAll(){
        return vStudentMapper.getAll();
    }

    public List<VStudent> getByName(String name){
        if(StringUtils.isNotBlank(name)){
            return vStudentMapper.getByName(name);
        }
        return Lists.newArrayList();
    }

    public List<VStudent> getByClassID(Integer classID){
        return vStudentMapper.getByClassID(classID);
    }

    public void delete(Integer id){
        VStudent before = vStudentMapper.selectByPrimaryKey(id);
        Preconditions.checkNotNull(before,"待删除的学生不存在");
        vStudentMapper.deleteByPrimaryKey(id);
    }



}
