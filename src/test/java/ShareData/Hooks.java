package ShareData;

import logger.LoggerUtility;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.internal.IResultListener2;

public class Hooks extends ShareData{

    public String testName;

    @BeforeMethod
    public void prepareEnvironment(){
        testName = this.getClass().getSimpleName();//va scoate numele clasei curente
        LoggerUtility.startTestCase(testName);
        prepareBrowser();
    }


    @AfterMethod
    public void clearEnvironmnet(ITestResult result){
        //daca statusul e failure da-mi un mesaj de eroare
        if(result.getStatus() == ITestResult.FAILURE){
            LoggerUtility.errorLog(result.getThrowable().getMessage());
        }
        clearBrowser();
        //puntru moment toate sunt bune
        LoggerUtility.endTestCase(testName);
    }

    //metoda care merge-uieste toate fisierele suite  in unul singur
    @AfterSuite
    public void finaliseLogFiles(){
        LoggerUtility.mergeLogFilesIntoOne();
    }


}
