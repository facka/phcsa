<html>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.7/angular.min.js"></script>
<script type="text/javascript" src="js/application.js"></script>
<body>
	<div ng-app="App">
		<div ng-controller="Edificios">
			<input type="text" ng-model="idEdificio" size="80" />
			<button ng-click="buscar()">Buscar</button>
			<br>
			
			<ul class="unstyled">
				<li ng-repeat="edificio in edificios"><input type="checkbox"
					ng-model="edificio.deleted"> <span>{{edificio.idEdificio}} - {{edificio.direccion}}</span>
				</li>
			</ul>
		</div>
		
		<a href="" ng-click="deleteSelected()">Delete selected</a>

		<input type="text" ng-model="direccionText" size="30"
				placeholder="direccion"> <button ng-click="addEdificio()">Agregar</button>
	</div>
</body>
</html>