package org.example.test.constant;

public class UrlConstant {

    public static class Author {
        private static final String PRE_FIX = "/authors";
        public static final String GET_AUTHORS = PRE_FIX;
        public static final String GET_AUTHOR = PRE_FIX + "/{authorId}";
        public static final String CREATE_AUTHOR= PRE_FIX + "/create";
        public static final String UPDATE_AUTHOR = PRE_FIX + "/update/{authorId}";
        public static final String DELETE_AUTHOR = PRE_FIX + "/delete/{authorId}";

        private Author() {
        }
    }

    public static class Category {
        private static final String PRE_FIX = "/categories";
        public static final String GET_CATEGORIES = PRE_FIX;
        public static final String GET_CATEGORY = PRE_FIX + "/{categoryId}";
        public static final String CREATE_CATEGORY= PRE_FIX + "/create";
        public static final String UPDATE_CATEGORY = PRE_FIX + "/update/{categoryId}";
        public static final String DELETE_CATEGORY = PRE_FIX + "/delete/{categoryId}";

        private Category() {
        }
    }

    public static class Book {
        private static final String PRE_FIX = "/books";
        public static final String GET_BOOKS = PRE_FIX;
        public static final String GET_BOOK = PRE_FIX + "/{bookId}";
        public static final String CREATE_BOOK = PRE_FIX + "/create";
        public static final String UPDATE_BOOK = PRE_FIX + "/update/{bookId}";
        public static final String DELETE_BOOK = PRE_FIX + "/delete/{bookId}";

        private Book() {
        }
    }


}
