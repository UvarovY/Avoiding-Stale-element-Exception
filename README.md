There are several usefull fetures that I Used to use in while building test automation f-wks. 


 /**
     *  The method waitFor , uses with two parameters: Web Element condition( is Visible, Is clickable, etc.  and Timeout in seconds. 
     If there are no timeOut params, will use timeOutInSeconds : 10;
     Webdriver will wait Timeout interval till the Webelemetn gets some conditions.
       
     Second Part of the the metod, for given number of seconds for element with given locator to be visible  on the page
     The method waitForVisibilityOf invokes waitFor, and sends Webelemnt and timeout, and condition
     Webelement was found, the waitForVisibilityOf metod try to cath Stale elemnt Exaption is it is. 
     And do next attempt to do  waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
     while attemts < 2. so element is refreshed on DOM , and Stale elemetn Exaption could be aovoided. 
     *
     */
       private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 10;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(condition);
    }

    public void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
