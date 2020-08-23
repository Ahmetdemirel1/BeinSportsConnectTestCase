Bein Sports Connect Australia Subscription Test Case
=====================
Created by ahmet.demirel on 23.08.2020



Subscription
--------
tags: subscription
* "https://connect-au.beinsports.com/en" ortamında çalıştır
* "Subscribe" elementine tıklanır
* "Package_Amount" alanı "AU$19.99" değerini eşit mi kontrolü yapılır
* "Monthly_Plan_Subscribe" elementine tıklanır
* "First_Name" alanına "Ahmet" yazılır
* "Last_Name" alanına "Demirel" yazılır
* "Email" alanına random mail adresi yazılır
* "Password" alanına "ahmet123" yazılır
* "Create_Account" elementine tıklanır
* "Total_Amount" alanı "Total Amount : AU$19.99" değerini eşit mi kontrolü yapılır
* Sayfa üzerinde "Total_Amount" elementi görünene kadar beklenir
* "2" saniye beklenir
* "Check_Terms" elementine tıklanır
* "Pay_Now" elementine tıklanır
* "Total_Payment_Amount" alanı "1.00 AUD" değerini eşit mi kontrolü yapılır
* "Card_Holders_Name" alanına "Ahmet Demirel" yazılır
* "Card_Number" alanına "1111222233334444" yazılır
* "Card_Exp_Date_Month" listesinden "02" objesi seçilir
* "Card_Exp_Date_Year" listesinden "2024" objesi seçilir
* "Card_Verification" alanına "000" yazılır
* "Payment_Submit" elementine tıklanır
* "Error_Message" alanı "Card number incorrect or incompatible" değerini eşit mi kontrolü yapılır
