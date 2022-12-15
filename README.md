# Pigu.lt
## Setup
### Site used for testing
[pigu.lt](https://pigu.lt/)
### Packages used
- TestNG `org.testng:testng`
- Selenium `org.seleniumhq.selenium:selenium-java`

## Test cases
### **Add To Cart**
- Test 1 (addItemsToCart)

// neveikia,nes kazkodel nespaudzia ant "Į krepšelį" mygtuko
1. Open page of one of the items in the Store
2. Click "Į krepšelį" button
3. Cart item window appears, check if window contains text "Prekė įtraukta į krepšelį"
6. Click "Tęsti prekių paiešką" button
7. Check if cart icon shows that 2 items are in the cart

### Login
- Test 2 (LoginUsingWrongInfoTest)

*Try to log in with wrong account information*
1. Open log in page
2. Input email(neveikiantisinfo@gmail.com) and password(123456789)
3. Click "Login" button
4. Alert message appears, check if alert message is "Neteisingi prisijungimo duomenys"

- Test 3 (LoginUsingRightInfoTest)

*Try to log in with existing account information*
1. Open log in page
2. Input email(pienas1545@protonmail.com) and password(lukasvcs)
3. Click "Login" button
4. Check if site url is "https://pigu.lt/lt/u/dashboard"


### Item search
- Test 4 (searchForSpicesWithSearchBar)
*Try to search for item with search bar*
1. Open main page
2. Add item name(Razer) to search bar
3. Click "Search" button
4. Check if any item named(Razer) is present

- Test 5 (searchitemWithFilter)

// irgi neveikia,nes neuzdeda varneles, nezinau del ko
*Try to search for a item with filters*
1. Click on Visos prekės
2. Click on Kompiuterinė technika
3. Check if element(Ausinės) is present
4. Click on Ausinės
5. Find filter searchbar
6. Write Razer
6. Check if item element(Razer) is present and click on it