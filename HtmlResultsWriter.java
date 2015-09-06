package Utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.List;

import javax.xml.transform.stream.StreamResult;

public class HtmlResultsWriter {

	private String Separator = "</td><td>";
	public void writeTestResults(String filename,List<TestCases> items){
		try {

			File fout = new File(filename);
			FileOutputStream fos;

			fos = new FileOutputStream(fout);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			bw.write("<html><body><table><thead><th>Test Case Id</th><th>Test Case Name</th><th>Test Steps</th>><th>Expected Results</th><th>Actual Results</th></thead><tbody>");
			for (TestCases tcase : items) {
				String style = tcase.getTestCaseResultStatus().contains("Fail") ? "style = 'background-color:red'" : "style = 'background-color:green'";
				bw.write("<tr " + style + "><td>" + tcase.getTestCaseId() + Separator + tcase.getTestCaseName() + Separator + tcase.getTestSteps()  + Separator + tcase.getExpected() + Separator + tcase.getTestCaseResultStatus() + "</td></tr>");
				bw.newLine();
			}

			bw.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
