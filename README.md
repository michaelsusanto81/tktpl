# TKTPL B - 1806205653 - Michael Susanto
* This project is for TKTPL Mobile Programming course at Faculty of Computer Science, Universitas Indonesia.
* Please check branches for more information.

## Lab 4 - Views, Architecture, Data Binding
* This lab simulates how to pass data between fragments in the same activity.
* My Lab 4 project has one activity and two fragments.
    * MainActivity contains Shared ViewModel
    * FirstFragment uses Shared ViewModel to fill up its Recycler View to show Job List, and send data (clicked job) to SecondFragment.
        * It is done by setting the value of clickedJob LiveData.
    * SecondFragment uses Shared ViewModel and observe LiveData changes, then update the Detail Informations.
* Architecture used: Model-View-ViewModel (MVVM)
* This project uses Data Binding too.
    
Regards,
Michael