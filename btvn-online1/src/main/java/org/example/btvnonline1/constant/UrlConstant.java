package org.example.btvnonline1.constant;

public class UrlConstant {

    public static class Hotel {
        public static final String PRE_FIX = "hotels";
        public static final String GET_HOTELS = PRE_FIX;
        public static final String GET_HOTEL = PRE_FIX + "/{hotelId}";
        public static final String CREATE_HOTEL = PRE_FIX + "/create";
        public static final String UPDATE_HOTEL = PRE_FIX + "/update/{hotelId}";
        public static final String DELETE_HOTEL = PRE_FIX + "/delete/{hotelId}";

        private Hotel() {
        }

    }
}
