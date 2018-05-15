var app = angular.module('metasystem-app', []);

/**
 * main.js
 *
 * Used with index.html to provide the following functionality:
 *
 *
 */
var mainController = app.controller('MainController',
  ['$scope', '$http', '$window', function ($scope, $http, $window) {

    var urlForOrganisation = "http://localhost:9294/metasystem/organisation/1";
    var urlForOperations = "http://localhost:9294/metasystem/operation";
    var urlForOrganisationAreas = "http://localhost:9294/metasystem/organisationarea";
    var urlForOrganisationSegments = "http://localhost:9294/metasystem/organisationsegment";
    var urlForActivities = "http://localhost:9294/metasystem/activity";

    var token = "iii";
    $http({
      method: 'GET',
      url: urlForOrganisation,
      headers: {'Authorization': token}
    }).then(function successCallback(response) {
      $scope.organisation = response.data;
      console.log(" GET urlForOrganisation[" + urlForOrganisation +
        "] returned " + JSON.stringify(response.data));
    }, function errorCallback(response) {
      alert("Kunne ikke hente. " +
        JSON.stringify(response));
      console.log(" GET urlForOrganisation[" + urlForOrganisation+
        "] returned " + JSON.stringify(response));
    });

    $http({
      method: 'GET',
      url: urlForOrganisationAreas,
      headers: {'Authorization': token}
    }).then(function successCallback(response) {
      $scope.organisationAreas = response.data;
      console.log(" GET urlForOrganisationAreas[" + urlForOrganisationAreas +
        "] returned " + JSON.stringify(response.data));
    }, function errorCallback(response) {
      alert("Kunne ikke hente. " +
        JSON.stringify(response));
      console.log(" GET urlForOrganisationAreas[" + urlForOrganisationAreas +
        "] returned " + JSON.stringify(response));
    });

    $http({
      method: 'GET',
      url: urlForActivities,
      headers: {'Authorization': token}
    }).then(function successCallback(response) {
      $scope.activities = response.data;
      console.log(" GET urlForActivities[" + urlForActivities +
        "] returned " + JSON.stringify(response.data));
    }, function errorCallback(response) {
      alert("Kunne ikke hente. " +
        JSON.stringify(response));
      console.log(" GET urlForActivities[" + urlForActivities +
        "] returned " + JSON.stringify(response));
    });

    $http({
      method: 'GET',
      url: urlForOrganisationSegments,
      headers: {'Authorization': token}
    }).then(function successCallback(response) {
      $scope.organisationSegments = response.data;
      console.log(" GET urlForOrganisationSegments[" + urlForOrganisationSegments +
        "] returned " + JSON.stringify(response.data));
    }, function errorCallback(response) {
      alert("Kunne ikke hente. " +
        JSON.stringify(response));
      console.log(" GET urlForOrganisationSegments[" + urlForOrganisationSegments +
        "] returned " + JSON.stringify(response));
    });

    $http({
      method: 'GET',
      url: urlForOperations,
      headers: {'Authorization': token}
    }).then(function successCallback(response) {
      $scope.operations = response.data;
      console.log(" GET urlForOperations[" + urlForOperations +
        "] returned " + JSON.stringify(response));
    }, function errorCallback(response) {
      alert("Kunne ikke hente. " +
        JSON.stringify(response));
      console.log(" GET urlForOperations[" + urlForOperations+
        "] returned " + JSON.stringify(response));
    });

/*
    $scope.operations = [
      {id: 'k', title: 'Kultur'},
      {id: 'b', title: 'Bibliotek'},
      {id: 'm', title: 'Museum'},
      {id: 'u', title: 'Ungdom'},
      {id: 'i', title: 'Idrott & Fritid'},
      {id: 'k', title: 'Konsumentstöd'}];

    $scope.organisationAreas = [
      {id: 'l', title: 'Ledning och stöd'},
      {id: 'i', title: 'Information'},
      {id: 'p', title: 'Program'},
      {id: 'm', title: 'Mediaförsörjning'},
      {id: 'u', title: 'Uppsökande verksamhet'},
      {id: 'b', title: 'Barn o ungdom'},
      {id: 'n', title: 'Närbibliotek 1+2'}];

    $scope.organisationSegments = [
      {id: 'l', title: 'Planering & uppföljning'},
      {id: 'b', title: 'Samordning med integrerade skolbibliotek'},
      {id: 'n', title: 'Föreningssamver'}];
*/
}]);

