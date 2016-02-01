(function()
{
    'use strict';
    angular
        .module('Animations')
        .factory('ContactService', ['$q','$http', function($q,$http) {

            function isJson(files){
                try{
                    JSON.parse(files);
                }catch(e){
                    return false;
                }
                return true;
            }


            function getAllCustomers(){
                var deferred = $q.defer();

                $http({
                    method:'GET',
                    url: 'http://localhost:7001/getAllContacts'
                }).success(function(info){
                    var result = {};
                    if(info){
                        result = angular.fromJson(info);
                    }
                    deferred.resolve(result);
                }).error(function(info){
                    if(isJson(info)){
                        deferred.reject(angular.fromJson(info));
                    }
                    else{
                        deferred.reject(info);
                    }
                });
                return deferred.promise;
            }

            return{
                getAllCustomers : getAllCustomers
            }

        }]);
})();