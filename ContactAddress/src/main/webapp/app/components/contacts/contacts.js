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

        contactController.$inject = ['ContactService'];

        function contactController(ContactService) {

            var me = this;
            me.contacts = [];
            me.showModal = false;
            console.log('ContactController');

            ContactService.getAllCustomers().then(function(data){

                me.contacts = data.contacts;
                console.log(me.contacts)
            });

        }
})();
