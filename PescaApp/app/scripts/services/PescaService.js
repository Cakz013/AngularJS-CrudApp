'use strict'
pescaApp
    .factory('PescaService', ['$http', 'Config', function($http, Config) {
        return {

            obtenerRegistros: function() {
                return $http.get(Config.backendURL + '/registro-pesca/');
            },
            crearRegistro: function(registro) {
                return $http.post(Config.backendURL + '/registro-pesca/', registro);
            },
            modificarRegistro: function(id, registro) {
                return $http.put(Config.backendURL + '/registro-pesca/' + id, registro);
            },
            eliminarRegistro: function(id) {
                return $http.delete(Config.backendURL + '/registro-pesca/' + id);
            },
            getById: function(id) {
                return $http.get(Config.backendURL + '/registro-pesca/' + id.id);
            }
        };

    }]);