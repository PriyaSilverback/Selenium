 package Utilities;
public class TestCases {
private String testCaseId;
private String testCaseName;
private String testSteps;
private String TestCaseResultStatus;
private String expected;

public TestCases(String testcaseid, String testcasename,String testSteps, String expected,String testresultstatus){
  this.setTestCaseId(testcaseid);
  this.setTestCaseName(testcasename);
  this.setTestSteps(testSteps);
  this.setExpected(expected);
  this.setTestCaseResultStatus(testresultstatus);
}


			public String getTestCaseId() {
			  return testCaseId;
			}			
			public void setTestCaseId(String testCaseId) {
			  this.testCaseId = testCaseId;
			}
			
			
			
			
			public String getTestCaseName() {
				  return testCaseName;
			}
			public void setTestCaseName(String testCaseName) {
					  this.testCaseName = testCaseName;
			}
			
			
				
			public String getTestSteps() {
					  return testSteps;
			}
			public void setTestSteps(String TestSteps) {
					  this.testSteps = TestSteps;
			}

			public String getExpected(){
				return expected;
			}
			
			public void setExpected(String Expected){
				this.expected = Expected;
			}
			

		
			
			public String getTestCaseResultStatus() {
				  return TestCaseResultStatus;
			}


				public void setTestCaseResultStatus(String testCaseResultStatus) {
				  TestCaseResultStatus = testCaseResultStatus;
			}



}