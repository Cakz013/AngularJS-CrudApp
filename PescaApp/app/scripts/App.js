var pescaApp = angular.module('pescaApp', ['ui.router']);

pescaApp.constant('Config', { "backendURL": "http://localhost:8090/pesca.api" });

pescaApp.config(function($stateProvider) {
    $stateProvider.state('registros-list', {
        url: '/registros',
        templateUrl: '../partials/lista-pesca.html',
        controller: 'PescaListCtrl'
    });
    $stateProvider
        .state('registros-view', {
            url: '/registros/:id/ver',
            templateUrl: '../partials/ver-pesca.html',
            controller: 'PescaViewCtrl'
        }).state('registros-nuevo', {
            url: '/registros/nuevo',
            templateUrl: '../partials/nuevo-pesca.html',
            controller: 'PescaNuevoCtrl'
        }).state('registros-edit', {
            url: '/registros/:id/editar',
            templateUrl: '../partials/editar-pesca.html',
            controller: 'PescaEditCtrl'
        });
}).run(function($state) {
    $state.go('registros-list');
});