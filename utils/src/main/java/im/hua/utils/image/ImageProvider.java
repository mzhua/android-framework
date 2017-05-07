package im.hua.utils.image;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.File;
import java.util.Calendar;

/**
 * Created by hua on 2017/5/7.
 */

public class ImageProvider {
    public static void pickFromLocal(Activity activity, int requestCode) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        activity.startActivityForResult(intent, requestCode);
    }

    public static String takePicture(Activity activity, int requestCode) {
        String tmp = Environment.getExternalStorageDirectory().getPath() + File.separator + activity.getApplicationInfo().packageName+ Calendar.getInstance().getTimeInMillis() + ".png";
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(tmp)));
        activity.startActivityForResult(intent,requestCode);
        return tmp;
    }

    public static String resolveLocalResult(Context context,Intent data) {
        String imagePath = null;
        Cursor cursor = context.getContentResolver().query(data.getData(), null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            imagePath = cursor.getString(cursor.getColumnIndex("_data"));
            cursor.close();
        }

        return imagePath;
    }

}
