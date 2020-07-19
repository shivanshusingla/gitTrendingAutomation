package listeners;

import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {

  Date date = new Date();

  @Override
  public void onTestStart(ITestResult iTestResult) {
    System.out.println(
        "Test '" + iTestResult.getName() + "' and Test Description '" + iTestResult.getMethod()
            .getDescription()
            + "' Started on '" + new Date() + "'");
  }

  @Override
  public void onTestSuccess(ITestResult iTestResult) {
    System.out.println("Test '" + iTestResult.getName() + "' Passed on '" + new Date() + "'");
  }

  @Override
  public void onTestFailure(ITestResult iTestResult) {
    System.out.println(
        "***************EXECUTION OF TESTCASE ENDS HERE at : " + new Date() + " ***************");
  }

  @Override
  public void onTestSkipped(ITestResult iTestResult) {
    System.out.println("Test case skipped - '" + iTestResult.getName() + "'");
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

  }

  @Override
  public void onStart(ITestContext iTestContext) {
    System.out.println("Automation Execution started on " + date + " on Thread id:- "
        + Thread.currentThread().getId());
  }

  @Override
  public void onFinish(ITestContext iTestContext) {
    int seconds = Math.abs(date.getSeconds() - new Date().getSeconds());
    System.out.println(
        "Automation Execution finished after " + seconds + " seconds on Thread id:- " + Thread
            .currentThread().getId());
  }
}