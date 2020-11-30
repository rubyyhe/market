# Problem
Given a java function `isMarketOpen(Date date)` on the date (Function detail described
in class `com.ruby.he.Market`).

Write test cases to test the function and find out potential bugs.

# Solution

## Test cases
JUnit test cases under package `com.ruby.he.tests`. 
* Test with normal holidays, verify if the output is false.
  * For New Year’s Day, input as 01/01/2021, expect the output to be false
  * For Martin Luther King Day, input as 01/18/2021, expect the output to be false
  * For President’s Day, input as 02/15/2021, expect the output to be false.
  * For Good Friday, input as 04/02/2021, expect the output to be false
  * For Memorial Day, input as 05/31/2021, expect the output to be false. 
  * For Independence Day, input as 07/04/2022, expect the output to be false.
  * For Labor Day, input as 09/06/2021, expect the output to be false.
  * For Thanksgiving Day, input as 11/25/2021, expect the output to be false.
  * For Chrismas Day, input as 12/25/2020, expect the output to be false.

* Test with observed holidays, verify if the output is false.
  * For New Year’s Day observed in 2023, input as 01/02/2023, expect the output to be false
  * For Independence Day observed in 2020, input as 07/03/2020, expect the output to be false.
  * For Independence Day observed in 2021, input as 07/05/2021, expect the output to be false.
  * For Chrismas Day observed in 2021, input as 12/24/2021, expect the output to be false
  * For Chrismas Day observed in 2022, input as 12/26/2022, expect the output to be false

* Test with the normal weekend, verify if the output is false.
  * Set the input date as a normal Saturday 02/06/2021, expect the output to be false.
  * Set the input date as a normal Sunday 02/07/2021, expect the output to be false.

* Test with the normal workday,  verify if the output is true. 
  * Set the input date as a normal workday(Monday) 02/08/2021, expect the output to be true.
  * Set the input date as a normal workday(Thursday) 10/22/2020, expect the output to be true.



## Bugs
1. Missing check for Memorial Day.
2. The check for New Year’s Day is incorrect. The `“dayOfMonth == 2”` in the if branch should be `“dayOfMonth == 1”`
   ```
      // New Year's Day
       if (month == Calendar.JANUARY && dayOfMonth == 2) { 
           return false;
       } 
   ```
3. No logic for checking observed holiday
   1. If one of the holidays falls on a Saturday it is observed on the preceding Friday.  
   2. If it falls on a Sunday it is observed on the following Monday.
4. Missing check for Good friday.  
 