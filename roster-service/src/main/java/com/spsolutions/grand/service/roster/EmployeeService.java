package com.spsolutions.grand.service.roster;

import com.spsolutions.grand.domain.roster.EmployeeMaster;
import com.spsolutions.grand.mappers.roster.EmployeeMapper;
import com.spsolutions.grand.mappers.roster.RosterDocumentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Value("${archive.path}")
    private String archivePath;

    @Autowired
    private RosterDocumentMapper documentMapper;

    @Autowired
    private RosterFileService fileService;

    @Autowired
    private EmployeeMapper employeeMapper;

    public Long  saveEmployee(EmployeeMaster employeeMaster){
        employeeMapper.saveEmployee(employeeMaster);
        if(employeeMaster!=null){
            return employeeMaster.getId();
        }else{
            return -9999L;
        }
    }

    public List<EmployeeMaster> findAllActiveEmployees(){
        List<EmployeeMaster> allEmployeesList = employeeMapper.findAllActiveEmployees();
        allEmployeesList.stream().forEach(employeeMaster ->{
            if (employeeMaster.getThumbnail() != null) {
                employeeMaster.setThumbnail(this.fileService.findThumbnail(employeeMaster.getThumbnail(), employeeMaster.getExt()));
            }
        }
        );
        return allEmployeesList;
    }

    public List<EmployeeMaster> findAllInActiveEmployees(){
        List<EmployeeMaster> allEmployeesList = employeeMapper.findAllInActiveEmployees();
        allEmployeesList.stream().forEach(employeeMaster ->{
                    if (employeeMaster.getThumbnail() != null) {
                        employeeMaster.setThumbnail(this.fileService.findThumbnail(employeeMaster.getThumbnail(), employeeMaster.getExt()));
                    }
                }
        );
        return allEmployeesList;
    }

    public List<EmployeeMaster> filterEmployee(String keyword){
        List<EmployeeMaster> filteredEmployeesList = employeeMapper.filterEmployee(keyword);
        filteredEmployeesList.stream().forEach(employeeMaster ->{
            if (employeeMaster.getThumbnail() != null) {
                employeeMaster.setThumbnail(this.fileService.findThumbnail(employeeMaster.getThumbnail(), employeeMaster.getExt()));
            }
        }
        );
        return filteredEmployeesList;
    }

    public EmployeeMaster findActiveEmployeeById(Long id){
        return employeeMapper.findActiveEmployeeById(id);
    }


    public int  updateEmployee(EmployeeMaster employeeMaster){
       return employeeMapper.updateEmployee(employeeMaster);

    }

}
