<template>
    <div class="advanced-search">
      <h1>Búsqueda Avanzada</h1>
      <form>
        <label for="make">Marca:</label>
        <input id="make" type="text" placeholder="Ingrese la marca" />
  
        <label for="model">Modelo:</label>
        <input id="model" type="text" placeholder="Ingrese el modelo" />
  
        <label for="year">Año:</label>
        <input id="year" type="number" placeholder="Ingrese el año" />
  
        <label for="price">Precio máximo:</label>
        <input id="price" type="number" placeholder="Ingrese el precio máximo" />
  
        <button type="submit">Buscar</button>
      </form>
    </div>
  </template>
  
  <script>
  export default {
    name: 'AdvancedSearch',
  };
  </script>
  