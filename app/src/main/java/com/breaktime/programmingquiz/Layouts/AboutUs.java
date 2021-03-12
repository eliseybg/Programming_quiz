package com.breaktime.programmingquiz.Layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.breaktime.programmingquiz.R;

import java.util.List;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
    }

    public void openVK(View view) {
        Uri uri = Uri.parse("https://vk.com/eliseybg");
        Intent vk = new Intent(Intent.ACTION_VIEW, uri);
        vk.setPackage("com.vk.android");

        if (isIntentAvailable(this, vk)){
            startActivity(vk);
        } else{
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/eliseybg")));
        }
    }

    public void openInstagram(View view) {
        Uri uri = Uri.parse("https://www.instagram.com/road_to_the_uk/");
        Intent insta = new Intent(Intent.ACTION_VIEW, uri);
        insta.setPackage("com.instagram.android");

        if (isIntentAvailable(this, insta)){
            startActivity(insta);
        } else{
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/road_to_the_uk/")));
        }
    }

    private boolean isIntentAvailable(Context ctx, Intent intent) {
        final PackageManager packageManager = ctx.getPackageManager();
        List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }

    public void openGooglePlay(View view) {
        Intent i = new Intent(android.content.Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.breaktime.programmingquiz"));
        startActivity(i);
    }
}