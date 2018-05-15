var baseUrlApp = "http://localhost:9294/grouse";
var baseUrlGui = "http://localhost:9294/grouse";
var startPageName = "krav.html";
var requirementPageName = "requirement.html";
var REQUIREMENT = "krav";
var FUNCTIONALITY = "funksjon";

var SetUserToken = function (t) {
    localStorage.setItem("token", t);
    console.log("Adding token " + t + " to local storage");
};

var GetUserToken = function (t) {
    return localStorage.getItem("token");
};

var SetUserRequirementNumber = function (t) {
    localStorage.setItem("requirementNumber", t);
    console.log("Adding requirementNumber " + t + " to local storage");
};

var GetUserRequirementNumber = function () {
    return localStorage.getItem("requirementNumber");
};

var changeLocation = function ($scope, url, forceReload) {
    $scope = $scope || angular.element(document).scope();
    console.log("changeLocation to URL" + url);
    if (forceReload || $scope.$$phase) {
        window.location = url;
    }
    else {
        $location.path(url);
        $scope.$apply();
    }
};
