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
WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Swag Labs/dropdown'),'hilo', false)
WebUI.waitForElementVisible(findTestObject('Object Repository/Product Price'), 10)
List<WebElement> priceElements = WebUI.findWebElements(findTestObject('Object Repository/Product Price'), 10)

List<Double> prices = new ArrayList<>()
for (WebElement priceElement : priceElements) {
	String priceText = priceElement.getText().replace('$', '').trim()  // Menghapus simbol $ dan spasi
	if (priceText.matches("[0-9]+(\\.[0-9]+)?")) {  // Pastikan format harga valid
		prices.add(Double.parseDouble(priceText))  // Mengonversi ke tipe Double dan menambahkannya ke list
	}
}

boolean isSorted = true
for (int i = 1; i < prices.size(); i++) {
	if (prices.get(i) > prices.get(i - 1)) {
		isSorted = false
		break
	}
}

// Menyatakan apakah harga terurut dengan benar
if (isSorted) {
	println("Harga sudah terurut dari harga tertinggi.")
} else {
	println("Harga tidak terurut dengan benar.")
}

WebUI.closeBrowser()