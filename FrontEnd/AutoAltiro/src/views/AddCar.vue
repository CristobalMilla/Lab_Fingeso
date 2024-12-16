<template>
    <div class="add-car">
      <h1>Agregar un Vehículo</h1>
      <form>
        <label for="make">Marca:</label>
        <input id="make" type="text" placeholder="Ingrese la marca" />
  
        <label for="model">Modelo:</label>
        <input id="model" type="text" placeholder="Ingrese el modelo" />
  
        <label for="year">Año:</label>
        <input id="year" type="number" placeholder="Ingrese el año" />
  
        <button type="submit">Agregar</button>
      </form>
    </div>
  </template>
  
  <script>
  export default {
    name: 'AddCar',
  };
  </script>
