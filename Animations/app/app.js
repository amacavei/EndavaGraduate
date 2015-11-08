(function()
{
  'use strict';
angular
  .module('Animations', [
    'ngRoute',
    'ui.bootstrap'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/home', {
        templateUrl: 'components/home/home.html'
      })
      .when('/contacts', {
        templateUrl: 'components/contacts/contacts.html'
      })
      .otherwise({
        redirectTo: '/home'
      });
    });
})()
