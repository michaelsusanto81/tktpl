# TKTPL B - 1806205653 - Michael Susanto
* This project is for TKTPL Mobile Programming course at Faculty of Computer Science, Universitas Indonesia.
* Please check branches for more information.

## Lab 2
This branch is about Unit Test, Instrumented Test, sign APKs, and deploy APKs.

### Features
* Register
* Login

### Unit Test
* Checking user input validation on Registration and Login.
* Tool used: JUnit 4.
* Registration:
    * Fields can't be empty.
    * Username contains at least 4 characters & should be unique.
    * Email must follow valid email's structure.
    * Password should contain at least 1 number and 8 characters.
* Login:
    * Fields can't be empty.
    * Username should exists.
    * If Username exists, password should matches.
    
### Instrumented Test
* Checking user's Registration and Login's flow.
* Tools used: JUnit 4 and Espresso.
* Registration:
    * Check if all UI components rendered completely.
    * Simulate fail registration flow.
    * Simulate success registration flow.
    * Simulate press back should go to login page.
* Login:
    * Check if all UI components rendered completely.
    * Simulate fail login flow.
    * Simulate success login flow.
    * Check if register button navigate to registration page.
    
### Sign & Deploy APKs
* APK is signed and deployed with two flavours: debug and release.

Regards,
Michael