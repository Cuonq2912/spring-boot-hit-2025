package org.example.btvnbuoi5.constant;

public class ErrorMessage {

    public static final String NOT_BLANK_FIELD = "Trường này không được để trống";
    public static final String INVALID_FORMAT_PASSWORD = "Mật khẩu không hợp lệ";
    public static final String INVALID_SOME_THING_FIELD_IS_REQUIRED = "Trường không hợp lệ";
    public static final String INVALID_FORMAT_SOME_THING_FIELD = "Trường không hợp lệ";

    public static class User{
        public static final String ERR_NOT_FOUND_ID = "Không tìm thấy người dùng với id: %s";
    }
    public static class Department{
        public static final String ERR_NOT_FOUND_ID = "Không tìm thấy phòng ban với id: %s";
    }
    public static class Employee{
        public static final String ERR_NOT_FOUND = "Không tìm thấy nhân viên";
        public static final String ERR_NOT_FOUND_ID = "Không tìm thấy nhân viên với id: %s";
        public static final String ERR_NOT_FOUND_FULLNAME = "Không tìm thấy nhân viên với tên: %s";
        public static final String ERR_NOT_FOUND_DEPARTMENT_ID = "Không tìm thấy nhân viên với id phòng ban: %s";
        public static final String ERR_NOT_FOUND_POSITION_ID = "Không tìm thấy nhân viên với id vị trí: %s";

    }
    public static class Position{
        public static final String ERR_NOT_FOUND_ID = "Không tìm thấy vị trí với id: %s";
    }
}
