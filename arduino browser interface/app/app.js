(function()
{
  'use strict';
angular
  .module('WindMill', [
    'ngRoute',
    'ui.bootstrap'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/home', {
        templateUrl: 'arduino/browser/home.html'
      })
      .otherwise({
        redirectTo: '/home'
      });
    });
})();
