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
		angular.forEach($scope.edificios, function(edificio) {
			
			if (edificio.deleted) {
				$http({
					method : "DELETE",
					url : "/phcsa/edificios/"+edificio.idEdificio+"?"+getRandomParam(),
					cache : $templateCache,
		            headers: {'Content-Type': 'application/json'}
				}).success(function(data, status) {
					$scope.buscar();
				}).error(function(data, status) {
					$scope.data = data || "Request failed";
				});
				
			}
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