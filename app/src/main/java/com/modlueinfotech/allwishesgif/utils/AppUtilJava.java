package com.modlueinfotech.allwishesgif.utils;

import android.content.Context;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.io.File;

public class AppUtilJava {
    private static AppUtilJava appUtilsJava;

    public static AppUtilJava getInstance() {
        if (appUtilsJava == null) {
            appUtilsJava = new AppUtilJava();
        }
        return appUtilsJava;
    }
    public void getFile(Context ctx, Object object, DownloadFileListener listener) {
        Glide.with(ctx)
                .downloadOnly()
                .load(object)
                .listener(new RequestListener<File>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<File> target, boolean isFirstResource) {
                        listener.onDownloadComplete(null);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(File resource, Object model, Target<File> target, DataSource dataSource, boolean isFirstResource) {
                        listener.onDownloadComplete(resource);
                        return false;
                    }
                })
                .submit(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
    }
    public interface DownloadFileListener {
        void onDownloadComplete(File file);
    }
}
