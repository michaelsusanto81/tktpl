package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.ui.auth.login

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.MainActivity
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.R
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.ToastMatcher
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class LoginFragmentTest {

    @get: Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testWidgetsVisibility() {
        onView(withId(R.id.fragment_login)).check(matches(isDisplayed()))
        onView(withId(R.id.app_title)).check(matches(isDisplayed()))
        onView(withId(R.id.username_field)).check(matches(isDisplayed()))
        onView(withId(R.id.password_field)).check(matches(isDisplayed()))
        onView(withId(R.id.login_button)).check(matches(isDisplayed()))
        onView(withId(R.id.dont_have_an_account)).check(matches(isDisplayed()))
        onView(withId(R.id.register_button)).check(matches(isDisplayed()))
    }

    @Test
    fun testLoginFailed() {
        onView(withId(R.id.username_edit)).perform(replaceText("usernameDoesNotExist"))
        onView(withId(R.id.password_edit)).perform(replaceText("testing123"))
        onView(withId(R.id.login_button)).perform(click())
        onView(withText("Username doesn't exist.")).inRoot(ToastMatcher())
            .check(matches(isDisplayed()))
    }

    @Test
    fun testLoginSuccess() {
        onView(withId(R.id.username_edit)).perform(replaceText("dummy"))
        onView(withId(R.id.password_edit)).perform(replaceText("dummy12345"))
        onView(withId(R.id.login_button)).perform(click())
        onView(withText("Logged in!")).inRoot(ToastMatcher())
            .check(matches(isDisplayed()))
    }

    @Test
    fun testNavigateToRegisterFragment() {
        onView(withId(R.id.register_button)).perform(click())
        onView(withId(R.id.fragment_register)).check(matches(isDisplayed()))
    }
}