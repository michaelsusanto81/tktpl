package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.ui.auth.register

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.MainActivity
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.R
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.ToastMatcher
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class RegisterFragmentTest {

    @get: Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        onView(withId(R.id.register_button)).perform(click())
        onView(withId(R.id.fragment_register)).check(matches(isDisplayed()))
    }

    @Test
    fun testWidgetsVisibility() {
        onView(withId(R.id.app_title)).check(matches(isDisplayed()))
        onView(withId(R.id.username_field)).check(matches(isDisplayed()))
        onView(withId(R.id.email_field)).check(matches(isDisplayed()))
        onView(withId(R.id.address_field)).check(matches(isDisplayed()))
        onView(withId(R.id.name_field)).check(matches(isDisplayed()))
        onView(withId(R.id.password_field)).check(matches(isDisplayed()))
        onView(withId(R.id.passwordconfirm_field)).check(matches(isDisplayed()))
        onView(withId(R.id.register_button)).check(matches(isDisplayed()))
    }

    @Test
    fun testRegisterFailed() {
        onView(withId(R.id.username_edit)).perform(ViewActions.replaceText("usernameDoesNotExist"))
        onView(withId(R.id.email_edit)).perform(ViewActions.replaceText("user@gmail.com"))
        onView(withId(R.id.address_edit)).perform(ViewActions.replaceText("Jl. Espresso No.1"))
        onView(withId(R.id.name_edit)).perform(ViewActions.replaceText("UserName Dummy"))
        onView(withId(R.id.password_edit)).perform(ViewActions.replaceText("dummy12345"))
        onView(withId(R.id.passwordconfirm_edit)).perform(ViewActions.replaceText("dummyhehe123"))
        onView(withId(R.id.register_button)).perform(click())
        onView(ViewMatchers.withText("Password confirmation doesn't match.")).inRoot(ToastMatcher())
            .check(matches(isDisplayed()))
    }

    @Test
    fun testRegisterSuccess() {
        onView(withId(R.id.username_edit)).perform(ViewActions.replaceText("usernameDoesNotExist"))
        onView(withId(R.id.email_edit)).perform(ViewActions.replaceText("user@gmail.com"))
        onView(withId(R.id.address_edit)).perform(ViewActions.replaceText("Jl. Espresso No.1"))
        onView(withId(R.id.name_edit)).perform(ViewActions.replaceText("UserName Dummy"))
        onView(withId(R.id.password_edit)).perform(ViewActions.replaceText("dummy12345"))
        onView(withId(R.id.passwordconfirm_edit)).perform(ViewActions.replaceText("dummy12345"))
        onView(withId(R.id.register_button)).perform(click())
        onView(ViewMatchers.withText("Successfully registered!")).inRoot(ToastMatcher())
            .check(matches(isDisplayed()))
    }

    @Test
    fun testPressBackGoToLoginFragment() {
        pressBack()
        onView(withId(R.id.fragment_login)).check(matches(isDisplayed()))
    }
}