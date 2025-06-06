import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement

WebUI.callTestCase(findTestCase('Login/Reusable/TC_LoginSuccess'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Swag Labs/dropdown'),'az', false)
WebUI.waitForElementVisible(findTestObject('Object Repository/Product Price'), 10)
List<WebElement> productElements = WebUI.findWebElements(findTestObject('Object Repository/ProductName'), 10)

List<String> productNames = new ArrayList<>()
for (WebElement productElement : productElements) {
	String productName = productElement.getText().trim()
	productNames.add(productName)
}

boolean isSortedDescending = true
for (int i = 1; i < productNames.size(); i++) {
	 if (productNames.get(i).compareTo(productNames.get(i - 1)) < 0) {
		isSorted = false
		break
	}
}

// Menyatakan apakah harga terurut dengan benar
if (isSortedDescending) {
	println("Nama Product Ascending")
} else {
	println("Nama Product Descending")
}

WebUI.delay(10)