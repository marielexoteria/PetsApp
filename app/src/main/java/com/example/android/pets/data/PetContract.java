package com.example.android.pets.data;

import android.net.Uri;
import android.provider.BaseColumns;

public final class PetContract {

    /* Setting up the content authority for the URIs that will be generated
    when handling CRUD actions */
    public static final String CONTENT_AUTHORITY = "com.example.android.pets";

    //Setting up the base URI with the scheme (content://) and the content authority
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    //Setting up the db that will complete the URI
    public static final String PATH_PETS = "pets";

    public static abstract class PetEntry implements BaseColumns {

        /* Creating a full URI with format "content://com.example.android.pets/pets"
        using the method Uri.withAppendedPath and the variables initialized above */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PETS);

        public static final String TABLE_NAME = "pets";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_PET_NAME = "name";
        public static final String COLUMN_PET_BREED = "breed";
        public static final String COLUMN_PET_GENDER = "gender";
        public static final String COLUMN_PET_WEIGHT = "weight";

        /**
         * Possible values for the gender.
         */
        public static final int GENDER_UNKNOWN = 0;
        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;

    }
}
