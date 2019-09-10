$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resource/features/contact.feature");
formatter.feature({
  "line": 1,
  "name": "Contact",
  "description": "User should be able to contact admin",
  "id": "contact",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "User should be able to login with valid credentials",
  "description": "",
  "id": "contact;user-should-be-able-to-login-with-valid-credentials",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "Load home page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Enter name \"Pierre\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Enter email \"pierre@gmail.com\"",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Enter phone \"01724567805778\"",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Enter subject \"contacting\"",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Enter message \"Hello there! your contact form sucks!!!\"",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "CLick Submit button",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "we see successful message",
  "keyword": "Then "
});
formatter.match({
  "location": "Contact.load_home_page()"
});
formatter.result({
  "duration": 3392917758,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Pierre",
      "offset": 12
    }
  ],
  "location": "Contact.enter_name(String)"
});
formatter.result({
  "duration": 809993245,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "pierre@gmail.com",
      "offset": 13
    }
  ],
  "location": "Contact.enter_email(String)"
});
formatter.result({
  "duration": 144659126,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "01724567805778",
      "offset": 13
    }
  ],
  "location": "Contact.enter_phone(String)"
});
formatter.result({
  "duration": 126088247,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "contacting",
      "offset": 15
    }
  ],
  "location": "Contact.enter_subject(String)"
});
formatter.result({
  "duration": 100630057,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Hello there! your contact form sucks!!!",
      "offset": 15
    }
  ],
  "location": "Contact.enter_message(String)"
});
formatter.result({
  "duration": 225697815,
  "status": "passed"
});
formatter.match({
  "location": "Contact.click_Submit_button()"
});
formatter.result({
  "duration": 59749763,
  "status": "passed"
});
formatter.match({
  "location": "Contact.we_see_successful_message()"
});
formatter.result({
  "duration": 7074715281,
  "status": "passed"
});
});