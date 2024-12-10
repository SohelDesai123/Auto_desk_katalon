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

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://stage-desking.autoalert.com/#/web/desking/quickdesk')

WebUI.setText(findTestObject('Object Repository/Page_AutoAlert  Login/input_Remember Me_username'), 'shalu.fmdemo')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_AutoAlert  Login/input_Remember Me_password'), 'tjDLxW8AgrlZqZ4EC6hpKg==')


TestObject deskingSignin = findTestObject('Object Repository/Page_AutoAlert  Login/input_Remember Me_username')

boolean deskingSigninVisible = WebUI.waitForElementVisible(deskingSignin, 20)

if(deskingSigninVisible) {
	WebUI.takeScreenshot('Screenshots/1_Desking_signin.png')
}
else {
	WebUI.comment('Desking Signin is not Visible')
}

WebUI.click(findTestObject('Object Repository/Page_AutoAlert  Login/button_CONTINUE'))

WebUI.click(findTestObject('Object Repository/Page_AutoAlert  Two Factor Authentication/input_--1254_onVerifyPhone'))

WebUI.newTab('')

WebUI.navigateToUrl('https://client.get.mymfa.io/login')

WebUI.setText(findTestObject('Object Repository/Page_GetMyMFA/input_Or_ant-input ng-untouched ng-pristine_24b292'), '0afc36c8')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_GetMyMFA/input_Or_ant-input ng-untouched ng-star-ins_a66743'),
	'5qQ/200ct7MTgBN71rrXayWaG/EIx1nx')

TestObject mfaLogin = findTestObject('Object Repository/Page_GetMyMFA/input_Or_ant-input ng-untouched ng-pristine_24b292')

boolean mfaLoginVisible = WebUI.waitForElementVisible(mfaLogin, 20)

if(mfaLoginVisible) {
	WebUI.takeScreenshot('Screenshots/2_MFA_Login.png')
}
else {
	WebUI.comment('MFA Login is not Visible')
}

WebUI.click(findTestObject('Object Repository/Page_GetMyMFA/button_Log in'))

TestObject mfaCodeObject = findTestObject('Page_GetMyMFA/h1_549460')

boolean isVisibleMFA = WebUI.waitForElementVisible(mfaCodeObject, 20)

if(isVisibleMFA) {
	WebUI.takeScreenshot('Screenshots/3_MFA_CODE.png')
}
else {
	WebUI.comment('MFA Code is not Visible')
}

String code = WebUI.getText(findTestObject('Page_GetMyMFA/h1_549460'))

WebUI.switchToWindowTitle('AutoAlert | Two Factor Authentication')

WebUI.setText(findTestObject('Object Repository/Page_AutoAlert  Two Factor Authentication/input_Enter your confirmation code below_Co_1c8322'),code)

TestObject verifyMfaCode = findTestObject('Object Repository/Page_AutoAlert  Two Factor Authentication/input_Enter your confirmation code below_Co_1c8322')

boolean isVisibleMFAVerify = WebUI.waitForElementVisible(verifyMfaCode, 20)

if(isVisibleMFAVerify) {
	WebUI.takeScreenshot('Screenshots/4_MFA_Verified.png')
}
else {
	WebUI.comment('MFA Code is not Visible')
}

WebUI.click(findTestObject('Object Repository/Page_AutoAlert  Two Factor Authentication/button_Verify Code'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Desking/img_Demo Dealerships_store-switcher-icon'), 0)

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Desking/a_Desk Configuration'))

WebUI.takeScreenshot('Screenshots/5_Signup_success.png')



