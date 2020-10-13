$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("cucumberTest.feature");
formatter.feature({
  "line": 1,
  "name": "googleTest",
  "description": "",
  "id": "googletest",
  "keyword": "Feature"
});
formatter.before({
  "duration": 5049996000,
  "status": "passed"
});
formatter.scenario({
  "line": 2,
  "name": "Find kitten images on Google",
  "description": "",
  "id": "googletest;find-kitten-images-on-google",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "we can open google",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "we search for kittens",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "google will return us images of kittens",
  "keyword": "Then "
});
formatter.match({
  "location": "CucumberTest.we_can_open_google()"
});
formatter.result({
  "duration": 1189271500,
  "status": "passed"
});
formatter.match({
  "location": "CucumberTest.we_search_for_kittens()"
});
formatter.result({
  "duration": 9406233200,
  "status": "passed"
});
formatter.match({
  "location": "CucumberTest.google_will_return_us_images_of_kittens()"
});
formatter.result({
  "duration": 62416200,
  "status": "passed"
});
formatter.after({
  "duration": 759938100,
  "status": "passed"
});
});