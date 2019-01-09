$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri('com\jp\cucumber\sample.feature');
formatter.feature({
  "line": 2,
  "name": "To test cucumber java application is running",
  "description": "",
  "id": "to-test-cucumber-java-application-is-running",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@smokeTest"
    }
  ]
});
formatter.scenario({
  "line": 3,
  "name": "cucumber scenario",
  "description": "",
  "id": "to-test-cucumber-java-application-is-running;cucumber-scenario",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "sample feature file is ready",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I run the feature file",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "run should be successful",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.givenStatement()"
});
formatter.result({
  "duration": 188366712,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.I_run_the_feature_file()"
});
formatter.result({
  "duration": 57054,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.run_should_be_successful()"
});
formatter.result({
  "duration": 53129,
  "status": "passed"
});
});