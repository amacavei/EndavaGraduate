(function()
{
  'use strict';
angular
  .module('Animations')
  .directive('baseTemplate', function() {
  return {
    restrict:'AE',
    templateUrl:'components/base-template/base-template.html',
    controller: 'baseTemplateController',
    controllerAs: 'baseCtrl'
  };
})
  .controller('baseTemplateController',['$scope','$location',function($scope,$location){
    var me = this;
    me.config = {
      expand: true,
      items: ['Home','View Contacts','Logout']
    }
        console.log('base')

    me.go = function (path) {
      $location.url(path);
    };
}])
})();
