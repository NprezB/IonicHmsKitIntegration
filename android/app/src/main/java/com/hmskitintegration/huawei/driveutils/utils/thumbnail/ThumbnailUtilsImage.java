/*
 * Copyright 2020. Huawei Technologies Co., Ltd. All rights reserved.

 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at

 *   http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hmskitintegration.huawei.driveutils.utils.thumbnail;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;

import com.hmskitintegration.huawei.driveutils.log.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 *  Generate image thumbnail.
 */

public class ThumbnailUtilsImage {

    private static final String TAG = "ThumbnailUtilsImage";
    public static final int FILE_TYPE_PNG = 102;
    private ThumbnailUtilsImage() {

    }

    /**
     *  gen thumbnail
     *
     * @param imageName  Path of the source image.
     * @param thumbnailName  Store Path of thumbnail
     * @param width     Specifies the width of the output thumbnail
     * @param height    Specifies the height of the output thumbnail
     */
    public static void genImageThumbnail(String imageName, String thumbnailName, int width, int height, int type) {
        OutputStream os = null;
        try {
            Bitmap bmp = null;
            BitmapFactory.Options ops = new BitmapFactory.Options();
            ops.inJustDecodeBounds = true;
            bmp = BitmapFactory.decodeFile(imageName,ops);

            ops.inJustDecodeBounds = false;
            // Computing Zooms in ratio
            int outHeight = ops.outHeight;
            int outWidth = ops.outWidth;
            int widthPercent = outWidth / width;
            int heightPercent = outHeight / height;
            int sampleSize = 1;
            if (widthPercent < heightPercent) {
                sampleSize = widthPercent;
            } else {
                sampleSize = heightPercent;
            }
            if (sampleSize <= 0) {
                sampleSize = 1;
            }
            ops.inSampleSize = sampleSize;
            // Read the picture againand set options.inJustDecodeBounds to false.

            bmp = BitmapFactory.decodeFile(imageName, ops);
            // Use ThumbnailUtils to create a thumbnail.
            // The size of the thumbnail of the access control file on the server cannot exceed 8 times the size of the file.
            // If the large thumbnail of some small images is generated by 1680*1920, the upload fails.
            if (outHeight < height || outWidth < width) {
                bmp = ThumbnailUtils.extractThumbnail(bmp, outWidth, outHeight, ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
            } else {
                bmp = ThumbnailUtils.extractThumbnail(bmp, width, height, ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
            }

            String fileNameParent = thumbnailName.substring(0, thumbnailName.lastIndexOf(File.separator));
            File file = new File(fileNameParent);
            if (!file.exists()) {
                boolean mkdirs = file.mkdirs();
                if (!mkdirs) {
                    Logger.e(TAG, "getImageThumbnail file.mkdirs fail");
                }
            }
            os = new FileOutputStream(thumbnailName);
            if (type == FILE_TYPE_PNG) {
                bmp.compress(Bitmap.CompressFormat.PNG, 90, os);
            } else {
                bmp.compress(Bitmap.CompressFormat.JPEG, 90, os);
            }
        } catch (FileNotFoundException e) {
            Logger.e(TAG, "read or write file error");
        } catch (Exception e) {
            Logger.e(TAG, "internal error "+ e.toString());
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    Logger.e(TAG, "close FileOutputStream error");
                }
            }
        }
    }
}
