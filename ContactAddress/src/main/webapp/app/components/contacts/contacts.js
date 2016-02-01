(function()
{
    'use strict';
    angular
        .module('Animations')
        .directive('contacts',function(){
            return{
                templateUrl: 'app/components/contacts/contacts.html',
                restrict:'E',
                controller: 'contactController',
                controllerAs: 'contactCtrl',
                bindToController: true
            };
        })
        .controller('contactController', contactController);

        contactController.$inject = ['ContactService', '$scope'];

        function contactController(ContactService,$scope) {

            var me = this;
            me.contacts = [];
            console.log('ContactController');

            ContactService.getAllCustomers().then(function(data){

                me.contacts = data.contacts;
                console.log(me.contacts)
            });

        }
})();
