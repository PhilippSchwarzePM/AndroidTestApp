package com.philipps.androidtestapp;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by philipps on 08.09.17.
 */


    @RunWith(AndroidJUnit4.class)
    @LargeTest
    public class mySmallCoffeeTests {

        private String mStringToBetyped;

        @Rule
        public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
                MainActivity.class);

        @Before
        public void initValidString() {
            // Specify a valid string.
            mStringToBetyped = "Espresso";
        }

        @Test
        public void changeText() {
            // Type text and then press the button.

            onView(withId(R.id.editText))
                    .perform(typeText(mStringToBetyped), closeSoftKeyboard());
            onView(withId(R.id.send_button)).perform(click());

            // Check that the text was changed.
            onView(withId(R.id.displayTextView))
                    .check(matches(withText(mStringToBetyped)));
        }
    }

