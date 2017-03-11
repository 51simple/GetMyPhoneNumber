package com.yukang.getmyphonenumber;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Phone;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by simple on 17-3-11.
 */

public class GetNumber {

    public static List<PhoneInfo> lists = new ArrayList<>();

    public static String getNumber(Context context) {
        Cursor cursor = context.getContentResolver().query(Phone.CONTENT_URI, null, null, null, null);
        String phoneNumber;
        String phoneName;
        while (cursor.moveToNext()) {
            phoneNumber = cursor.getString(cursor.getColumnIndex(Phone.NUMBER));
            phoneName = cursor.getString(cursor.getColumnIndex(Phone.DISPLAY_NAME));
            PhoneInfo phoneInfo = new PhoneInfo(phoneName, phoneNumber);
            lists.add(phoneInfo);
            System.out.println(phoneName + phoneNumber);
        }
        return null;
    }
}
