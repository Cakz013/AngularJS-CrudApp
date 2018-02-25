'use strict'
pescaApp

    .controller('PescaListCtrl', ['$scope', '$http', 'PescaService', '$state', '$window',
    function($scope, $http, pescaService, $state, $window) {
        $scope.pesca = {};

        $scope.obtenerRegistros = function() {
            pescaService.obtenerRegistros()
                .success(function(x) {
                    $scope.listaRegistros = x;
                    console.log(x);
                })
                .error(function(data) {
                    console.log(data);
                });
        };

        $scope.obtenerRegistros();

        $scope.eliminarRegistro = function(id) {
            console.log(id);
            pescaService.eliminarRegistro(id)
                .success(function(data) {
                    console.log(data);
                    alert("el registro ha sido eliminado");
                    $window.location.href = '';
                })
                .error(function(data) {
                    console.log('OCURRIO UN ERROR');
                    console.log(data);
                });


        };
    }
])

.controller('PescaViewCtrl', ['$scope', '$stateParams', 'PescaService', function($scope, $stateParams, pescaService) {
    $scope.registro = {};
    pescaService.getById({ id: $stateParams.id })
        .success(function(data) {
            console.log(data);
            $scope.registro = data;
        }).error(function(data) {
            alert('ERROR MI SOCIO');
        });
}])

.controller('PescaNuevoCtrl', ['$scope', '$state', '$stateParams', 'PescaService', function($scope, $state, $stateParams, pescaService) {
    $scope.pesca = {};
    $scope.estados = [{
        id: "PEND",
        label: 'Pendiente',
    }, {
        id: "PAGA",
        label: 'Pagado',
    }, {
        id: "ANUL",
        label: 'Anulado',
    }, {
        id: "CANC",
        label: 'Cancelado',
    }];
    $scope.crearRegistro = function() {
        // las funciones de abajo sirven para conseguir la fecha lo preestablecido es que se inserten la fecha de salida 2 horas luego de la de entrada
        var now = new Date();
        $scope.pesca.fecha_entrada = now;
        //sobreescribo una variable para enviarla
        $scope.pesca.cant_horas_reales = $scope.pesca.cantidad_horas_reales;
        now.setHours(now.getHours() + 2);
        $scope.pesca.fecha_salida_real = now;
        pescaService.crearRegistro($scope.pesca)
            .then(function(data) {
                alert("el registro se ha agregado");
                $scope.registro = {};
                console.log(data);
                $state.go('registros-list');
            }, function(data) {
                alert("ERROR ERROR ERROR");
                console.log(data);
            });
    };

}])

.controller(
    'PescaEditCtrl', ['$scope', '$state', '$stateParams', 'PescaService',
        function($scope, $state, $stateParams, pescaService) {
            $scope.Create = false;
            $scope.estados = [{
                id: "PEND",
                label: 'Pendiente',
            }, {
                id: "PAGA",
                label: 'Pagado',
            }, {
                id: "ANUL",
                label: 'Anulado',
            }, {
                id: "CANC",
                label: 'Cancelado',
            }];
            pescaService.getById({ id: $stateParams.id })
                .success(function(data) {
                    $scope.pesca = {};
                    $scope.pesca = data;
                }).error(function(data) {
                    console.log('OCURRIO UN ERROR');
                    console.log(data);
                });
            $scope.modificarRegistro = function() {
                $scope.pesca.cant_horas_reales = $scope.pesca.cantidad_horas_reales;
                pescaService.modificarRegistro($scope.pesca.id, $scope.pesca)
                    .then(function(data) {
                        alert("el registro se ha modificado");
                        $scope.registro = {};
                        $state.go('registros-list');
                    }, function(data) {
                        alert("ERROR ERROR ERROR");
                        console.log(data);
                    });
            };



        }
    ]);