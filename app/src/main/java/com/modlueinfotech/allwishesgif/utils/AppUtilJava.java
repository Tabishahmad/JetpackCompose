package com.modlueinfotech.allwishesgif.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.modlueinfotech.allwishesgif.BuildConfig;
import com.modlueinfotech.allwishesgif.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class AppUtilJava {
    private static AppUtilJava appUtilsJava;

    public static AppUtilJava getInstance() {
        if (appUtilsJava == null) {
            appUtilsJava = new AppUtilJava();
        }
        return appUtilsJava;
    }
    public File getFile(Context ctx, Bitmap bmp) {
        try {
            File file = new File(ctx.getExternalCacheDir(), "share.png");
            FileOutputStream fOut = fOut = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            fOut.flush();
            fOut.close();
            file.setReadable(true, false);
            return file;
        } catch (IOException e) {
            return null;
        }
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
    public Bitmap captureScreen(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap bmp = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return bmp;
    }
    public void shareBitmap(Context context, Bitmap bitmap, boolean isOnWhatsApp) {
        try {
            File file = new File(context.getExternalCacheDir(), "share.png");
            FileOutputStream fOut = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            fOut.flush();
            fOut.close();
            file.setReadable(true, false);
            if (isOnWhatsApp) {
                shareImageOnWhatsApp(context, getProviderUri(context, file));
            } else {
                shareImage(context, getProviderUri(context, file));
            }
        } catch (Exception e) {
            e.printStackTrace();
//            showToast(context, e.getMessage());
        }
    }
    public void shareImage(Context ctx, Uri uri) {
        String sAux = "Download " + ctx.getString(R.string.app_name) + "\n";
        sAux = sAux + "https://play.google.com/store/apps/details?id=" + ctx.getPackageName() + "\n";
        Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
        whatsappIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        whatsappIntent.putExtra(Intent.EXTRA_TEXT, sAux);
        whatsappIntent.putExtra(Intent.EXTRA_STREAM, uri);
        whatsappIntent.setType("image/jpeg");
        try {
            ctx.startActivity(whatsappIntent);
        } catch (ActivityNotFoundException e) {
//            showToast(ctx, "WhatsApp not installed");
        }
    }
    public void shareImageOnWhatsApp(Context ctx, Uri uri) {
        String sAux = "Download " + ctx.getString(R.string.app_name) + "\n";
        sAux = sAux + "https://play.google.com/store/apps/details?id=" + ctx.getPackageName() + "\n";
        Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
        whatsappIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        whatsappIntent.setType("text/plain");
        whatsappIntent.setPackage("com.whatsapp");
        whatsappIntent.putExtra(Intent.EXTRA_TEXT, sAux);
        whatsappIntent.putExtra(Intent.EXTRA_STREAM, uri);
        whatsappIntent.setType("image/jpeg");
        whatsappIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        try {
            ctx.startActivity(whatsappIntent);
        } catch (ActivityNotFoundException e) {
//            showToast(ctx, "WhatsApp not installed");
        }
    }
    public Uri getProviderUri(Context ctx, File file) {
        File filePath = file.getAbsoluteFile();
        Uri uri = FileProvider.getUriForFile(ctx, BuildConfig.APPLICATION_ID + ".provider", filePath);
        return uri;
    }
    public void openUrl(Context context, String url) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse(url));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (Exception e) {
            showToast(context, e.getMessage());
        }
    }
    public void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
    public void shareApp(Context context) {
        try {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            String sAux = "Download\n" + context.getResources().getString(R.string.app_name) + "\n";
            sAux = sAux + "https://play.google.com/store/apps/details?id=" + context.getPackageName() + "\n";
            i.putExtra(Intent.EXTRA_TEXT, sAux);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(Intent.createChooser(i, "choose one"));
        } catch (Exception e) {
            showToast(context, e.getMessage());
        }
    }
    public void rateUs(Context context) {
        try {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + context.getPackageName()));
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        } catch (Exception e) {
            showToast(context, e.getMessage());
        }
    }
}
