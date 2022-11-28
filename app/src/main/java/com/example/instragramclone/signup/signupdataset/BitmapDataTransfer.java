package com.example.instragramclone.signup.signupdataset;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.example.instragramclone.signup.AddPhotoActivity;
import com.parse.FindCallback;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.ProgressCallback;

import java.util.ArrayList;
import java.util.List;

public class BitmapDataTransfer {

    private static ArrayList<Bitmap> picturesBitmapList;

    public static void setBitmapPicture(ArrayList<Bitmap> bitmapPictureList) {
        picturesBitmapList = bitmapPictureList;
    }

    public static ArrayList<Bitmap> getBitmapPicture() {

        return picturesBitmapList;

    }

}
