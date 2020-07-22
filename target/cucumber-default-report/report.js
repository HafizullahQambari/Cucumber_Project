$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/feature/Login.feature");
formatter.feature({
  "name": "Login",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@sprint5"
    },
    {
      "name": "@login"
    }
  ]
});
formatter.scenarioOutline({
  "name": "valid admin and ess login",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "name": "user enter \"\u003cUsername\u003e\" and \"\u003cPassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "user click on login button",
  "keyword": "And "
});
formatter.step({
  "name": "\"\u003cFirstName\u003e\" is successfully logged in",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Username",
        "Password",
        "FirstName"
      ]
    },
    {
      "cells": [
        "Mahady",
        "Mahady123!!",
        "John"
      ]
    },
    {
      "cells": [
        "abd77",
        "Syntax123!",
        "Abdullah"
      ]
    }
  ]
});
formatter.scenario({
  "name": "valid admin and ess login",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@sprint5"
    },
    {
      "name": "@login"
    },
    {
      "name": "@smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user enter \"Mahady\" and \"Mahady123!!\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.LoginToHrmsApplication.user_enter_valid_and(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user click on login button",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.LoginToHrmsApplication.user_click_on_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "\"John\" is successfully logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.steps.LoginToHrmsApplication.is_successfully_logged_in(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png", "valid admin and ess login");
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "valid admin and ess login",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@sprint5"
    },
    {
      "name": "@login"
    },
    {
      "name": "@smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user enter \"abd77\" and \"Syntax123!\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.steps.LoginToHrmsApplication.user_enter_valid_and(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user click on login button",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.steps.LoginToHrmsApplication.user_click_on_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "\"Abdullah\" is successfully logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.steps.LoginToHrmsApplication.is_successfully_logged_in(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded1.png", "valid admin and ess login");
formatter.after({
  "status": "passed"
});
});