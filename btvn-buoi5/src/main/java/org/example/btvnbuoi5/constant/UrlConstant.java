package org.example.btvnbuoi5.constant;

public class UrlConstant {

    public static class Department {
        private static final String PRE_FIX = "/department";

        public static final String GET_DEPARTMENTS = PRE_FIX;
        public static final String GET_DEPARTMENT = PRE_FIX + "/{departmentId}";
        public static final String CREATE_DEPARTMENT = PRE_FIX + "/create";
        public static final String UPDATE_DEPARTMENT = PRE_FIX + "/update/{departmentId}";
        public static final String DELETE_DEPARTMENT = PRE_FIX + "/delete/{departmentId}";

        private Department() {
        }
    }
    public static class User {
        private static final String PRE_FIX = "/user";
        public static final String GET_USERS = PRE_FIX;
        public static final String GET_USER = PRE_FIX + "/{userId}";
        public static final String CREATE_USER = PRE_FIX + "/create";
        public static final String UPDATE_USER = PRE_FIX + "/update/{userId}";
        public static final String DELETE_USER = PRE_FIX + "/delete/{userId}";

        private User() {
        }
    }

    public static class Employee {
        private static final String PRE_FIX = "/employee";
        public static final String GET_EMPLOYEES = PRE_FIX;
        public static final String GET_EMPLOYEE = PRE_FIX + "/{employeeId}";
        public static final String GET_EMPLOYEES_BY_FULLNAME = PRE_FIX + "/username/{fullName}";
        public static final String GET_EMPLOYEES_BY_DEPARTMENT = PRE_FIX + "/department/{departmentId}";
        public static final String GET_EMPLOYEES_BY_POSITION = PRE_FIX + "/position/{positionId}";
        public static final String CREATE_EMPLOYEE = PRE_FIX + "/create";
        public static final String UPDATE_EMPLOYEE = PRE_FIX + "/update/{employeeId}";
        public static final String DELETE_EMPLOYEE = PRE_FIX + "/delete/{employeeId}";

        private Employee() {
        }
    }

    public static class Position {
        private static final String PRE_FIX = "/position";
        public static final String GET_POSITIONS = PRE_FIX;
        public static final String GET_POSITION = PRE_FIX + "/{positionId}";
        public static final String CREATE_POSITION = PRE_FIX + "/create";
        public static final String UPDATE_POSITION = PRE_FIX + "/update/{positionId}";
        public static final String DELETE_POSITION = PRE_FIX + "/delete/{positionId}";

        private Position() {
        }
    }

}
