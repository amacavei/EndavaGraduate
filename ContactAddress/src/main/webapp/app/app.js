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
        controller: 'contactController',
        controllerAs: 'contactCtrl',
        templateUrl: 'components/contacts/contacts.html'
      })
      .otherwise({
        redirectTo: '/home'
      });
    });
})();
