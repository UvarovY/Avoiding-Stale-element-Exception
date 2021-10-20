*There are several usefull fetures for avoiding stale element exaption wtih DOM structure.*


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


This class gives you nice way of retrying some action several times to make sure that either works or not.
Here's an example of the code where this class can be used :

/**
	 * Get value of an element using id
	 * 
	 * @param id				the location of the element
	 * @param attribute			name of an attribute
	 * @return attribute value	value that was in attribute
	 */
	 
	public String getValueFromId(String id, String attribute) throws Exception {
        RetryStrategy retry = new RetryStrategy();
        WebElement element = null;
        String result = null;
        while(retry.shouldRetry()) {
            try {
                element = manager.getDriver().findElement(By.id(id));
                result = element.getAttribute(attribute);
                break;
            } catch (StaleElementReferenceException e){
                logger.warning("Got into StaleElement exception with id " + id);
                retry.errorOccured(e);
            }
        }
	return result;
    } 
    
    Really simple insstance of metod which can help avoid Stale elemetn exaption
    part of more complicated methods discrubed upper.
    
      public static void waitForElementPresent(By locator) {
       // WebElement webElement = driver.findElement(locator);
        WebDriverWait wait = new WebDriverWait(driver, 10);
       // WebElement element = wait.until(ExpectedConditions.visibilityOf(webElement));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
       // wait.until(ExpectedConditions.elementToBeClickable(locator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
