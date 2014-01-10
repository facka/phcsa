angular.module('App', []);

function Edificios($scope, $http, $templateCache) {

	var getRandomParam = function() {
		return "r="+Math.floor((Math.random()*1000000)+1);
	};
	
	$scope.buscar = function() {

		$http({
			method : "GET",
			url : "/phcsa/edificios?"+getRandomParam(),
			cache : $templateCache
		}).success(function(data, status) {
			$scope.edificios = data;
		}).error(function(data, status) {
			$scope.data = data || "Request failed";
		});
	};

	$scope.deleteSelected = function() {
		var oldEdificios = $scope.edificios;
		$scope.edificios = [];
		angular.forEach(oldEdificios, function(edificio) {
			if (!edificio.deleted)
				$scope.edificios.push(edificio);
		});
	};

	$scope.addEdificio = function() {
		if ($scope.direccionText) {
			$http({
				method : "POST",
				url : "/phcsa/edificios?"+getRandomParam(),
				cache : $templateCache,
				data: { "direccion" : $scope.direccionText},
	            headers: {'Content-Type': 'application/json'}
			}).success(function(data, status) {
				$scope.buscar();
				$scope.direccionText = '';
			}).error(function(data, status) {
				$scope.data = data || "Request failed";
			});
		}
		else {
			console.log("Inserte direccion");
		}
			
	};
	
	$scope.buscar();
}