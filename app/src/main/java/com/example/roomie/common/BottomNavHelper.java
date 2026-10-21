package com.example.roomie.common;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;

import com.example.roomie.R;
import com.example.roomie.ui.home.HomeActivity;
import com.example.roomie.ui.matching.MatchingActivity;
import com.example.roomie.ui.profile.ProfileActivity;
import com.example.roomie.ui.search.SearchActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public final class BottomNavHelper {

    private BottomNavHelper() {}

    public static void setup(
            Activity activity,
            BottomNavigationView navigation,
            int selectedItemId) {

        navigation.setSelectedItemId(selectedItemId);

        navigation.setOnItemSelectedListener(
                (MenuItem item) -> {
                    int id = item.getItemId();

                    if (id == selectedItemId) {
                        return true;
                    }

                    Class<?> target;

                    if (id == R.id.nav_explore) {
                        target = HomeActivity.class;
                    } else if (id == R.id.nav_saved) {
                        target = SearchActivity.class;
                    } else if (id == R.id.nav_my_posts) {
                        target = MatchingActivity.class;
                    } else if (id == R.id.nav_profile) {
                        target = ProfileActivity.class;
                    } else {
                        return false;
                    }

                    Intent intent = new Intent(activity, target);
                    activity.startActivity(intent);
                    activity.finish();

                    return true;
                });
    }
}
