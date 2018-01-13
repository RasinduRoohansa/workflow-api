package com.spsolutions.grand.mappers.roster;

import com.spsolutions.grand.domain.roster.EmployeeMaster;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Mapper for the RosterEmployee
 */
@Mapper
public interface EmployeeMapper {

    /**
     * save employeess
     *
     * @param employeeMaster
     */
    public void saveEmployee(EmployeeMaster employeeMaster);


    /**
     * search all the employees
     *
     * @return
     */
    public List<EmployeeMaster> findAllActiveEmployees();

    /**
     * seaqrch all inactive emplyees
     * @return
     */
    public List<EmployeeMaster> findAllInActiveEmployees();


    /**
     * filter employee list according to the keyword parse from the front end
     *
     * @return
     */
    public List<EmployeeMaster> filterEmployee(String keyword);

    /**
     * load employee details to update according to the id
     *
     * @param id
     * @return
     */
    public EmployeeMaster findActiveEmployeeById(Long id);

    /**
     * update employee information
     *
     * @param employeeMaster
     */
    public int updateEmployee(EmployeeMaster employeeMaster);


}
