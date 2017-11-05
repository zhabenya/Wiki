## Project Name
Implementation of search test for site https://wikipedia.org

## Requirements 
- Make sure you have Java and Maven installed. 
- Download browser drivers ([ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/), [FirefoxDriver](https://github.com/mozilla/geckodriver/releases), etc.)

## Installation

- Clone repository https://github.com/zhabenya/Wiki.git
- Run test in IDE or in terminal mvn test

## Note
By default tests run in Chrome WebDriver. Add system property `-Dwebdriver.chrome.driver="path_to_chromedriver.exe"` 

To run tests in any other browser add system property (e.g. `-Dbrowser=firefox`) 
and corresponding path to driver (e.g. `-Dwebdriver.gecko.driver="path_to_geckodriver.exe"`)
