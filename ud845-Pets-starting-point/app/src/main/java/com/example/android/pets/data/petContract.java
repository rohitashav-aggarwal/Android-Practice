package com.example.android.pets.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public final class petContract {

    petContract(){}

    public static abstract class petEntry implements BaseColumns{

        public static final String CONTENT_AUTHORITY = "com.example.android.pets";
        public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
        public static final  String PATH_PETS = "pets";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PETS);

        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;

        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;


        public final static String Table_Name = "pets";

        public final static String _ID = BaseColumns._ID;
        public final static String Column_Pet_Name = "name";
        public final static String Column_Pet_Breed = "breed";
        public final static String Column_Pet_Gender = "gender";
        public final static String Column_Pet_Weight = "weight";

        public static final int Gender_Unknown = 0;
        public static final int Gender_Male = 1;
        public static final int Gender_Female = 2;

        public static boolean isValidGender(int gender){
            if (gender == Gender_Unknown || gender == Gender_Male || gender == Gender_Female) {
                return true;
            }
            return false;
        }
    }

}
