package org.example.test.constant;

public class ErrorMessage {
    public static final String NOT_BLANK_FIELD = "Trường này không được để trống";
    public static final String INVALID_FORMAT_PASSWORD = "Mật khẩu không hợp lệ";
    public static final String INVALID_SOME_THING_FIELD_IS_REQUIRED = "Trường không hợp lệ";
    public static final String INVALID_FORMAT_SOME_THING_FIELD = "Trường không hợp lệ";

    public static final String NOT_FOUND = "Not Found Exception: %s";
    public static final String VALIDATE_ERROR = "Validate Exception: %s";
    public static final String INTERNAL_SERVER_ERROR = "Internal Server Error: %s";

    public static class Book{
        public static final String INVALID_PRICE_GREATER_THAN_ZERO = "Price must be greater than 0";
        public static final String ERR_NOT_FOUND_ID = "Không tìm thấy sách với id: %s";

    }

    public static class Author{
        public static final String ERR_NOT_FOUND_ID = "Không tìm thấy tác giả với id: %s";
    }

    public static class Category{
        public static final String ERR_NOT_FOUND_ID = "Không tìm thấy thể loại với id: %s";
    }

}
