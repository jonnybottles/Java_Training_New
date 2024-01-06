package dev.lpa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HospitalManagement {
    List<Department> departments;

    public HospitalManagement() {
        this.departments = new ArrayList<Department>();

    }

    public boolean addDepartment(Department department) {
        if (findDepartment(department)) {
            System.out.println("Department " + department + " already exists.");
            return false;
        }

        departments.add(department);
        departments.sort(Comparator.comparing(Department::getName));
        return true;
    }

    private boolean findDepartment(Department department) {
        return departments.contains(department);
    }

    public String getDepartmentInfo(String departmentName) {
        for (Department department : departments) {
            if (department.getName().equals(departmentName)) {
                return department.getDepartmentDetails();
            }
        }

        System.out.println("Department " + departmentName + "does not exist");
        return null;
    }

    public String getAllDepartmentsDetails() {
        StringBuilder sb = new StringBuilder();
        for (Department department : departments) {
            sb.append(department.getDepartmentDetails());
        }

        return sb.toString();
    }

}
